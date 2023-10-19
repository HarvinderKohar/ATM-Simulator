package banking.system;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Transactions extends JFrame implements ActionListener
{
    String pinNo;
    JButton deposits,withdrawal,statements,exit;
    
    Transactions(String pinNo)
    {
        this.pinNo = pinNo;
        setLayout(null);
        
        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMImage2.png"));
        Image a2 = a1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel label = new JLabel(a3);
        label.setBounds(0,0,800,700);
        add(label); 
        
        //title
        JLabel t1 = new JLabel("Select Your Transactions ");
        t1.setFont(new Font("default",Font.BOLD, 24));
        t1.setBounds(240,200,400,100);
        t1.setForeground(Color.white);
        label.add(t1);
        
        //deposit
        deposits = new JButton("Deposit");
        deposits.setBounds(200,285,150,20);
        deposits.setBackground(Color.white);
        deposits.setForeground(Color.black);
        deposits.addActionListener(this);
        label.add(deposits);
        
        //withdraw
        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(200,330,150,20);
        withdrawal.setBackground(Color.white);
        withdrawal.setForeground(Color.black);
        withdrawal.addActionListener(this);
        label.add(withdrawal);
        
        //statement/balance enquiry
        statements = new JButton("Current Balance");
        statements.setBounds(200,375,150,20);
        statements.setBackground(Color.white);
        statements.setForeground(Color.black);
        statements.addActionListener(this);
        label.add(statements);
        
        //exit
        exit = new JButton("Exit");
        exit.setBounds(200,415,150,20);
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        label.add(exit);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 700);
        setVisible(true);
        //setUndecorated(true);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent p)
    {
        if(p.getSource() == exit)
        {
            System.exit(0);
        }
        else if(p.getSource() == deposits)
        {
            setVisible(false);
            new Deposit(pinNo).setVisible(true);
        }
        else if(p.getSource() == withdrawal)
        {
            setVisible(false);
            new Withdraw(pinNo).setVisible(true);
        }
        else if(p.getSource() == statements)
        {
            setVisible(false);
            new Balance1(pinNo).setVisible(true);
        }
        
    }
            
    
    public static void main(String[] args)
    {
        new Transactions("");
    }
    
}
