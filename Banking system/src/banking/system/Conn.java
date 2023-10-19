package banking.system;
import java.sql.*;
public class Conn
{
    Connection c;
    Statement s;
    public Conn()
    {

        
        try
        {
          // Class.forName(com.mysql.cj.jdbc.Driver); 
           c = DriverManager.getConnection("jdbc:mysql:///bankingsystem", "root","2511");
           s = c.createStatement();
        }
        catch(Exception a)
        {
            System.out.println(a);
        }
    }
}