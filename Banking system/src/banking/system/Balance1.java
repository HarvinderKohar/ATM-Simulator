package banking.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Balance1 extends JFrame implements ActionListener {
    
    JButton back;
    JLabel lblBalance;
    String pinNo;
    
    Balance1(String pinNo) {
        this.pinNo = pinNo;
        setLayout(null);
        
        //image
        ImageIcon a1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATMImage2.png"));
        Image a2 = a1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon a3 = new ImageIcon(a2);
        JLabel label = new JLabel(a3);
        label.setBounds(0,0,800,700);
        add(label);

        // Get the current balance
        double balance = getCurrentBalance(pinNo);
        lblBalance = new JLabel("Current Balance: £" + balance);
        lblBalance.setFont(new Font("default", Font.BOLD, 24));
        lblBalance.setForeground(Color.white);
        lblBalance.setBounds(240, 250, 400, 30);
        label.add(lblBalance);

        //back button
        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBorder(null);
        back.setFont(new Font("default", Font.BOLD, 14));
        back.setBounds(200, 375, 100, 30);
        back.addActionListener(this);
        label.add(back);
        
        getContentPane().setBackground(Color.white);
        setSize(800, 700);
        setVisible(true);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private double getCurrentBalance(String pinNo) {
        double balance = 0;
        try {
            Conn conn = new Conn();
            String depositQuery = "select sum(amount) as sum from bank where shortNumber = '" + pinNo + "' and type = 'Deposit'";
            String withdrawQuery = "select sum(amount) as sum from bank where shortNumber = '" + pinNo + "' and type = 'Withdraw'";

            ResultSet rsD = conn.s.executeQuery(depositQuery);
            if (rsD.next()) {
                balance += rsD.getDouble("sum");
            }

            ResultSet rsW = conn.s.executeQuery(withdrawQuery);
            if (rsW.next()) {
                balance -= rsW.getDouble("sum");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }

    public void actionPerformed(ActionEvent p) {
        if (p.getSource() == back) {
            setVisible(false);
            new Transactions(pinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Balance1("");
    }
}

