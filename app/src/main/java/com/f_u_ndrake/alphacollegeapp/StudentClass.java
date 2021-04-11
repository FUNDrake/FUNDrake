package com.f_u_ndrake.alphacollegeapp;

public class StudentClass {

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    String FullName;

    public StudentClass() {}

    public StudentClass(String FullName) {
        this.FullName = FullName;
    }


}
