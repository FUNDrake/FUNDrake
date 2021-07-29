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

    public int getSubject1Attend() {
        return Subject1Attend;
    }

    public void setSubject1Attend(int subject1Attend) {
        Subject1Attend = subject1Attend;
    }

    public int getSubject2Attend() {
        return Subject2Attend;
    }

    public void setSubject2Attend(int subject2Attend) {
        Subject2Attend = subject2Attend;
    }

    public int getSubject3Attend() {
        return Subject3Attend;
    }

    public void setSubject3Attend(int subject3Attend) {
        Subject3Attend = subject3Attend;
    }

    public int getSubject4Attend() {
        return Subject4Attend;
    }

    public void setSubject4Attend(int subject4Attend) {
        Subject4Attend = subject4Attend;
    }

    public int getSubject5Attend() {
        return Subject5Attend;
    }

    public void setSubject5Attend(int subject5Attend) {
        Subject5Attend = subject5Attend;
    }

    public int getSubject6Attend() {
        return Subject6Attend;
    }

    public void setSubject6Attend(int subject6Attend) {
        Subject6Attend = subject6Attend;
    }

    public int getSubject7Attend() {
        return Subject7Attend;
    }

    public void setSubject7Attend(int subject7Attend) {
        Subject7Attend = subject7Attend;
    }

    public int getSubject8Attend() {
        return Subject8Attend;
    }

    public void setSubject8Attend(int subject8Attend) {
        Subject8Attend = subject8Attend;
    }

    public int getSubject9Attend() {
        return Subject9Attend;
    }

    public void setSubject9Attend(int subject9Attend) {
        Subject9Attend = subject9Attend;
    }

    int Subject1Attend,Subject2Attend,Subject3Attend,Subject4Attend,Subject5Attend,Subject6Attend,Subject7Attend,Subject8Attend,Subject9Attend;

    public UserData(String fullname, String emailid, String phonenumber, String aurollno, String gender, String address, String department, String year, String semester,int Subject1Attend,int Subject2Attend,int Subject3Attend,int Subject4Attend,int Subject5Attend,int Subject6Attend,int Subject7Attend,int Subject8Attend,int Subject9Attend) {
        this.fullname = fullname;
        this.emailid = emailid;
        this.phonenumber = phonenumber;
        this.aurollno = aurollno;
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.year = year;
        this.semester = semester;
        this.Subject1Attend = Subject1Attend;
        this.Subject2Attend = Subject2Attend;
        this.Subject3Attend = Subject3Attend;
        this.Subject4Attend = Subject4Attend;
        this.Subject5Attend = Subject5Attend;
        this.Subject6Attend = Subject6Attend;
        this.Subject7Attend = Subject7Attend;
        this.Subject8Attend = Subject8Attend;
        this.Subject9Attend = Subject9Attend;
    }



    public UserData(){}

}
