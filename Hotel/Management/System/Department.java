package Hotel.Management.System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    JButton back;
    JLabel department,budget;
    Department(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        JTable table=new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(48, 40, 3));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            conProvider con=new conProvider();
            String q="select * from Department";
            ResultSet resultSet=con.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        back=new JButton("Back");
        back.setBounds(400,410,120,30);
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

        department=new JLabel("Department");
        department.setBounds(130,11,105,20);
        department.setFont(new Font("Calibri", Font.BOLD,18));
        department.setForeground(Color.WHITE);
        panel.add(department);

        budget=new JLabel("Budget");
        budget.setBounds(450,11,105,20);
        budget.setFont(new Font("Calibri", Font.BOLD,18));
        budget.setForeground(Color.WHITE);
        panel.add(budget);

        setUndecorated(true);
        setLayout(null);
        setLocation(550,150);
        setSize(700,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Department();
    }
}
