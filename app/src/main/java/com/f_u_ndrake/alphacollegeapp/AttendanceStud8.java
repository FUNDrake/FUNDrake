package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AttendanceStud8 extends AppCompatActivity {

    TextView SubCode1,SubName1,Attend1,SubCode2,SubName2,Attend2,SubCode3,SubName3,Attend3,SubCode4,SubName4,Attend4,SubCode5,SubName5,Attend5,SubCode6,SubName6,Attend6,SubCode7,SubName7,Attend7,SubCode8,SubName8,Attend8;
    String attendance1,attendance2,attendance3,attendance4,attendance5,attendance6,attendance7,attendance8;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public String firstName,dep,sem;
    private static final String TAG = "AttendanceStud8";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_stud8);

        SubCode1 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode1);
        SubCode2 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode2);
        SubCode3 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode3);
        SubCode4 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode4);
        SubCode5 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode5);
        SubCode6 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode6);
        SubCode7 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode7);
        SubCode8 = (TextView)findViewById(R.id.tvAttend8StudSubjectCode8);

        SubName1 = (TextView)findViewById(R.id.tvAttend8StudSubjectName1);
        SubName2 = (TextView)findViewById(R.id.tvAttend8StudSubjectName2);
        SubName3 = (TextView)findViewById(R.id.tvAttend8StudSubjectName3);
        SubName4 = (TextView)findViewById(R.id.tvAttend8StudSubjectName4);
        SubName5 = (TextView)findViewById(R.id.tvAttend8StudSubjectName5);
        SubName6 = (TextView)findViewById(R.id.tvAttend8StudSubjectName6);
        SubName7 = (TextView)findViewById(R.id.tvAttend8StudSubjectName7);
        SubName8 = (TextView)findViewById(R.id.tvAttend8StudSubjectName8);

        Attend1 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend1);
        Attend2 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend2);
        Attend3 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend3);
        Attend4 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend4);
        Attend5 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend5);
        Attend6 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend6);
        Attend7 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend7);
        Attend8 = (TextView)findViewById(R.id.tvAttend8StudSubjectAttend8);

        db.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful() && task.getResult() != null){
                firstName = task.getResult().get("FullName").toString();
                dep = task.getResult().get("Department").toString();
                sem = task.getResult().get("Semester").toString();
                attendance1 = task.getResult().get("Subject 1 Attendance").toString();
                attendance2 = task.getResult().get("Subject 2 Attendance").toString();
                attendance3 = task.getResult().get("Subject 3 Attendance").toString();
                attendance4 = task.getResult().get("Subject 4 Attendance").toString();
                attendance5 = task.getResult().get("Subject 5 Attendance").toString();
                attendance6 = task.getResult().get("Subject 6 Attendance").toString();
                attendance7 = task.getResult().get("Subject 7 Attendance").toString();
                attendance8 = task.getResult().get("Subject 8 Attendance").toString();
                getvalue(firstName,dep,sem);
                //other stuff

            }//deal with error

        });

    }

    @SuppressLint("SetTextI18n")
    private void getvalue(String firstName, String dep, String sem) {
        this.firstName = firstName;
        this.dep = dep;
        this.sem = sem;

        Attend1.setText(attendance1);
        Attend2.setText(attendance2);
        Attend3.setText(attendance3);
        Attend4.setText(attendance4);
        Attend5.setText(attendance5);
        Attend6.setText(attendance6);
        Attend7.setText(attendance7);
        Attend8.setText(attendance8);

        if(dep.equals("CSE")){
            if(sem.equals("1st Semester")){
                SubCode1.setText("HS8151");
                SubName1.setText("Communicative English");
                SubCode2.setText("MA8151");
                SubName2.setText("Engineering Mathematics - I");
                SubCode3.setText("PH8151");
                SubName3.setText("Engineering Physics");
                SubCode4.setText("CY8151");
                SubName4.setText("Engineering Chemistry");
                SubCode5.setText("GE8151");
                SubName5.setText("Problem Solving and Python Programming");
                SubCode6.setText("GE8152");
                SubName6.setText("Engineering Graphics");
                SubCode7.setText("GE8161");
                SubName7.setText("Problem Solving and Python Programming Laboratory");
                SubCode8.setText("BS8161");
                SubName8.setText("Physics and Chemistry Laboratory");
            }
            if(sem.equals("2nd Semester")){
                SubCode1.setText("HS8251");
                SubName1.setText("Technical English");
                SubCode2.setText("MA8251");
                SubName2.setText("Engineering Mathematics - II");
                SubCode3.setText("PH8252");
                SubName3.setText("Physics for Information Science");
                SubCode4.setText("BE8255");
                SubName4.setText("Basic Electrical, Electronics and Measurement Engineering");
                SubCode5.setText("CS8251");
                SubName5.setText("Programming in C");
                SubCode6.setText("GE8152");
                SubName6.setText("Engineering Graphics");
                SubCode7.setText("GE8261");
                SubName7.setText("Engineering Practices Laboratory");
                SubCode8.setText("CS8261");
                SubName8.setText("C Programming Laboratory");
            }
            if(sem.equals("7th Semester")){
                SubCode1.setText("MG8591");
                SubName1.setText("Principles of Management");
                SubCode2.setText("CS8792");
                SubName2.setText("Cryptography and Network Security");
                SubCode3.setText("CS8791");
                SubName3.setText("Cloud Computing");
                SubCode4.setText(" - ");
                SubName4.setText("Open Elective II");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective II");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective III");
                SubCode7.setText("CS8711");
                SubName7.setText("Cloud Computing Laboratory");
                SubCode8.setText("IT8761");
                SubName8.setText("Security Laboratory");
            }
        }if(dep.equals("BME")){
            if(sem.equals("1st Semester")){
                SubCode1.setText("HS8151");
                SubName1.setText("Communicative English");
                SubCode2.setText("MA8151");
                SubName2.setText("Engineering Mathematics - I");
                SubCode3.setText("PH8151");
                SubName3.setText("Engineering Physics");
                SubCode4.setText("CY8151");
                SubName4.setText("Engineering Chemistry");
                SubCode5.setText("GE8151");
                SubName5.setText("Problem Solving and Python Programming");
                SubCode6.setText("GE8152");
                SubName6.setText("Engineering Graphics");
                SubCode7.setText("GE8161");
                SubName7.setText("Problem Solving and Python Programming Laboratory");
                SubCode8.setText("BS8161");
                SubName8.setText("Physics and Chemistry Laboratory");
            }
            if(sem.equals("2nd Semester")){
                SubCode1.setText("HS8251");
                SubName1.setText("Technical English");
                SubCode2.setText("MA8251");
                SubName2.setText("Engineering Mathematics - II");
                SubCode3.setText("PH8253");
                SubName3.setText("Physics for Electronics Engineering");
                SubCode4.setText("BM8251");
                SubName4.setText("Engineering Mechanics for Biomedical Engineers");
                SubCode5.setText("BM8201");
                SubName5.setText("Fundamentals of Bio Chemistry");
                SubCode6.setText("EC8251");
                SubName6.setText("Circuit Analysis");
                SubCode7.setText("GE8261");
                SubName7.setText("Engineering Practices Laboratory");
                SubCode8.setText("BM8211");
                SubName8.setText("Bio Chemistry Laboratory");
            }
            if(sem.equals("4th Semester")){
                SubCode1.setText("MA8391");
                SubName1.setText("Probability and Statistics");
                SubCode2.setText("BM8401");
                SubName2.setText("Medical Physics");
                SubCode3.setText("EE8452");
                SubName3.setText("Basics of Electrical Engineering");
                SubCode4.setText("EC8453");
                SubName4.setText("Linear Integrated Circuits");
                SubCode5.setText("EC8393");
                SubName5.setText("Fundamentals of Data Structures In C");
                SubCode6.setText("EC8392");
                SubName6.setText("Digital Electronics");
                SubCode7.setText("EC8381");
                SubName7.setText("Fundamentals of Data Structures In C Laboratory");
                SubCode8.setText("BM8411");
                SubName8.setText("Integrated Circuits Laboratory");
            }
            if(sem.equals("7th Semester")){
                SubCode1.setText("BM8701");
                SubName1.setText("Diagnostic and Therapeutic Equipment - II");
                SubCode2.setText("EC8093");
                SubName2.setText("Digital Image Processing");
                SubCode3.setText("BM8702");
                SubName3.setText("Radiological Equipments");
                SubCode4.setText("BM8703");
                SubName4.setText("Rehabilitation Engineering");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective III");
                SubCode6.setText(" - ");
                SubName6.setText("Open Elective - II");
                SubCode7.setText("EC8762");
                SubName7.setText("Digital Image Processing Laboratory");
                SubCode8.setText("MD8751");
                SubName8.setText("Hospital Training");
            }
        }if(dep.equals("ECE")){
            if(sem.equals("1st Semester")){
                SubCode1.setText("HS8151");
                SubName1.setText("Communicative English");
                SubCode2.setText("MA8151");
                SubName2.setText("Engineering Mathematics - I");
                SubCode3.setText("PH8151");
                SubName3.setText("Engineering Physics");
                SubCode4.setText("CY8151");
                SubName4.setText("Engineering Chemistry");
                SubCode5.setText("GE8151");
                SubName5.setText("Problem Solving and Python Programming");
                SubCode6.setText("GE8152");
                SubName6.setText("Engineering Graphics");
                SubCode7.setText("GE8161");
                SubName7.setText("Problem Solving and Python Programming Laboratory");
                SubCode8.setText("BS8161");
                SubName8.setText("Physics and Chemistry Laboratory");
            }
            if(sem.equals("2nd Semester")){
                SubCode1.setText("HS8251");
                SubName1.setText("Technical English");
                SubCode2.setText("MA8251");
                SubName2.setText("Engineering Mathematics - II");
                SubCode3.setText("PH8253");
                SubName3.setText("Physics for Electronics Engineering");
                SubCode4.setText("BE8254");
                SubName4.setText("Basic Electrical and Instrumentation Engineering");
                SubCode5.setText("EC8251");
                SubName5.setText("Circuit Analysis");
                SubCode6.setText("EC8252");
                SubName6.setText("Electronic Devices");
                SubCode7.setText("EC8261");
                SubName7.setText("Circuits and Devices Laboratory");
                SubCode8.setText("GE8261");
                SubName8.setText("Engineering Practices Laboratory");
            }
            if(sem.equals("4th Semester")){
                SubCode1.setText("MA8451");
                SubName1.setText("Probability and Random Processes");
                SubCode2.setText("EC8452");
                SubName2.setText("Electronic Circuits II");
                SubCode3.setText("EC8491");
                SubName3.setText("Communication Theory");
                SubCode4.setText("EC8451");
                SubName4.setText("Electromagnetic Fields");
                SubCode5.setText("EC8453");
                SubName5.setText("Linear Integrated Circuits");
                SubCode6.setText("GE8291");
                SubName6.setText("Environmental Science and Engineering");
                SubCode7.setText("EC8461");
                SubName7.setText("Circuits Design and Simulation Laboratory");
                SubCode8.setText("EC8462");
                SubName8.setText("Linear Integrated Circuits Laboratory");
            }
            if(sem.equals("7th Semester")){
                SubCode1.setText("EC8701");
                SubName1.setText("Antennas and Microwave Engineering");
                SubCode2.setText("EC8751");
                SubName2.setText("Optical Communication");
                SubCode3.setText("EC8791");
                SubName3.setText("Embedded and Real Time Systems");
                SubCode4.setText("EC8702");
                SubName4.setText("Ad hoc and Wireless Sensor Networks");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective - III");
                SubCode6.setText(" - ");
                SubName6.setText("Open Elective - II");
                SubCode7.setText("EC8711");
                SubName7.setText("Embedded Laboratory");
                SubCode8.setText("EC8761");
                SubName8.setText("Advanced Communication Laboratory");
            }
        }if(dep.equals("MECH")){
            if(sem.equals("1st Semester")){
                SubCode1.setText("HS8151");
                SubName1.setText("Communicative English");
                SubCode2.setText("MA8151");
                SubName2.setText("Engineering Mathematics - I");
                SubCode3.setText("PH8151");
                SubName3.setText("Engineering Physics");
                SubCode4.setText("CY8151");
                SubName4.setText("Engineering Chemistry");
                SubCode5.setText("GE8151");
                SubName5.setText("Problem Solving and Python Programming");
                SubCode6.setText("GE8152");
                SubName6.setText("Engineering Graphics");
                SubCode7.setText("GE8161");
                SubName7.setText("Problem Solving and Python Programming Laboratory");
                SubCode8.setText("BS8161");
                SubName8.setText("Physics and Chemistry Laboratory");
            }
            if(sem.equals("2nd Semester")){
                SubCode1.setText("HS8251");
                SubName1.setText("Technical English");
                SubCode2.setText("MA8251");
                SubName2.setText("Engineering Mathematics - II");
                SubCode3.setText("PH8251");
                SubName3.setText("Materials Science");
                SubCode4.setText("BE8253");
                SubName4.setText("Basic Electrical, Electronics and Instrumentation Engineering");
                SubCode5.setText("GE8291");
                SubName5.setText("Environmental Science and Engineering");
                SubCode6.setText("GE8292");
                SubName6.setText("Engineering Mechanics");
                SubCode7.setText("GE8261");
                SubName7.setText("Engineering Practices Laboratory");
                SubCode8.setText("BE8261");
                SubName8.setText("Basic Electrical, Electronics and Instrumentation Engineering Laboratory");
            }
            if(sem.equals("5th Semester")){
                SubCode1.setText("ME8595");
                SubName1.setText("Thermal Engineering- II");
                SubCode2.setText("ME8593");
                SubName2.setText("Design of Machine Elements");
                SubCode3.setText("ME8501");
                SubName3.setText("Metrology and Measurements");
                SubCode4.setText("ME8594");
                SubName4.setText("Dynamics of Machines");
                SubCode5.setText(" - ");
                SubName5.setText("Open Elective I");
                SubCode6.setText("ME8511");
                SubName6.setText("Kinematics and Dynamics Laboratory");
                SubCode7.setText("ME8512");
                SubName7.setText("Thermal Engineering Laboratory");
                SubCode8.setText("ME8513");
                SubName8.setText("Metrology and Measurements Laboratory");
            }
        }
        if(dep.equals("IT")){
            if(sem.equals("1st Semester")){
                SubCode1.setText("HS8151");
                SubName1.setText("Communicative English");
                SubCode2.setText("MA8151");
                SubName2.setText("Engineering Mathematics - I");
                SubCode3.setText("PH8151");
                SubName3.setText("Engineering Physics");
                SubCode4.setText("CY8151");
                SubName4.setText("Engineering Chemistry");
                SubCode5.setText("GE8151");
                SubName5.setText("Problem Solving and Python Programming");
                SubCode6.setText("GE8152");
                SubName6.setText("Engineering Graphics");
                SubCode7.setText("GE8161");
                SubName7.setText("Problem Solving and Python Programming Laboratory");
                SubCode8.setText("BS8161");
                SubName8.setText("Physics and Chemistry Laboratory");
            }
            if(sem.equals("7th Semester")){
                SubCode1.setText("MG8591");
                SubName1.setText("Principles of Management");
                SubCode2.setText("CS8792");
                SubName2.setText("Cryptography and Network Security");
                SubCode3.setText("CS8791");
                SubName3.setText("Cloud Computing");
                SubCode4.setText(" - ");
                SubName4.setText("Open Elective II");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective II");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective III");
                SubCode7.setText("IT8711");
                SubName7.setText("FOSS and Cloud Computing Laboratory");
                SubCode8.setText("IT8761");
                SubName8.setText("Security Laboratory");
            }
        }
        //Toast.makeText(MenuActivity.this,"Name "+firstName + "Dep "+ dep +"Sem " + sem,Toast.LENGTH_LONG).show();
    }
}

