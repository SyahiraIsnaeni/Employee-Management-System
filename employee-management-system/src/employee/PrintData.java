package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class PrintData implements ActionListener{
    JFrame printFrame;
    JLabel id, label1, labelName, label2, labelDob, label3, labelAge, label4, labelGender,
            label5, labelAddress, label6, labelPhone, label7, labelEmail, label8, labelEducation,
            label9, labelJob, label10, label11;
    String employeeId, gender, name, dateOfBirth, address, phone, email, education, job, age;
    JButton printButton, cancelButton;

    PrintData(String empId){
        try{
            ConnectionDatabase connection = new ConnectionDatabase();
            String query = "select * from employee where employee_id = '"+ empId +"'";
            ResultSet resultSet = connection.statement.executeQuery(query);

            while(resultSet.next()){

                name = resultSet.getString("name");
                dateOfBirth = resultSet.getString("date_of_birth");
                age = resultSet.getString("age");
                gender = resultSet.getString("gender");
                address = resultSet.getString("address");
                phone = resultSet.getString("phone_number");
                email = resultSet.getString("email");
                education = resultSet.getString("education");
                job = resultSet.getString("job_position");
                employeeId = resultSet.getString("employee_id");

            }
        }catch(Exception e){
            e.printStackTrace();
        }

        printFrame = new JFrame("Employee Management System");
        printFrame.setVisible(true);
        printFrame.setResizable(false);
        printFrame.setSize(720,600);
        printFrame.setLocation(290,50);
        printFrame.setBackground(Color.white);
        printFrame.setLayout(null);
        printFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label11 = new JLabel();
        label11.setBounds(0,0,595,642);
        label11.setLayout(null);
        printFrame.add(label11);

        printButton = new JButton("Print");
        printButton.setFont(new Font("open sans extra bold",Font.BOLD,15));
        printButton.setFocusable(false);
        printButton.setBackground(Color.BLACK);
        printButton.setForeground(Color.WHITE);
        printButton.setBounds(90,480,110,35);
        printButton.addActionListener(this);
        label11.add(printButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("open sans extra bold",Font.BOLD,15));
        cancelButton.setFocusable(false);
        cancelButton.setBackground(Color.BLACK);
        cancelButton.setForeground(Color.WHITE);
        cancelButton.setBounds(240,480,110,35);
        cancelButton.addActionListener(this);
        label11.add(cancelButton);

        id = new JLabel("Employee Id  :");
        id.setBounds(50,150,200,30);
        id.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(id);

        label1 = new JLabel(employeeId);
        label1.setBounds(200,150,200,30);
        label1.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label1);

        labelName = new JLabel("Name              :");
        labelName.setBounds(50,180,200,30);
        labelName.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelName);

        label2 = new JLabel(name);
        label2.setBounds(200,180,300,30);
        label2.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label2);

        labelDob = new JLabel("Date of Birth  :");
        labelDob.setBounds(50,210,200,30);
        labelDob.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelDob);

        label3 = new JLabel(dateOfBirth);
        label3.setBounds(200,210,300,30);
        label3.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label3);

        labelAge = new JLabel("Age                 :");
        labelAge.setBounds(50,240,200,30);
        labelAge.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelAge);

        label4 = new JLabel(age);
        label4.setBounds(200,240,300,30);
        label4.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label4);

        labelGender = new JLabel("Gender           : ");
        labelGender.setBounds(50,270,200,30);
        labelGender.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelGender);

        label5 = new JLabel(gender);
        label5.setBounds(200,270,300,30);
        label5.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label5);

        labelAddress = new JLabel("Address         :");
        labelAddress.setBounds(50,300,200,30);
        labelAddress.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelAddress);

        label6 = new JLabel(address);
        label6.setBounds(200,300,300,30);
        label6.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label6);

        labelPhone= new JLabel("Phone             : ");
        labelPhone.setBounds(50,330,200,30);
        labelPhone.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelPhone);

        label7 = new JLabel(phone);
        label7.setBounds(200,330,300,30);
        label7.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label7);

        labelEmail = new JLabel("Email              :");
        labelEmail.setBounds(50,360,200,30);
        labelEmail.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelEmail);

        label8= new JLabel(email);
        label8.setBounds(200,360,300,30);
        label8.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label8);

        labelEducation = new JLabel("Education      :");
        labelEducation.setBounds(50,390,200,30);
        labelEducation.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelEducation);

        label9= new JLabel(education);
        label9.setBounds(200,390,300,30);
        label9.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label9);

        labelJob = new JLabel("Job Post        :");
        labelJob.setBounds(50,420,200,30);
        labelJob.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(labelJob);

        label10 = new JLabel(job);
        label10.setBounds(200,420,300,30);
        label10.setFont(new Font("open sans",Font.BOLD,20));
        label11.add(label10);

        ImageIcon peopleIcon = new ImageIcon(ClassLoader.getSystemResource("icon/peopleLogo.png"));
        Image peopleImage = peopleIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon peopleIcon2 =  new ImageIcon(peopleImage);
        JLabel label1 = new JLabel(peopleIcon2);
        label1.setBounds(480,180,200,200);
        printFrame.add(label1);

        ImageIcon dataIcon = new ImageIcon(ClassLoader.getSystemResource("icon/dataBg1.png"));
        Image dataImage = dataIcon.getImage().getScaledInstance(720,600,Image.SCALE_DEFAULT);
        ImageIcon printDataIcon =  new ImageIcon(dataImage);
        JLabel label2 = new JLabel(printDataIcon);
        label2.setBounds(0,0,720,600);
        printFrame.add(label2);

    }

    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == printButton){
            JOptionPane.showMessageDialog(null,"printed successfully");
            printFrame.setVisible(false);
            Details detail = new Details();
        }
        if(ae.getSource() == cancelButton){
            printFrame.setVisible(false);
            Details detail = new Details();
        }
    }

}
