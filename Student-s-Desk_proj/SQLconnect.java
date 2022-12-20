package src.Database.SQLconnect;

import java.sql.*;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;


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

    public boolean adminLogin(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Give Admin ID       : ");
        String ID = scan.nextLine();
        System.out.print("Give Admin password : ");
        String pass = scan.nextLine();

        String q = "select * from login_details where designation = 'admin'";

        try{
            ResultSet rs = con.createStatement().executeQuery(q);

            while(rs.next()){
                if(rs.getString("ID").compareTo(ID) == 0){
                    if(rs.getString("password").compareTo(pass) == 0){
                        return true;
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void DeleteId(String ID){
        if(this.adminLogin()){
            try{
                String q = "select \"" + ID + "\" in (Select ID from stu_info) as lol";
                ResultSet rs = con.createStatement().executeQuery(q);
                rs.next();
                int condition = rs.getInt("lol");
                // System.out.println(condition);
                if(condition == 1){
                    q = "delete from stu_info where ID = \"" + ID +"\"";
                    con.createStatement().executeUpdate(q);
                    System.out.println("Deleted From Student");

                    q = "delete from marksheets where ID = \"" + ID +"\"";
                    con.createStatement().executeUpdate(q);
                    System.out.println("Deleted From Marksheets");

                    q = "delete from login_details where ID = \"" + ID +"\"";
                    con.createStatement().executeUpdate(q);
                    System.out.println("Deleted From Login Details");
                }
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("You Need Admin Privilages !!!");
        }
    }
}