package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class MenuActivity extends AppCompatActivity {

    CardView Material, Attedance,News,Calendar;
    TextView welcomeUser;
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
                String email = task.getResult().getString("Email");
                String phone = task.getResult().getString("Phone");
                //other stuff
                welcomeUser.setText(" Welcome back \n" + firstName );

            }//deal with error

        });


        Material = (CardView)findViewById(R.id.cardviewMaterial);
        Attedance = (CardView)findViewById(R.id.cardviewAttendance);
        News =  (CardView)findViewById(R.id.cardviewNews);
        Calendar =  (CardView)findViewById(R.id.cardviewCalendar);

        welcomeUser = (TextView)findViewById(R.id.textWelcome);


        Attedance.setOnClickListener(new View.OnClickListener() {
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

        News.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this,"Please wait for the Page to load",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MenuActivity.this,News.class);
                startActivity(intent);
            }
        });

        /*Database show data
        db.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful() && task.getResult() != null){
                String firstName = task.getResult().getString("FullName");
                String email = task.getResult().getString("Email");
                String phone = task.getResult().getString("Phone");
                //other stuff
                Toast.makeText(MenuActivity.this,"FN " + firstName + "EM" + email + "phone " + phone , Toast.LENGTH_SHORT).show();
            }else{
                //deal with error
            }
        });*/
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

                //if you want to finish just current activity

//                MenuActivity.this.finish();
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