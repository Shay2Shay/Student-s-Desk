package src.administration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import src.administration.conn;

public class select_stu_by_sgpa {
    public static void select_by_gpa(float minGPA){
        try{
            conn con = new conn();
            String q = "select Name, ID, (c101+c102+c103+c104+c105+c106)/6 as gpa from stu_info natural join marksheets";

            Statement st = con.connection.createStatement();
            ResultSet rs = st.executeQuery(q);

            System.out.println("      ID      || GPA ||    NAME");
            while(rs.next()){
                float gpa = rs.getFloat("gpa");
                String id = rs.getString("ID");
                String name = rs.getString("Name");

                // System.out.println(id + "  || " + gpa + " || " + name);
                if(minGPA <= gpa){
                    System.out.printf("%s  || %.1f || %s\n", id, gpa, name);
                }
            }
            con.connection.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
