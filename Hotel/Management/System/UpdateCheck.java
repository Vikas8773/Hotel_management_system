package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    JLabel CID,id,RN,name,cit,ap,pa;
    Choice c1;
    JTextField RNJ,namet,citt,apt,pat;
    JButton update,check,back;
    UpdateCheck(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(48, 40, 3));
        add(panel);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(500,60,300,300);
        panel.add(label1);

        CID=new JLabel("Check-In Details");
        CID.setBounds(124,11,222,28);
        CID.setFont(new Font("Calibri", Font.BOLD,28));
        CID.setForeground(Color.WHITE);
        panel.add(CID);

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


        name=new JLabel("Name");
        name.setBounds(25,185,85,18);
        name.setFont(new Font("Calibri", Font.BOLD,18));
        name.setForeground(Color.WHITE);
        panel.add(name);
        namet=new JTextField();
        namet.setBounds(230,181,140,20);
        namet.setFont(new Font("Calibri", Font.BOLD,18));
        namet.setForeground(Color.WHITE);
        namet.setBackground(new Color(35, 116, 73));
        panel.add(namet);

        cit=new JLabel("Checked-In");
        cit.setBounds(25,235,120,18);
        cit.setFont(new Font("Calibri", Font.BOLD,18));
        cit.setForeground(Color.WHITE);
        panel.add(cit);
        citt=new JTextField();
        citt.setBounds(230,231,140,20);
        citt.setFont(new Font("Calibri", Font.BOLD,18));
        citt.setForeground(Color.WHITE);
        citt.setBackground(new Color(35, 116, 73));
        panel.add(citt);

        ap=new JLabel("Amount Paid(Rs)");
        ap.setBounds(25,285,130,18);
        ap.setFont(new Font("Calibri", Font.BOLD,18));
        ap.setForeground(Color.WHITE);
        panel.add(ap);
        apt=new JTextField();
        apt.setBounds(230,281,140,20);
        apt.setFont(new Font("Calibri", Font.BOLD,18));
        apt.setForeground(Color.WHITE);
        apt.setBackground(new Color(35, 116, 73));
        panel.add(apt);

        pa=new JLabel("Pending Amount(Rs)");
        pa.setBounds(25,335,165,18);
        pa.setFont(new Font("Calibri", Font.BOLD,18));
        pa.setForeground(Color.WHITE);
        panel.add(pa);
        pat=new JTextField();
        pat.setBounds(230,331,140,20);
        pat.setFont(new Font("Calibri", Font.BOLD,18));
        pat.setForeground(Color.WHITE);
        pat.setBackground(new Color(35, 116, 73));
        panel.add(pat);

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
                    String q= c1.getSelectedItem();
                    String r=RNJ.getText();
                    String n=namet.getText();
                    String c=citt.getText();
                    String d=apt.getText();
                    con.statement.executeUpdate("update customer set Allocated_room='"+r+"',Name='"+n+"',checkintime='"+c+"',deposit='"+d+"' where Number='"+c1.getSelectedItem()+"'"  );
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
                        namet.setText(resultSet.getString("Name"));
                        citt.setText(resultSet.getString("checkintime"));
                        apt.setText(resultSet.getString("deposit"));
                    }
                    ResultSet resultSet1=con.statement.executeQuery("select * from room where roomNO='"+RNJ.getText()+"'");

                    while(resultSet1.next()){
                        String price=resultSet1.getString("price");
                        int amountPaid=Integer.parseInt(price)-Integer.parseInt(apt.getText());
                        pat.setText(""+amountPaid);
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });
        panel.add(check);



        setUndecorated(true);
        setLocation(400,150);
        setLayout(null);
        setSize(950,500);
        setVisible(true);
    }


    public static void main(String[] args) {
        new UpdateCheck();
    }
}
