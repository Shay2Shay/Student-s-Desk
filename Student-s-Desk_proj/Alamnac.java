package src.Database.Alamnac;

import src.Database.LoadDatabase.*;
import src.Database.SQLconnect.*;
import java.io.*;
import java.sql.*;

public class Alamnac implements LoadDatabase{
    @Override
    public void loadCsv(String name, String path){
        SQLconnect con = new SQLconnect("alamnac", "jdbc", "jdbc");

        File f;
        try{
            f = new File(path+"/alamnac/"+name+".csv");
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

        return;
    }

    public void viewDatabase(String table){
        System.out.println("DAY   || Date || Working Days");
        SQLconnect con = new SQLconnect("alamnac", "jdbc", "jdbc");
        char[] type = {'s', 'i', 'i'};
        con.selectAllFromTable(table, type);
    }
}
