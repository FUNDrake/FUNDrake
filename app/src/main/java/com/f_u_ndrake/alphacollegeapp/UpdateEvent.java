package com.f_u_ndrake.alphacollegeapp;


public class UpdateEvent {

    String Title;
    String Description;


    public UpdateEvent(){}

    public String getTitle() {
        return Title;
    }

    public void setTitle(String text) {
        Title = text;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
