package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {
    JButton add_EMP,add_Room,add_Driver,log_out,exit;
    Admin(){
       add_EMP=new JButton("ADD EMPLOYEE");
       add_EMP.setBounds(250,230,200,30);
       add_EMP.setBackground(Color.BLACK);
       add_EMP.setForeground(Color.WHITE);
       add_EMP.setFont(new Font("Arial",Font.BOLD,15));
       add_EMP.addActionListener(this);
       add(add_EMP);

        add_Room=new JButton("ADD ROOM");
        add_Room.setBounds(250,380,200,30);
        add_Room.setBackground(Color.BLACK);
        add_Room.setForeground(Color.WHITE);
        add_Room.setFont(new Font("Arial",Font.BOLD,15));
        add_Room.addActionListener(this);
        add(add_Room);

        add_Driver=new JButton("ADD DRIVER");
        add_Driver.setBounds(250,530,200,30);
        add_Driver.setBackground(Color.BLACK);
        add_Driver.setForeground(Color.WHITE);
        add_Driver.setFont(new Font("Arial",Font.BOLD,15));
        add_Driver.addActionListener(this);
        add(add_Driver);

        log_out=new JButton("Log Out");
        log_out.setBounds(10,700,95,30);
        log_out.setBackground(Color.WHITE);
        log_out.setForeground(Color.BLACK);
        log_out.setFont(new Font("Arial",Font.BOLD,15));
        log_out.addActionListener(this);
        add(log_out);

        exit=new JButton("Exit");
        exit.setBounds(110,700,95,30);
        exit.setBackground(Color.WHITE);
        exit.setForeground(Color.BLACK);
        exit.setFont(new Font("Arial",Font.BOLD,15));
        exit.addActionListener(this);
        add(exit);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/employees.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(70,180,120,120);
        add(label1);

        ImageIcon imageIcon3=new ImageIcon(ClassLoader.getSystemResource("icon/room.png"));
        Image i2=imageIcon3.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon4=new ImageIcon(i2);
        JLabel label2=new JLabel(imageIcon4);
        label2.setBounds(70,340,120,120);
        add(label2);

        ImageIcon imageIcon5=new ImageIcon(ClassLoader.getSystemResource("icon/driver.png"));
        Image i3=imageIcon5.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon6=new ImageIcon(i3);
        JLabel label3=new JLabel(imageIcon6);
        label3.setBounds(70,500,120,120);
        add(label3);

        ImageIcon imageIcon7=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i4=imageIcon7.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon8=new ImageIcon(i4);
        JLabel label4=new JLabel(imageIcon8);
        label4.setBounds(1000,250,400,400);
        add(label4);

        getContentPane().setBackground(new Color(48, 40, 3));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add_EMP){
            new AddEmployee();
        }else if (e.getSource()==add_Room){
            new AddRoom();
        } else if (e.getSource()==add_Driver) {
            new AddDriver();
        } else if (e.getSource()==log_out) {
            new Login2();
            setVisible(false);
        } else if (e.getSource()==exit) {
            System.exit(100);
        }
    }

    public static void main(String[] args) {
        new Admin();
    }
}
