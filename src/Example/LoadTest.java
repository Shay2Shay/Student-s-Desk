package src.Example;

import java.io.*;

import src.Database.LoadDatabase.*;
import src.Database.SQLconnect.*;

public class LoadTest implements LoadDatabase{
    @Override
    public void loadCsv(String name, String path){
        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        System.out.println("Connected...");

        File f;
        try{
            f = new File(path+name+".csv");
            FileReader fr = new FileReader(f);
            int val = 0;
            String values;
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

        return;
    }
}