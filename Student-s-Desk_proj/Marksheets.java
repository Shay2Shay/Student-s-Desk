package src.Database.Marksheets;

import src.Database.LoadDatabase.*;
import src.Database.SQLconnect.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Marksheets implements LoadDatabase{
    @Override
    public void loadCsv(String name, String path){
        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");

        if(con.adminLogin()){
            File f;
            try{
                f = new File(path+"/"+name+".csv");
                FileReader fr = new FileReader(f);
                int val = 0;
                String values;
                con.truncateTable(name);
                while((val = fr.read()) != -1){
                    values = "";
                    while((char)val != '\n'){
                        values += (char)val;
                        val = fr.read();
                    }
                    if(values.length() != 0){     
                        try{               
                            con.insertIntoTable(name, values);
                        }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    
                }
                fr.close();
            }catch(Exception e){
                System.out.println(e.getMessage());
                System.exit(-1);
            }
        }else{
            System.out.println("Wrong Credentials");
        }
        return;
    }

    public void viewDatabase(String table){
        // System.out.print("Give Admin Password >>> ");
        // Scanner sc = new Scanner(System.in);
        // int pass = sc.nextInt();
        // if(pass != 123){
        //     System.out.println("Wrong PASSWORD !!!");
        //     return;
        // }
        
        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        if(con.adminLogin()){
            System.out.println("\nSID || C101 >> C102 >> C103 >> C104 >> C105 >> C106");
            char[] type = {'s', 'i', 'i', 'i', 'i', 'i', 'i'};
            con.selectAllFromTable(table, type);
        }else{
            System.out.println("Wrong Credentials");
        }
    }
}
