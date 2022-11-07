import src.Example.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running...");

        LoadTest lt = new LoadTest();
        lt.loadCsv("test2", "/home/shay/Desktop/");
    }
}
