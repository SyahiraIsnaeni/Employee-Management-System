package employee;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

class AddEmployee implements ActionListener{

    JFrame addFrame;
    JLabel nameLabel, dobLabel, ageLabel, genderLabel, addressLabel, phoneLabel, emailLabel, educationLabel,
            jobLabel, idLabel, label;
    JTextField textName, textDob, textAge, textGender, textAddress, textPhone, textEmail, textEducation,
            textJob, textId;
    JButton submitButton, cancelButton;

    AddEmployee(){
        addFrame = new JFrame("Employee Management System");
        addFrame.setLayout(null);

        label = new JLabel();
        label.setBounds(0,0,900,700);
        label.setLayout(null);
        addFrame.add(label);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(110,170,100,30);
        nameLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(nameLabel);

        textName=new JTextField();
        textName.setBounds(240,170,150,30);
        label.add(textName);

        dobLabel = new JLabel("Date of Birth");
        dobLabel.setBounds(460,170,200,30);
        dobLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(dobLabel);

        textDob=new JTextField();
        textDob.setBounds(640,170,150,30);
        label.add(textDob);

        ageLabel = new JLabel("Age");
        ageLabel.setBounds(110,220,100,30);
        ageLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(ageLabel);

        textAge = new JTextField();
        textAge.setBounds(240,220,150,30);
        label.add(textAge);

        genderLabel = new JLabel("Gender");
        genderLabel.setBounds(460,220,200,30);
        genderLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(genderLabel);

        textGender=new JTextField();
        textGender.setBounds(640,220,150,30);
        label.add(textGender);

        addressLabel= new JLabel("Address");
        addressLabel.setBounds(110,270,100,30);
        addressLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(addressLabel);

        textAddress=new JTextField();
        textAddress.setBounds(240,270,150,30);
        label.add(textAddress);

        phoneLabel= new JLabel("Phone");
        phoneLabel.setBounds(460,270,100,30);
        phoneLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(phoneLabel);

        textPhone = new JTextField();
        textPhone.setBounds(640,270,150,30);
        label.add(textPhone);

        emailLabel= new JLabel("Email");
        emailLabel.setBounds(110,320,100,30);
        emailLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(emailLabel);

        textEmail = new JTextField();
        textEmail.setBounds(240,320,150,30);
        label.add(textEmail);

        educationLabel = new JLabel("Education");
        educationLabel.setBounds(460,320,100,30);
        educationLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(educationLabel);

        textEducation=new JTextField();
        textEducation.setBounds(640,320,150,30);
        label.add(textEducation);

        jobLabel = new JLabel("Job Post");
        jobLabel.setBounds(110,370,100,30);
        jobLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(jobLabel);

        textJob = new JTextField();
        textJob.setBounds(240,370,150,30);
        label.add(textJob);

        idLabel= new JLabel("Employee Id");
        idLabel.setBounds(460,370,150,30);
        idLabel.setFont(new Font("open sans extra bold",Font.BOLD,17));
        label.add(idLabel);

        textId = new JTextField();
        textId.setBounds(640,370,150,30);
        label.add(textId);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("open sans extra bold",Font.BOLD,17));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBounds(260,430,150,40);

        label.add(submitButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("open sans extra bold",Font.BOLD,17));
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(465,430,150,40);

        label.add(cancelButton);

        submitButton.addActionListener(this);
        cancelButton.addActionListener(this);

        ImageIcon detailIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employeeDetail2.png"));
        Image detailImage = detailIcon.getImage().getScaledInstance(900,600,Image.SCALE_DEFAULT);
        ImageIcon employeeIcon =  new ImageIcon(detailImage);
        JLabel label = new JLabel(employeeIcon);
        label.setBounds(0,0,900,600);
        addFrame.add(label);

        addFrame.setResizable(false);
        addFrame.setVisible(true);
        addFrame.setSize(900,600);
        addFrame.setLocation(200,50);
        addFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){

        String name = textName.getText();
        String dateOfBirth = textDob.getText();
        String age = textAge.getText();
        String gender = textGender.getText();
        String address = textAddress.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        String education = textEducation.getText();
        String job = textJob.getText();
        String id = textId.getText();
        if(ae.getSource() == submitButton){
            try{
                ConnectionDatabase connection = new ConnectionDatabase();
                String query = "insert into employee values('"+ name +"','"+ dateOfBirth +"','"+ age +"','"+ gender +"','"+ address +"','"+ phone +"','"+ email +"','"+ education +"','"+ job +"','"+ id +"')";
                connection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                addFrame.setVisible(false);
                new Details();
            }catch(Exception e){
                System.out.println("The error is:" + e);
            }
        }else if(ae.getSource() == cancelButton){
            addFrame.setVisible(false);
            new Details();
        }
    }
}
