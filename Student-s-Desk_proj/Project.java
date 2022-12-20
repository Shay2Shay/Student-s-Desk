package src.administration;

import src.administration.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;
import src.Database.Timetable.*;
import src.administration.ConsoleColors;

public class Project{

    public static void main2() {
        try{

            conn c = new conn();
            System.out.println("|-----------------------------------------------------------------------|");
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT + "|--------------------------Enter login details--------------------------|" + ConsoleColors.RESET);
            System.out.println("|-----------------------------------------------------------------------|\n");

            Scanner scan = new Scanner(System.in);
            String login_user_ID ;
            String login_user_name;
            String login_pass ;
            String designation ;
            String q = "select name , designation from login_details where ID = ? and password = ?";
            PreparedStatement ps = c.connection.prepareStatement(q);
            System.out.print("Enter user ID : ");
            login_user_ID = scan.nextLine();
            System.out.print("Enter password : ");
            login_pass = scan.nextLine();
            ps.setString(1,login_user_ID);
            ps.setString(2,login_pass);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {

                System.out.println("\n-------------------------------------------------------------------------------------\n");
                System.out.println("Welcome "+ rs.getString("name")+" to college management desk ");
                int choice;
                designation = rs.getString("designation");
                //System.out.println(designation);
                if(designation.compareTo("student") == 0)
                {

                    while(true)
                    {
                        System.out.println("\n-------------------------------------------------------------------------------------\n");
                        System.out.println("Enter 1 to see personal info");
                        System.out.println("Enter 2 to update personal info");//Do not provide the right to update branch , id or year
                        System.out.println("Enter 3 to see time table");
                        System.out.println("Enter 4 to see marksheet");
                        System.out.println("Enter 5 to exit");
                        System.out.println("\n-------------------------------------------------------------------------------------\n");
                        System.out.print("Enter your choice : ");
                        choice = scan.nextInt();
                        System.out.println("\n-------------------------------------------------------------------------------------\n");

                        if(choice == 1)
                        {
                            view_stu_details v = new view_stu_details();
                            v.details(login_user_ID);
                        }
                        if(choice == 3)
                        {
                            time_table db1 = new time_table();
                            db1.viewDatabase(login_user_ID);
                        }
                        if(choice == 2)
                        {
                            update_stu_info up = new update_stu_info();
                            up.update_info(login_user_ID);
                        }
                        if(choice == 4)
                        {
                            View_marksheet_student vm = new View_marksheet_student();
                            vm.details(login_user_ID);
                        }
                        if(choice == 5){
                            break;
                        }

                    }

                }
                if(designation.compareTo("faculty") == 0)
                {
                    while(true)
                    {
                        System.out.println("\n-------------------------------------------------------------------------------------\n");
                        System.out.println("Enter 1 to see personal info ");
                        System.out.println("Enter 2 to update personal info ");//Do not give the right to update salary , designation , id
                        System.out.println("Enter 3 to see time table");
                        System.out.println("Enter 4 to view marksheet");

                        System.out.println("Enter 5 to search by SGPA");
                        System.out.println("Enter 6 to select student by name");

                        System.out.println("Enter 7 to exit ");
                        System.out.println("\n-------------------------------------------------------------------------------------\n");
                        System.out.print("Enter your choice : ");
                        choice = scan.nextInt();
                        System.out.println("\n-------------------------------------------------------------------------------------\n");
                        if(choice == 1)
                        {
                            view_fac_details f = new view_fac_details();
                            f.details(login_user_ID);
                           

                        }
                        if(choice == 4)
                        {
                            View_marksheet_faculty vm = new View_marksheet_faculty();
                            vm.details(login_user_ID);

                        }
                        if(choice == 2)
                        {
                            update_fac_info fac = new update_fac_info();
                            fac.update_info(login_user_ID);
                        }
                        if(choice == 3)
                        {
                            time_table db1 = new time_table();
                            db1.viewDatabase(login_user_ID);     
                        }
                        if(choice == 7)
                        {
                            break;
                        }
                        if(choice == 5)
                        {
                            System.out.print("Give Minimum SGPA : ");
                            float min = scan.nextFloat();
                            select_stu_by_sgpa.select_by_gpa(min);
                        }
                        if(choice == 6)
                        {
                            System.out.print("Give the name : ");
                            scan.nextLine();
                            String name = scan.nextLine();
                            select_stu_by_name.select_by_name(name);
                        }
                    }

                }

            }
            else
            {
                System.out.println("Please enter a valid user name or password !!! ");
            }
            // c.connection.close();

        }
        catch (Exception e){
            System.out.println(e);
        }


    }
}
