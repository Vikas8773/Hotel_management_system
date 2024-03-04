package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {
    JLabel AD,name,age,gender,car,carn,aval,loc;
    JTextField namet,aget,cart,cartn,loct;
    JRadioButton male,female;
    JComboBox avalt;
    JButton add,back,reset;

    AddDriver(){
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,890,490);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

        AD=new JLabel("ADD DRIVER");
        AD.setBounds(350,10,200,27);
        AD.setFont(new Font("Tahoma", Font.BOLD,30));
        AD.setForeground(Color.WHITE);
        panel1.add(AD);

        name=new JLabel("Name");
        name.setBounds(64,70,102,27);
        name.setFont(new Font("Impact", Font.ITALIC,18));
        name.setForeground(Color.WHITE);
        panel1.add(name);
        namet=new JTextField();
        namet.setBounds(180,70,156,27);
        namet.setFont(new Font("Calibri", Font.BOLD,20));
        namet.setForeground(Color.WHITE);
        namet.setBackground(new Color(35, 116, 73));
        panel1.add(namet);

        age=new JLabel("Age");
        age.setBounds(64,110,102,27);
        age.setFont(new Font("Impact", Font.ITALIC,18));
        age.setForeground(Color.WHITE);
        panel1.add(age);
        aget=new JTextField();
        aget.setBounds(180,110,156,27);
        aget.setFont(new Font("Calibri", Font.BOLD,20));
        aget.setForeground(Color.WHITE);
        aget.setBackground(new Color(35, 116, 73));
        panel1.add(aget);

        gender=new JLabel("Gender");
        gender.setBounds(64,150,156,27);
        gender.setFont(new Font("Impact", Font.ITALIC,18));
        gender.setForeground(Color.WHITE);
        panel1.add(gender);
        male=new JRadioButton("Male");
        male.setBounds(180,150,100,27);
        male.setFont(new Font("Calibri", Font.BOLD,20));
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(48, 40, 3));
        panel1.add(male);

        female=new JRadioButton("Female");
        female.setBounds(284,150,100,27);
        female.setFont(new Font("Calibri", Font.BOLD,20));
        female.setBackground(new Color(48, 40, 3));
        female.setForeground(Color.WHITE);
        panel1.add(female);

        car=new JLabel("Car Company");
        car.setBounds(64,190,102,27);
        car.setFont(new Font("Impact", Font.ITALIC,18));
        car.setForeground(Color.WHITE);
        panel1.add(car);
        cart=new JTextField();
        cart.setBounds(180,190,156,27);
        cart.setFont(new Font("Calibri", Font.BOLD,20));
        cart.setForeground(Color.WHITE);
        cart.setBackground(new Color(35, 116, 73));
        panel1.add(cart);

        carn=new JLabel("Car Name");
        carn.setBounds(64,230,102,27);
        carn.setFont(new Font("Impact", Font.ITALIC,18));
        carn.setForeground(Color.WHITE);
        panel1.add(carn);
        cartn=new JTextField();
        cartn.setBounds(180,230,156,27);
        cartn.setFont(new Font("Calibri", Font.BOLD,20));
        cartn.setForeground(Color.WHITE);
        cartn.setBackground(new Color(35, 116, 73));
        panel1.add(cartn);

        aval=new JLabel("Available");
        aval.setBounds(64,270,156,27);
        aval.setFont(new Font("Impact", Font.ITALIC,18));
        aval.setForeground(Color.WHITE);
        panel1.add(aval);
        avalt=new JComboBox(new String[]{"Yes","No"});
        avalt.setBounds(180,270,156,27);
        avalt.setFont(new Font("Calibri", Font.BOLD,20));
        avalt.setForeground(Color.WHITE);
        avalt.setBackground(new Color(35, 116, 73));
        panel1.add(avalt);

        loc=new JLabel("Location");
        loc.setBounds(64,310,102,27);
        loc.setFont(new Font("Impact", Font.ITALIC,18));
        loc.setForeground(Color.WHITE);
        panel1.add(loc);
        loct=new JTextField();
        loct.setBounds(180,310,156,27);
        loct.setFont(new Font("Calibri", Font.BOLD,20));
        loct.setForeground(Color.WHITE);
        loct.setBackground(new Color(35, 116, 73));
        panel1.add(loct);

        //buttons
        add=new JButton("ADD");
        add.setBounds(50,380,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial",Font.BOLD,15));
        add.addActionListener(this);
        panel1.add(add);

        back=new JButton("Back");
        back.setBounds(170,380,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(this);
        panel1.add(back);

        reset=new JButton("Reset");
        reset.setBounds(290,380,100,30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial",Font.BOLD,15));
        reset.addActionListener(this);
        panel1.add(reset);

        //image
        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/license.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(500,60,300,300);
        panel1.add(label1);

        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            try{
                conProvider con=new conProvider();

                String name=namet.getText();
                String age=aget.getText();
                String gender=null;
                String company=cart.getText();
                String carname=cartn.getText();
                String aval=(String)avalt.getSelectedItem();
                String loc=loct.getText();
                if(male.isSelected()){
                    gender="Male";
                }
                else{
                    gender="Female";
                }

                String q="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+carname+"','"+aval+"','"+loc+"')";
                con.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Driver Added Successfully");

            }catch (Exception E){
                E.printStackTrace();
            }

        } else if (e.getSource()==reset) {
            namet.setText("");
            aget.setText("");
            cart.setText("");
            cartn.setText("");
            loct.setText("");
            avalt.setSelectedIndex(0);
        }else {
            //new Admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
