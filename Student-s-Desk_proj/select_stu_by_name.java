package src.administration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import src.administration.conn;


public class select_stu_by_name {
    public static void select_by_name(String name){
        try{
            conn con = new conn();
            String q="select Name,ID,(c101+c102+c103+c104+c105+c106)/6 as gpa from stu_info natural join marksheets";

            Statement st = con.connection.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            System.out.println("     ID      || GPA || Name");
            while(rs.next()){
                
                String id = rs.getString("ID");
                String name1= rs.getString("Name");
                float gpa = rs.getFloat("gpa");


                if(name.compareTo(name1)==0){
                    // System.out.println(id + " || " + name + " || " + gpa);
                    System.out.printf("%s || %.1f || %s", id, gpa, name);
                }
            
            }

            con.connection.close();
        
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    } 
    
}
