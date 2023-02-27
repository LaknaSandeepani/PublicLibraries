package lk.viva.publiclibraries;

import android.widget.EditText;

public class UserHelperClass {
    String Fname,Lname,Gender,Email,EnrollNo,CardNo,Password,Confirmpwd, Type;;

    public UserHelperClass() {
    }


    public UserHelperClass(String fname, String lname, String gender, String email, String enrollNo, String cardNo, String password, String confirmpwd, String type) {
        Fname = fname;
        Lname = lname;
        Gender = gender;
        Email = email;
        EnrollNo = enrollNo;
        CardNo = cardNo;
        Password = password;
        Confirmpwd = confirmpwd;
        Type = type;


    }
    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEnrollNo() {
        return EnrollNo;
    }

    public void setEnrollNo(String enrollNo) {
        EnrollNo = enrollNo;
    }

    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirmpwd() {
        return Confirmpwd;
    }

    public void setConfirmpwd(String confirmpwd) {
        Confirmpwd = confirmpwd;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }


}
