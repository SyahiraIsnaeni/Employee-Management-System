package employee;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

class UpdateEmployee implements ActionListener{

    JFrame updateFrame;
    JLabel label, labelName, labelDob, labelAge, labelGender, labelAddress, labelPhone, labelEmail, labelEducation,
            labelJob, labelId;
    JTextField textName, textDob, textAge, textGender, textAddress, textPhone, textEmail, textEducation,
            textJob, textId;
    JButton updateButton, cancelButton;
    String idEmp;

    UpdateEmployee(String id){
        updateFrame = new JFrame("Employee Management System");
        updateFrame.setSize(900,550);
        updateFrame.setLocation(200,250);
        updateFrame.setBackground(Color.white);
        updateFrame.setLayout(null);
        updateFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        idEmp = id;
        label = new JLabel();
        label.setBounds(0,0,900,500);
        label.setLayout(null);
        updateFrame.add(label);

        updateButton = new JButton("Update");
        updateButton.setBounds(295,365,100,30);
        updateButton.addActionListener(this);
        label.add(updateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(495,365,100,30);
        cancelButton.addActionListener(this);
        label.add(cancelButton);

        labelName = new JLabel("Name");
        labelName.setBounds(120,150,100,25);
        labelName.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelName);

        textName=new JTextField();
        textName.setBounds(240,150,150,25);
        label.add(textName);

        labelDob = new JLabel("Date of Birth");
        labelDob.setBounds(480,150,200,25);
        labelDob.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelDob);

        textDob=new JTextField();
        textDob.setBounds(640,150,150,25);
        label.add(textDob);

        labelGender = new JLabel("Gender");
        labelGender.setBounds(480,200,100,25);
        labelGender.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelGender);

        textGender = new JTextField();
        textGender.setBounds(640,200,150,25);
        label.add(textGender);

        labelAddress = new JLabel("Address");
        labelAddress.setBounds(120,200,100,25);
        labelAddress.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelAddress);

        textAddress = new JTextField();
        textAddress.setBounds(240,200,150,25);
        label.add(textAddress);

        labelEmail= new JLabel("Email");
        labelEmail.setBounds(120,250,100,25);
        labelEmail.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelEmail);

        textEmail = new JTextField();
        textEmail.setBounds(240,250,150,25);
        label.add(textEmail);

        labelEducation= new JLabel("Education");
        labelEducation.setBounds(480,250,100,25);
        labelEducation.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelEducation);

        textEducation = new JTextField();
        textEducation.setBounds(640,250,150,25);
        label.add(textEducation);

        labelJob = new JLabel("Job Post");
        labelJob.setBounds(120,300,150,25);
        labelJob.setFont(new Font("open sans",Font.BOLD,18));
        label.add(labelJob);

        textJob = new JTextField();
        textJob.setBounds(240,300,150,25);
        label.add(textJob);


        ImageIcon updateIcon = new ImageIcon(ClassLoader.getSystemResource("icon/updateEmployee.png"));
        Image updateImage = updateIcon.getImage().getScaledInstance(900,550,Image.SCALE_DEFAULT);
        ImageIcon updateIcon2 = new ImageIcon(updateImage);
        JLabel labelImage = new JLabel(updateIcon2);
        labelImage.setBounds(0,0,900,550);
        updateFrame.add(labelImage);

        showData(id);
    }

    int i = 0;
    String age, phone, id;

    void showData(String s){
        try{
            ConnectionDatabase connection = new ConnectionDatabase();
            String query = "select * from employee where employee_id = '"+ s +"'";
            ResultSet resultSet = connection.statement.executeQuery(query);

            if(resultSet.next()){
                updateFrame.setVisible(true);

                i = 1;

                textName.setText(resultSet.getString("name"));
                textDob.setText(resultSet.getString("date_of_birth"));
                textGender.setText(resultSet.getString("gender"));
                textAddress.setText(resultSet.getString("address"));
                textEmail.setText(resultSet.getString("email"));
                textEducation.setText(resultSet.getString("education"));
                textJob.setText(resultSet.getString("job_position"));

                age = resultSet.getString("age");
                phone = resultSet.getString("phone_number");
                id = resultSet.getString("employee_id");

            }
            if(i == 0){
                JOptionPane.showMessageDialog(null,"Id not found");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        updateFrame.setVisible(true);
        updateFrame.setSize(900,500);
        updateFrame.setLocation(200,80);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == updateButton && i == 1){
            try{
                ConnectionDatabase connnection = new ConnectionDatabase();
                String query = "update employee set name='"+ textName.getText() +"',date_of_birth='"+ textDob.getText() +
                        "',age='"+age+"',gender='"+textGender.getText()+"',address='"+ textAddress.getText() +"',phone_number='"+phone+
                        "',email='"+textEmail.getText()+"',education='"+textEducation.getText()+"',job_position='"+textJob.getText()+
                        "',employee_id='"+id+"'";
                connnection.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"successfully updated");
                updateFrame.setVisible(false);
                Details detail = new Details();
            }catch(Exception e){
                System.out.println("The error is:" + e);
            }
        }
        if(ae.getSource() == cancelButton){
            updateFrame.setVisible(false);
            Details detail = new Details();
        }
    }
}
