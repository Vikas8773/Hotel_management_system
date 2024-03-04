package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {
    JLabel SFR,RBT,RN,avl,sts,price,type;
    JCheckBox ODA;
    Choice ch;
    JTable table;
    JButton search,back;
    SearchRoom(){
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,690,490);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

        SFR=new JLabel("Search For Room");
        SFR.setBounds(250,11,186,31);
        SFR.setFont(new Font("Calibri", Font.BOLD,20));
        SFR.setForeground(Color.WHITE);
        panel1.add(SFR);

        RBT=new JLabel("Room Bed Type");
        RBT.setBounds(50,74,120,14);
        RBT.setFont(new Font("Calibri", Font.BOLD,14));
        RBT.setForeground(Color.WHITE);
        panel1.add(RBT);

        ODA=new JCheckBox("Only Display Available");
        ODA.setBounds(400,69,205,23);
        //ODA.setFont(new Font("Calibri", Font.BOLD,20));
        ODA.setForeground(Color.WHITE);
        ODA.setBackground(new Color(48, 40, 3));
        panel1.add(ODA);

        ch=new Choice();
        ch.add("Single");
        ch.add("Double");
        ch.setBounds(170,70,120,20);
        panel1.add(ch);

        table=new JTable();
        table.setBounds(0,187,700,150);
        table.setForeground(Color.white);
        table.setBackground(new Color(48, 40, 3));
        panel1.add(table);
        try {
            conProvider con=new conProvider();
            String q="select * from room";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        RN=new JLabel("Room No.");
        RN.setBounds(0,162,100,20);
        RN.setFont(new Font("Calibri", Font.BOLD,18));
        RN.setForeground(Color.WHITE);
        panel1.add(RN);

        avl=new JLabel("Availability");
        avl.setBounds(140,162,100,20);
        avl.setFont(new Font("Calibri", Font.BOLD,18));
        avl.setForeground(Color.WHITE);
        panel1.add(avl);

        sts=new JLabel("Status");
        sts.setBounds(280,162,100,20);
        sts.setFont(new Font("Calibri", Font.BOLD,18));
        sts.setForeground(Color.WHITE);
        panel1.add(sts);

        price=new JLabel("Price");
        price.setBounds(420,162,100,20);
        price.setFont(new Font("Calibri", Font.BOLD,18));
        price.setForeground(Color.WHITE);
        panel1.add(price);

        type=new JLabel("Bed Type");
        type.setBounds(560,162,100,20);
        type.setFont(new Font("Calibri", Font.BOLD,18));
        type.setForeground(Color.WHITE);
        panel1.add(type);


        search=new JButton("Search");
        search.setBounds(200,400,120,30);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Arial",Font.BOLD,15));
        search.addActionListener(this);
        panel1.add(search);

        back=new JButton("Back");
        back.setBounds(380,400,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(this);
        panel1.add(back);


        setUndecorated(true);
        setLocation(550,160);
        setLayout(null);
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==search){
            String q1="select * from room where bed_type='"+ch.getSelectedItem()+"'";
            String q2="select * from room where availability='Available' And bed_type='"+ch.getSelectedItem()+"'";

            try {
                conProvider con=new conProvider();
                ResultSet resultSet=con.statement.executeQuery(q1);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));

                if(ODA.isSelected()){
                    ResultSet resultSet1=con.statement.executeQuery(q2);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet1));
                }
            }
            catch (Exception E){
                E.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
