package com.f_u_ndrake.alphacollegeapp;

public class SubjectGrade {

    String subjectname;
    int grade;

    public SubjectGrade(String subjectname, int grade){
        this.subjectname = subjectname;
        this.grade = grade;
    }

    public String getSubjectname() {
        return subjectname;
    }

    public void setSubjectname(String subjectname) {
        this.subjectname = subjectname;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }


}
