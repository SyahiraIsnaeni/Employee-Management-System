package employee;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;

class ViewEmployee implements ActionListener{

    JFrame viewFrame;
    JTextField text;
    JLabel label1, label2;
    JButton searchButton, cancelButton;

    ViewEmployee(){
        viewFrame = new JFrame("Employee Management System");
        viewFrame.setLayout(null);

        label1=new JLabel();
        label1.setBounds(0,0,500,270);
        label1.setLayout(null);

        label2 = new JLabel("Employee Id");
        label2.setVisible(true);
        label2.setBounds(100,145,250,30);
        label2.setForeground(Color.BLACK);
        Font F1 = new Font("Calibri",Font.BOLD,25);
        label2.setFont(F1);
        label1.add(label2);
        viewFrame.add(label1);

        text = new JTextField();
        text.setBounds(280,140,220,30);
        label1.add(text);

        searchButton = new JButton("Search");
        searchButton.setBounds(150,210,130,30);
        searchButton.setFont(new Font("open sans extra bold",Font.BOLD,15));
        searchButton.setFocusable(false);
        searchButton.setBackground(Color.BLACK);
        searchButton.setForeground(Color.WHITE);
        searchButton.addActionListener(this);
        label1.add(searchButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("open sans extra bold",Font.BOLD,15));
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(330,210,130,30);
        cancelButton.addActionListener(this);
        label1.add(cancelButton);

        ImageIcon peopleIcon = new ImageIcon(ClassLoader.getSystemResource("icon/people.png"));
        Image peopleImage = peopleIcon.getImage().getScaledInstance(225,200,Image.SCALE_DEFAULT);
        ImageIcon peopleIcon2 =  new ImageIcon(peopleImage);
        JLabel label1 = new JLabel(peopleIcon2);
        label1.setBounds(180,-35,225,200);
        viewFrame.add(label1);

        ImageIcon squareIcon = new ImageIcon(ClassLoader.getSystemResource("icon/cyan.png"));
        Image squareImage = squareIcon.getImage().getScaledInstance(500,250,Image.SCALE_DEFAULT);
        ImageIcon squareIcon2 =  new ImageIcon(squareImage);
        JLabel label2 = new JLabel(squareIcon2);
        label2.setBounds(45,60,500,250);
        viewFrame.add(label2);

        ImageIcon laptopIcon = new ImageIcon(ClassLoader.getSystemResource("icon/laptop.png"));
        Image viewImage = laptopIcon.getImage().getScaledInstance(600,350,Image.SCALE_DEFAULT);
        ImageIcon viewIcon =  new ImageIcon(viewImage);
        JLabel label3 = new JLabel(viewIcon);
        label3.setBounds(0,0,600,350);
        viewFrame.add(label3);

        viewFrame.setResizable(false);
        viewFrame.setSize(600,350);
        viewFrame.setLocation(350,150);
        viewFrame.setVisible(true);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == cancelButton){
            viewFrame.setVisible(false);
            Details detail = new Details();
        }
        if(ae.getSource() == searchButton){
            try{
                ConnectionDatabase connection = new ConnectionDatabase();
                String query = "select * from employee where employee_id ='" + text.getText() + "' ";
                ResultSet resultSet = connection.statement.executeQuery(query);
                if(resultSet.next()){
                    PrintData printData = new PrintData(text.getText());
                    viewFrame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    viewFrame.setVisible(false);
                    Details detail = new Details();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
}
