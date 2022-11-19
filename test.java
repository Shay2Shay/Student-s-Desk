import src.Database.SQLconnect.*;

/**
 * test
 */
public class test {

    public static void main(String[] args) {
        System.out.println("Running...");
        SQLconnect con = new SQLconnect("student", "root", "yoyo_Anjali@123");
        System.out.println("connected");
        
    }
}