package com.f_u_ndrake.alphacollegeapp;

public class StudentClass {

    String FullName;


    Boolean ischecked;

    public StudentClass() {}

    public StudentClass(String fullName, Boolean ischecked) {
        FullName = fullName;
        this.ischecked = ischecked;
    }

    public StudentClass(String FullName) {
        this.FullName = FullName;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Boolean getIschecked() {
        return ischecked;
    }

    public void setIschecked(Boolean ischecked) {
        this.ischecked = ischecked;
    }

}
