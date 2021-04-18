package com.f_u_ndrake.alphacollegeapp;

public class StudentClass {

    String FullName;


    Boolean check;

    public StudentClass() {}

    public StudentClass(String fullName, Boolean check) {
        FullName = fullName;
        this.check = check;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

}
