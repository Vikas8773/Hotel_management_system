package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom extends JFrame implements ActionListener {
    JTextField namet,pricet;
    JComboBox availablet,cleant,Btypet;
    JButton add,back,reset;
    JLabel label3,label5,label6;
    AddRoom(){
        //Labels
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,875,490);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

        JLabel label1=new JLabel("ADD ROOMS");
        label1.setBounds(350,10,200,27);
        label1.setFont(new Font("Tahoma", Font.BOLD,30));
        label1.setForeground(Color.WHITE);
        panel1.add(label1);


        JLabel label2=new JLabel("Room Number");
        label2.setBounds(64,70,152,22);
        label2.setFont(new Font("Calibri", Font.BOLD,18));
        label2.setForeground(Color.WHITE);
        panel1.add(label2);
        namet=new JTextField();
        namet.setBounds(200,70,156,24);
        namet.setFont(new Font("Calibri", Font.BOLD,18));
        namet.setForeground(Color.WHITE);
        namet.setBackground(new Color(35, 116, 73));
        panel1.add(namet);


        label3=new JLabel("Availability");
        label3.setBounds(64,110,152,22);
        label3.setFont(new Font("Calibri", Font.BOLD,18));
        label3.setForeground(Color.WHITE);
        panel1.add(label3);
        availablet=new JComboBox(new String[]{"Available","Occupied"});
        availablet.setBounds(200,110,156,24);
        availablet.setFont(new Font("Calibri", Font.BOLD,18));
        availablet.setForeground(Color.WHITE);
        availablet.setBackground(new Color(35, 116, 73));
        panel1.add(availablet);

        JLabel label4=new JLabel("Price");
        label4.setBounds(64,150,152,22);
        label4.setFont(new Font("Calibri", Font.BOLD,18));
        label4.setForeground(Color.WHITE);
        panel1.add(label4);
        pricet=new JTextField();
        pricet.setBounds(200,150,156,24);
        pricet.setFont(new Font("Calibri", Font.BOLD,18));
        pricet.setForeground(Color.WHITE);
        pricet.setBackground(new Color(35, 116, 73));
        panel1.add(pricet);

        label5=new JLabel("Cleaning Status");
        label5.setBounds(64,190,152,22);
        label5.setFont(new Font("Calibri", Font.BOLD,18));
        label5.setForeground(Color.WHITE);
        panel1.add(label5);
        cleant=new JComboBox(new String[]{"Durty","Cleaned"});
        cleant.setBounds(200,190,156,24);
        cleant.setFont(new Font("Calibri", Font.BOLD,18));
        cleant.setForeground(Color.WHITE);
        cleant.setBackground(new Color(35, 116, 73));
        panel1.add(cleant);

        label6=new JLabel("Bed Type");
        label6.setBounds(64,230,152,22);
        label6.setFont(new Font("Calibri", Font.BOLD,18));
        label6.setForeground(Color.WHITE);
        panel1.add(label6);
        Btypet=new JComboBox(new String[]{"Single","Double"});
        Btypet.setBounds(200,230,156,24);
        Btypet.setFont(new Font("Calibri", Font.BOLD,18));
        Btypet.setForeground(Color.WHITE);
        Btypet.setBackground(new Color(35, 116, 73));
        panel1.add(Btypet);



        //Buttons
        add=new JButton("ADD");
        add.setBounds(64,321,111,33);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial",Font.BOLD,15));
        add.addActionListener(this);
        panel1.add(add);

        back=new JButton("Back");
        back.setBounds(190,321,111,33);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(this);
        panel1.add(back);

        reset=new JButton("Reset");
        reset.setBounds(316,321,111,33);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial",Font.BOLD,15));
        reset.addActionListener(this);
        panel1.add(reset);

        //image
        ImageIcon imageIcon7=new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image i4=imageIcon7.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon8=new ImageIcon(i4);
        JLabel label7=new JLabel(imageIcon8);
        label7.setBounds(500,60,300,300);
        panel1.add(label7);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            try {
                conProvider con=new conProvider();
                String rooms=namet.getText();
                String aval=(String) availablet.getSelectedItem();
                String status=(String) cleant.getSelectedItem();
                String pri=pricet.getText();
                String type=(String) Btypet.getSelectedItem();

                String q="insert into room values('"+rooms+"','"+aval+"','"+status+"','"+pri+"','"+type+"')";
                con.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Room Added Successfully");
                //this.setVisible(false);

            }catch(Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==reset) {
            namet.setText("");
            pricet.setText("");

            availablet.setSelectedIndex(0);

            cleant.setSelectedIndex(0);

            Btypet.setSelectedIndex(0);


        } else {
            //new Admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
