package banking.system;
import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener
{
    
    JTextField nameBox,emailBox,addressBox,cityBox,postcodeBox;
    JRadioButton man,woman,married,single;
    JDateChooser selectDate;
    JButton nextPage;
    
    SignUp()
    {
        setLayout(null);
        
        //title
        JLabel title = new JLabel("Application");
        title.setFont(new Font("default",Font.BOLD, 28));
        title.setBounds(300,1,400,100);
        add(title);
        
        //mini title
        JLabel miniTitle = new JLabel("Your Details ");
        miniTitle.setFont(new Font("default",Font.BOLD, 20));
        miniTitle.setBounds(300,50,400,100);
        add(miniTitle);
        
        //details labels
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("default",Font.BOLD, 17));
        name.setBounds(180,90,200,100);
        add(name);
        
        nameBox = new JTextField();
        nameBox.setFont(new Font("default", Font.BOLD,14 ));
        nameBox.setBounds(300,130,200,20);
        add(nameBox);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("default",Font.BOLD, 17));
        gender.setBounds(180,150,200,100);
        add(gender);
        
        man = new JRadioButton("Male");
        man.setBounds(300,190,100,20);
        man.setBackground(Color.white);
        add(man);
        
        woman = new JRadioButton("Female");
        woman.setBounds(400,190,100,20);
        woman.setBackground(Color.white);
        add(woman); 
        
        ButtonGroup genders = new ButtonGroup();
        genders.add(man);
        genders.add(woman);
        
        JLabel dob = new JLabel("DOB:");
        dob.setFont(new Font("default",Font.BOLD, 17));
        dob.setBounds(180,210,200,100);
        add(dob);
        
        selectDate = new JDateChooser();
        selectDate.setBounds(300,250,200,20);
        selectDate.setForeground(new Color(105,105,105));
        add(selectDate);
        
        JLabel email = new JLabel("Email address:");
        email.setFont(new Font("default",Font.BOLD, 17));
        email.setBounds(180,270,200,100);
        add(email);
        
        emailBox = new JTextField();
        emailBox.setFont(new Font("default", Font.BOLD,14 ));
        emailBox.setBounds(300,310,200,20);
        add(emailBox);
        
        
        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("default",Font.BOLD, 17));
        marital.setBounds(180,330,200,100);
        add(marital);
        
        married = new JRadioButton("Married");
        married.setBounds(300,370,100,20);
        married.setBackground(Color.white);
        add(married);
        
        single = new JRadioButton("Single");
        single.setBounds(400,370,100,20);
        single.setBackground(Color.white);
        add(single); 
        
        ButtonGroup maritalButtons = new ButtonGroup();
        maritalButtons.add(married);
        maritalButtons.add(single);
        
        JLabel address  = new JLabel("Address:");
        address.setFont(new Font("default",Font.BOLD, 17));
        address.setBounds(180,390,200,100);
        add(address);
        
        addressBox = new JTextField();
        addressBox.setFont(new Font("default", Font.BOLD,14 ));
        addressBox.setBounds(300,430,200,20);
        add(addressBox);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("default",Font.BOLD, 17));
        city.setBounds(180,450,200,100);
        add(city);
        
        cityBox = new JTextField();
        cityBox.setFont(new Font("default", Font.BOLD,14 ));
        cityBox.setBounds(300,490,200,20);
        add(cityBox);
        
        JLabel postcode = new JLabel("Postcode:");
        postcode.setFont(new Font("default",Font.BOLD, 17));
        postcode.setBounds(180,510,200,100);
        add(postcode);
        
        postcodeBox = new JTextField();
        postcodeBox.setFont(new Font("default", Font.BOLD,14 ));
        postcodeBox.setBounds(300,550,200,20);
        add(postcodeBox);
        
        //next button
        nextPage = new JButton("Next");
        nextPage.setBackground(Color.white);
        nextPage.setForeground(Color.black);
        nextPage.setBorder(null);
        nextPage.setFont(new Font("default", Font.BOLD, 14));
        nextPage.setBounds(300,600,100,30);
        nextPage.addActionListener(this);
        add(nextPage);
        
        //jframe settings 
       getContentPane().setBackground(Color.white);
        
        setSize(800, 700);
        setVisible(true);
        setLocation(350,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        //nameBox,emailBox,addressBox,cityBox,postcodeBox;
       //RadioButton man,woman,married,single;
      // JDateChooser selectDate;
     // JButton nextPage;
        
        
        String name = nameBox.getText();
        String email = emailBox.getText();
        String address = addressBox.getText();
        String city = cityBox.getText();
        String postcode = postcodeBox.getText();
        
        String dob = ((JTextField) selectDate.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(man.isSelected())
        {
            gender = "Male";
        }
        else if(woman.isSelected())
        {
            gender = "Female";
        }
        
        String marital = null;
        if(married.isSelected())
        {
            marital = "Married";
        }
        else if(single.isSelected())
        {
            marital = "Single";
        }
        
        try
        {
            if(name.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Input Name");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signup value('"+name+"', '"+email+"', '"+address+"', '"+city+"', '"+postcode+"', '"+dob+"', '"+gender+"', '"+marital+"')";
                c.s.executeUpdate(query);
                
                this.setVisible(false);
                new SignUptwo();
            }
        }
        catch(Exception a)
        {
            System.out.println(a);
        }
        
    }
    
    public static void main(String[] args)
    {
        new SignUp(); 
        
    }
}
