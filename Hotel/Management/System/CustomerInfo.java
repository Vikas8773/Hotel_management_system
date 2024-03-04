package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    JTable table;
    JLabel name,id,number,gender,cn,AR,CIS,dp;
    JButton back;
    CustomerInfo(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        table=new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(48, 40, 3));
        table.setForeground(Color.WHITE);
        panel.add(table);
        try{
            conProvider con=new conProvider();
            String q="select * from customer";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        name=new JLabel("Name");
        name.setBounds(10,11,46,14);
        name.setFont(new Font("Calibri", Font.BOLD,18));
        name.setForeground(Color.WHITE);
        panel.add(name);

        id=new JLabel("ID");
        id.setBounds(130,11,46,14);
        id.setFont(new Font("Calibri", Font.BOLD,18));
        id.setForeground(Color.WHITE);
        panel.add(id);

        number=new JLabel("Number");
        number.setBounds(235,11,65,14);
        number.setFont(new Font("Calibri", Font.BOLD,18));
        number.setForeground(Color.WHITE);
        panel.add(number);

        gender=new JLabel("Gender");
        gender.setBounds(350,11,65,14);
        gender.setFont(new Font("Calibri", Font.BOLD,18));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        cn=new JLabel("Country");
        cn.setBounds(460,11,65,14);
        cn.setFont(new Font("Calibri", Font.BOLD,18));
        cn.setForeground(Color.WHITE);
        panel.add(cn);

        AR=new JLabel("Alloc Room");
        AR.setBounds(574,11,100,14);
        AR.setFont(new Font("Calibri", Font.BOLD,18));
        AR.setForeground(Color.WHITE);
        panel.add(AR);

        CIS=new JLabel("Checked-In");
        CIS.setBounds(685,11,90,14);
        CIS.setFont(new Font("Calibri", Font.BOLD,18));
        CIS.setForeground(Color.WHITE);
        panel.add(CIS);

        dp=new JLabel("Deposit");
        dp.setBounds(795,11,65,14);
        dp.setFont(new Font("Calibri", Font.BOLD,18));
        dp.setForeground(Color.WHITE);
        panel.add(dp);

        back=new JButton("Back");
        back.setBounds(190,470,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        //back.addActionListener(this);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }
}
