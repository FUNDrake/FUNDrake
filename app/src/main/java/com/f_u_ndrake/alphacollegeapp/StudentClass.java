package com.f_u_ndrake.alphacollegeapp;

public class StudentClass {

    private String FullName;

    private StudentClass() {}

    private StudentClass(String FullName, Boolean checkbox) {
        this.FullName = FullName;

    }

    public String getName() {
        return FullName;
    }

    public void setName(String name) {
        FullName = name;
    }

}
