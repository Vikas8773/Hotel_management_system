package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

//        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/cccc.png"));
//        Image i1=imageIcon1.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
//        ImageIcon imageIcon2=new ImageIcon(i1);
//        JLabel jLabel1=new JLabel(imageIcon2);
//        jLabel1.setBounds(300,20,800,800);
//        panel.add(jLabel1);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel jLabel1=new JLabel(imageIcon2);
        jLabel1.setBounds(5,530,250,250);
        panel1.add(jLabel1);

        JButton btnNCF=new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,30);
        btnNCF.setFont(new Font("Arial",Font.BOLD,15));
        btnNCF.setBackground(Color.BLACK);
        btnNCF.setForeground(Color.WHITE);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new newCustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnRoom=new JButton("Room");
        btnRoom.setBounds(30,70,200,30);
        btnRoom.setFont(new Font("Arial",Font.BOLD,15));
        btnRoom.setBackground(Color.BLACK);
        btnRoom.setForeground(Color.WHITE);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnDepartment=new JButton("Department");
        btnDepartment.setBounds(30,110,200,30);
        btnDepartment.setFont(new Font("Arial",Font.BOLD,15));
        btnDepartment.setBackground(Color.BLACK);
        btnDepartment.setForeground(Color.WHITE);
        panel1.add(btnDepartment);
        btnDepartment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnAEI=new JButton("All Employee Info");
        btnAEI.setBounds(30,150,200,30);
        btnAEI.setFont(new Font("Arial",Font.BOLD,15));
        btnAEI.setBackground(Color.BLACK);
        btnAEI.setForeground(Color.WHITE);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new EmployeeInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCI=new JButton("Customer Info");
        btnCI.setBounds(30,190,200,30);
        btnCI.setFont(new Font("Arial",Font.BOLD,15));
        btnCI.setBackground(Color.BLACK);
        btnCI.setForeground(Color.WHITE);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CustomerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnMI=new JButton("Manager Info");
        btnMI.setBounds(30,230,200,30);
        btnMI.setFont(new Font("Arial",Font.BOLD,15));
        btnMI.setBackground(Color.BLACK);
        btnMI.setForeground(Color.WHITE);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new ManagerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCO=new JButton("Check Out");
        btnCO.setBounds(30,270,200,30);
        btnCO.setFont(new Font("Arial",Font.BOLD,15));
        btnCO.setBackground(Color.BLACK);
        btnCO.setForeground(Color.WHITE);
        panel1.add(btnCO);
        btnCO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnUCD=new JButton("Update Check-in Details");
        btnUCD.setBounds(30,310,200,30);
        btnUCD.setFont(new Font("Arial",Font.BOLD,15));
        btnUCD.setBackground(Color.BLACK);
        btnUCD.setForeground(Color.WHITE);
        panel1.add(btnUCD);
        btnUCD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateCheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnURS=new JButton("Update Room Status");
        btnURS.setBounds(30,350,200,30);
        btnURS.setFont(new Font("Arial",Font.BOLD,15));
        btnURS.setBackground(Color.BLACK);
        btnURS.setForeground(Color.WHITE);
        panel1.add(btnURS);
        btnURS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new UpdateRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnPS=new JButton("Pick-up Service");
        btnPS.setBounds(30,390,200,30);
        btnPS.setFont(new Font("Arial",Font.BOLD,15));
        btnPS.setBackground(Color.BLACK);
        btnPS.setForeground(Color.WHITE);
        panel1.add(btnPS);
        btnPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new pickupServices();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnSR=new JButton("Search Room");
        btnSR.setBounds(30,430,200,30);
        btnSR.setFont(new Font("Arial",Font.BOLD,15));
        btnSR.setBackground(Color.BLACK);
        btnSR.setForeground(Color.WHITE);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(30,470,200,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new dashBoard();
                setVisible(false);
            }
        });


        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setSize(1950,1080);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();
    }
}
