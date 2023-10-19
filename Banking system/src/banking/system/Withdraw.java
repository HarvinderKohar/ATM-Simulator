package banking.system;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener
{
    JTextField sum;
    JButton Enter, back;
    String pinNo;
    Withdraw(String pinNo)
    {
        this.pinNo = pinNo;
        setLayout(null);
        
        //image
        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMImage2.png"));
        Image a2 = a1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel label = new JLabel(a3);
        label.setBounds(0,0,800,700);
        add(label);
        
        //title
        JLabel t1 = new JLabel("Enter Withdrawal amount:  ");
        t1.setFont(new Font("default",Font.BOLD, 24));
        t1.setBounds(240,200,400,100);
        t1.setForeground(Color.white);
        label.add(t1);
        
        //deposit
        sum = new JTextField();
        sum.setFont(new Font("default", Font.BOLD,14 ));
        sum.setBounds(200,290,200,20);
        label.add(sum);
        
        //buttons
        Enter = new JButton("Enter");
        Enter.setBackground(Color.white);
        Enter.setForeground(Color.black);
        Enter.setBorder(null);
        Enter.setFont(new Font("default", Font.BOLD, 14));
        Enter.setBounds(200,330,100,30);
        Enter.addActionListener(this);
        label.add(Enter);
        
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBorder(null);
        back.setFont(new Font("default", Font.BOLD, 14));
        back.setBounds(200,375,100,30);
        back.addActionListener(this);
        label.add(back);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 700);
        setVisible(true);
        //setUndecorated(true);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent p)
    {
        if(p.getSource() == Enter)
        {
            String amt = sum.getText();
            Date date = new Date();
            if(amt.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter An Amount!"); 
            }
            else
            {
                try
                {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinNo+"', '"+date+"', 'Withdraw' , '"+amt+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"£ " + amt + " Has Been Withdrawn");
                setVisible(false);
                new Transactions(pinNo).setVisible(true);
                }
                catch(Exception d)
                {
                    System.out.println(d);
                }
                
                
            }
        }
        else if(p.getSource() == back)
        {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
    }
    
    public static void main (String[] args)
    {
        new Withdraw("");
    }
}
