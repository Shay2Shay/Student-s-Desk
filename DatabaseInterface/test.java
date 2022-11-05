import SQLconnect.*;

public class test {
    public static void main(String[] args) {
        System.out.println("Running...");

        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        con.selectAllFromTable("test");
        System.out.println();
        con.insertIntoTable("test", "attr1", "2321");
        System.out.println();
        con.selectAllFromTable("test");
    }
}

