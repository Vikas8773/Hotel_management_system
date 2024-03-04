package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ManagerInfo  extends JFrame {

    JButton back;
    JLabel name,age,gender,job,salary,mobNo,email;
    ManagerInfo(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,1090,590);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        JTable table=new JTable();
        table.setBounds(10,34,1080,450);
        table.setBackground(new Color(48, 40, 3));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conProvider con=new conProvider();
            String q="select * from employee where job='Manager'";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(350,500,120,30);
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

        name=new JLabel("Name");
        name.setBounds(12,11,70,19);
        name.setFont(new Font("Calibri", Font.BOLD,18));
        name.setForeground(Color.WHITE);
        panel.add(name);

        age=new JLabel("Age");
        age.setBounds(166,11,105,20);
        age.setFont(new Font("Calibri", Font.BOLD,18));
        age.setForeground(Color.WHITE);
        panel.add(age);

        gender=new JLabel("Gender");
        gender.setBounds(320,11,105,20);
        gender.setFont(new Font("Calibri", Font.BOLD,18));
        gender.setForeground(Color.WHITE);
        panel.add(gender);

        job=new JLabel("Job");
        job.setBounds(480,11,105,20);
        job.setFont(new Font("Calibri", Font.BOLD,18));
        job.setForeground(Color.WHITE);
        panel.add(job);

        salary=new JLabel("Salary");
        salary.setBounds(630,11,105,20);
        salary.setFont(new Font("Calibri", Font.BOLD,18));
        salary.setForeground(Color.WHITE);
        panel.add(salary);

        mobNo=new JLabel("mobNo");
        mobNo.setBounds(784,11,105,20);
        mobNo.setFont(new Font("Calibri", Font.BOLD,18));
        mobNo.setForeground(Color.WHITE);
        panel.add(mobNo);

        email=new JLabel("email");
        email.setBounds(943,11,105,20);
        email.setFont(new Font("Calibri", Font.BOLD,18));
        email.setForeground(Color.WHITE);
        panel.add(email);



        setUndecorated(true);
        setLayout(null);
        setLocation(370,100);
        setSize(1100,600);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ManagerInfo();
    }
}
