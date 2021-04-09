package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class C_CGPATotal extends AppCompatActivity {

    TextView department,year,sem;
    Button get;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c__c_g_p_a_total);

        String depart = getIntent().getStringExtra("shareddepartment");
        String Syear = getIntent().getStringExtra("sharedyear");
        String Ssem = getIntent().getStringExtra("sharedsem");

        department = (TextView)findViewById(R.id.tvCGPADep);
        year = (TextView)findViewById(R.id.tvCGPAYear);
        sem = (TextView)findViewById(R.id.tvCGPASem);
        get = (Button)findViewById(R.id.buttonGet);

        department.setText(depart);
        year.setText(Syear);
        sem.setText(Ssem);


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        ArrayList<SubjectGrade> arrayList = new ArrayList<SubjectGrade>();
        arrayList.add(new SubjectGrade("Subject 1",4));
        Toast.makeText(C_CGPATotal.this,"Subject  = "+arrayList.get(0).getSubjectname()+"\nGrade = "+arrayList.get(0).getGrade(),Toast.LENGTH_SHORT).show();

    }
}