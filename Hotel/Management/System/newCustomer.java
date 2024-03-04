package Hotel.Management.System;

//import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class newCustomer extends JFrame implements ActionListener {
    JLabel NCF,id,cd,name,gender,cn,AR,CIS,date,dp;
    JTextField cdt,namet,cnt,dpt;
    JComboBox idt;
    JRadioButton male,female;
    Choice c1;
    JButton add,back,reset;
    newCustomer(){
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,840,540);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/customer.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(550,150,200,200);
        panel1.add(label1);

        NCF=new JLabel("New Customer Form");
        NCF.setBounds(240,11,280,32);
        NCF.setFont(new Font("Calibri", Font.BOLD,32));
        NCF.setForeground(Color.WHITE);
        panel1.add(NCF);

        name=new JLabel("Name");
        name.setBounds(30,70,200,27);
        name.setFont(new Font("Impact", Font.ITALIC,18));
        name.setForeground(Color.WHITE);
        panel1.add(name);
        namet=new JTextField();
        namet.setBounds(190,70,156,27);
        namet.setFont(new Font("Calibri", Font.BOLD,20));
        namet.setForeground(Color.WHITE);
        namet.setBackground(new Color(35, 116, 73));
        panel1.add(namet);

        id=new JLabel("ID");
        id.setBounds(30,120,200,27);
        id.setFont(new Font("Impact", Font.ITALIC,18));
        id.setForeground(Color.WHITE);
        panel1.add(id);
        idt=new JComboBox(new String[]{"Passport","Adhar card","Voter ID","Driving Licence"});
        idt.setBounds(190,120,156,27);
        idt.setFont(new Font("Calibri", Font.BOLD,20));
        idt.setForeground(Color.WHITE);
        idt.setBackground(new Color(35, 116, 73));
        panel1.add(idt);

        cd=new JLabel("Number");
        cd.setBounds(30,170,200,27);
        cd.setFont(new Font("Impact", Font.ITALIC,18));
        cd.setForeground(Color.WHITE);
        panel1.add(cd);
        cdt=new JTextField();
        cdt.setBounds(190,170,156,27);
        cdt.setFont(new Font("Calibri", Font.BOLD,20));
        cdt.setForeground(Color.WHITE);
        cdt.setBackground(new Color(35, 116, 73));
        panel1.add(cdt);

        gender=new JLabel("Gender");
        gender.setBounds(30,220,200,27);
        gender.setFont(new Font("Impact", Font.ITALIC,18));
        gender.setForeground(Color.WHITE);
        panel1.add(gender);
        male=new JRadioButton("Male");
        male.setBounds(190,220,90,27);
        male.setFont(new Font("Calibri", Font.BOLD,20));
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(35, 116, 73));
        panel1.add(male);

        female=new JRadioButton("Female");
        female.setBounds(300,220,90,27);
        female.setFont(new Font("Calibri", Font.BOLD,20));
        female.setForeground(Color.WHITE);
        female.setBackground(new Color(35, 116, 73));
        panel1.add(female);

        cn=new JLabel("Country");
        cn.setBounds(30,270,200,27);
        cn.setFont(new Font("Impact", Font.ITALIC,18));
        cn.setForeground(Color.WHITE);
        panel1.add(cn);
        cnt=new JTextField();
        cnt.setBounds(190,270,156,27);
        cnt.setFont(new Font("Calibri", Font.BOLD,20));
        cnt.setForeground(Color.WHITE);
        cnt.setBackground(new Color(35, 116, 73));
        panel1.add(cnt);

        AR=new JLabel("Allocated Room");
        AR.setBounds(30,320,120,27);
        AR.setFont(new Font("Impact", Font.ITALIC,18));
        AR.setForeground(Color.WHITE);
        panel1.add(AR);
        c1=new Choice();
        try{
            conProvider con=new conProvider();
            ResultSet resultSet=con.statement.executeQuery("select * from room");
            while(resultSet.next()){
                c1.add(resultSet.getString("roomNO"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        c1.setBounds(190,320,150,20);
        c1.setFont(new Font("Calibri", Font.BOLD,18));
        c1.setBackground(new Color(35, 116, 73));
        c1.setForeground(Color.WHITE);
        panel1.add(c1);

        CIS=new JLabel("Checked-In");
        CIS.setBounds(30,370,120,27);
        CIS.setFont(new Font("Impact", Font.ITALIC,18));
        CIS.setForeground(Color.WHITE);
        panel1.add(CIS);

        Date date1=new Date();

        date=new JLabel(""+date1);
        date.setBounds(190,370,160,27);
        date.setFont(new Font("Impact", Font.ITALIC,18));
        date.setForeground(Color.WHITE);
        panel1.add(date);

        dp=new JLabel("Deposit");
        dp.setBounds(30,420,200,27);
        dp.setFont(new Font("Impact", Font.ITALIC,18));
        dp.setForeground(Color.WHITE);
        panel1.add(dp);
        dpt=new JTextField();
        dpt.setBounds(190,420,156,27);
        dpt.setFont(new Font("Calibri", Font.BOLD,20));
        dpt.setForeground(Color.WHITE);
        dpt.setBackground(new Color(35, 116, 73));
        panel1.add(dpt);


        add=new JButton("ADD");
        add.setBounds(45,470,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial",Font.BOLD,15));
        add.addActionListener(this);
        panel1.add(add);

        back=new JButton("Back");
        back.setBounds(190,470,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(this);
        panel1.add(back);

        reset=new JButton("Reset");
        reset.setBounds(325,470,100,30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial",Font.BOLD,15));
        reset.addActionListener(this);
        panel1.add(reset);


        setUndecorated(true);
        setLayout(null);
        setLocation(400,130);
        setSize(850,550);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            try{
                conProvider con=new conProvider();

                String name=namet.getText();
                String id=(String)idt.getSelectedItem();
                String contact=cdt.getText();
                String gender=null;
                String country=cnt.getText();
                String AR=c1.getSelectedItem();
                String CIS=date.getText();
                String dp=dpt.getText();
                if(male.isSelected()){
                    gender="Male";
                }
                else{
                    gender="Female";
                }

                String q="insert into customer values('"+name+"','"+id+"','"+contact+"','"+gender+"','"+country+"','"+AR+"','"+CIS+"','"+dp+"')";
                String q1="update room set availability='Occupied' where roomNO="+AR;
                con.statement.executeUpdate(q);
                con.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Added Successfully");
            }catch (Exception E){
                E.printStackTrace();
            }
        }
        else if(e.getSource()==reset){
            namet.setText("");
            idt.setSelectedIndex(0);
            cdt.setText("");
            cnt.setText("");
            dpt.setText("");
        }
        else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
