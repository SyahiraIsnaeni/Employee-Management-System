package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class FrontPage implements ActionListener{

    JFrame frontFrame;
    JButton continueButton;

    FrontPage(){

        frontFrame = new JFrame();
        frontFrame.setTitle("Employee Management System");
        frontFrame.setBackground(Color.red);
        frontFrame.setLayout(null);

        continueButton = new JButton("CLICK HERE TO CONTINUE");
        continueButton.setFont(new Font("open sans extra bold", Font.BOLD,20));
        continueButton.setBackground(new Color(176, 226, 233));
        continueButton.setBounds(375,335,400,45);
        continueButton.setFocusable(false);
        continueButton.addActionListener(this);
        frontFrame.add(continueButton);

        ImageIcon icon = new ImageIcon("icon/employee.png");
        frontFrame.setIconImage(icon.getImage());

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bgFront2.png"));
        Image i2 = i1.getImage().getScaledInstance(1150,650,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);

        l1.setBounds(0,0,1150,600);
        frontFrame.add(l1);

        frontFrame.getContentPane().setBackground(Color.WHITE);

        frontFrame.setResizable(false);
        frontFrame.setVisible(true);
        frontFrame.setSize(1150,630);
        frontFrame.setLocation(75,25);
        frontFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == continueButton){
            frontFrame.setVisible(false);
            new Login();
        }
    }

    public static void main(String[] arg){

        FrontPage frontPage = new FrontPage();
    }
}
