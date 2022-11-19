
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;

import javax.security.auth.Subject;



package college_project;

public class Admin {
    
    private String Name;

   private String User_Name;
   
   private String ID;

   private LocalDate Date_of_Birth;
   private int Phone_number;
   private String Address;
   private String Aadhar_Number;

   private String passWord;

   private  String email_id;
   private String gender;

   private LocalDate Date_of_joining;
   private float Salary;



   Admin(){

   }

   Admin(String name , String ID , LocalDate DOB , int phone_number , String address , String Aadhar_Number , String User_Nme , String password , String email_id , String gender, String Date_of_joining,float salary){
       
        this.Name = name;
        this.Date_of_Birth = DOB;
        this.ID = ID;
        this.Phone_number = phone_number;
        this.Address = address;
        this.Aadhar_Number = Aadhar_Number;
        this.User_Name = User_Nme;
        this.passWord = password;
        this.email_id = email_id;
        this.gender = gender;
        this.Salary=salary;
        this.Date_of_joining=Date_of_joining;

   }


   public String getEmail_id() {
    return email_id;
}

public void setGender(String gender) {
    this.gender = gender;
}

public String getGender() {
    return gender;
}

public String getAadhar_Number() {
    return Aadhar_Number;
}

public String getPassWord() {
    return passWord;
}

public String getName() {
    return Name;
}

public LocalDate getDate_of_Birth() {
    return Date_of_Birth;
}

public int getPhone_number() {
    return Phone_number;
}

public String getAddress() {
    return Address;
}



public String getID() {
    return ID;
}

public void setDate_of_Birth(LocalDate date_of_Birth) {
    this.Date_of_Birth = date_of_Birth;
}

public void setName(String name) {
    this.Name = name;
}

public void setAddress(String address) {
    this.Address = address;
}

public void setEmail_id(String email_id) {
    this.email_id = email_id;
}



public void setID(String ID) {
    this.ID = ID;
}

public void setPassWord(String passWord) {
    this.passWord = passWord;
}

public void setPhone_number(int phone_number) {
    this.Phone_number = phone_number;
}

public void setAadhar_Number(String aadhar_Number) {
    this.Aadhar_Number = aadhar_Number;
}

public void setUser_Name(String user_Name) {
    this.User_Name = user_Name;
}

public String getUser_Name() {
    return User_Name;
}

public void setSalary(float salary)
{
    this.Salary=salary
}

public float getSalary(){
    return Salary;
}

public void setDate_ofjoining(LocalDate date_of_joining)
{
    this.Date_of_joining=date_of_joining
}

public LocalDate getDate_of_joining(){
    return Date_of_joining;
}




public int calculateAge()
{
    LocalDate dt = getDate_of_Birth();
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

public Boolean verification(String user_Name , String passWord )
{
    if(this.passWord.compareTo(passWord) == 0 && this.User_Name.compareTo(user_Name) == 0)
    {
        return true;
    }
    else
    {
        return false;
    }

}



}

class Management extends Admin{

    private String Designation;

    Management()
    {
        super();
    }

    Management(String name , String ID , LocalDate DOB , int phone_number , String address , String Aadhar_Number , String User_Nme , String password , String email_id , String gender, String Date_of_joining,float salary,String Designation)
    {
        super(name,ID,DOB,phone_number,address,Aadhar_Number,User_Nme,password,email_id,gender,Date_of_joining,salary);
        this.Designation=Designation;
    }

    public void setDesignation(String designation){

        this.Designation=designation;

    }

    public String getDesignation(){
        return Designation;
    }

    @Override
    public String toString()
    {
        return "Name :"+super.getName() +"User Name :" + super.getUser_Name() +"Designation :" +this.Designation +"ID :" + super.getID() +"Aadhar No :" + super.getAadhar_Number() +"Address :" + super.getAddress() +"Email :" + super.getEmail_id() +"Gender :" + super.getGender() +"Phone No :"+super.getPhone_number() +"Date Of Birth :" + super.getDate_of_Birth() +"Date of Joining :" + super.getDate_of_joining();
    }

}

class Teacher extends Admin{
    
    Private String Subject;

    Teacher()
    {
        super();
    }

    Teacher(String name , String ID , LocalDate DOB , int phone_number , String address , String Aadhar_Number , String User_Nme , String password , String email_id , String gender, String Date_of_joining,float salary,String subject)
    {
        super(name,ID,DOB,phone_number,address,Aadhar_Number,User_Nme,password,email_id,gender,Date_of_joining,salary);
        this.Subject=subject;
    }

    public void setSubject(String subject)
    {
        this.Subject=subject;
    }

    public String getSubject()
    {
        return Subject;
    } 


    @Override
    public String toString()
    {
        return "Name :"+super.getName() +"User Name :" + super.getUser_Name() +"Subject :" + this.getSubject() +"ID :" + super.getID() +"Aadhar No :" + super.getAadhar_Number() +"Address :" + super.getAddress() +"Email :" + super.getEmail_id() +"Gender :" + super.getGender() +"Phone No :"+super.getPhone_number() +"Date Of Birth :" + super.getDate_of_Birth() +"Date of Joining :" + super.getDate_of_joining();
    }



}

