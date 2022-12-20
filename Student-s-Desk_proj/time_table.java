package src.administration;
import java.util.*;
import java.io.*;
import java.sql.*;

public class time_table {
    // public void loadCsv(String name, String path){
    //     SQLconnect connection = new SQLconnect("jdbc", "jdbc", "jdbc");

    //     File f;
    //     try{
    //         f = new File(path+"/"+name+".csv");
    //         FileReader fr = new FileReader(f);
    //         int val = 0;
    //         String values;
    //         connection.truncateTable(name);
    //         while((val = fr.read()) != -1){
    //             values = "";
    //             while((char)val != '\n'){
    //                 values += (char)val;
    //                 val = fr.read();
    //             }
    //             if(values.length() != 0){
    //                 connection.insertIntoTable(name, values);
    //             }
                
    //         }
    //         fr.close();
    //     }catch(Exception e){
    //         System.out.println(e);
    //         System.exit(-1);
    //     }

    //     return;
    // }

    public void viewDatabase(String table){
        // conn con = new conn();
        // System.out.println("SLOT || MON >> TUE >> WED >> THU >> FRI >> SAT");
        // // char[] type = {'s', 's', 's', 's', 's', 's'};
        // // con.selectAllFromTable(table, type);
        // String q = "Select * from timetable";
        // Statement st = con.connection.createStatement();
        // ResultSet rs = st.executeQuery(q);

        try{
            conn con = new conn();
            String q = "Select * from timetable";
            PreparedStatement st = con.connection.prepareStatement(q);
            ResultSet rs = st.executeQuery();

            while(rs.next()){
                for(int i = 1; i <= 5; i++){
                    System.out.printf("%s ", rs.getString(i));
                }
                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}
