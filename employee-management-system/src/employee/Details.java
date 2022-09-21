package employee;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Details  implements ActionListener{

    JFrame detailFrame;
    JLabel label1;
    JButton AddButton, viewButton, removeButton, updateButton;

    Details(){

        detailFrame = new JFrame("Employee Management System");
        detailFrame.setLayout(null);

        label1 = new JLabel();
        label1.setBounds(0,0,700,500);
        label1.setLayout(null);

        AddButton = new JButton("Add");
        AddButton.setBounds(210,250,150,40);
        AddButton.setFocusable(false);
        AddButton.setFont(new Font("open sans extra bold",Font.BOLD,17));
        AddButton.addActionListener(this);
        label1.add(AddButton);

        viewButton = new JButton("View");
        viewButton.setBounds(500,250,150,40);
        viewButton.setFont(new Font("open sans extra bold",Font.BOLD,17));
        viewButton.setFocusable(false);
        viewButton.addActionListener(this);
        label1.add(viewButton);

        removeButton = new JButton("Remove");
        removeButton.setBounds(210,320,150,40);
        removeButton.setFont(new Font("open sans extra bold",Font.BOLD,17));
        removeButton.setFocusable(false);
        removeButton.addActionListener(this);
        label1.add(removeButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(500,320,150,40);
        updateButton.setFont(new Font("open sans extra bold",Font.BOLD,17));
        updateButton.setFocusable(false);
        updateButton.addActionListener(this);
        label1.add(updateButton);

        ImageIcon detailIcon = new ImageIcon(ClassLoader.getSystemResource("icon/employeeDetail.png"));
        Image detailImage = detailIcon.getImage().getScaledInstance(850,500,Image.SCALE_DEFAULT);
        ImageIcon employeeIcon =  new ImageIcon(detailImage);
        JLabel label = new JLabel(employeeIcon);
        label.setBounds(0,0,850,500);

        detailFrame.add(label1);
        detailFrame.add(label);

        detailFrame.setResizable(false);
        detailFrame.setVisible(true);
        detailFrame.setSize(850,500);
        detailFrame.setLocation(220,100);
        detailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == AddButton){
            detailFrame.setVisible(false);
            new AddEmployee();
        }
        if(ae.getSource() == viewButton){
            detailFrame.setVisible(false);
            new ViewEmployee();
        }
        if(ae.getSource() == removeButton){
            detailFrame.setVisible(false);
            new RemoveEmployee();
        }
        if(ae.getSource() == updateButton){
            detailFrame.setVisible(false);
            new SearchEmployee();
        }
    }
}
