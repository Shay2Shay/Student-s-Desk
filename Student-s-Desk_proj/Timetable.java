package src.Database.Timetable;

import src.Database.LoadDatabase.*;
import src.Database.SQLconnect.*;
import java.io.*;

public class Timetable implements LoadDatabase{

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
                        con.insertIntoTable(name, values);
                    }
                    
                }
                fr.close();
            }catch(Exception e){
                System.out.println(e);
                System.exit(-1);
            }
        }else{
            System.out.println("Wrong Credentials");
        }

        return;
    }

    public void viewDatabase(String table){
        System.out.println("SLOT || MON >> TUE >> WED >> THU >> FRI >> SAT");
        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        char[] type = {'s', 's', 's', 's', 's', 's'};
        con.selectAllFromTable(table, type);
    }

}
