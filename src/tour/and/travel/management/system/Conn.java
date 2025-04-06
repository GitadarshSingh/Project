package tour.and.travel.management.system;
import javax.swing.*;
import java.sql.*;
public class Conn {

    // Esme Main method nhi banayenge
// JDBC  : java database connectivity concept ka use kar ke Database ke saath add karenge
    // There are 5 steps in JDBC

    Connection c;
    Statement s;

    Conn(){
 // Step 1 : register the driver : here we are using mysql driver
        try{
        Class.forName(("com.mysql.cj.jdbc.Driver"));
        c = DriverManager.getConnection("jdbc:mysql:///tourandtravelmanagementsystem","root","Adarsh@1234$");
        s = c.createStatement();
        

    }catch(Exception e){
        e.printStackTrace();
    }

    }
}

