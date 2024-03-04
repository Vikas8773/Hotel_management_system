package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class dashBoard extends JFrame implements ActionListener {
    JButton add,rec;
    dashBoard(){
        super("HOTEL MANAGEMENT SYSTEM");

        rec=new JButton("RECEPTION");
        rec.setBounds(525,510,140,30);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

        add=new JButton("ADMIN");
        add.setBounds(850,510,140,30);
        add.setFont(new Font("Tahoma",Font.BOLD,15));
        add.setBackground(new Color(255,98,0));
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/boss.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel jLabel1=new JLabel(imageIcon2);
        jLabel1.setBounds(820,300,200,195);
        add(jLabel1);

        ImageIcon imageIcon3=new ImageIcon(ClassLoader.getSystemResource("icon/Reception.png"));
        Image i2=imageIcon3.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon imageIcon4=new ImageIcon(i2);
        JLabel jLabel2=new JLabel(imageIcon4);
        jLabel2.setBounds(500,300,200,195);
        add(jLabel2);

        ImageIcon imageIcon5=new ImageIcon(ClassLoader.getSystemResource("icon/Dashboard.gif"));
        Image i3=imageIcon5.getImage().getScaledInstance(1950,1080,Image.SCALE_DEFAULT);
        ImageIcon imageIcon6=new ImageIcon(i3);
        JLabel jLabel3=new JLabel(imageIcon6);
        jLabel3.setBounds(0,0,1950,1080);
        add(jLabel3);

        setLayout(null);
        setSize(1950,1080);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            new Reception();
            setVisible(false);
        }
        else {
            new Login2();
            //setVisible(false);
        }
    }

    public static void main(String[] args) {
        new dashBoard();
    }
}
