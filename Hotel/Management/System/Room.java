package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;
    JButton back;
    JLabel roomNo,avail,status,price,bed;
    Room(){
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,890,590);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(600,200,200,200);
        panel1.add(label1);

        table=new JTable();
        table.setBounds(10,40,500,400);
        table.setBackground(new Color(48, 40, 3));
        table.setForeground(Color.WHITE);
        panel1.add(table);

        back=new JButton("Back");
        back.setBounds(200,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel1.add(back);

        roomNo=new JLabel("Room No");
        roomNo.setBounds(14,15,120,19);
        roomNo.setFont(new Font("Calibri", Font.BOLD,18));
        roomNo.setForeground(Color.WHITE);
        panel1.add(roomNo);

        avail=new JLabel("Availability");
        avail.setBounds(114,15,120,19);
        avail.setFont(new Font("Calibri", Font.BOLD,18));
        avail.setForeground(Color.WHITE);
        panel1.add(avail);

        status=new JLabel("Clean Status");
        status.setBounds(210,15,120,19);
        status.setFont(new Font("Calibri", Font.BOLD,18));
        status.setForeground(Color.WHITE);
        panel1.add(status);

        price=new JLabel("Price");
        price.setBounds(320,15,120,19);
        price.setFont(new Font("Calibri", Font.BOLD,18));
        price.setForeground(Color.WHITE);
        panel1.add(price);

        bed=new JLabel("Bed Type");
        bed.setBounds(415,15,120,19);
        bed.setFont(new Font("Calibri", Font.BOLD,18));
        bed.setForeground(Color.WHITE);
        panel1.add(bed);



        try{
            conProvider con=new conProvider();
            String q="select * from room";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils .resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(900,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Room();
    }
}
