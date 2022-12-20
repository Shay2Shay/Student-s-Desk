package src.Database.SQLconnect;

import java.sql.*;

public class SQLconnect{
    Connection con;
    public SQLconnect(String database, String usr, String pass){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database, usr, pass);
            // System.out.println("Connected...");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void selectAllFromTable(String table, char[] type){
        try{
            Statement st = con.createStatement();
            String q = "Select * from " + table;
            ResultSet rs = st.executeQuery(q);
            String ans = "";
            while(rs.next()){
                int count = 1;
                for(char i : type){
                    if(i == 'i'){
                        ans += rs.getInt(count);
                    }else if(i == 's'){
                        ans += rs.getString(count);
                    }else if(i == 'd'){
                        ans += rs.getDate(count);
                    }else{
                        ans += "dont know which type";
                    }
                    if(count != type.length) ans += " >> ";
                    else ans += " ||";
                    count++;
                }
                System.out.println(ans);
                ans = "";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return;
    }

    public void insertIntoTable(String table, String values){
        try{
            Statement st = con.createStatement();
            String[] arr = values.split(",");
            values = "";
            for(int i = 0; i < arr.length; i++){
                if(arr[i].compareTo("null") != 0)
                    values += "\"" + arr[i] + "\"";
                else
                    values += arr[i];
                if(i != arr.length-1){
                    values += ",";
                }
            }
            String q = "insert into " + table + " values(" + values + " )";
            st.executeUpdate(q);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return;
    }

    public void truncateTable(String table){
        try{
            Statement st = con.createStatement();
            st.executeUpdate("truncate table " + table);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}