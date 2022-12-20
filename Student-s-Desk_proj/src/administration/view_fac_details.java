package src.administration;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class view_fac_details extends Faculty{

    public void details(String login_user_ID)
    {
        try{
            conn c = new conn();
            String q = "select* from fac_info where ID = ?";
            PreparedStatement ps = c.connection.prepareStatement(q);
            ps.setString(1,login_user_ID);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                System.out.println("*********************************************************************\n");
                System.out.println("Name = "+rs.getString("Name"));
                System.out.println("Specilization = "+rs.getString("Specilization"));
                System.out.println("ID = "+rs.getString("ID"));
                System.out.println("Email_id = "+rs.getString("Email_id"));
                System.out.println("DOB = "+rs.getDate("DOB"));
                System.out.println("Age = "+rs.getInt("Age"));
                System.out.println("Gender = "+rs.getString("Gender"));
                System.out.println("Address = "+rs.getString("Address"));
                System.out.println("Addhar_number = "+rs.getBigDecimal("Addhar_number"));
                System.out.println("Phone_Number = "+rs.getBigDecimal("Phone_Number"));
                System.out.println("Salary = "+rs.getFloat("salary"));

                System.out.println("\n*********************************************************************\n");


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
