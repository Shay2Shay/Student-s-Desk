// package DatabaseInterface;

import java.sql.*;

// export CLASSPATH=/home/shay/Downloads/mysql-connector-j-8.0.31/mysql-connector-j-8.0.31.jar:.

class SQLconnect{
    Connection con;
    SQLconnect(String database, String usr, String pass){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, usr, pass);
            System.out.println("Connected...");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void selectAllFromTable(String table){
        try{
            Statement st = con.createStatement();
            String q = "Select * from test";
            ResultSet rs = st.executeQuery(q);

            while(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return;
    }
}

public class test {
    public static void main(String[] args) {
        System.out.println("Running...");

        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        con.selectAllFromTable("test");

        

    }
}
