package src.administration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View_marksheet_student {

    public void details(String login_user_ID)
    {
        try{
            conn c = new conn();
            String q = "select* from marksheets where ID = ?";
            PreparedStatement ps = c.connection.prepareStatement(q);
            ps.setString(1,login_user_ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                System.out.println("***********************\n");
                String id = rs.getString("ID");
                int c101 = rs.getInt("c101");
                int c102 = rs.getInt("c102");
                int c103 = rs.getInt("c103");
                int c104 = rs.getInt("c104");
                int c105 = rs.getInt("c105");
                int c106 = rs.getInt("c106");

           
                System.out.println(id + "\t\t" + c101
                                      + "\t\t"+ c102
                                      + "\t\t"+ c103
                                      + "\t\t"+ c104
                                      + "\t\t"+ c105
                                      + "\t\t"+ c106);

                System.out.println("\n*************************\n");


            }
            else {
                System.out.println("Something went wrong.\nCouldn't fetch your data");
            }
            c.connection.close();

        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
