package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class pickupServices  extends JFrame {
    JLabel PUS,TOC,name,age,gender,car,carn,aval,loc;
    Choice c1;
    JButton display,back;
    pickupServices(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,590);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        PUS=new JLabel("PickUp Service");
        PUS.setBounds(90,20,220,35);
        PUS.setFont(new Font("Calibri", Font.BOLD,28));
        PUS.setForeground(Color.WHITE);
        panel.add(PUS);

        TOC=new JLabel("Type of Car");
        TOC.setBounds(32,97,89,16);
        TOC.setFont(new Font("Calibri", Font.BOLD,18));
        TOC.setForeground(Color.WHITE);
        panel.add(TOC);

        c1=new Choice();
        c1.setBounds(150,92,150,25);
        c1.setFont(new Font("Calibri", Font.BOLD,14));
        c1.setBackground(new Color(35, 116, 73));
        c1.setForeground(Color.WHITE);
        panel.add(c1);
        try{
            conProvider con=new conProvider();
            ResultSet resultSet=con.statement.executeQuery("select * from driver");
            while(resultSet.next()){
                c1.add(resultSet.getString("carname"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table=new JTable();
        table.setBounds(10,233,800,250);
        table.setBackground(new Color(48, 40, 3));
        table.setForeground(Color.WHITE);
        panel.add(table);
        try{
            conProvider con=new conProvider();
            String q="select * from driver";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        name=new JLabel("Name");
        name.setBounds(10,205,46,14);
        name.setFont(new Font("Calibri", Font.BOLD,18));
        name.setForeground(Color.WHITE);
        panel.add(name);

        age=new JLabel("Age");
        age.setBounds(125,205,46,14);
        age.setFont(new Font("Calibri", Font.BOLD,18));
        age.setForeground(Color.WHITE);
        panel.add(age);

        gender=new JLabel("Gender");
        gender.setBounds(240,200,65,16);
        gender.setFont(new Font("Calibri", Font.BOLD,18));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        car=new JLabel("Car Company");
        car.setBounds(350,200,110,16);
        car.setFont(new Font("Calibri", Font.BOLD,18));
        car.setForeground(Color.WHITE);
        panel.add(car);

        carn=new JLabel("Car Name");
        carn.setBounds(468,200,90,16);
        carn.setFont(new Font("Calibri", Font.BOLD,18));
        carn.setForeground(Color.WHITE);
        panel.add(carn);

        aval=new JLabel("Available");
        aval.setBounds(580,200,95,16);
        aval.setFont(new Font("Calibri", Font.BOLD,18));
        aval.setForeground(Color.WHITE);
        panel.add(aval);

        loc=new JLabel("Location");
        loc.setBounds(699,200,95,16);
        loc.setFont(new Font("Calibri", Font.BOLD,18));
        loc.setForeground(Color.WHITE);
        panel.add(loc);


        display=new JButton("Display");
        display.setBounds(200,500,120,30);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("Arial",Font.BOLD,15));
        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select * from driver where carname='"+c1.getSelectedItem()+"'";
                try {
                    conProvider con=new conProvider();
                    ResultSet resultSet=con.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));
                }
                catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(display);

        back=new JButton("Back");
        back.setBounds(420,500,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        panel.add(back);



//        setUndecorated(true);
        setLayout(null);
        setLocation(500,100);
        setSize(800,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new pickupServices();
    }
}
