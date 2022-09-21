package employee;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class SearchEmployee implements ActionListener{
    JFrame searchFrame;
    JTextField text;
    JLabel labelId, label;
    JButton searchButton, cancelButton;

    SearchEmployee(){
        searchFrame = new JFrame("Employee Management System");
        searchFrame.setBackground(Color.green);
        searchFrame.setLayout(null);

        label = new JLabel();
        label.setBounds(0,0,500,270);
        label.setLayout(null);

        searchButton = new JButton("Search");
        searchButton.setBounds(200,240,100,30);
        searchButton.addActionListener(this);
        label.add(searchButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(320,240,100,30);
        cancelButton.addActionListener(this);
        label.add(cancelButton);

        labelId = new JLabel("Employee Id");
        labelId.setVisible(true);
        labelId.setBounds(140,180,200,25);
        labelId.setForeground(Color.BLACK);
        Font f1 = new Font("open sans",Font.BOLD,18);
        labelId.setFont(f1);
        label.add(labelId);
        searchFrame.add(label);

        text = new JTextField();
        text.setBounds(310,180,150,25);
        label.add(text);

        ImageIcon searchIcon = new ImageIcon(ClassLoader.getSystemResource("icon/searchEmployee.png"));
        Image searchImage = searchIcon.getImage().getScaledInstance(600,380,Image.SCALE_DEFAULT);
        ImageIcon searchIcon2 = new ImageIcon(searchImage);
        JLabel labelImage = new JLabel(searchIcon2);
        labelImage.setBounds(0,0,600,380);
        searchFrame.add(labelImage);

        searchFrame.setSize(600,380);
        searchFrame.setLocation(360,170);
        searchFrame.setVisible(true);
        searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == cancelButton){
            searchFrame.setVisible(false);
            Details detail = new Details();
        }
        if(ae.getSource() == searchButton){
            try{
                ConnectionDatabase connection = new ConnectionDatabase();
                String query = "select * from employee where employee_id ='" + text.getText() + "' ";
                ResultSet resultSet = connection.statement.executeQuery(query);
                if(resultSet.next()){
                    new UpdateEmployee(text.getText()).updateFrame.setVisible(true);
                    searchFrame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    searchFrame.setVisible(false);
                    Details detail = new Details();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
