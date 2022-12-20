package src.administration;
import java.math.BigInteger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//bug
// change phone+number to string
// aadhar number too

public class update_stu_info {

    public void update_info(String login_user_ID) {

        BigInteger addhar_number;
        BigInteger phone_number1;
        String q1, q2, q3, q4;
        String option;
        int op;
        Scanner scan = new Scanner(System.in);
        q1 = "UPDATE stu_info set Addhar_number = ? where ID = ?";
        q2 = "UPDATE stu_info set Phone_Number = ? where ID = ?";
        q3 = "UPDATE stu_info set Address = ? where ID = ?";
        q4 = "UPDATE stu_info set Address = ? , Phone_Number = ? , Address = ? where ID = ?";
        String address;
        try {
            conn cc = new conn();
            System.out.print("Do you want to update your phone number (y/n) : ");
            option = scan.next();
            if(option.compareTo("y") == 0)
            {
                System.out.print("Enter your new phone number : ");
                phone_number1 = BigInteger.valueOf(scan.nextInt());
                PreparedStatement ps2 = cc.connection.prepareStatement(q2);
                ps2.setString(1, String.valueOf(phone_number1));
                ps2.setString(2,login_user_ID);
                ps2.executeUpdate();
            } else if (option.compareTo("n") == 0) {

            } else{
                System.out.println("Sorry something went wrong can't update!!!");

            }
            cc.connection.close();

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        try {
            conn c = new conn();

            System.out.print("Do you want to update your Addhar number (y/n) : ");
            option = scan.next();
            if (option.compareTo("y") == 0) {
                System.out.print("Enter your new addhar number : ");
                addhar_number = BigInteger.valueOf(scan.nextInt());
                PreparedStatement ps = c.connection.prepareStatement(q1);
                ps.setString(1, String.valueOf(addhar_number));
                ps.setString(2, login_user_ID);
                ps.executeUpdate();

            } else if (option.compareTo("n") == 0) {

            } else {
                System.out.println("Sorry something went wrong can't update!!!");

            }
            c.connection.close();

            }
        catch (Exception e)
        {
            System.out.println(e);
        }

        try {
            conn c = new conn();
            System.out.print("Do you want to update your address (y/n) : ");
            scan.nextLine();
                option = scan.nextLine();
                if(option.compareTo("y") == 0)
                {
                    System.out.print("Enter your new address : ");
                    address = scan.nextLine();

                    PreparedStatement ps3 = c.connection.prepareStatement(q3);
                    ps3.setString(1, String.valueOf(address));
                    ps3.setString(2,login_user_ID);
                    ps3.executeUpdate();

                }
                else if (option.compareTo("n") == 0) {

                }
                else{
                    System.out.println("Sorry something went wrong can't update!!!");

                }
            c.connection.close();
        }
        catch (Exception e)
        {
            System.out.println(e);

        }
        System.out.println("\n---------------------------------------------------------------------------------------------\n");
        System.out.println("The updated record is as follows");
        System.out.println("\n---------------------------------------------------------------------------------------------\n");


                view_stu_details v = new view_stu_details();
                v.details(login_user_ID);
        }



    }

