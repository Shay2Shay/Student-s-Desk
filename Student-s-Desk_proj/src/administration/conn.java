package src.administration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
public class conn {
    public Connection connection;
    Statement statement;
    public conn()
    {
        try{

            String url = "jdbc:mysql://localhost:3306/jdbc";
            String username = "jdbc";
            String password = "jdbc";
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();

        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
