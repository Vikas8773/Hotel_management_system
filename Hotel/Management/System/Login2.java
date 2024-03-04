package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login2 extends JFrame implements ActionListener{
    JTextField jTextField1;
    JPasswordField jPasswordField1;
    JButton b1,b2;
    Login2(){

        JLabel AD=new JLabel("Admin Login ");
        AD.setBounds(70,10,200,30);
        AD.setFont(new Font("Tahoma", Font.BOLD,30));
        AD.setForeground(Color.WHITE);
        add(AD);

        JLabel label1=new JLabel("Username");
        label1.setBounds(40,60,100,30);
        label1.setFont(new Font("Impact", Font.ITALIC,18));
        label1.setForeground(Color.WHITE);
        add(label1);

        JLabel label2=new JLabel("Password");
        label2.setBounds(40,100,100,30);
        label2.setFont(new Font("Impact", Font.ITALIC,18));
        label2.setForeground(Color.WHITE);
        add(label2);


        jTextField1=new JTextField();
        jTextField1.setBounds(150,60,150,30);
        jTextField1.setForeground(Color.WHITE);
        jTextField1.setFont(new Font("Impact",Font.PLAIN,18));
        jTextField1.setBackground(new Color(35, 116, 73));
        add(jTextField1);

        jPasswordField1=new JPasswordField();
        jPasswordField1.setBounds(150,100,150,30);
        jPasswordField1.setForeground(Color.WHITE);
        jPasswordField1.setBackground(new Color(35, 116, 73));
        add(jPasswordField1);


        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        //Image i1=imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT); if gif file is there
        JLabel label=new JLabel(imageIcon);
        label.setBounds(318,-30,255,300);
        add(label);


        b1=new JButton("Login");
        b1.setBounds(40,170,120,30);
        b1.setFont(new Font("Serif",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,170,120,30);
        b2.setFont(new Font("Serif",Font.BOLD,18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);


        getContentPane().setBackground(new Color(48, 40, 3));
        setUndecorated(true);
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
                conProvider con=new conProvider();
                String user=jTextField1.getText();
                String pass=jPasswordField1.getText();

                String q="select * from login2 where username='"+user+"' and password='"+pass+"'";
                ResultSet resultSet=con.statement.executeQuery(q);

                if(resultSet.next()){
                    new Admin();
                    setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Invalid credentials");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else{
//            System.exit(100);
            new dashBoard();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login2();
    }
}
