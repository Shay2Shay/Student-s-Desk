import java.io.File;
import java.io.FileReader;

import LoadDatabase.*;
import SQLconnect.*;

class loadForTest implements LoadDatabase{
    File f;
    public void loadCsv(String name, String path){
        try{
            f = new File(path+name);
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
                    System.out.println(values);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }

        return;
    }
}

class testLoad{
    public static void main(String[] args) {
        loadForTest lt = new loadForTest();
        lt.loadCsv("test.csv", "/home/shay/Desktop/");
    }
}