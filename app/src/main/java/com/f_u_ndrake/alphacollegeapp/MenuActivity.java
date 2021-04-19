package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MenuActivity extends AppCompatActivity {

    CardView Material, Attendance,AttendanceProf,News,Calendar,Events,CGPA,Assignment;
    TextView welcomeUser;
    ImageButton logout;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private long backPressedTime;
    public String firstName,dep,sem;
    public int subject;
    private static final String TAG = "MenuActivity";
    String[] arrayDepart = new String[] {
            "CSE", "BME", "ECE", "MECH", "MBA"};
    String[] arraySem = new String[] {
            "1st Semester", "2nd Semester","3rd Semester", "4th Semester","5th Semester", "6th Semester","7th Semester", "8th Semester"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        db.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful() && task.getResult() != null){
                firstName = task.getResult().getString("FullName");
                dep = task.getResult().getString("Department");
                sem = task.getResult().getString("Semester");
                getvalue(firstName,dep,sem);
                //other stuff
                welcomeUser.setText(" Welcome back \n" + firstName );
            }//deal with error
            if(!task.isSuccessful()){
                Toast.makeText(MenuActivity.this,"There was some problem retrieving data",Toast.LENGTH_LONG).show();
            }
        });

        logout = (ImageButton)findViewById(R.id.imageButLogout);

        Assignment = (CardView)findViewById(R.id.cardviewAssignment);
        Material = (CardView)findViewById(R.id.cardviewMaterial);
        Attendance = (CardView)findViewById(R.id.cardviewAttendance);
        News =  (CardView)findViewById(R.id.cardviewNews);
        Calendar =  (CardView)findViewById(R.id.cardviewCalendar);
        AttendanceProf = (CardView)findViewById(R.id.imgcalenda2);
        Events = (CardView)findViewById(R.id.cardviewEvents);
        CGPA = (CardView)findViewById(R.id.cardviewCGPA);

        welcomeUser = (TextView)findViewById(R.id.textWelcome);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        CGPA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,CGPA.class);
                startActivity(intent);
            }
        });

        Attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (subject){
                    case 8 :
                        Intent intent = new Intent(MenuActivity.this,AttendanceStud8.class);
                        startActivity(intent);break;
                    case 9 :
                        Intent intent1 = new Intent(MenuActivity.this,AttendanceStud9.class);
                        startActivity(intent1);break;
                    case 3:
                        Intent intent4 = new Intent(MenuActivity.this,AttendanceStud3.class);
                        startActivity(intent4);
                    default:
                        Toast.makeText(MenuActivity.this,"Dep = "+dep+"\nSem = "+sem+"\nSubject = "+subject,Toast.LENGTH_LONG).show();
                    }
                }
        });

        AttendanceProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,AttendanceProf.class);
                startActivity(intent);
            }
        });

        Assignment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,Assignment.class);
                startActivity(intent);
            }
        });

        Material.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,DownloadMaterial.class);
                startActivity(intent);
            }
        });

        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this,CalendarEvent.class);
                startActivity(intent);
            }
        });

        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, Events.class);
                startActivity(intent);
            }
        });

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this,"Please wait for the Page to load",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this,News.class);
                startActivity(intent);
            }
        });

    }

    private void getvalue(String firstName,String dep, String sem) {
        this.firstName = firstName;
        this.dep = dep;
        this.sem = sem;
        if(sem.equals("1st Semester")){
            subject=8;
        }
        if(sem.equals("2nd Semester")){
            subject=8;
        }
        if(sem.equals("3rd Semester")){
            subject=9;
        }
        if(sem.equals("4th Semester")){
            subject=9;
        }
        if(sem.equals("5th Semester")){
            subject=9;
        }
        if(sem.equals("6th Semester")){
            subject=9;
        }
        if(sem.equals("7th Semester")){
            subject=8;
        }
        if(sem.equals("8th Semester")){
            subject=3;
        }
        //Toast.makeText(MenuActivity.this,"Name "+firstName + "Dep "+ dep +"Sem " + sem,Toast.LENGTH_LONG).show();
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder ab = new AlertDialog.Builder(MenuActivity.this);
        ab.setTitle("Exit?");
        ab.setMessage("Are you sure to exit?");
        ab.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                //if you want to kill app . from other then your main avtivity.(Launcher)
                finishAffinity();
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        ab.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ab.show();
    }

}