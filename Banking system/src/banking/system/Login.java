package banking.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;



public class Login extends JFrame implements ActionListener
{
    JButton signIn, signUp, clear;
    JTextField idBox;
    JPasswordField pinBox;
    
    Login()
    {

        setTitle("Online Banking");
        setLayout(null);
        
        //Icon
        ImageIcon p1 = new ImageIcon(Login.class.getResource("/icons/bankImage.png"));
        Image p2 = p1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon p3 = new ImageIcon(p2);
        JLabel label = new JLabel(p3);
        label.setBounds(70,15,100,100);
        add(label); 
        
        //title
        JLabel text = new JLabel("Welcome to your Banking");
        text.setFont(new Font("default",Font.BOLD, 28));
        text.setBounds(250,10,400,100);
        add(text);
        
        //id
        JLabel id = new JLabel("ID:");
        id.setFont(new Font("default",Font.BOLD, 25));
        id.setBounds(180,90,200,100);
        add(id);
        
        idBox = new JTextField();
        idBox.setBounds(250,120,250,40);
        add(idBox);
        
        //pin
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("default",Font.BOLD, 25));
        pin.setBounds(180,170,200,100);
        add(pin);
        
        pinBox = new JPasswordField();
        pinBox.setBounds(250,200,250,40);
        add(pinBox);
        
        //sign in,sign up, clear buttons
        signIn = new JButton("SIGN IN");
        signIn.setBackground(Color.white);
        signIn.setForeground(Color.black);
        signIn.setFont(new Font("default",Font.BOLD, 17));
        signIn.setBorder(null);
        signIn.setBounds(200,280,150,40);
        signIn.addActionListener(this);
        add(signIn);
        
        clear = new JButton("CLEAR");
        clear.setBackground(Color.white);
        signIn.setForeground(Color.black);
        clear.setFont(new Font("default",Font.BOLD, 17));
        clear.setBorder(null);
        clear.setBounds(400,280,150,40);
        clear.addActionListener(this);
        add(clear);
        
        signUp = new JButton("SIGN UP");
        signUp.setBackground(Color.white);
        signIn.setForeground(Color.black);
        signUp.setFont(new Font("default",Font.BOLD, 17));
        signUp.setBorder(null);
        signUp.setForeground(Color.black);
        signUp.setBounds(600,40,150,40);
        signUp.addActionListener(this);
        add(signUp);
        
        //background colour
        getContentPane().setBackground(Color.white);
       
        //pane size
        setSize(800, 480);
        setVisible(true);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == clear)
        {
            idBox.setText("");
            pinBox.setText("");
            
        }
        
        else if(ae.getSource() == signUp)
        {
            setVisible(false);
            new SignUp().setVisible(true);
            
        }
        
        else if(ae.getSource() == signIn)
        {
            Conn conn = new Conn();
            String cardNo = idBox.getText();
            String pinNo = pinBox.getText();
            String query = "select * from login where longNumber = '" + cardNo + "' and shortNumber = '"+ pinNo +"'" ;
            
            try
            {
                ResultSet r = conn.s.executeQuery(query);
                if(r.next())
                {
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number Or Pin");
                }
            }
            catch(Exception n)
            {
                System.out.println(n);
            }
                
         
        }
            
        
    }
            
    
    public static void main(String[] args)
    {
       new Login(); 
    }
    
}