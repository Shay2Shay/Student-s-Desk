package src.Database.StudentLoad;

import src.Database.LoadDatabase.LoadDatabase;

import src.Database.LoadDatabase.*;
import src.Database.SQLconnect.*;
import java.io.*;

public class TeacherLoad implements LoadDatabase{
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
}
