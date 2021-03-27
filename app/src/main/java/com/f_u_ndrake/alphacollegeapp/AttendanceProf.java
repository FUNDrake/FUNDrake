package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AttendanceProf extends AppCompatActivity {

    Spinner AttendProfDep,AttendProfYear,AttendProfPeriod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_prof);

        AttendProfDep = (Spinner)findViewById(R.id.spinnerAttendProfDep);
        AttendProfYear = (Spinner)findViewById(R.id.spinnerAttendProfYear);
        AttendProfPeriod = (Spinner)findViewById(R.id.spinnerAttendProfPeriod);

        String[] arrayDepart = new String[] {
                "CSE", "BME", "ECE", "MECH", "MBA"};
        String[] arrayYear = new String[] {
                "Year 1", "Year 2", "Year 3", "Year 4"};
        String[] arrayPeriod = new String[] {
                "1st Period" , "2nd Period" , "3rd Period" , "4th Period" , "5th Period" , "6th Period" , "7th Period" , "8th Period" , "9th Period" };

        ArrayAdapter<String> adapterDepart = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayDepart);
        adapterDepart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AttendProfDep.setAdapter(adapterDepart);

        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayYear);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AttendProfYear.setAdapter(adapterYear);

        ArrayAdapter<String> adapterPeriod = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayPeriod);
        adapterPeriod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AttendProfPeriod.setAdapter(adapterPeriod);


    }
}