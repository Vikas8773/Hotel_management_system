package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField namet,aget,salt,phonet,emailt;
    JRadioButton male,female;
    JComboBox jobt;
    JButton add,back,reset;
    JLabel name,AED,age,gender,job,sal,mobno,email;

    AddEmployee(){
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,890,490);
        panel1.setBackground(new Color(48, 40, 3));
        add(panel1);

        AED=new JLabel("ADD EMPLOYEE DETAILS");
        AED.setBounds(430,70,450,29);
        AED.setFont(new Font("Tahoma", Font.BOLD,30));
        AED.setForeground(Color.WHITE);
        panel1.add(AED);

        name=new JLabel("Name");
        name.setBounds(60,30,150,27);
        name.setFont(new Font("Impact", Font.ITALIC,18));
        name.setForeground(Color.WHITE);
        panel1.add(name);
        namet=new JTextField();
        namet.setBounds(150,30,150,27);
        namet.setFont(new Font("Calibri", Font.BOLD,18));
        namet.setForeground(Color.WHITE);
        namet.setBackground(new Color(35, 116, 73));
        panel1.add(namet);

        age=new JLabel("Age");
        age.setBounds(60,80,150,27);
        age.setFont(new Font("Impact", Font.ITALIC,18));
        age.setForeground(Color.WHITE);
        panel1.add(age);
        aget=new JTextField();
        aget.setBounds(150,80,150,27);
        aget.setFont(new Font("Calibri", Font.BOLD,18));
        aget.setForeground(Color.WHITE);
        aget.setBackground(new Color(35, 116, 73));
        panel1.add(aget);

        gender=new JLabel("Gender");
        gender.setBounds(60,130,150,27);
        gender.setFont(new Font("Impact", Font.ITALIC,18));
        gender.setForeground(Color.WHITE);
        panel1.add(gender);
        male=new JRadioButton("Male");
        male.setBounds(150,130,100,27);
        male.setFont(new Font("Calibri", Font.BOLD,18));
        male.setForeground(Color.WHITE);
        male.setBackground(new Color(48, 40, 3));
        panel1.add(male);

        female=new JRadioButton("Female");
        female.setBounds(250,130,100,27);
        female.setFont(new Font("Calibri", Font.BOLD,18));
        female.setBackground(new Color(48, 40, 3));
        female.setForeground(Color.WHITE);
        panel1.add(female);

        job=new JLabel("Job");
        job.setBounds(60,180,150,27);
        job.setFont(new Font("Impact", Font.ITALIC,18));
        job.setForeground(Color.WHITE);
        panel1.add(job);
        jobt=new JComboBox(new String[]{"Front Desk","House Keeping","Kitchen Staff","Room Service","Manager","Accountant","Chef"});
        jobt.setBounds(150,180,150,27);
        jobt.setFont(new Font("Calibri", Font.BOLD,18));
        jobt.setForeground(Color.WHITE);
        jobt.setBackground(new Color(35, 116, 73));
        panel1.add(jobt);

        sal=new JLabel("Salary");
        sal.setBounds(60,230,150,27);
        sal.setFont(new Font("Impact", Font.ITALIC,18));
        sal.setForeground(Color.WHITE);
        panel1.add(sal);
        salt=new JTextField();
        salt.setBounds(150,230,150,27);
        salt.setFont(new Font("Calibri", Font.BOLD,18));
        salt.setForeground(Color.WHITE);
        salt.setBackground(new Color(35, 116, 73));
        panel1.add(salt);

        mobno=new JLabel("MobileNo");
        mobno.setBounds(60,280,150,27);
        mobno.setFont(new Font("Impact", Font.ITALIC,18));
        mobno.setForeground(Color.WHITE);
        panel1.add(mobno);
        phonet=new JTextField();
        phonet.setBounds(150,280,150,27);
        phonet.setFont(new Font("Calibri", Font.BOLD,18));
        phonet.setForeground(Color.WHITE);
        phonet.setBackground(new Color(35, 116, 73));
        panel1.add(phonet);

//        adhar=new JLabel("Adhar");
//        adhar.setBounds(60,330,150,27);
//        adhar.setFont(new Font("Impact", Font.ITALIC,18));
//        adhar.setForeground(Color.WHITE);
//        panel1.add(adhar);
//        adhart=new JTextField();
//        adhart.setBounds(150,330,150,27);
//        adhart.setFont(new Font("Calibri", Font.BOLD,18));
//        adhart.setForeground(Color.WHITE);
//        adhart.setBackground(new Color(35, 116, 73));
//        panel1.add(adhart);

        email=new JLabel("Email");
        email.setBounds(60,330,150,27);
        email.setFont(new Font("Impact", Font.ITALIC,18));
        email.setForeground(Color.WHITE);
        panel1.add(email);
        emailt=new JTextField();
        emailt.setBounds(150,330,150,27);
        emailt.setFont(new Font("Calibri", Font.BOLD,18));
        emailt.setForeground(Color.WHITE);
        emailt.setBackground(new Color(35, 116, 73));
        panel1.add(emailt);

        //buttons
        add=new JButton("ADD");
        add.setBounds(80,420,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Arial",Font.BOLD,15));
        add.addActionListener(this);
        panel1.add(add);

        back=new JButton("Back");
        back.setBounds(200,420,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Arial",Font.BOLD,15));
        back.addActionListener(this);
        panel1.add(back);

        reset=new JButton("Reset");
        reset.setBounds(320,420,100,30);
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setFont(new Font("Arial",Font.BOLD,15));
        reset.addActionListener(this);
        panel1.add(reset);

        //Image
        ImageIcon imageIcon1=new ImageIcon(ClassLoader.getSystemResource("icon/addemp.png"));
        Image i1=imageIcon1.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2=new ImageIcon(i1);
        JLabel label1=new JLabel(imageIcon2);
        label1.setBounds(500,100,300,300);
        panel1.add(label1);

        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
            try {
                conProvider con=new conProvider();
                String name=namet.getText();
                String age=aget.getText();
                String gender=null;
                String job=(String)jobt.getSelectedItem();
                String salary=salt.getText();
                String mobno=phonet.getText();
                //String adhar=adhart.getText();
                String email=emailt.getText();


                if(male.isSelected()){
                    gender="Male";
                    female.setSelected(false);
                }
                else{
                    gender="Female";
                    male.setSelected(false);
                }
                String q="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+mobno+"','"+email+"')";
                con.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Employee Added Successfully");
                //this.setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource()==reset) {
            namet.setText("");
            aget.setText("");
            salt.setText("");
            phonet.setText("");
            //adhart.setText("");
            emailt.setText("");
            jobt.setSelectedIndex(0);
        } else{
            //new Admin();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
