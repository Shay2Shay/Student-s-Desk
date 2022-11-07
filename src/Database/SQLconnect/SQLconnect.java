package src.Database.SQLconnect;

import java.sql.*;

public class SQLconnect{
    Connection con;
    public SQLconnect(String database, String usr, String pass){
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

    // public void insertIntoTable(String table, String ... args){
    //     try{
    //         Statement st = con.createStatement();
    //         String q = "insert into " + table + "(";
    //         int size = args.length/2;
    //         for(int i = 0; i < size; i++){
    //             q += args[i];
    //             if(i != size-1){
    //                 q += ",";
    //             }
    //         }
    //         q += ") values(";
    //         for(int i = size; i < args.length; i++){
    //             q += args[i];
    //             if(i != args.length-1){
    //                 q += ",";
    //             }
    //         }
    //         q += ")";
    //         st.executeUpdate(q);
    //     }
    //     catch(Exception e){
    //         System.out.println(e);
    //     }
    //     return;
    // }

    public void insertIntoTable(String table, String values){
        try{
            Statement st = con.createStatement();
            String[] arr = values.split(", ");
            values = "";
            for(int i = 0; i < arr.length; i++){
                values += "\"" + arr[i] + "\"";
                if(i != arr.length-1){
                    values += ",";
                }
            }
            String q = "insert into " + table + " values(" + values + " )";
            st.executeUpdate(q);
        }catch(Exception e){
            System.out.println(e);
        }
        return;
    }
}