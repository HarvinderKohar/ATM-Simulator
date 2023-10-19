/*package banking.system;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Balance extends JFrame implements ActionListener
{
    
    JButton back;
    String pinNo;
    Balance(String pinNo)
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
        
        //back
        
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
         setVisible(false);
         new Transactions(pinNo).setVisible(true);
        
    }
    
    public static void main(String[] args)
    {
        new Balance("");
    }
}*/

