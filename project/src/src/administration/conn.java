package src.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
public class conn {
    Connection connection;
    Statement statement;
    public conn()
    {
        try{

            String url = "jdbc:mysql://localhost:3306/student";
            String username = "root";
            String password = "yoyo_Anjali@123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
