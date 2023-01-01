package lk.viva.publiclibraries;

import android.widget.EditText;

public class UserHelperClass {
    String Fname,Lname,Gender,Nic,Address,Phone,Email,Status,District,Library;

    public UserHelperClass() {
    }

    public UserHelperClass(String fname, String lname, String gender, String nic, String address, String phone, String email,String status,String district,String library) {
        Fname = fname;
        Lname = lname;
        Gender = gender;
        Nic = nic;
        Address = address;
        Phone = phone;
        Email = email;
        Status = status;
        District = district;
        Library = library;

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

    public void setLname(String gender) {
        Gender = gender;
    }
    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getNic() {
        return Nic;
    }

    public void setNic(String nic) {
        Nic = nic;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }
    public String getLibrary() {
        return Library;
    }

    public void setLibrary(String library) {
        Library = library;
    }
}
