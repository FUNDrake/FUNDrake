package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AttendanceStud3 extends AppCompatActivity {

    TextView SubCode1,SubName1,SubCode2,SubName2,SubCode3,SubName3;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public String firstName,dep,sem;
    int subject;
    private static final String TAG = "AttendanceStud3";
    String[] arrayDepart = new String[] {
            "CSE", "BME", "ECE", "MECH", "MBA"};
    String[] arraySem = new String[] {
            "1st Semester", "2nd Semester","3rd Semester", "4th Semester","5th Semester", "6th Semester","7th Semester", "8th Semester"};

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


        db.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful() && task.getResult() != null){
                firstName = task.getResult().getString("FullName");
                dep = task.getResult().getString("Department");
                sem = task.getResult().getString("Semester");
                getvalue(firstName,dep,sem);
                String email = task.getResult().getString("Email");
                String phone = task.getResult().getString("Phone");
                //other stuff

            }//deal with error

        });

    }
    private void getvalue(String firstName,String dep, String sem) {
        this.firstName = firstName;
        this.dep = dep;
        this.sem = sem;
        if(dep.equals("CSE")){
            SubCode1.setText("CS8080");
            SubName1.setText("Information Retrieval Technique");
            SubCode2.setText("GE8076");
            SubName2.setText("Professional Ethics in Engineering");
            SubCode3.setText("CS8811");
            SubName3.setText("Project Work");
        }
        //Toast.makeText(MenuActivity.this,"Name "+firstName + "Dep "+ dep +"Sem " + sem,Toast.LENGTH_LONG).show();
    }
}