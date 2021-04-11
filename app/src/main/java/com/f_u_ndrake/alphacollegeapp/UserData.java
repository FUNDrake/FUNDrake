package com.f_u_ndrake.alphacollegeapp;

public class UserData {
    String fullname;
    String emailid;
    String phonenumber;
    String aurollno;
    String gender;
    String address;
    String department;
    String year;
    String semester;

    public UserData(String fullname, String emailid, String phonenumber, String aurollno, String gender, String address, String department, String year, String semester) {
        this.fullname = fullname;
        this.emailid = emailid;
        this.phonenumber = phonenumber;
        this.aurollno = aurollno;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.year = year;
        this.semester = semester;
    }



    public UserData(){}

}
