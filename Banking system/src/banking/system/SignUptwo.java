package banking.system;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignUptwo extends JFrame implements ActionListener
{
    JRadioButton b1,b2;
    JCheckBox s1,s2,s3;
    JButton cancel,submit;
    
    SignUptwo()
    {
        setLayout(null);
        
        //title
        JLabel title2 = new JLabel("Application Page 2");
        title2.setFont(new Font("default",Font.BOLD, 28));
        title2.setBounds(300,1,400,100);
        add(title2);
        
        //account type
        JLabel AccountType = new JLabel("Account Type:");
        AccountType.setFont(new Font("default",Font.BOLD, 17));
        AccountType.setBounds(180,90,200,100);
        add(AccountType);
        
        b1 = new JRadioButton("Current Account");
        b1.setBounds(180,160,150,20);
        b1.setBackground(Color.white);
        add(b1);
        
        b2 = new JRadioButton("Saving Account");
        b2.setBounds(330,160,150,20);
        b2.setBackground(Color.white);
        add(b2);
        
        ButtonGroup accountButtons = new ButtonGroup();
        accountButtons.add(b1);
        accountButtons.add(b2);
        
        //Card Info
        
        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("default",Font.BOLD, 17));
        cardNo.setBounds(180,175,200,100);
        add(cardNo);
        
        JLabel cardNoInfo = new JLabel("(16 Digit Card Number)");
        cardNoInfo.setFont(new Font("default",Font.BOLD, 17));
        cardNoInfo.setBounds(180,190,200,100);
        add(cardNoInfo);
        
        JLabel cardNoDisplay = new JLabel("****-****-****-****");
        cardNoDisplay.setFont(new Font("default",Font.BOLD, 17));
        cardNoDisplay.setBounds(450,175,200,125);
        add(cardNoDisplay);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("default",Font.BOLD, 17));
        pin.setBounds(180,235,200,100);
        add(pin);
        
        JLabel pinInfo = new JLabel("(4 Digit Pin Code)");
        pinInfo.setFont(new Font("default",Font.BOLD, 17));
        pinInfo.setBounds(180,250,200,100);
        add(pinInfo);
        
        JLabel pinDisplay = new JLabel("****");
        pinDisplay.setFont(new Font("default",Font.BOLD, 17));
        pinDisplay.setBounds(450,235,200,125);
        add(pinDisplay);
        
        //services
        JLabel services = new JLabel("Services:");
        services.setFont(new Font("default",Font.BOLD, 17));
        services.setBounds(180,310,200,100);
        add(services);
        
        s1 = new JCheckBox("ATM Card");
        s1.setBounds(180,425,150,20);
        s1.setBackground(Color.white);
        add(s1);
        
        s2 = new JCheckBox("Statements");
        s2.setBounds(330,425,150,20);
        s2.setBackground(Color.white);
        add(s2);
        
        //declaration
        s3 = new JCheckBox("I can confirm that the details above are correct");
        s3.setBounds(180,525,300,20);
        s3.setBackground(Color.white);
        add(s3);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.setBorder(null);
        submit.setFont(new Font("default", Font.BOLD, 14));
        submit.setBounds(180,600,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.setBorder(null);
        cancel.setFont(new Font("default", Font.BOLD, 14));
        cancel.setBounds(330,600,100,30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.white);
        
        setSize(800, 700);
        setVisible(true);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent a)
    {
        if(a.getSource() == submit)
        {
            String accountType = null;
            if(b1.isSelected())
            {
                accountType = "Current Account";
            }
            else if(b2.isSelected())
            {
                accountType = "Saving Account";
            }
            
            Random ran = new Random();
            
            String longNumber = "" + Math.abs((ran.nextLong() % 90000000L) + 1357246800000000L);
            
            String shortNumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
            
            String functions = "";
            if(s1.isSelected())
            {
                functions = functions + " ATM Card";
            }
            else if(s2.isSelected())
            {
                functions = functions + " Statements";
            }
            
            try
            {
                if(accountType.equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Select An Account Type");
                }
                else
                {
                    Conn Conns = new Conn();
                    String query2 = "insert into signup2 values('"+accountType+"', '"+longNumber+"', '"+shortNumber+"', '"+functions+"')";
                    String query3 = "insert into login values('"+longNumber+"', '"+shortNumber+"')";
                    Conns.s.executeUpdate(query2);
                    Conns.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + longNumber + "\n Pin: " + shortNumber);
                    
                    setVisible(false);
                    new Deposit(shortNumber).setVisible(false);
                    
                }
                
            }
            catch(Exception o)
            {
                System.out.println(o);
            }
        }
        else if (a.getSource() == cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
            
      
    
    public static void main(String[] args)
    {
        new SignUptwo();
    }
}
