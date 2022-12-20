package src.administration;

import src.administration.*;

import java.sql.ResultSet;

import src.Database.SQLconnect.*;;

public class DeleteByID {
    public static void deleteID(String id){
        SQLconnect con = new SQLconnect("jdbc", "jdbc", "jdbc");
        con.DeleteId(id);
    }

}
