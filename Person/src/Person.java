import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Person {

   private String Name;

   private String User_Name;
   private String Designation;
   private String ID;

   private LocalDate Date_of_Birth;
   private int Phone_number;
   private String Address;
   private String Aadhar_Number;

   private String passWord;

   private  String email_id;

   private String gender;


    Person()
    {

    }

    Person(String name , String Designation , String ID , LocalDate DOB , int phone_number , String address , String Aadhar_Number , String User_Nme , String password , String email_id , String gender)
    {
        this.Name = name;
        this.Date_of_Birth = DOB;
        this.Designation = Designation;
        this.ID = ID;
        this.Phone_number = phone_number;
        this.Address = address;
        this.Aadhar_Number = Aadhar_Number;
        this.User_Name = User_Nme;
        this.passWord = password;
        this.email_id = email_id;
        this.gender = gender;

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

    public String getDesignation() {
        return Designation;
    }

    public String getID() {
        return ID;
    }

    public void setDate_of_Birth(LocalDate date_of_Birth) {
        Date_of_Birth = date_of_Birth;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setPhone_number(int phone_number) {
        Phone_number = phone_number;
    }

    public void setAadhar_Number(String aadhar_Number) {
        Aadhar_Number = aadhar_Number;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Name() {
        return User_Name;
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
