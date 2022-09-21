package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class Login extends JFrame implements ActionListener{
    private JFrame loginFrame;
    private JLabel usernameLabel, passwordLabel;
    private JTextField text1;
    private JPasswordField text2;
    JButton loginButton,cancelButton;
    Login(){

        loginFrame = new JFrame("Employee Management System");
        loginFrame.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setFont(new Font("open sans",Font.BOLD,14));
        usernameLabel.setBounds(40,50,100,30);
        loginFrame.add(usernameLabel);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("open sans",Font.BOLD,14));
        passwordLabel.setBounds(40,100,100,30);
        loginFrame.add(passwordLabel);

        text1 = new JTextField();
        text1.setBounds(150,50,150,30);
        loginFrame.add(text1);

        text2 = new JPasswordField();
        text2.setBounds(150,100,150,30);
        loginFrame.add(text2);

        loginButton = new JButton("Login");
        loginButton.setBounds(40,180,120,30);
        loginButton.setFont(new Font("open sans",Font.BOLD,15));
        loginButton.addActionListener(this);
        loginButton.setFocusable(false);
        loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);
        loginFrame.add(loginButton);

        cancelButton=new JButton("Cancel");
        cancelButton.setBounds(180,180,120,30);
        cancelButton.setFont(new Font("open sans",Font.BOLD,15));
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        loginFrame.add(cancelButton);

        cancelButton.addActionListener(this);

        ImageIcon square = new ImageIcon(ClassLoader.getSystemResource("icon/cyan.png"));
        Image squareImage = square.getImage().getScaledInstance(350,350,Image.SCALE_DEFAULT);
        ImageIcon squareIcon =  new ImageIcon(squareImage);
        JLabel label2 = new JLabel(squareIcon);
        label2.setBounds(3,-50,350,350);
        loginFrame.add(label2);

        ImageIcon key = new ImageIcon(ClassLoader.getSystemResource("icon/key.png"));
        Image keyImage = key.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon keyIcon =  new ImageIcon(keyImage);
        JLabel label = new JLabel(keyIcon);
        label.setBounds(380,45,150,150);
        loginFrame.add(label);

        ImageIcon bg = new ImageIcon(ClassLoader.getSystemResource("icon/bg.png"));
        Image bgImage = bg.getImage().getScaledInstance(600,300,Image.SCALE_DEFAULT);
        ImageIcon bgIcon =  new ImageIcon(bgImage);
        JLabel label3 = new JLabel(bgIcon);
        label3.setBounds(0,0,600,300);
        loginFrame.add(label3);

        loginFrame.getContentPane().setBackground(Color.WHITE);

        loginFrame.setResizable(false);
        loginFrame.setVisible(true);
        loginFrame.setSize(600,300);
        loginFrame.setLocation(350,200);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == loginButton){
            try{
                ConnectionDatabase connection = new ConnectionDatabase();
                String username = text1.getText();
                String password = text2.getText();

                String query = "select * from login where username='" + username + "' and password='" + password + "'";

                ResultSet resultSet = connection.statement.executeQuery(query);

                if(resultSet.next()){
                    new Details().detailFrame.setVisible(true);
                    loginFrame.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    loginFrame.setVisible(false);
                    new FrontPage();
                }

            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == cancelButton){
            loginFrame.setVisible(false);
            new FrontPage();
        }

    }
}
