package com.f_u_ndrake.alphacollegeapp;

import java.util.Date;

public class UpdateEvent {

    String Title;
    String Description;
    com.google.firebase.Timestamp Timestamp;

    public Date getTimestamp() {
        Date javaDate = Timestamp.toDate();
        return javaDate;
    }

    public void setTimestamp(com.google.firebase.Timestamp timestamp) {
        Timestamp = timestamp;
    }

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
