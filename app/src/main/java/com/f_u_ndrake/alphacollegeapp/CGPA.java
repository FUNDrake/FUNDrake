package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class CGPA extends AppCompatActivity {

    Spinner Dep,Year,Sem;
    Button GPA,CGPA;
    String Sdepart,Syear,Ssem;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_g_p_a);

        String[] arrayDepart = new String[] {
                "CSE", "BME", "ECE", "MECH", "IT"};
        String[] arrayYear = new String[] {
                "Year 1", "Year 2", "Year 3", "Year 4"};
        String[] arraySem12 = new String[] {
                "Semester 1", "Semester 2"};
        String[] arraySem34 = new String[] {
                "Semester 3", "Semester 4"};
        String[] arraySem56 = new String[] {
                "Semester 5", "Semester 6"};
        String[] arraySem78 = new String[] {
                "Semester 7", "Semester 8"};

        Dep = (Spinner)findViewById(R.id.spinnerCGPADep);
        Year = (Spinner)findViewById(R.id.spinnerCGPAYear);
        Sem = (Spinner)findViewById(R.id.spinnerCGPASemester);

        GPA = (Button)findViewById(R.id.butCGPA_GPA);
        CGPA = (Button)findViewById(R.id.butCGPA_CGPA);

        ArrayAdapter<String> adapterSem12 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem12);
        adapterSem12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem34 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem34);
        adapterSem34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem56 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem56);
        adapterSem56.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem78 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem78);
        adapterSem78.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterDepart = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayDepart);
        adapterDepart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Dep.setAdapter(adapterDepart);

        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayYear);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Year.setAdapter(adapterYear);

        Year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (Year.getSelectedItemPosition()){
                    case 0 : Sem.setAdapter(adapterSem12); break;
                    case 1 : Sem.setAdapter(adapterSem34); break;
                    case 2 : Sem.setAdapter(adapterSem56); break;
                    case 3 : Sem.setAdapter(adapterSem78); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

/*      String savedPref = sharedPreferences.getString("savedPref",null);
        String Sdep = sharedPreferences.getString("SPdepartment",null);
        String Syear = sharedPreferences.getString("SPyear",null);
        String Ssem = sharedPreferences.getString("SPsemester",null);

        sharedPreferences = getSharedPreferences("savedPref",MODE_PRIVATE);
        editor =  sharedPreferences.edit();
        editor.putString(Sdep, Dep.getSelectedItem().toString());
        editor.putString(Syear, Year.getSelectedItem().toString());
        editor.putString(Ssem, Sem.getSelectedItem().toString());

        Ssem = Sem.getSelectedItem().toString();
                Intent intent = new Intent(CGPA.this,C_CGPATotal.class);
                intent.putExtra("shareddepartment",Sdepart);
                intent.putExtra("sharedyear",Syear);
                intent.putExtra("sharedsem",Ssem);
                startActivity(intent);
        */

        GPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sdepart = Dep.getSelectedItem().toString();
                Syear = Year.getSelectedItem().toString();
                Ssem = Sem.getSelectedItem().toString();
                Intent intent = new Intent(CGPA.this, C_CGPASingle.class);
                intent.putExtra("shareddepartment",Sdepart);
                intent.putExtra("sharedyear",Syear);
                intent.putExtra("sharedsem",Ssem);
                startActivity(intent);
            }
        });
    }
}