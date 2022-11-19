
package src.administration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;



class Student{
    private String name;
    private String branch;
    private int year;
    private String ID;
    private LocalDate dob;
    private String email_id;
    private String gender;

    private int age;

    private String address;
    private int phone_number1;

    private int addhar_number;

    public Student() {
    }
    public Student(String name , String branch , int year , String ID , LocalDate dob , String email_id , String gender, int addhar_number  , int phone_number1)
    {
        this.name = name;
        this.ID = ID;
        this.dob = dob;
        this.branch = branch;
        this.year = year;
        this.email_id = email_id;
        this.gender = gender;
        this.age = calculateAge(dob);
        this.addhar_number = addhar_number;
        this.phone_number1 = phone_number1;

    }

    public LocalDate getDob() {
        return dob;
    }

    public String getBranch() {
        return branch;
    }

    public int getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail_id() {
        return email_id;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getAddhar_number() {
        return addhar_number;
    }

    public int getPhone_number1() {
        return phone_number1;
    }

    public int getAge() {
        return age;
    }

    public int calculateAge(LocalDate d)
    {
        LocalDate dt = d;
        LocalDate curDate = LocalDate.now();
        if ((dt != null) && (curDate != null))
        {
            return Period.between(dt,curDate).getYears();
        }
        else
        {
            return 0;
        }

    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddhar_number(int addhar_number) {
        this.addhar_number = addhar_number;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPhone_number1(int phone_number1) {
        this.phone_number1 = phone_number1;
    }



    public void DateToLocalDate()
    {
        Date date = new java.util.Date();
        LocalDate localDate = new java.sql.Date(date.getTime()).toLocalDate();
    }

    public void Update_Right_Student(int ID)
    {

        Scanner scan = new Scanner(System.in);
        String option;
        System.out.print("Do you want to update your Addhar number (y/n) : ");
        option = scan.nextLine();
        if(option.compareTo("y") == 0)
        {
            System.out.print("Enter your new addhar number : ");
            this.addhar_number = scan.nextInt();
        }
        System.out.println("Do you want to update your phone number (y/n) : ");
        option = scan.nextLine();
        if(option.compareTo("y") == 0)
        {
            System.out.print("Enter your new phone number : ");
            this.phone_number1 = scan.nextInt();
        }
        System.out.println("Do you want to update your address (y/n) : ");
        option = scan.nextLine();
        if(option.compareTo("y") == 0)
        {
            System.out.print("Enter your new address : ");
            this.address = scan.nextLine();
        }

    }









}