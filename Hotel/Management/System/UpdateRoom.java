package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    JLabel urs,id,RN,avl,cs;
    Choice c1;
    JTextField RNJ,avalt,cst;
    JButton update,check,back;
    UpdateRoom(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,440);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/update.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

        urs=new JLabel("Update Room Status");
        urs.setBounds(124,11,222,28);
        urs.setFont(new Font("Calibri", Font.BOLD,28));
        urs.setForeground(Color.WHITE);
        panel.add(urs);

        id=new JLabel("ID");
        id.setBounds(25,85,46,18);
        id.setFont(new Font("Calibri", Font.BOLD,18));
        id.setForeground(Color.WHITE);
        panel.add(id);
        c1=new Choice();
        try{
            conProvider con=new conProvider();
            ResultSet resultSet=con.statement.executeQuery("select * from customer");
            while(resultSet.next()){
                c1.add(resultSet.getString("Number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(230,81,140,14);
        c1.setFont(new Font("Calibri", Font.BOLD,16));
        c1.setBackground(new Color(35, 116, 73));
        c1.setForeground(Color.WHITE);
        panel.add(c1);

        RN=new JLabel("Room No");
        RN.setBounds(25,135,85,18);
        RN.setFont(new Font("Calibri", Font.BOLD,18));
        RN.setForeground(Color.WHITE);
        panel.add(RN);
        RNJ=new JTextField();
        RNJ.setBounds(230,131,140,20);
        RNJ.setFont(new Font("Calibri", Font.BOLD,18));
        RNJ.setForeground(Color.WHITE);
        RNJ.setBackground(new Color(35, 116, 73));
        panel.add(RNJ);


        avl=new JLabel("Availability");
        avl.setBounds(25,185,120,18);
        avl.setFont(new Font("Calibri", Font.BOLD,18));
        avl.setForeground(Color.WHITE);
        panel.add(avl);
        avalt=new JTextField();
        avalt.setBounds(230,181,140,20);
        avalt.setFont(new Font("Calibri", Font.BOLD,18));
        avalt.setForeground(Color.WHITE);
        avalt.setBackground(new Color(35, 116, 73));
        panel.add(avalt);

        cs=new JLabel("Clean Status");
        cs.setBounds(25,235,120,18);
        cs.setFont(new Font("Calibri", Font.BOLD,18));
        cs.setForeground(Color.WHITE);
        panel.add(cs);
        cst=new JTextField();
        cst.setBounds(230,231,140,20);
        cst.setFont(new Font("Calibri", Font.BOLD,18));
        cst.setForeground(Color.WHITE);
        cst.setBackground(new Color(35, 116, 73));
        panel.add(cst);


        //buttons
        update=new JButton("Update");
        update.setBounds(55,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Arial",Font.BOLD,15));
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conProvider con=new conProvider();
                    String a=avalt.getText();
                    String c=cst.getText();
                    con.statement.executeUpdate("update room set cleaning_status='"+c+"',availability='"+a+"' where roomNO='"+RNJ.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(update);

        back=new JButton("Back");
        back.setBounds(168,378,89,23);
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

        check=new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setFont(new Font("Arial",Font.BOLD,15));
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=c1.getSelectedItem();
                String q="select * from customer where Number ='"+id+"'";

                try {
                    conProvider con=new conProvider();
                    ResultSet resultSet=con.statement.executeQuery(q);

                    while(resultSet.next()){
                        RNJ.setText(resultSet.getString("Allocated_room"));
                    }
                    ResultSet resultSet1=con.statement.executeQuery("select * from room where roomNO='"+RNJ.getText()+"'");

                    while(resultSet1.next()){
                        avalt.setText(resultSet1.getString("availability"));
                        cst.setText(resultSet1.getString("cleaning_status"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(check);



//        setUndecorated(true);
        setLocation(400,200);
        setLayout(null);
        setSize(950,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
