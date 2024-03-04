package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {

    CheckOut(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        JLabel co=new JLabel("Check Out");
        co.setBounds(100,20,150,30);
        co.setFont(new Font("Calibri", Font.BOLD,28));
        co.setForeground(Color.WHITE);
        panel.add(co);

        JLabel id=new JLabel("Customer ID");
        id.setBounds(30,80,100,20);
        id.setFont(new Font("Calibri", Font.BOLD,18));
        id.setForeground(Color.WHITE);
        panel.add(id);

        Choice c1=new Choice();
        c1.setBounds(200,76,150,16);
        c1.setFont(new Font("Calibri", Font.BOLD,16));
//        c1.setForeground(Color.WHITE);
        panel.add(c1);

        JLabel rn=new JLabel("Room No");
        rn.setBounds(30,130,100,20);
        rn.setFont(new Font("Calibri", Font.BOLD,18));
        rn.setForeground(Color.WHITE);
        panel.add(rn);
        JLabel labelrn=new JLabel();
        labelrn.setBounds(200,130,100,20);
        labelrn.setFont(new Font("Calibri", Font.BOLD,18));
        labelrn.setForeground(Color.WHITE);
        panel.add(labelrn);

        JLabel cit=new JLabel("Check-In Time");
        cit.setBounds(30,180,140,20);
        cit.setFont(new Font("Calibri", Font.BOLD,18));
        cit.setForeground(Color.WHITE);
        panel.add(cit);
        JLabel labelcs=new JLabel();
        labelcs.setBounds(200,180,200,20);
        labelcs.setFont(new Font("Calibri", Font.BOLD,18));
        labelcs.setForeground(Color.WHITE);
        panel.add(labelcs);

        JLabel cot=new JLabel("Check-Out Time");
        cot.setBounds(30,230,140,20);
        cot.setFont(new Font("Calibri", Font.BOLD,18));
        cot.setForeground(Color.WHITE);
        panel.add(cot);
        Date date=new Date();
        JLabel labelcot=new JLabel(""+date);
        labelcot.setBounds(200,230,200,20);
        labelcot.setFont(new Font("Calibri", Font.BOLD,18));
        labelcot.setForeground(Color.WHITE);
        panel.add(labelcot);

        try {
            conProvider con=new conProvider();
            ResultSet resultSet=con.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                c1.add(resultSet.getString("Number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        //buttons
        JButton checkout=new JButton("Check Out");
        checkout.setBounds(30,300,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Arial",Font.BOLD,15));
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conProvider con=new conProvider();
                try {
                    con.statement.executeUpdate("delete from customer where Number='"+c1.getSelectedItem()+"'");
                    con.statement.executeUpdate("update room set availability='Available' where roomNO='"+labelrn.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done");
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });


        JButton check=new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(check);
        panel.add(checkout);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conProvider con=new conProvider();
                try {
                    ResultSet resultSet=con.statement.executeQuery("select * from customer where Number='"+c1.getSelectedItem()+"'");
                    while (resultSet.next()){
                        labelrn.setText(resultSet.getString("Allocated_room"));
                        labelcs.setText(resultSet.getString("checkintime"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back=new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });






//        setUndecorated(true);
        setLocation(500,210);
        setLayout(null);
        setSize(800,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
