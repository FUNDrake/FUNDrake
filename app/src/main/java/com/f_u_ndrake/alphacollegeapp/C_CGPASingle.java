package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class C_CGPASingle extends AppCompatActivity {

    TextView department,year,sem;
    TextView sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8,sub9;
    TextView cred1,cred2,cred3,cred4,cred5,cred6,cred7,cred8,cred9;
    String subjectname1,subjectname2,subjectname3,subjectname4,subjectname5,subjectname6,subjectname7,subjectname8,subjectname9;
    int subjectgrade1,subjectgrade2,subjectgrade3,subjectgrade4,subjectgrade5,subjectgrade6,subjectgrade7,subjectgrade8,subjectgrade9;
    int grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9;
    Spinner spin1,spin2,spin3,spin4,spin5,spin6,spin7,spin8,spin9;
    Button get;
    int subjectnumber = 0;
    int totalcredit,sub1grade,sub2grade,sub3grade,sub4grade,sub5grade,sub6grade,sub7grade,sub8grade,sub9grade,totalgrade;
    float gpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c__c_g_p_a_single);

        String depart = getIntent().getStringExtra("shareddepartment");
        String Syear = getIntent().getStringExtra("sharedyear");
        String Ssem = getIntent().getStringExtra("sharedsem");

        department = findViewById(R.id.tvCGPADep);
        year = findViewById(R.id.tvCGPAYear);
        sem = findViewById(R.id.tvCGPASem);
        get = findViewById(R.id.buttonGet);

        sub1 = findViewById(R.id.tvGPASub1);
        sub2 = findViewById(R.id.tvGPASub2);
        sub3 = findViewById(R.id.tvGPASub3);
        sub4 = findViewById(R.id.tvGPASub4);
        sub5 = findViewById(R.id.tvGPASub5);
        sub6 = findViewById(R.id.tvGPASub6);
        sub7 = findViewById(R.id.tvGPASub7);
        sub8 = findViewById(R.id.tvGPASub8);
        sub9 = findViewById(R.id.tvGPASub9);

        cred1 = findViewById(R.id.tvGPACred1);
        cred2 = findViewById(R.id.tvGPACred2);
        cred3 = findViewById(R.id.tvGPACred3);
        cred4 = findViewById(R.id.tvGPACred4);
        cred5 = findViewById(R.id.tvGPACred5);
        cred6 = findViewById(R.id.tvGPACred6);
        cred7 = findViewById(R.id.tvGPACred7);
        cred8 = findViewById(R.id.tvGPACred8);
        cred9 = findViewById(R.id.tvGPACred9);

        spin1 = findViewById(R.id.spinGPA1);
        spin2 = findViewById(R.id.spinGPA2);
        spin3 = findViewById(R.id.spinGPA3);
        spin4 = findViewById(R.id.spinGPA4);
        spin5 = findViewById(R.id.spinGPA5);
        spin6 = findViewById(R.id.spinGPA6);
        spin7 = findViewById(R.id.spinGPA7);
        spin8 = findViewById(R.id.spinGPA8);
        spin9 = findViewById(R.id.spinGPA9);

        department.setText(depart);
        year.setText(Syear);
        sem.setText(Ssem);

        AlertDialog.Builder builder1 = new AlertDialog.Builder(C_CGPASingle.this);
        builder1.setMessage("Something has gone wrong, please try again!");
        builder1.setCancelable(true);
        builder1.setPositiveButton(
                "Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        onBackPressed();
                    }
                });
        AlertDialog failurealert = builder1.create();

        // CSE = 8 + 8 + 9 + 9 + 8 + 9 + 9 + 3 = 63
        ArrayList<SubjectGrade> CSEY1S1 = new ArrayList<>();
        // CSE Semester 1 ArrayList Total Grade = 25
        CSEY1S1.add(new SubjectGrade("HS8151 Communicative English",4));
        CSEY1S1.add(new SubjectGrade("MA8151 Engineering Mathematics - I",4));
        CSEY1S1.add(new SubjectGrade("PH8151 Engineering Physics",3));
        CSEY1S1.add(new SubjectGrade("CY8151 Engineering Chemistry",3));
        CSEY1S1.add(new SubjectGrade("GE8151 Problem Solving and Python Programming",3));
        CSEY1S1.add(new SubjectGrade("GE8152 Engineering Graphics",4));
        CSEY1S1.add(new SubjectGrade("GE8161 Problem Solving and Python Programming Laboratory",2));
        CSEY1S1.add(new SubjectGrade("BS8161 Physics and Chemistry Laboratory",2));
        ArrayList<SubjectGrade> CSEY1S2 = new ArrayList<>();
        // CSE Semester 2 ArrayList Total Grade 24
        CSEY1S2.add(new SubjectGrade("HS8251 Technical English",4));
        CSEY1S2.add(new SubjectGrade("MA8251 Engineering Mathematics - II",4));
        CSEY1S2.add(new SubjectGrade("PH8252 Physics for Information Science",3));
        CSEY1S2.add(new SubjectGrade("BE8255 Basic Electrical, Electronics and Measurement Engineering",3));
        CSEY1S2.add(new SubjectGrade("GE8291 Environmental Science and Engineering",3));
        CSEY1S2.add(new SubjectGrade("CS8251 Programming in C",3));
        CSEY1S2.add(new SubjectGrade("GE8261 Engineering Practices Laboratory",2));
        CSEY1S2.add(new SubjectGrade("CS8261 C Programming Laboratory",2));
        ArrayList<SubjectGrade> arrayList = new ArrayList<>();
        ArrayList<SubjectGrade> CSEY2S3 = new ArrayList<>();
        // CSE Semester 3 ArrayList Total Grade 24
        CSEY2S3.add(new SubjectGrade("MA8351 Discrete Mathematics",4));
        CSEY2S3.add(new SubjectGrade("CS8351 Digital Principles and System Design",4));
        CSEY2S3.add(new SubjectGrade("CS8391 Data Structures",3));
        CSEY2S3.add(new SubjectGrade("CS8392 Object Oriented Programming",3));
        CSEY2S3.add(new SubjectGrade("EC8395 Communication Engineering",3));
        CSEY2S3.add(new SubjectGrade("CS8381 Data Structures Laboratory",2));
        CSEY2S3.add(new SubjectGrade("CS8383 Object Oriented Programming Laboratory",2));
        CSEY2S3.add(new SubjectGrade("CS8382 Digital Systems Laboratory",2));
        CSEY2S3.add(new SubjectGrade("HS8381 Interpersonal Skills/Listening & Speaking",1));
        ArrayList<SubjectGrade> CSEY2S4 = new ArrayList<>();
        // CSE Semester 4 ArrayList Total Grade 24
        CSEY2S4.add(new SubjectGrade("MA8402 Probability and Queueing Theory",4));
        CSEY2S4.add(new SubjectGrade("CS8491 Computer Architecture",3));
        CSEY2S4.add(new SubjectGrade("CS8492 Database Management Systems",3));
        CSEY2S4.add(new SubjectGrade("CS8451 Design and Analysis of Algorithms",3));
        CSEY2S4.add(new SubjectGrade("CS8493 Operating Systems",3));
        CSEY2S4.add(new SubjectGrade("CS8494 Software Engineering",3));
        CSEY2S4.add(new SubjectGrade("CS8481 Database Management Systems Laboratory",2));
        CSEY2S4.add(new SubjectGrade("CS8461 Operating Systems Laboratory",2));
        CSEY2S4.add(new SubjectGrade("HS8461 Advanced Reading and Writing",1));
        ArrayList<SubjectGrade> CSEY3S5 = new ArrayList<>();
        // CSE Semester 5 ArrayList Total Grade 25
        CSEY3S5.add(new SubjectGrade("MA8551 Algebra and Number Theory",4));
        CSEY3S5.add(new SubjectGrade("CS8591 Computer Networks",  3));
        CSEY3S5.add(new SubjectGrade("EC8691 Microprocessors and Microcontrollers",3));
        CSEY3S5.add(new SubjectGrade("CS8501 Theory of Computation",3));
        CSEY3S5.add(new SubjectGrade("CS8592 Object Oriented Analysis and Design",3));
        CSEY3S5.add(new SubjectGrade("Open Elective I",3));
        CSEY3S5.add(new SubjectGrade("EC8681 Microprocessors and Microcontrollers Laboratory",2));
        CSEY3S5.add(new SubjectGrade("CS8582 Object Oriented Analysis and Design Laboratory",2));
        CSEY3S5.add(new SubjectGrade("CS8581 Networks Laboratory",2));
        ArrayList<SubjectGrade> CSEY3S6 = new ArrayList<>();
        // CSE Semester 6 ArrayList Total Grade 24
        CSEY3S6.add(new SubjectGrade("CS8651 Internet Programming",3));
        CSEY3S6.add(new SubjectGrade("CS8691 Artificial Intelligence",  3));
        CSEY3S6.add(new SubjectGrade("CS8601 Mobile Computing",3));
        CSEY3S6.add(new SubjectGrade("CS8602 Compiler Design",4));
        CSEY3S6.add(new SubjectGrade("CS8603 Distributed Systems",3));
        CSEY3S6.add(new SubjectGrade("Professional Elective I",3));
        CSEY3S6.add(new SubjectGrade("CS8661 Internet Programming Laboratory",2));
        CSEY3S6.add(new SubjectGrade("CS8662 Mobile Application Development Laboratory",2));
        CSEY3S6.add(new SubjectGrade("CS8611 Mini Project",1));
        ArrayList<SubjectGrade> CSEY4S7 = new ArrayList<>();
        // CSE Semester 7 ArrayList Total Grade 22
        CSEY4S7.add(new SubjectGrade("MG8591 Principles of Management",3));
        CSEY4S7.add(new SubjectGrade("CS8792 Cryptography and Network Security",  3));
        CSEY4S7.add(new SubjectGrade("CS8791 Cloud Computing",3));
        CSEY4S7.add(new SubjectGrade("Open Elective II",3));
        CSEY4S7.add(new SubjectGrade("Professional Elective II",3));
        CSEY4S7.add(new SubjectGrade("Professional Elective III",3));
        CSEY4S7.add(new SubjectGrade("CS8711 Cloud Computing Laboratory",2));
        CSEY4S7.add(new SubjectGrade("IT8761 Security Laboratory",2));
        ArrayList<SubjectGrade> CSEY4S8 = new ArrayList<>();
        // CSE Semester 8 ArrayList Total Grade 16
        CSEY4S8.add(new SubjectGrade("Professional Elective IV",3));
        CSEY4S8.add(new SubjectGrade("Professional Elective V",  3));
        CSEY4S8.add(new SubjectGrade("CS8811 Project Work",10));

        ArrayList<SubjectGrade> BMEY1S1 = new ArrayList<>();
        // BME Semester 1 ArrayList Total Grade = 25
        BMEY1S1.add(new SubjectGrade("HS8151 Communicative English",4));
        BMEY1S1.add(new SubjectGrade("MA8151 Engineering Mathematics - I",4));
        BMEY1S1.add(new SubjectGrade("PH8151 Engineering Physics",3));
        BMEY1S1.add(new SubjectGrade("CY8151 Engineering Chemistry",3));
        BMEY1S1.add(new SubjectGrade("GE8151 Problem Solving and Python Programming",3));
        BMEY1S1.add(new SubjectGrade("GE8152 Engineering Graphics",4));
        BMEY1S1.add(new SubjectGrade("GE8161 Problem Solving and Python Programming Laboratory",2));
        BMEY1S1.add(new SubjectGrade("BS8161 Physics and Chemistry Laboratory",2));
        ArrayList<SubjectGrade> BMEY1S2 = new ArrayList<>();
        // BME Semester 2 ArrayList Total Grade = 25
        BMEY1S2.add(new SubjectGrade("HS8251 Technical English",4));
        BMEY1S2.add(new SubjectGrade("MA8251 Engineering Mathematics - II",4));
        BMEY1S2.add(new SubjectGrade("PH8253 Physics for Electronics Engineering",3));
        BMEY1S2.add(new SubjectGrade("BM8251 Engineering Mechanics for Biomedical Engineers",3));
        BMEY1S2.add(new SubjectGrade("BM8201 Fundamentals of Bio Chemistry",3));
        BMEY1S2.add(new SubjectGrade("EC8251 Circuit Analysis",4));
        BMEY1S2.add(new SubjectGrade("GE8261 Engineering Practices Laboratory",2));
        BMEY1S2.add(new SubjectGrade("BM8211 Bio Chemistry Laboratory",2));
        ArrayList<SubjectGrade> BMEY2S3 = new ArrayList<>();
        // BME Semester 3 ArrayList Total Grade = 25
        BMEY2S3.add(new SubjectGrade("MA8352 Linear Algebra and Partial Differential Equations",4));
        BMEY2S3.add(new SubjectGrade("EC8352 Signals and Systems",4));
        BMEY2S3.add(new SubjectGrade("BM8351 Anatomy and Human Physiology",3));
        BMEY2S3.add(new SubjectGrade("BM8301 Sensors and Measurements",3));
        BMEY2S3.add(new SubjectGrade("EC8353 Electron Devices and Circuits",3));
        BMEY2S3.add(new SubjectGrade("BM8302 Pathology and Microbiology",3));
        BMEY2S3.add(new SubjectGrade("BM8311 Pathology and Microbiology Laboratory",2));
        BMEY2S3.add(new SubjectGrade("BM8312 Devices and Circuits Laboratory",2));
        BMEY2S3.add(new SubjectGrade("BM8313 Human Physiology Laboratory",1));
        ArrayList<SubjectGrade> BMEY2S4 = new ArrayList<>();
        // BME Semester 4 ArrayList Total Grade = 23
        BMEY2S4.add(new SubjectGrade("MA8391 Probability and Statistics",4));
        BMEY2S4.add(new SubjectGrade("BM8401 Medical Physics",3));
        BMEY2S4.add(new SubjectGrade("EE8452 Basics of Electrical Engineering",3));
        BMEY2S4.add(new SubjectGrade("EC8453 Linear Integrated Circuits",3));
        BMEY2S4.add(new SubjectGrade("EC8393 Fundamentals of Data Structures In C",3));
        BMEY2S4.add(new SubjectGrade("EC8392 Digital Electronics",3));
        BMEY2S4.add(new SubjectGrade("EC8381 Fundamentals of Data Structures In C Laboratory",2));
        BMEY2S4.add(new SubjectGrade("BM8411 Integrated Circuits Laboratory",2));
        ArrayList<SubjectGrade> BMEY3S5 = new ArrayList<>();
        // BME Semester 5 ArrayList Total Grade = 25
        BMEY3S5.add(new SubjectGrade("EC8394 Analog and Digital Communication",3));
        BMEY3S5.add(new SubjectGrade("BM8501 Biocontrol Systems",4));
        BMEY3S5.add(new SubjectGrade("BM8502 Biomedical Instrumentation",3));
        BMEY3S5.add(new SubjectGrade("EC8553 Discrete-Time Signal Processing",4));
        BMEY3S5.add(new SubjectGrade("Professional Elective - I",3));
        BMEY3S5.add(new SubjectGrade("Open Elective -I",3));
        BMEY3S5.add(new SubjectGrade("EC8562 Digital Signal Processing Laboratory",2));
        BMEY3S5.add(new SubjectGrade("BM8511 Biomedical Instrumentation Laboratory",2));
        BMEY3S5.add(new SubjectGrade("HS8381 Interpersonal Skills/Listening & Speaking",1));
        ArrayList<SubjectGrade> BMEY3S6 = new ArrayList<>();
        // BME Semester 6 ArrayList Total Grade = 23
        BMEY3S6.add(new SubjectGrade("EC8691 Microprocessors and Microcontrollers",3));
        BMEY3S6.add(new SubjectGrade("BM8601 Diagnostic and Therapeutic Equipment - I",3));
        BMEY3S6.add(new SubjectGrade("BM8651 Biomechanics",3));
        BMEY3S6.add(new SubjectGrade("GE8291 Environmental Science and Engineering",3));
        BMEY3S6.add(new SubjectGrade("MD8091 Hospital Management",3));
        BMEY3S6.add(new SubjectGrade("Professional Elective - II",3));
        BMEY3S6.add(new SubjectGrade("EC8681 Microprocessors and Microcontrollers Laboratory",2));
        BMEY3S6.add(new SubjectGrade("BM8611 Diagnostic and Therapeutic Equipment Laboratory",2));
        BMEY3S6.add(new SubjectGrade("BM8612 Mini Project",1));
        ArrayList<SubjectGrade> BMEY4S7 = new ArrayList<>();
        // BME Semester 7 ArrayList Total Grade = 22
        BMEY4S7.add(new SubjectGrade("BM8701 Diagnostic and Therapeutic Equipment - II",3));
        BMEY4S7.add(new SubjectGrade("EC8093 Digital Image Processing",3));
        BMEY4S7.add(new SubjectGrade("BM8702 Radiological Equipments",3));
        BMEY4S7.add(new SubjectGrade("BM8703 Rehabilitation Engineering",3));
        BMEY4S7.add(new SubjectGrade("Professional Elective III",3));
        BMEY4S7.add(new SubjectGrade("Open Elective -II",3));
        BMEY4S7.add(new SubjectGrade("EC8762 Digital Image Processing Laboratory",2));
        BMEY4S7.add(new SubjectGrade("MD8751 Hospital Training",2));
        ArrayList<SubjectGrade> BMEY4S8 = new ArrayList<>();
        // BME Semester 8 ArrayList Total Grade = 16
        BMEY4S8.add(new SubjectGrade("Professional Elective IV",3));
        BMEY4S8.add(new SubjectGrade("Professional Elective V",3));
        BMEY4S8.add(new SubjectGrade("BM8811 Project Work",10));

        ArrayList<SubjectGrade> ECEY1S1 = new ArrayList<>();
        // ECE Semester 1 ArrayList Total Grade = 25
        ECEY1S1.add(new SubjectGrade("HS8151 Communicative English",4));
        ECEY1S1.add(new SubjectGrade("MA8151 Engineering Mathematics - I",4));
        ECEY1S1.add(new SubjectGrade("PH8151 Engineering Physics",3));
        ECEY1S1.add(new SubjectGrade("CY8151 Engineering Chemistry",3));
        ECEY1S1.add(new SubjectGrade("GE8151 Problem Solving and Python Programming",3));
        ECEY1S1.add(new SubjectGrade("GE8152 Engineering Graphics",4));
        ECEY1S1.add(new SubjectGrade("GE8161 Problem Solving and Python Programming Laboratory",2));
        ECEY1S1.add(new SubjectGrade("BS8161 Physics and Chemistry Laboratory",2));
        ArrayList<SubjectGrade> ECEY1S2 = new ArrayList<>();
        // ECE Semester 2 ArrayList Total Grade 24
        ECEY1S2.add(new SubjectGrade("HS8251 Technical English",4));
        ECEY1S2.add(new SubjectGrade("MA8251 Engineering Mathematics - II",4));
        ECEY1S2.add(new SubjectGrade("PH8253 Physics for Electronics Engineering",3));
        ECEY1S2.add(new SubjectGrade("BE8255 Basic Electrical, Electronics and Measurement Engineering",3));
        ECEY1S2.add(new SubjectGrade("EC8251 Circuit Analysis",4));
        ECEY1S2.add(new SubjectGrade("EC8252 Electronic Devices",3));
        ECEY1S2.add(new SubjectGrade("EC8261 Circuits and Devices Laboratory",2));
        ECEY1S2.add(new SubjectGrade("GE8261 Engineering Practices Laboratory",2));
        ArrayList<SubjectGrade> ECEY2S3 = new ArrayList<>();
        // ECE Semester 3 ArrayList Total Grade 25
        ECEY2S3.add(new SubjectGrade("MA8352 Linear Algebra and Partial Differential Equations",4));
        ECEY2S3.add(new SubjectGrade("EC8393 Fundamentals of Data Structures In C",3));
        ECEY2S3.add(new SubjectGrade("EC8351 Electronic Circuits- I",3));
        ECEY2S3.add(new SubjectGrade("EC8352 Signals and Systems",4));
        ECEY2S3.add(new SubjectGrade("EC8392 Digital Electronics",3));
        ECEY2S3.add(new SubjectGrade("EC8391 Control Systems Engineering",3));
        ECEY2S3.add(new SubjectGrade("EC8381 Fundamentals of Data Structures in C Laboratory",2));
        ECEY2S3.add(new SubjectGrade("EC8361 Analog and Digital Circuits Laboratory",2));
        ECEY2S3.add(new SubjectGrade("HS8381 Interpersonal Skills/Listening & Speaking",1));
        ArrayList<SubjectGrade> ECEY2S4 = new ArrayList<>();
        // ECE Semester 4 ArrayList Total Grade 24
        ECEY2S4.add(new SubjectGrade("MA8451 Probability and Random Processes",4));
        ECEY2S4.add(new SubjectGrade("EC8452 Electronic Circuits II",3));
        ECEY2S4.add(new SubjectGrade("EC8491 Communication Theory",3));
        ECEY2S4.add(new SubjectGrade("EC8451 Electromagnetic Fields",4));
        ECEY2S4.add(new SubjectGrade("EC8453 Linear Integrated Circuits",3));
        ECEY2S4.add(new SubjectGrade("GE8291 Environmental Science and Engineering",3));
        ECEY2S4.add(new SubjectGrade("EC8461 Circuits Design and Simulation Laboratory",2));
        ECEY2S4.add(new SubjectGrade("EC8462 Linear Integrated Circuits Laboratory",2));
        ArrayList<SubjectGrade> ECEY3S5 = new ArrayList<>();
        // ECE Semester 5 ArrayList Total Grade 25
        ECEY3S5.add(new SubjectGrade("EC8501 Digital Communication",3));
        ECEY3S5.add(new SubjectGrade("EC8553 Discrete-Time Signal Processing",  4));
        ECEY3S5.add(new SubjectGrade("EC8552 Computer Architecture and Organization",3));
        ECEY3S5.add(new SubjectGrade("EC8551 Communication Networks",3));
        ECEY3S5.add(new SubjectGrade("Professional Elective I",3));
        ECEY3S5.add(new SubjectGrade("Open Elective I",3));
        ECEY3S5.add(new SubjectGrade("EC8562 Digital Signal Processing Laboratory",2));
        ECEY3S5.add(new SubjectGrade("EC8561 Communication Systems Laboratory",2));
        ECEY3S5.add(new SubjectGrade("EC8563 Communication Networks Laboratory",2));
        ArrayList<SubjectGrade> ECEY3S6 = new ArrayList<>();
        // ECE Semester 6 ArrayList Total Grade 23
        ECEY3S6.add(new SubjectGrade("EC8691 Microprocessors and Microcontrollers",3));
        ECEY3S6.add(new SubjectGrade("EC8095 VLSI Design",  3));
        ECEY3S6.add(new SubjectGrade("EC8652 Wireless Communication",3));
        ECEY3S6.add(new SubjectGrade("MG8591 Principles of Management",3));
        ECEY3S6.add(new SubjectGrade("EC8651 Transmission Lines and RF Systems",3));
        ECEY3S6.add(new SubjectGrade("Professional Elective -II",3));
        ECEY3S6.add(new SubjectGrade("EC8681 Microprocessors and Microcontrollers Laboratory",2));
        ECEY3S6.add(new SubjectGrade("EC8661 VLSI Design Laboratory",2));
        ECEY3S6.add(new SubjectGrade("EC8611 Technical Seminar",1));
        ArrayList<SubjectGrade> ECEY4S7 = new ArrayList<>();
        // ECE Semester 7 ArrayList Total Grade 22
        ECEY4S7.add(new SubjectGrade("EC8701 Antennas and Microwave Engineering",3));
        ECEY4S7.add(new SubjectGrade("EC8751 Optical Communication",  3));
        ECEY4S7.add(new SubjectGrade("EC8791 Embedded and Real Time Systems",3));
        ECEY4S7.add(new SubjectGrade("EC8702 Ad hoc and Wireless Sensor Networks",3));
        ECEY4S7.add(new SubjectGrade("Professional Elective -III",3));
        ECEY4S7.add(new SubjectGrade("Open Elective - II",3));
        ECEY4S7.add(new SubjectGrade("EC8711 Embedded Laboratory",2));
        ECEY4S7.add(new SubjectGrade("EC8761 Advanced Communication Laboratory",2));
        ArrayList<SubjectGrade> ECEY4S8 = new ArrayList<>();
        // ECE Semester 8 ArrayList Total Grade 16
        ECEY4S8.add(new SubjectGrade("Professional Elective IV",3));
        ECEY4S8.add(new SubjectGrade("Professional Elective V",  3));
        ECEY4S8.add(new SubjectGrade("EC8811 Project Work",10));

        ArrayList<SubjectGrade> ITY1S1 = new ArrayList<>();
        // IT Semester 1 ArrayList Total Grade = 25
        ITY1S1.add(new SubjectGrade("HS8151 Communicative English",4));
        ITY1S1.add(new SubjectGrade("MA8151 Engineering Mathematics - I",4));
        ITY1S1.add(new SubjectGrade("PH8151 Engineering Physics",3));
        ITY1S1.add(new SubjectGrade("CY8151 Engineering Chemistry",3));
        ITY1S1.add(new SubjectGrade("GE8151 Problem Solving and Python Programming",3));
        ITY1S1.add(new SubjectGrade("GE8152 Engineering Graphics",4));
        ITY1S1.add(new SubjectGrade("GE8161 Problem Solving and Python Programming Laboratory",2));
        ITY1S1.add(new SubjectGrade("BS8161 Physics and Chemistry Laboratory",2));
        ArrayList<SubjectGrade> ITY1S2 = new ArrayList<>();
        // IT Semester 2 ArrayList Total Grade 25
        ITY1S2.add(new SubjectGrade("HS8251 Technical English",4));
        ITY1S2.add(new SubjectGrade("MA8251 Engineering Mathematics - II",4));
        ITY1S2.add(new SubjectGrade("PH8253 Physics for Electronics Engineering",3));
        ITY1S2.add(new SubjectGrade("BE8255 Basic Electrical, Electronics and Measurement Engineering",3));
        ITY1S2.add(new SubjectGrade("EC8251 Circuit Analysis",4));
        ITY1S2.add(new SubjectGrade("EC8252 Electronic Devices",3));
        ITY1S2.add(new SubjectGrade("EC8261 Circuits and Devices Laboratory",2));
        ITY1S2.add(new SubjectGrade("GE8261 Engineering Practices Laboratory",2));
        ArrayList<SubjectGrade> ITY2S3 = new ArrayList<>();
        // IT Semester 3 ArrayList Total Grade 24
        ITY2S3.add(new SubjectGrade("MA8351 Discrete Mathematics",4));
        ITY2S3.add(new SubjectGrade("CS8351 Digital Principles and System Design",4));
        ITY2S3.add(new SubjectGrade("CS8391 Data Structures",3));
        ITY2S3.add(new SubjectGrade("CS8392 Object Oriented Programming",3));
        ITY2S3.add(new SubjectGrade("EC8395 Communication Engineering",3));
        ITY2S3.add(new SubjectGrade("CS8381 Data Structures Laboratory",2));
        ITY2S3.add(new SubjectGrade("CS8383 Object Oriented Programming Laboratory",2));
        ITY2S3.add(new SubjectGrade("CS8382 Digital Systems Laboratory",2));
        ITY2S3.add(new SubjectGrade("HS8381 Interpersonal Skills/Listening & Speaking",1));
        ArrayList<SubjectGrade> ITY2S4 = new ArrayList<>();
        // IT Semester 4 ArrayList Total Grade 24
        ITY2S4.add(new SubjectGrade("MA8402 Probability and Queueing Theory",4));
        ITY2S4.add(new SubjectGrade("CS8491 Computer Architecture",3));
        ITY2S4.add(new SubjectGrade("CS8492 Database Management Systems",3));
        ITY2S4.add(new SubjectGrade("CS8451 Design and Analysis of Algorithms",3));
        ITY2S4.add(new SubjectGrade("CS8493 Operating Systems",3));
        ITY2S4.add(new SubjectGrade("CS8494 Software Engineering",3));
        ITY2S4.add(new SubjectGrade("CS8481 Database Management Systems Laboratory",2));
        ITY2S4.add(new SubjectGrade("CS8461 Operating Systems Laboratory",2));
        ITY2S4.add(new SubjectGrade("HS8461 Advanced Reading and Writing",1));
        ArrayList<SubjectGrade> ITY3S5 = new ArrayList<>();
        // IT Semester 5 ArrayList Total Grade 25
        ITY3S5.add(new SubjectGrade("MA8551 Algebra and Number Theory",4));
        ITY3S5.add(new SubjectGrade("CS8591 Computer Networks",  3));
        ITY3S5.add(new SubjectGrade("EC8691 Microprocessors and Microcontrollers",3));
        ITY3S5.add(new SubjectGrade("IT8501 Web Technology",3));
        ITY3S5.add(new SubjectGrade("CS8494 Software Engineering",3));
        ITY3S5.add(new SubjectGrade("Open Elective I",3));
        ITY3S5.add(new SubjectGrade("EC8681 Microprocessors and Microcontrollers Laboratory",2));
        ITY3S5.add(new SubjectGrade("CS8581 Networks Laboratory",2));
        ITY3S5.add(new SubjectGrade("IT8511 Web Technology Laboratory",2));
        ArrayList<SubjectGrade> ITY3S6 = new ArrayList<>();
        // IT Semester 6 ArrayList Total Grade 23
        ITY3S6.add(new SubjectGrade("IT8601 Computational Intelligence",3));
        ITY3S6.add(new SubjectGrade("CS8592 Object Oriented Analysis and Design",  3));
        ITY3S6.add(new SubjectGrade("IT8602 Mobile Communication",3));
        ITY3S6.add(new SubjectGrade("CS8091 Big Data Analytics",4));
        ITY3S6.add(new SubjectGrade("CS8092 Computer Graphics and Multimedia",3));
        ITY3S6.add(new SubjectGrade("Professional Elective I",3));
        ITY3S6.add(new SubjectGrade("CS8662 Mobile Application Development Laboratory",2));
        ITY3S6.add(new SubjectGrade("CS8582 Object Oriented Analysis and Design Laboratory",2));
        ITY3S6.add(new SubjectGrade("IT8611 Mini Project",1));
        ArrayList<SubjectGrade> ITY4S7 = new ArrayList<>();
        // IT Semester 7 ArrayList Total Grade 22
        ITY4S7.add(new SubjectGrade("MG8591 Principles of Management",3));
        ITY4S7.add(new SubjectGrade("CS8792 Cryptography and Network Security",  3));
        ITY4S7.add(new SubjectGrade("CS8791 Cloud Computing",3));
        ITY4S7.add(new SubjectGrade("Open Elective II",3));
        ITY4S7.add(new SubjectGrade("Professional Elective II",3));
        ITY4S7.add(new SubjectGrade("Professional Elective III",3));
        ITY4S7.add(new SubjectGrade("IT8711 FOSS and Cloud Computing Laboratory",2));
        ITY4S7.add(new SubjectGrade("IT8761 Security Laboratory",2));
        ArrayList<SubjectGrade> ITY4S8 = new ArrayList<>();
        // IT Semester 8 ArrayList Total Grade 16
        ITY4S8.add(new SubjectGrade("Professional Elective IV",3));
        ITY4S8.add(new SubjectGrade("Professional Elective V",  3));
        ITY4S8.add(new SubjectGrade("IT8811 Project Work",10));

        ArrayList<SubjectGrade> MECHY1S1 = new ArrayList<>();
        // MECH Semester 1 ArrayList Total Grade = 25
        MECHY1S1.add(new SubjectGrade("HS8151 Communicative English",4));
        MECHY1S1.add(new SubjectGrade("MA8151 Engineering Mathematics - I",4));
        MECHY1S1.add(new SubjectGrade("PH8151 Engineering Physics",3));
        MECHY1S1.add(new SubjectGrade("CY8151 Engineering Chemistry",3));
        MECHY1S1.add(new SubjectGrade("GE8151 Problem Solving and Python Programming",3));
        MECHY1S1.add(new SubjectGrade("GE8152 Engineering Graphics",4));
        MECHY1S1.add(new SubjectGrade("GE8161 Problem Solving and Python Programming Laboratory",2));
        MECHY1S1.add(new SubjectGrade("BS8161 Physics and Chemistry Laboratory",2));
        ArrayList<SubjectGrade> MECHY1S2 = new ArrayList<>();
        // MECH Semester 2 ArrayList Total Grade = 25
        MECHY1S2.add(new SubjectGrade("HS8251 Technical English",4));
        MECHY1S2.add(new SubjectGrade("MA8251 Engineering Mathematics - II",4));
        MECHY1S2.add(new SubjectGrade("PH8251 Materials Science",3));
        MECHY1S2.add(new SubjectGrade("BE8253 Basic Electrical, Electronics and Instrumentation Engineering",3));
        MECHY1S2.add(new SubjectGrade("GE8291 Environmental Science and Engineering",3));
        MECHY1S2.add(new SubjectGrade("GE8292 Engineering Mechanics",4));
        MECHY1S2.add(new SubjectGrade("GE8261 Engineering Practices Laboratory",2));
        MECHY1S2.add(new SubjectGrade("BE8261 Basic Electrical, Electronicsand Instrumentation Engineering Laboratory",2));
        ArrayList<SubjectGrade> MECHY2S3 = new ArrayList<>();
        // MECH Semester 3 ArrayList Total Grade = 25
        MECHY2S3.add(new SubjectGrade("MA8353 Transforms and Partial Differential Equations",4));
        MECHY2S3.add(new SubjectGrade("ME8391 Engineering Thermodynamics",4));
        MECHY2S3.add(new SubjectGrade("CE8394 Fluid Mechanics and Machinery",4));
        MECHY2S3.add(new SubjectGrade("ME8351 Manufacturing Technology - I",3));
        MECHY2S3.add(new SubjectGrade("EE8353 Electrical Drives and Controls",3));
        MECHY2S3.add(new SubjectGrade("ME8361 Manufacturing Technology Laboratory - I",2));
        MECHY2S3.add(new SubjectGrade("ME8381 Computer Aided Machine Drawing",2));
        MECHY2S3.add(new SubjectGrade("EE8361 Electrical Engineering Laboratory",2));
        MECHY2S3.add(new SubjectGrade("HS8381 Interpersonal Skills / Listening & Speaking",1));
        ArrayList<SubjectGrade> MECHY2S4 = new ArrayList<>();
        // MECH Semester 4 ArrayList Total Grade = 24
        MECHY2S4.add(new SubjectGrade("MA8452 Statistics and Numerical Methods",4));
        MECHY2S4.add(new SubjectGrade("ME8492 Kinematics of Machinery",3));
        MECHY2S4.add(new SubjectGrade("ME8451 Manufacturing Technology – II",3));
        MECHY2S4.add(new SubjectGrade("ME8491 Engineering Metallurgy",3));
        MECHY2S4.add(new SubjectGrade("CE8395 Strength of Materials for Mechanical Engineers",3));
        MECHY2S4.add(new SubjectGrade("ME8493 Thermal Engineering- I",3));
        MECHY2S4.add(new SubjectGrade("ME8462 Manufacturing Technology Laboratory – II",2));
        MECHY2S4.add(new SubjectGrade("CE8381 Strength of Materials and Fluid Mechanics and Machinery Laboratory",2));
        MECHY2S4.add(new SubjectGrade("HS8461 Advanced Reading and Writing",1));
        ArrayList<SubjectGrade> MECHY3S5 = new ArrayList<>();
        // MECH Semester 5 ArrayList Total Grade = 22
        MECHY3S5.add(new SubjectGrade("ME8595 Thermal Engineering- II",3));
        MECHY3S5.add(new SubjectGrade("ME8593 Design of Machine Elements",3));
        MECHY3S5.add(new SubjectGrade("ME8501 Metrology and Measurements",3));
        MECHY3S5.add(new SubjectGrade("ME8594 Dynamics of Machines",4));
        MECHY3S5.add(new SubjectGrade("Open Elective I",3));
        MECHY3S5.add(new SubjectGrade("ME8511 Kinematics and Dynamics Laboratory",2));
        MECHY3S5.add(new SubjectGrade("ME8512 Thermal Engineering Laboratory",2));
        MECHY3S5.add(new SubjectGrade("ME8513 Metrology and Measurements Laboratory",2));
        ArrayList<SubjectGrade> MECHY3S6 = new ArrayList<>();
        // MECH Semester 6 ArrayList Total Grade = 24
        MECHY3S6.add(new SubjectGrade("ME8651 Design of Transmission Systems",3));
        MECHY3S6.add(new SubjectGrade("ME8691 Computer Aided Design and Manufacturing",3));
        MECHY3S6.add(new SubjectGrade("ME8693 Heat and Mass Transfer",4));
        MECHY3S6.add(new SubjectGrade("ME8692 Finite Element Analysis",3));
        MECHY3S6.add(new SubjectGrade("ME8694 Hydraulics and Pneumatics",3));
        MECHY3S6.add(new SubjectGrade("Professional Elective - I",3));
        MECHY3S6.add(new SubjectGrade("ME8681 CAD / CAM Laboratory",2));
        MECHY3S6.add(new SubjectGrade("ME8682 Design and Fabrication Project",2));
        MECHY3S6.add(new SubjectGrade("HS8581 Professional Communication",1));
        ArrayList<SubjectGrade> MECHY4S7 = new ArrayList<>();
        // MECH Semester 7 ArrayList Total Grade = 23
        MECHY4S7.add(new SubjectGrade("ME8792 Power Plant Engineering",3));
        MECHY4S7.add(new SubjectGrade("ME8793 Process Planning and Cost Estimation",3));
        MECHY4S7.add(new SubjectGrade("ME8791 Mechatronics",3));
        MECHY4S7.add(new SubjectGrade("Open Elective - II",3));
        MECHY4S7.add(new SubjectGrade("Professional Elective – II",3));
        MECHY4S7.add(new SubjectGrade("Professional Elective – III",3));
        MECHY4S7.add(new SubjectGrade("ME8711 Simulation and Analysis Laboratory",2));
        MECHY4S7.add(new SubjectGrade("ME8781 Mechatronics Laboratory",2));
        MECHY4S7.add(new SubjectGrade("ME8712 Technical Seminar",2));
        ArrayList<SubjectGrade> MECHY4S8 = new ArrayList<>();
        // MECH Semester 8 ArrayList Total Grade = 16
        MECHY4S8.add(new SubjectGrade("MG8591 Principles of Management",3));
        MECHY4S8.add(new SubjectGrade("Professional Elective– IV",3));
        MECHY4S8.add(new SubjectGrade("ME8811 Project Work",10));
        



        if(depart.equals("CSE")){
            switch (Ssem){
                case "Semester 1" :
                    subjectname1 = CSEY1S1.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY1S1.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY1S1.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY1S1.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY1S1.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY1S1.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY1S1.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY1S1.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY1S1.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY1S1.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY1S1.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY1S1.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY1S1.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY1S1.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY1S1.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY1S1.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=25;subjectnumber=8; break;
                case "Semester 2" :
                    subjectname1 = CSEY1S2.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY1S2.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY1S2.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY1S2.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY1S2.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY1S2.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY1S2.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY1S2.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY1S2.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY1S2.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY1S2.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY1S2.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY1S2.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY1S2.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY1S2.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY1S2.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=24;subjectnumber=8; break;
                case "Semester 3" :
                    subjectname1 = CSEY2S3.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY2S3.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY2S3.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY2S3.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY2S3.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY2S3.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY2S3.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY2S3.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY2S3.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY2S3.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY2S3.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY2S3.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY2S3.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY2S3.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY2S3.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY2S3.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = CSEY2S3.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = CSEY2S3.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=24;subjectnumber=9; break;
                case "Semester 4" :
                    subjectname1 = CSEY2S4.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY2S4.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY2S4.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY2S4.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY2S4.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY2S4.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY2S4.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY2S4.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY2S4.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY2S4.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY2S4.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY2S4.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY2S4.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY2S4.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY2S4.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY2S4.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = CSEY2S4.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = CSEY2S4.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=24;subjectnumber=9; break;
                case "Semester 5" :
                    subjectname1 = CSEY3S5.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY3S5.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY3S5.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY3S5.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY3S5.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY3S5.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY3S5.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY3S5.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY3S5.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY3S5.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY3S5.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY3S5.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY3S5.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY3S5.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY3S5.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY3S5.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = CSEY3S5.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = CSEY3S5.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=25;subjectnumber=9; break;
                case "Semester 6" :
                    subjectname1 = CSEY3S6.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY3S6.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY3S6.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY3S6.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY3S6.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY3S6.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY3S6.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY3S6.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY3S6.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY3S6.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY3S6.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY3S6.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY3S6.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY3S6.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY3S6.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY3S6.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = CSEY3S6.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = CSEY3S6.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=24;subjectnumber=9; break;
                case "Semester 7" :
                    subjectname1 = CSEY4S7.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY4S7.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY4S7.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY4S7.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY4S7.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY4S7.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = CSEY4S7.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = CSEY4S7.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = CSEY4S7.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = CSEY4S7.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = CSEY4S7.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = CSEY4S7.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = CSEY4S7.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = CSEY4S7.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = CSEY4S7.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = CSEY4S7.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=22;subjectnumber= 8; break;
                case "Semester 8" :
                    subjectname1 = CSEY4S8.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (CSEY4S8.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = CSEY4S8.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = CSEY4S8.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = CSEY4S8.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = CSEY4S8.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    totalcredit=16;subjectnumber= 3; break;
            }
        }if(depart.equals("BME")) {
            switch (Ssem) {
                case "Semester 1":
                    subjectname1 = BMEY1S1.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY1S1.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY1S1.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY1S1.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY1S1.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY1S1.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY1S1.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY1S1.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY1S1.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY1S1.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY1S1.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY1S1.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY1S1.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY1S1.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY1S1.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY1S1.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit = 25;
                    subjectnumber = 8;
                    break;
                case "Semester 2":
                    subjectname1 = BMEY1S2.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY1S2.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY1S2.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY1S2.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY1S2.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY1S2.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY1S2.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY1S2.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY1S2.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY1S2.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY1S2.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY1S2.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY1S2.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY1S2.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY1S2.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY1S2.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit = 25;
                    subjectnumber = 8;
                    break;
                case "Semester 3":
                    subjectname1 = BMEY2S3.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY2S3.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY2S3.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY2S3.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY2S3.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY2S3.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY2S3.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY2S3.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY2S3.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY2S3.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY2S3.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY2S3.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY2S3.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY2S3.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY2S3.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY2S3.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = BMEY2S3.get(8).getSubjectname();
                    sub9.setText(subjectname9);
                    subjectgrade9 = BMEY2S3.get(8).getGrade();
                    cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit = 25;
                    subjectnumber = 9;
                    break;
                case "Semester 4":
                    subjectname1 = BMEY2S4.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY2S4.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY2S4.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY2S4.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY2S4.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY2S4.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY2S4.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY2S4.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY2S4.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY2S4.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY2S4.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY2S4.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY2S4.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY2S4.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY2S4.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY2S4.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit = 23;
                    subjectnumber = 8;
                    break;
                case "Semester 5":
                    subjectname1 = BMEY3S5.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY3S5.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY3S5.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY3S5.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY3S5.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY3S5.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY3S5.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY3S5.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY3S5.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY3S5.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY3S5.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY3S5.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY3S5.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY3S5.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY3S5.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY3S5.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = BMEY3S5.get(8).getSubjectname();
                    sub9.setText(subjectname9);
                    subjectgrade9 = BMEY3S5.get(8).getGrade();
                    cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit = 25;
                    subjectnumber = 9;
                    break;
                case "Semester 6":
                    subjectname1 = BMEY3S6.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY3S6.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY3S6.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY3S6.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY3S6.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY3S6.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY3S6.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY3S6.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY3S6.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY3S6.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY3S6.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY3S6.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY3S6.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY3S6.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY3S6.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY3S6.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = BMEY3S6.get(8).getSubjectname();
                    sub9.setText(subjectname9);
                    subjectgrade9 = BMEY3S6.get(8).getGrade();
                    cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit = 23;
                    subjectnumber = 9;
                    break;
                case "Semester 7":
                    subjectname1 = BMEY4S7.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY4S7.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY4S7.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY4S7.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY4S7.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY4S7.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = BMEY4S7.get(3).getSubjectname();
                    sub4.setText(subjectname4);
                    subjectgrade4 = BMEY4S7.get(3).getGrade();
                    cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = BMEY4S7.get(4).getSubjectname();
                    sub5.setText(subjectname5);
                    subjectgrade5 = BMEY4S7.get(4).getGrade();
                    cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = BMEY4S7.get(5).getSubjectname();
                    sub6.setText(subjectname6);
                    subjectgrade6 = BMEY4S7.get(5).getGrade();
                    cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = BMEY4S7.get(6).getSubjectname();
                    sub7.setText(subjectname7);
                    subjectgrade7 = BMEY4S7.get(6).getGrade();
                    cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = BMEY4S7.get(7).getSubjectname();
                    sub8.setText(subjectname8);
                    subjectgrade8 = BMEY4S7.get(7).getGrade();
                    cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit = 22;
                    subjectnumber = 8;
                    break;
                case "Semester 8":
                    subjectname1 = BMEY4S8.get(0).getSubjectname();
                    sub1.setText(subjectname1);
                    subjectgrade1 = (BMEY4S8.get(0).getGrade());
                    cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = BMEY4S8.get(1).getSubjectname();
                    sub2.setText(subjectname2);
                    subjectgrade2 = BMEY4S8.get(1).getGrade();
                    cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = BMEY4S8.get(2).getSubjectname();
                    sub3.setText(subjectname3);
                    subjectgrade3 = BMEY4S8.get(2).getGrade();
                    cred3.setText(String.valueOf(subjectgrade3));
                    totalcredit = 16;
                    subjectnumber = 3;
                    break;

            }
        }if(depart.equals("ECE")){
            switch (Ssem){
                case "Semester 1" :
                    subjectname1 = ECEY1S1.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY1S1.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY1S1.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY1S1.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY1S1.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY1S1.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY1S1.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY1S1.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY1S1.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY1S1.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY1S1.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY1S1.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY1S1.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY1S1.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY1S1.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY1S1.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=25;subjectnumber=8; break;
                case "Semester 2" :
                    subjectname1 = ECEY1S2.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY1S2.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY1S2.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY1S2.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY1S2.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY1S2.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY1S2.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY1S2.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY1S2.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY1S2.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY1S2.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY1S2.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY1S2.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY1S2.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY1S2.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY1S2.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=25;subjectnumber=8; break;
                case "Semester 3" :
                    subjectname1 = ECEY2S3.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY2S3.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY2S3.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY2S3.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY2S3.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY2S3.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY2S3.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY2S3.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY2S3.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY2S3.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY2S3.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY2S3.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY2S3.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY2S3.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY2S3.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY2S3.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ECEY2S3.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ECEY2S3.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=25;subjectnumber=9; break;
                case "Semester 4" :
                    subjectname1 = ECEY2S4.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY2S4.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY2S4.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY2S4.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY2S4.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY2S4.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY2S4.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY2S4.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY2S4.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY2S4.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY2S4.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY2S4.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY2S4.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY2S4.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY2S4.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY2S4.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=24;subjectnumber=8; break;
                case "Semester 5" :
                    subjectname1 = ECEY3S5.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY3S5.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY3S5.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY3S5.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY3S5.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY3S5.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY3S5.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY3S5.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY3S5.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY3S5.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY3S5.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY3S5.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY3S5.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY3S5.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY3S5.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY3S5.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ECEY3S5.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ECEY3S5.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=25;subjectnumber=9; break;
                case "Semester 6" :
                    subjectname1 = ECEY3S6.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY3S6.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY3S6.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY3S6.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY3S6.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY3S6.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY3S6.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY3S6.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY3S6.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY3S6.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY3S6.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY3S6.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY3S6.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY3S6.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY3S6.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY3S6.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ECEY3S6.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ECEY3S6.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=23;subjectnumber=9; break;
                case "Semester 7" :
                    subjectname1 = ECEY4S7.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY4S7.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY4S7.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY4S7.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY4S7.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY4S7.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ECEY4S7.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ECEY4S7.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ECEY4S7.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ECEY4S7.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ECEY4S7.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ECEY4S7.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ECEY4S7.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ECEY4S7.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ECEY4S7.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ECEY4S7.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=22;subjectnumber= 8; break;
                case "Semester 8" :
                    subjectname1 = ECEY4S8.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ECEY4S8.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ECEY4S8.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ECEY4S8.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ECEY4S8.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ECEY4S8.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    totalcredit=16;subjectnumber= 3; break;
            }
        }if(depart.equals("MECH")) {
                switch (Ssem) {
                    case "Semester 1":
                        subjectname1 = MECHY1S1.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY1S1.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY1S1.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY1S1.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY1S1.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY1S1.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY1S1.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY1S1.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY1S1.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY1S1.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY1S1.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY1S1.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY1S1.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY1S1.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY1S1.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY1S1.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                        totalcredit = 25; subjectnumber = 8; break;
                    case "Semester 2":
                        subjectname1 = MECHY1S2.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY1S2.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY1S2.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY1S2.get(1).getGrade();  cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY1S2.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY1S2.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY1S2.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY1S2.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY1S2.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY1S2.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY1S2.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY1S2.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY1S2.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY1S2.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY1S2.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY1S2.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                        totalcredit = 25;
                        subjectnumber = 8;
                        break;
                    case "Semester 3":
                        subjectname1 = MECHY2S3.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY2S3.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY2S3.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY2S3.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY2S3.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY2S3.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY2S3.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY2S3.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY2S3.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY2S3.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY2S3.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY2S3.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY2S3.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY2S3.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY2S3.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY2S3.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                        subjectname9 = MECHY2S3.get(8).getSubjectname(); sub9.setText(subjectname9);
                        subjectgrade9 = MECHY2S3.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                        totalcredit = 25; subjectnumber = 9; break;
                    case "Semester 4":
                        subjectname1 = MECHY2S4.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY2S4.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY2S4.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY2S4.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY2S4.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY2S4.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY2S4.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY2S4.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY2S4.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY2S4.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY2S4.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY2S4.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY2S4.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY2S4.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY2S4.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY2S4.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                        subjectname9 = MECHY2S4.get(8).getSubjectname(); sub9.setText(subjectname8);
                        subjectgrade9 = MECHY2S4.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade8));
                        totalcredit = 24; subjectnumber = 9; break;
                    case "Semester 5":
                        subjectname1 = MECHY3S5.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY3S5.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY3S5.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY3S5.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY3S5.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY3S5.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY3S5.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY3S5.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY3S5.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY3S5.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY3S5.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY3S5.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY3S5.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY3S5.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY3S5.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY3S5.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                        totalcredit = 22; subjectnumber = 8; break;
                    case "Semester 6":
                        subjectname1 = MECHY3S6.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY3S6.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY3S6.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY3S6.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY3S6.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY3S6.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY3S6.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY3S6.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY3S6.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY3S6.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY3S6.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY3S6.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY3S6.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY3S6.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY3S6.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY3S6.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                        subjectname9 = MECHY3S6.get(8).getSubjectname(); sub9.setText(subjectname9);
                        subjectgrade9 = MECHY3S6.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                        totalcredit = 24; subjectnumber = 9; break;
                    case "Semester 7":
                        subjectname1 = MECHY4S7.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY4S7.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY4S7.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY4S7.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY4S7.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY4S7.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        subjectname4 = MECHY4S7.get(3).getSubjectname(); sub4.setText(subjectname4);
                        subjectgrade4 = MECHY4S7.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                        subjectname5 = MECHY4S7.get(4).getSubjectname(); sub5.setText(subjectname5);
                        subjectgrade5 = MECHY4S7.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                        subjectname6 = MECHY4S7.get(5).getSubjectname(); sub6.setText(subjectname6);
                        subjectgrade6 = MECHY4S7.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                        subjectname7 = MECHY4S7.get(6).getSubjectname(); sub7.setText(subjectname7);
                        subjectgrade7 = MECHY4S7.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                        subjectname8 = MECHY4S7.get(7).getSubjectname(); sub8.setText(subjectname8);
                        subjectgrade8 = MECHY4S7.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade9));
                        subjectname9 = MECHY4S7.get(8).getSubjectname(); sub9.setText(subjectname8);
                        subjectgrade9 = MECHY4S7.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                        totalcredit = 23; subjectnumber = 9; break;
                    case "Semester 8":
                        subjectname1 = MECHY4S8.get(0).getSubjectname(); sub1.setText(subjectname1);
                        subjectgrade1 = (MECHY4S8.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                        subjectname2 = MECHY4S8.get(1).getSubjectname(); sub2.setText(subjectname2);
                        subjectgrade2 = MECHY4S8.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                        subjectname3 = MECHY4S8.get(2).getSubjectname(); sub3.setText(subjectname3);
                        subjectgrade3 = MECHY4S8.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                        totalcredit = 16; subjectnumber = 3; break;

                }
            }
        if(depart.equals("IT")){
            switch (Ssem){
                case "Semester 1" :
                    subjectname1 = ITY1S1.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY1S1.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY1S1.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY1S1.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY1S1.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY1S1.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY1S1.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY1S1.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY1S1.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY1S1.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY1S1.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY1S1.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY1S1.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY1S1.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY1S1.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY1S1.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=25;subjectnumber=8; break;
                case "Semester 2" :
                    subjectname1 = ITY1S2.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY1S2.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY1S2.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY1S2.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY1S2.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY1S2.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY1S2.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY1S2.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY1S2.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY1S2.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY1S2.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY1S2.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY1S2.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY1S2.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY1S2.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY1S2.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=24;subjectnumber=8; break;
                case "Semester 3" :
                    subjectname1 = ITY2S3.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY2S3.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY2S3.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY2S3.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY2S3.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY2S3.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY2S3.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY2S3.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY2S3.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY2S3.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY2S3.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY2S3.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY2S3.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY2S3.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY2S3.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY2S3.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ITY2S3.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ITY2S3.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=24;subjectnumber=9; break;
                case "Semester 4" :
                    subjectname1 = ITY2S4.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY2S4.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY2S4.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY2S4.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY2S4.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY2S4.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY2S4.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY2S4.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY2S4.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY2S4.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY2S4.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY2S4.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY2S4.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY2S4.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY2S4.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY2S4.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ITY2S4.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ITY2S4.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=24;subjectnumber=9; break;
                case "Semester 5" :
                    subjectname1 = ITY3S5.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY3S5.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY3S5.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY3S5.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY3S5.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY3S5.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY3S5.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY3S5.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY3S5.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY3S5.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY3S5.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY3S5.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY3S5.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY3S5.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY3S5.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY3S5.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ITY3S5.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ITY3S5.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=25;subjectnumber=9; break;
                case "Semester 6" :
                    subjectname1 = ITY3S6.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY3S6.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY3S6.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY3S6.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY3S6.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY3S6.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY3S6.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY3S6.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY3S6.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY3S6.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY3S6.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY3S6.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY3S6.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY3S6.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY3S6.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY3S6.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    subjectname9 = ITY3S6.get(8).getSubjectname(); sub9.setText(subjectname9);
                    subjectgrade9 = ITY3S6.get(8).getGrade(); cred9.setText(String.valueOf(subjectgrade9));
                    totalcredit=24;subjectnumber=9; break;
                case "Semester 7" :
                    subjectname1 = ITY4S7.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY4S7.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY4S7.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY4S7.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY4S7.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY4S7.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    subjectname4 = ITY4S7.get(3).getSubjectname(); sub4.setText(subjectname4);
                    subjectgrade4 = ITY4S7.get(3).getGrade(); cred4.setText(String.valueOf(subjectgrade4));
                    subjectname5 = ITY4S7.get(4).getSubjectname(); sub5.setText(subjectname5);
                    subjectgrade5 = ITY4S7.get(4).getGrade(); cred5.setText(String.valueOf(subjectgrade5));
                    subjectname6 = ITY4S7.get(5).getSubjectname(); sub6.setText(subjectname6);
                    subjectgrade6 = ITY4S7.get(5).getGrade(); cred6.setText(String.valueOf(subjectgrade6));
                    subjectname7 = ITY4S7.get(6).getSubjectname(); sub7.setText(subjectname7);
                    subjectgrade7 = ITY4S7.get(6).getGrade(); cred7.setText(String.valueOf(subjectgrade7));
                    subjectname8 = ITY4S7.get(7).getSubjectname(); sub8.setText(subjectname8);
                    subjectgrade8 = ITY4S7.get(7).getGrade(); cred8.setText(String.valueOf(subjectgrade8));
                    totalcredit=22;subjectnumber= 8; break;
                case "Semester 8" :
                    subjectname1 = ITY4S8.get(0).getSubjectname(); sub1.setText(subjectname1);
                    subjectgrade1 = (ITY4S8.get(0).getGrade()); cred1.setText(String.valueOf(subjectgrade1));
                    subjectname2 = ITY4S8.get(1).getSubjectname(); sub2.setText(subjectname2);
                    subjectgrade2 = ITY4S8.get(1).getGrade(); cred2.setText(String.valueOf(subjectgrade2));
                    subjectname3 = ITY4S8.get(2).getSubjectname(); sub3.setText(subjectname3);
                    subjectgrade3 = ITY4S8.get(2).getGrade(); cred3.setText(String.valueOf(subjectgrade3));
                    totalcredit=16;subjectnumber= 3; break;
            }
        }
        switch (subjectnumber){
            case 3 :
                sub4.setVisibility(View.GONE);
                sub5.setVisibility(View.GONE);
                sub6.setVisibility(View.GONE);
                sub7.setVisibility(View.GONE);
                sub8.setVisibility(View.GONE);
                sub9.setVisibility(View.GONE);

                cred4.setVisibility(View.GONE);
                cred5.setVisibility(View.GONE);
                cred6.setVisibility(View.GONE);
                cred7.setVisibility(View.GONE);
                cred8.setVisibility(View.GONE);
                cred9.setVisibility(View.GONE);

                spin4.setVisibility(View.GONE);
                spin5.setVisibility(View.GONE);
                spin6.setVisibility(View.GONE);
                spin7.setVisibility(View.GONE);
                spin8.setVisibility(View.GONE);
                spin9.setVisibility(View.GONE);break;

            case 8 :
                sub9.setVisibility(View.GONE);
                cred9.setVisibility(View.GONE);
                spin9.setVisibility(View.GONE);break;

        }


        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (spin1.getSelectedItem().toString()) {
                    case "O":
                        grade1 = 10;
                        break;
                    case "A+":
                        grade1 = 9;
                        break;
                    case "A":
                        grade1 = 8;
                        break;
                    case "B+":
                        grade1 = 7;
                        break;
                    case "B":
                        grade1 = 6;
                        break;
                    default:
                        grade1 = 0;
                        totalcredit=totalcredit-subjectgrade1;
                }
                switch (spin2.getSelectedItem().toString()) {
                    case "O":
                        grade2 = 10;
                        break;
                    case "A+":
                        grade2 = 9;
                        break;
                    case "A":
                        grade2 = 8;
                        break;
                    case "B+":
                        grade2 = 7;
                        break;
                    case "B":
                        grade2 = 6;
                        break;
                    default:
                        grade2 = 0;
                        totalcredit=totalcredit-subjectgrade2;
                }
                switch (spin3.getSelectedItem().toString()) {
                    case "O":
                        grade3 = 10;
                        break;
                    case "A+":
                        grade3 = 9;
                        break;
                    case "A":
                        grade3 = 8;
                        break;
                    case "B+":
                        grade3 = 7;
                        break;
                    case "B":
                        grade3 = 6;
                        break;
                    default:
                        grade3 = 0;
                        totalcredit=totalcredit-subjectgrade3;
                }
                switch (spin4.getSelectedItem().toString()) {
                    case "O":
                        grade4 = 10;
                        break;
                    case "A+":
                        grade4 = 9;
                        break;
                    case "A":
                        grade4 = 8;
                        break;
                    case "B+":
                        grade4 = 7;
                        break;
                    case "B":
                        grade4 = 6;
                        break;
                    default:
                        grade4 = 0;
                        totalcredit=totalcredit-subjectgrade4;
                }
                switch (spin5.getSelectedItem().toString()) {
                    case "O":
                        grade5 = 10;
                        break;
                    case "A+":
                        grade5 = 9;
                        break;
                    case "A":
                        grade5 = 8;
                        break;
                    case "B+":
                        grade5 = 7;
                        break;
                    case "B":
                        grade5 = 6;
                        break;
                    default:
                        grade5 = 0;
                        totalcredit=totalcredit-subjectgrade5;
                }
                switch (spin6.getSelectedItem().toString()) {
                    case "O":
                        grade6 = 10;
                        break;
                    case "A+":
                        grade6 = 9;
                        break;
                    case "A":
                        grade6 = 8;
                        break;
                    case "B+":
                        grade6 = 7;
                        break;
                    case "B":
                        grade6 = 6;
                        break;
                    default:
                        grade6 = 0;
                        totalcredit=totalcredit-subjectgrade6;
                }
                switch (spin7.getSelectedItem().toString()) {
                    case "O":
                        grade7 = 10;
                        break;
                    case "A+":
                        grade7 = 9;
                        break;
                    case "A":
                        grade7 = 8;
                        break;
                    case "B+":
                        grade7 = 7;
                        break;
                    case "B":
                        grade7 = 6;
                        break;
                    default:
                        grade7 = 0;
                        totalcredit=totalcredit-subjectgrade7;
                }
                switch (spin8.getSelectedItem().toString()) {
                    case "O":
                        grade8 = 10;
                        break;
                    case "A+":
                        grade8 = 9;
                        break;
                    case "A":
                        grade8 = 8;
                        break;
                    case "B+":
                        grade8 = 7;
                        break;
                    case "B":
                        grade8 = 6;
                        break;
                    default:
                        grade8 = 0;
                        totalcredit=totalcredit-subjectgrade8;
                }
                switch (spin9.getSelectedItem().toString()) {
                    case "O":
                        grade9 = 10;
                        break;
                    case "A+":
                        grade9 = 9;
                        break;
                    case "A":
                        grade9 = 8;
                        break;
                    case "B+":
                        grade9 = 7;
                        break;
                    case "B":
                        grade9 = 6;
                        break;
                    default:
                        grade9 = 0;
                        totalcredit=totalcredit-subjectgrade9;
                }

                sub1grade = subjectgrade1 * grade1;
                sub2grade = subjectgrade2 * grade2;
                sub3grade = subjectgrade3 * grade3;
                sub4grade = subjectgrade4 * grade4;
                sub5grade = subjectgrade5 * grade5;
                sub6grade = subjectgrade6 * grade6;
                sub7grade = subjectgrade7 * grade7;
                sub8grade = subjectgrade8 * grade8;
                sub9grade = subjectgrade9 * grade9;

                if(subjectnumber==8){
                    totalgrade= sub1grade+sub2grade+sub3grade+sub4grade+sub5grade+sub6grade+sub7grade+sub8grade;
                    Float credit = Float.valueOf(totalcredit);
                    Float grade = Float.valueOf(totalgrade);
                    gpa = grade/credit;
                    if(gpa>10 ||gpa<0){
                        failurealert.show();
                        return;
                    }
                    Toast.makeText(C_CGPASingle.this,"TotalCred = "+ totalcredit +"\nTotal Grade = "+totalgrade + "\nGPA TOTAL = "+gpa,Toast.LENGTH_LONG).show();
                }if(subjectnumber==9){
                    totalgrade= sub1grade+sub2grade+sub3grade+sub4grade+sub5grade+sub6grade+sub7grade+sub8grade+sub9grade;
                    Float credit = Float.valueOf(totalcredit);
                    Float grade = Float.valueOf(totalgrade);
                    gpa = grade/credit;
                    if(gpa>10 ||gpa<0){
                        failurealert.show();
                        return;
                    }
                    Toast.makeText(C_CGPASingle.this,"TotalCred = "+ totalcredit +"\nTotal Grade = "+totalgrade + "\nGPA TOTAL = "+gpa,Toast.LENGTH_LONG).show();
                }if (subjectnumber==3){
                    totalgrade= sub1grade+sub2grade+sub3grade;
                    Float credit = Float.valueOf(totalcredit);
                    Float grade = Float.valueOf(totalgrade);
                    gpa = grade/credit;
                    if(gpa>10 ||gpa<0){
                        failurealert.show();
                        return;
                    }
                    Toast.makeText(C_CGPASingle.this,"TotalCred = "+ totalcredit +"\nTotal Grade = "+totalgrade + "\nGPA TOTAL = "+gpa,Toast.LENGTH_LONG).show();
                }

                //Toast.makeText(C_CGPATotal.this,"SubGrade = "+sub1grade+"\nGrade = "+grade1,Toast.LENGTH_SHORT).show();
            }

        });



       // Toast.makeText(C_CGPATotal.this,"Subject  = "+arrayList.get(0).getSubjectname()+"\nGrade = "+arrayList.get(0).getGrade(),Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}