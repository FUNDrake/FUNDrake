package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AttendanceStud3 extends AppCompatActivity {

    TextView SubCode1,SubName1,Attend1,SubCode2,SubName2,Attend2,SubCode3,SubName3,Attend3;
    int attendance1,attendance2,attendance3;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public String firstName,dep,sem;
    private static final String TAG = "AttendanceStud3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_stud3);

        SubCode1 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectCode1);
        SubCode2 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectCode2);
        SubCode3 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectCode3);

        SubName1 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectName1);
        SubName2 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectName2);
        SubName3 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectName3);

        Attend1 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectAttend1);
        Attend2 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectAttend2);
        Attend3 = (TextView)findViewById(R.id.Stud3tvAttendStudSubjectAttend3);

        db.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful() && task.getResult() != null){
                firstName = task.getResult().getString("FullName");
                dep = task.getResult().getString("Department");
                sem = task.getResult().getString("Semester");
                getvalue(firstName,dep,sem);
                //other stuff

            }//deal with error

        });

    }
    private void getvalue(String firstName,String dep, String sem) {
        this.firstName = firstName;
        this.dep = dep;
        this.sem = sem;
        /*Attend1.setText(attendance1);
        Attend2.setText(attendance2);
        Attend3.setText(attendance3);*/
        if(dep.equals("CSE")){
            SubCode1.setText("CS8080");
            SubName1.setText("Information Retrieval Technique");
            SubCode2.setText("GE8076");
            SubName2.setText("Professional Ethics in Engineering");
            SubCode3.setText("CS8811");
            SubName3.setText("Project Work");
        }if(dep.equals("BME")){
            SubCode1.setText("GE8076");
            SubName1.setText("Professional Ethics in Engineering");
            SubCode2.setText("GE8076");
            SubName2.setText("Professional Elective - V");
            SubCode3.setText("BM8811");
            SubName3.setText("Project Work");
        }if(dep.equals("ECE")){
            SubCode1.setText("GE8076");
            SubName1.setText("Professional Ethics in Engineering");
            SubCode2.setText("EC8093");
            SubName2.setText("Digital Image Processing");
            SubCode3.setText("EC8811");
            SubName3.setText("Project Work");
        }if(dep.equals("MECH")){
            SubCode1.setText("GE8076");
            SubName1.setText("Professional Ethics in Engineering");
            SubCode2.setText("MG8591");
            SubName2.setText("Principles of Management");
            SubCode3.setText("ME8811");
            SubName3.setText("Project Work");
        }
        if(dep.equals("IT")){
            SubCode1.setText("CS8080");
            SubName1.setText("Information Retrieval Technique");
            SubCode2.setText("GE8076");
            SubName2.setText("Professional Ethics in Engineering");
            SubCode3.setText("IT8811");
            SubName3.setText("Project Work");
        }
        //Toast.makeText(MenuActivity.this,"Name "+firstName + "Dep "+ dep +"Sem " + sem,Toast.LENGTH_LONG).show();
    }
}
