package LoadTest;

import LoadDatabase.*;

public class LoadTest implements LoadDatabase{
    @Override
    public void loadCsv(String name, String path){
        System.out.println("Working...");
    }
}
