package src.Database.Courses;

import src.Database.LoadDatabase.*;
import src.Database.SQLconnect.*;
import java.io.*;
import java.sql.*;

public class Courses implements LoadDatabase{
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
                        // try{               
                        //     con.insertIntoTable(name, values);
                        // }catch(SQLIntegrityConstraintViolationException e){
                        //     System.out.println("KEY CONSTRAINED VIOLATED !!!");
                        //     System.out.println("REVERTING ALL UPDATES");
                        //     con.truncateTable(name);
                        //     break;
                        // }
                        con.insertIntoTable(name, values);
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
        System.out.println("NAME               >>  CODE  >> ID ");
        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        char[] type = {'s', 's', 'i'};
        con.selectAllFromTable(table, type);

        // if(con.adminLogin()){
        //     System.out.println("NAME               >>  CODE  >> ID ");
        //     char[] type = {'s', 's', 'i'};
        //     con.selectAllFromTable(table, type);
        // }else{
        //     System.out.println("Wrong Credentials");
        // }
    }
}
