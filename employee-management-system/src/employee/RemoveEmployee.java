package employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RemoveEmployee implements ActionListener{
    JFrame removeFrame;
    JTextField text;
    JLabel labelId, labelName,labelPhone, labelEmail, label, label1, label2, label3;
    JButton searchButton, removeButton, cancelButton, backButton;

    RemoveEmployee(){
        removeFrame = new JFrame("Employee Management System");
        removeFrame.setBackground(Color.green);
        removeFrame.setLayout(null);

        label = new JLabel();
        label.setBounds(0,0,500,500);
        label.setLayout(null);
        removeFrame.add(label);

        labelId = new JLabel("Employee Id");
        labelId.setBounds(190,50,250,30);
        labelId.setForeground(Color.BLACK);
        Font f1 = new Font("open sans",Font.BOLD,25);
        labelId.setFont(f1);
        label.add(labelId);

        text = new JTextField();
        text.setBounds(370,50,150,30);
        label.add(text);

        searchButton = new JButton("Search");
        searchButton.setBounds(210,110,100,40);
        searchButton.setFont(new Font("open sans",Font.BOLD,15));
        searchButton.setFocusable(false);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(this);
        label.add(searchButton);

        backButton=new JButton("Back");
        backButton.setBounds(380,110,100,40);
        backButton.setFont(new Font("open sans",Font.BOLD,15));
        backButton.setFocusable(false);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        label.add(backButton);

        labelName = new JLabel("Name            :");
        labelName.setBounds(130,180,250,30);
        labelName.setForeground(Color.BLACK);
        Font f2 = new Font("serif",Font.BOLD,20);
        labelName.setFont(f2);
        label.add(labelName);

        label1 = new JLabel();
        label1.setBounds(280,180,350,30);
        label1.setForeground(Color.BLACK);
        Font F3 = new Font("serif",Font.BOLD,20);
        label1.setFont(F3);
        label.add(label1);

        labelPhone = new JLabel("Phone           :");
        labelPhone.setBounds(130,230,250,30);
        labelPhone.setForeground(Color.BLACK);
        Font f4 = new Font("serif",Font.BOLD,20);
        labelPhone.setFont(f4);
        label.add(labelPhone);

        label2 = new JLabel();
        label2.setBounds(280,230,350,30);
        label2.setForeground(Color.BLACK);
        Font f5 = new Font("serif",Font.BOLD,20);
        label2.setFont(f5);
        label.add(label2);

        labelEmail = new JLabel("Email            :");
        labelEmail.setBounds(130,280,250,30);
        labelEmail.setForeground(Color.BLACK);
        Font f6 = new Font("serif",Font.BOLD,20);
        labelEmail.setFont(f6);
        label.add(labelEmail);

        label3 = new JLabel();
        label3.setBounds(280,280,350,30);
        label3.setForeground(Color.BLACK);
        Font f7 = new Font("serif",Font.BOLD,20);
        label3.setFont(f7);
        label.add(label3);

        removeButton = new JButton("Remove");
        removeButton.setBounds(210,340,100,30);
        removeButton.setFocusable(false);
        removeButton.setBackground(Color.BLACK);
        removeButton.setForeground(Color.WHITE);
        removeButton.addActionListener(this);
        label.add(removeButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(390,340,100,30);
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.addActionListener(this);
        label.add(cancelButton);
        labelName.setVisible(false);
        labelPhone.setVisible(false);
        labelEmail.setVisible(false);
        removeButton.setVisible(false);
        cancelButton.setVisible(false);

        ImageIcon removeIcon = new ImageIcon(ClassLoader.getSystemResource("icon/removeBg1.png"));
        Image removeImage = removeIcon.getImage().getScaledInstance(700,450,Image.SCALE_DEFAULT);
        ImageIcon removeIcon2 = new ImageIcon(removeImage);
        JLabel labelImage = new JLabel(removeIcon2);
        labelImage.setBounds(0,0,700,450);
        removeFrame.add(labelImage);

        removeFrame.setSize(700,450);
        removeFrame.setLocation(300,120);
        removeFrame.setVisible(true);
        removeFrame.setResizable(false);
        removeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == searchButton){
            try{
                ConnectionDatabase connection = new ConnectionDatabase();
                String query = "select name,phone_number,email from employee where employee_id ='" + text.getText() + "' ";
                ResultSet resultSet = connection.statement.executeQuery(query);

                int i = 0;
                while(resultSet.next()){
                    String name = resultSet.getString("name");
                    String phone = resultSet.getString("phone_number");
                    String email = resultSet.getString("email");

                    labelName.setVisible(true);
                    labelPhone.setVisible(true);
                    labelEmail.setVisible(true);
                    removeButton.setVisible(true);
                    cancelButton.setVisible(true);
                    i = 1;
                    label1.setText(name);
                    label2.setText(phone);
                    label3.setText(email);
                }
                if(i == 0){
                    JOptionPane.showMessageDialog(null,"Id not found");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(ae.getSource() == removeButton){
            try{
                ConnectionDatabase connection = new ConnectionDatabase();
                String query = "delete from employee where employee_id = '" + text.getText()+"'";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"deleted successfully");
                labelName.setVisible(false);
                labelPhone.setVisible(false);
                labelEmail.setVisible(false);
                label1.setVisible(false);
                label2.setVisible(false);
                label3.setVisible(false);
                removeButton.setVisible(false);
                cancelButton.setVisible(false);

            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Exception occured while deleting record " + ex);
            }
        }
        if(ae.getSource() == cancelButton){
            removeFrame.setVisible(false);
            Details detail = new Details();
        }
        if(ae.getSource() == backButton){
            removeFrame.setVisible(false);
            Details detail = new Details();
        }
    }
}
