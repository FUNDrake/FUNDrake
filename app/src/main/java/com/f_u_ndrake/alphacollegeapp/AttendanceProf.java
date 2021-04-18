package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AttendanceProf extends AppCompatActivity {

    Spinner AttendProfDep,AttendProfYear,AttendProfPeriod,AttendProfSem,AttendProfSub;
    Button Submit,GetClass,SelectAll, SelectNone;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference UserRef = db.collection("Users");
    RecyclerView recyclerViewStud;
    String dep,year,period;
    private List<String> present,absent;
    private ArrayList<StudentClass> studentClassArrayList;
    private StudentAdapter studentAdapter;
    int subjectpos;
    private static final String TAG = "AttendanceProf";

    Query query;


    Calendar cal = Calendar.getInstance();
    int Calyear = cal.get(Calendar.YEAR);
    int Calmonth = cal.get(Calendar.MONTH);
    int Calday = cal.get(Calendar.DAY_OF_MONTH);

    String date = Calmonth+1 + "-" + Calday + "-" + Calyear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_prof);

        AttendProfDep = findViewById(R.id.spinnerAttendProfDep);
        AttendProfYear = findViewById(R.id.spinnerAttendProfYear);
        AttendProfPeriod = findViewById(R.id.spinnerAttendProfPeriod);
        AttendProfSem = findViewById(R.id.spinnerAttendProfSem);
        AttendProfSub = findViewById(R.id.spinnerAttendProfSub);

        GetClass = (Button)findViewById(R.id.buttonGetClass);
        SelectAll = (Button)findViewById(R.id.buttonSelectAll);
        SelectNone = (Button)findViewById(R.id.buttonSelectNone);
        Submit = (Button)findViewById(R.id.buttonAttendProfSubmit);

        recyclerViewStud = (RecyclerView)findViewById(R.id.recycler_viewStud);

        String[] arrayDepart = new String[] {
                "CSE", "BME", "ECE", "MECH", "MBA"};
        String[] arrayYear = new String[] {
                "1st Year", "2nd Year", "3rd Year", "4th Year"};
        String[] arrayPeriod = new String[] {
                "1st Period" , "2nd Period" , "3rd Period" , "4th Period" , "5th Period" , "6th Period" , "7th Period" , "8th Period" , "9th Period" };
        String[] arraySem12 = new String[] {
                "Semester 1", "Semester 2"};
        String[] arraySem34 = new String[] {
                "Semester 3", "Semester 4"};
        String[] arraySem56 = new String[] {
                "Semester 5", "Semester 6"};
        String[] arraySem78 = new String[] {
                "Semester 7", "Semester 8"};
        String[] ALLDEP1Y1S = new String[] {"HS8151 Communicative English","MA8151 Engineering Mathematics - I","PH8151 Engineering Physics","CY8151 Engineering Chemistry","GE8151 Problem Solving and Python Programming","GE8152 Engineering Graphics"};

        ArrayAdapter<String> adapterSem12 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem12);
        adapterSem12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem34 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem34);
        adapterSem34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem56 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem56);
        adapterSem56.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem78 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem78);
        adapterSem78.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //CSE String Department

        String[] CSE1Y2S = new String[] {"HS8251 Technical English", "MA8251 Engineering Mathematics - II", "PH8252	Physics for Information Science", "BE8255 Basic Electrical, Electronics and Measurement Engineering", "GE8291 Environmental Science and Engineering","CS8251 Programming in C",};
        String[] CSE2Y3S = new String[] {"MA8351 Discrete Mathematics", "CS8351 Digital Principles and System Design", "CS8391 Data Structures", "CS8392 Object Oriented Programming", "EC8395 Communication Engineering"};
        String[] CSE2Y4S = new String[] {"MA8402 Probability and Queueing Theory", "CS8491 Computer Architecture", "CS8492 Database Management Systems", "CS8451 Design and Analysis of Algorithms", "CS8493 Operating Systems", "CS8494 Software Engineering"};
        String[] CSE3Y5S = new String[] {"MA8551 Algebra and Number Theory", "CS8591 Computer Networks", "EC8691 Microprocessors and Microcontrollers", "CS8501 Theory of Computation", "CS8592 Object Oriented Analysis and Design"};
        String[] CSE3Y6S = new String[] {"CS8651 Internet Programming", "CS8691 Artificial Intelligence", "CS8601 Mobile Computing", "CS8602 Compiler Design", "CS8603 Distributed Systems" };
        String[] CSE4Y7S = new String[] {"MG8591 Principles of Management", "CS8792 Cryptography and Network Security", "CS8791 Cloud Computing"};

        //MECH String Department

        String[] MECH1Y2S = new String[] {"HS8251 Technical English", "MA8251 Engineering Mathematics - II", "PH8251 Materials Science", "BE8253 Basic Electrical, Electronics and Instrumentation Engineering", "GE8291 Environmental Science and Engineering", "GE8292 Engineering Mechanics" };
        String[] MECH2Y3S = new String[] {"MA8353 Transforms and Partial Differential Equations", "ME8391 Engineering Thermodynamics", "CE8394 Fluid Mechanics and Machinery", "ME8351 Manufacturing Technology - I","EE8353 Electrical Drives and Controls" };
        String[] MECH2Y4S = new String[] {"MA8452 Statistics and Numerical Methods", "ME8492 Kinematics of Machinery", "ME8451 Manufacturing Technology – II", "ME8491 Engineering Metallurgy", "CE8395 Strength of Materials for Mechanical Engineers","ME8493	Thermal Engineering- I"};
        String[] MECH3Y5S = new String[] {"ME8595 Thermal Engineering- II", "ME8593 Design of Machine Elements", "ME8501 Metrology and Measurements", "ME8594 Dynamics of Machines" };
        String[] MECH3Y6S = new String[] {"ME8651 Design of Transmission Systems", "ME8691 Computer Aided Design and Manufacturing", "ME8693 Heat and Mass Transfer", "ME8692 Finite Element Analysis", "ME8694 Hydraulics and Pneumatics" };
        String[] MECH4Y7S = new String[] {"ME8792 Power Plant Engineering", "ME8793 Process Planning and Cost Estimation", "ME8791 Mechatronics"};

        //ECE  String Department

        String[] ECE1Y2S = new String[]{"HS8251	Technical English", "MA8251	Engineering Mathematics - II" , "PH8253	Physics for Electronics Engineering", "BE8254 Basic Electrical and Instrumentation Engineering",  "EC8251 Circuit Analysis", "EC8252 Electronic Devices"};
        String[] ECE2Y3S = new String[]{"MA8352	Linear Algebra and Partial Differential Equations", "EC8393	Fundamentals of Data", "Structures In C", "EC8351 Electronic Circuits- I", "EC8352 Signals and Systems", "EC8392 Digital Electronics",  "EC8391 Control Systems Engineering"};
        String[] ECE2Y4S = new String[]{"MA8451	Probability and Random Processes", "EC8452 Electronic Circuits II", "EC8491	Communication Theory", "EC8451 Electromagnetic Fields", "EC8453 Linear Integrated Circuits", "GE8291 Environmental Science and Engineering"};
        String[] ECE3Y5S = new String[]{"EC8501	Digital Communication", "EC8553	Discrete-Time Signal Processing", "EC8552 Computer Architecture and Organization", "EC8551 Communication Networks"};
        String[] ECE3Y6S = new String[]{"EC8691 Microprocessors and Microcontrollers", "EC8095 VLSI Design", "EC8652 Wireless Communication", "MG8591 Principles of Management", "EC8651 Transmission Lines and RF Systems"};
        String[] ECE4Y7S = new String[]{"EC8701	Antennas and Microwave Engineering", "EC8751 Optical Communication", "EC8791	Embedded and Real Time Systems", "EC8702 Ad hoc and Wireless Sensor Networks"};

        //BME  String Department

        String[] BME1Y2S = new String[]{"HS8251	Technical English", "MA8251	Engineering Mathematics - II", "PH8253 Physics for Electronics Engineering", "BM8251 Engineering Mechanics for Biomedical Engineers", "BM8201 Fundamentals of Bio Chemistry", "EC8251	Circuit Analysis"};
        String[] BME2Y3S = new String[]{"MA8352	Linear Algebra and Partial Differential Equations", "EC8352	Signals and Systems", "BM8351 Anatomy and Human Physiology", "BM8301 Sensors and Measurements", "EC8353 Electron Devices and Circuits", "BM8302 Pathology and Microbiology"};
        String[] BME2Y4S = new String[]{"MA8391	Probability and Statstics", "BM8401	Medical Physics", "EE8452 Basics of Electrical Engineering", "EC8453 Linear Integrated Circuits", "EC8393 Fundamentals of Data Structures In C", "EC8392 Digital Electronics"};
        String[] BME3Y5S = new String[]{"EC8394	Analog and Digital Communication", "BM8501 Biocontrol Systems", "BM8502	Biomedical Instrumentation", "EC8553 Discrete-Time Signal Processing"};
        String[] BME3Y6S = new String[]{"EC8691	Microprocessors and Microcontrollers", "BM8601 Diagnostic and Therapeutic Equipment - I", "BM8651 Biomechanics", "GE8291 Environmental Science and Engineering", "MD8091 Hospital Management"};
        String[] BME4Y7S = new String[]{" BM8701 Diagnostic and Therapeutic Equipment - II", "EC8093 Digital Image Processing", "BM8702	Radiological Equipments", "BM8703 Rehabilitation Engineering"};

        //IT  String Department

        String[] IT1Y2S = new String[]{"HS8251 Technical English", "MA8251 Engineering Mathematics - II", "PH8252 Physics for Information Science", "BE8255	Basic Electrical, Electronics and Measurement Engineering", "IT8201	Information Technology Essentials", "CS8251	Programming in C"};
        String[] IT2Y3S = new String[]{"MA8351 Discrete Mathematics", "CS8351 Digital Principles and System Design", "CS8391 Data Structures", "CS8392	Object Oriented Programming", "EC8394 Analog and Digital Communication"};
        String[] IT2Y4S = new String[]{"MA8391 Probability and Statistics", "CS8491	Computer Architecture", "CS8492	Database Management Systems", "CS8451 Design and Analysis of Algorithms", "CS8493 Operating Systems", "GE8291 Environmental Science and Engineering"};
        String[] IT3Y5S = new String[]{"MA8551 Algebra and Number Theory", "CS8591 Computer Networks", "EC8691	Microprocessors and Microcontrollers", "IT8501 Web Technology", "CS8494	Software Engineering"};
        String[] IT3Y6S = new String[]{"IT8601 Computational Intelligence", "CS8592	Object Oriented Analysis and Design", "IT8602 Mobile Communication", "CS8091 Big Data Analytics", "CS8092 Computer Graphics and Multimedia", "IT8601 Computational Intelligence"};
        String[] IT4Y7S = new String[]{"MG8591 Principles of Management", "CS8792 Cryptography and Network Security", "CS8791 Cloud Computing"};


        ArrayAdapter<String> adapterDepart = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayDepart);
        adapterDepart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AttendProfDep.setAdapter(adapterDepart);

        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayYear);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AttendProfYear.setAdapter(adapterYear);

        ArrayAdapter<String> adapterPeriod = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayPeriod);
        adapterPeriod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        AttendProfPeriod.setAdapter(adapterPeriod);

        dep = AttendProfDep.getSelectedItem().toString();
        year = AttendProfYear.getSelectedItem().toString();
        period = AttendProfPeriod.getSelectedItem().toString();

        //CSE Adapter for Spinner

        ArrayAdapter<String> adapterALLDEP1Y1S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ALLDEP1Y1S);
        adapterALLDEP1Y1S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterCSE1Y2S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CSE1Y2S);
        adapterCSE1Y2S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterCSE2Y3S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CSE2Y3S);
        adapterCSE2Y3S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterCSE2Y4S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CSE2Y4S);
        adapterCSE2Y4S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterCSE3Y5S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CSE3Y5S);
        adapterCSE3Y5S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterCSE3Y6S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CSE3Y6S);
        adapterCSE3Y6S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterCSE4Y7S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, CSE4Y7S);
        adapterCSE4Y7S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //MECH Adapter for Spinner

        ArrayAdapter<String> adapterMECH1Y2S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, MECH1Y2S);
        adapterMECH1Y2S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterMECH2Y3S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, MECH2Y3S);
        adapterMECH2Y3S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterMECH2Y4S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, MECH2Y4S);
        adapterMECH2Y4S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterMECH3Y5S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, MECH3Y5S);
        adapterMECH3Y5S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterMECH3Y6S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, MECH3Y6S);
        adapterMECH3Y6S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterMECH4Y7S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, MECH4Y7S);
        adapterMECH4Y7S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //ECE Adapter for Spinner

        ArrayAdapter<String> adapterECE1Y2S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ECE1Y2S);
        adapterECE1Y2S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterECE2Y3S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ECE2Y3S);
        adapterECE2Y3S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterECE2Y4S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ECE2Y4S);
        adapterECE2Y4S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterECE3Y5S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ECE3Y5S);
        adapterECE3Y5S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterECE3Y6S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ECE3Y6S);
        adapterECE3Y6S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterECE4Y7S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, ECE4Y7S);
        adapterECE4Y7S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //BME Adapter for Spinner

        ArrayAdapter<String> adapterBME1Y2S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, BME1Y2S);
        adapterBME1Y2S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBME2Y3S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, BME2Y3S);
        adapterBME2Y3S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBME2Y4S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, BME2Y4S);
        adapterBME2Y4S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBME3Y5S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, BME3Y5S);
        adapterBME3Y5S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBME3Y6S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, BME3Y6S);
        adapterBME3Y6S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterBME4Y7S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, BME4Y7S);
        adapterBME4Y7S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //IT Adapter for Spinner

        ArrayAdapter<String> adapterIT1Y2S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, IT1Y2S);
        adapterIT1Y2S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterIT2Y3S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, IT2Y3S);
        adapterIT2Y3S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterIT2Y4S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, IT2Y4S);
        adapterIT2Y4S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterIT3Y5S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, IT3Y5S);
        adapterIT3Y5S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterIT3Y6S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, IT3Y6S);
        adapterIT3Y6S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterIT4Y7S = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, IT4Y7S);
        adapterIT4Y7S.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        AttendProfYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (AttendProfYear.getSelectedItemPosition()){
                    case 0 : AttendProfSem.setAdapter(adapterSem12); break;
                    case 1 : AttendProfSem.setAdapter(adapterSem34); break;
                    case 2 : AttendProfSem.setAdapter(adapterSem56); break;
                    case 3 : AttendProfSem.setAdapter(adapterSem78); break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        AttendProfSem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (AttendProfDep.getSelectedItemPosition()==0){
                    if(AttendProfYear.getSelectedItemPosition()==0){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterALLDEP1Y1S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterCSE1Y2S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==1){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterCSE2Y3S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterCSE2Y4S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==2){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterCSE3Y5S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterCSE3Y6S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==3){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterCSE4Y7S);
                        }
                    }
                }
                if (AttendProfDep.getSelectedItemPosition()==1){
                    if(AttendProfYear.getSelectedItemPosition()==0){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterALLDEP1Y1S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterBME1Y2S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==1){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterBME2Y3S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterBME2Y4S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==2){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterBME3Y5S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterBME3Y6S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==3){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterBME4Y7S);
                        }
                    }
                }
                if (AttendProfDep.getSelectedItemPosition()==2){
                    if(AttendProfYear.getSelectedItemPosition()==0){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterALLDEP1Y1S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterECE1Y2S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==1){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterECE2Y3S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterECE2Y4S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==2){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterECE3Y5S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterECE3Y6S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==3){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterECE4Y7S);
                        }
                    }
                }
                if (AttendProfDep.getSelectedItemPosition()==3){
                    if(AttendProfYear.getSelectedItemPosition()==0){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterALLDEP1Y1S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterMECH1Y2S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==1){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterMECH2Y3S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterMECH2Y4S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==2){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterMECH3Y5S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterMECH3Y6S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==3){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterMECH4Y7S);
                        }
                    }
                }
                if (AttendProfDep.getSelectedItemPosition()==4){
                    if(AttendProfYear.getSelectedItemPosition()==0){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterALLDEP1Y1S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterIT1Y2S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==1){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterIT2Y3S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterIT2Y4S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==2){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterIT3Y5S);
                        }
                        if(AttendProfSem.getSelectedItemPosition()==1){
                            AttendProfSub.setAdapter(adapterIT3Y6S);
                        }
                    }
                    if(AttendProfYear.getSelectedItemPosition()==3){
                        if(AttendProfSem.getSelectedItemPosition()==0){
                            AttendProfSub.setAdapter(adapterIT4Y7S);
                        }
                    }
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        studentClassArrayList = new ArrayList<>();
        recyclerViewStud.setHasFixedSize(true);
        recyclerViewStud.setLayoutManager(new LinearLayoutManager(this));
        studentAdapter = new StudentAdapter(studentClassArrayList, this);

        recyclerViewStud.setAdapter(studentAdapter);


        GetClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentClassArrayList.clear();
                db.collection("Users")
                        .whereEqualTo("Year",AttendProfYear.getSelectedItem().toString())
                        .whereEqualTo("Department",AttendProfDep.getSelectedItem().toString())
                        .get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                if (!queryDocumentSnapshots.isEmpty()) {
                                    List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                                    for (DocumentSnapshot d : list) {
                                        StudentClass c = d.toObject(StudentClass.class);
                                        studentClassArrayList.add(c);

                                    }
                                    studentAdapter.notifyDataSetChanged();
                                } else {
                                    Toast.makeText(AttendanceProf.this, "No data found in Database", Toast.LENGTH_SHORT).show();
                                    studentClassArrayList.clear();
                                    studentAdapter.notifyDataSetChanged();
                                }
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AttendanceProf.this, "Fail to get the data.", Toast.LENGTH_SHORT).show();
                        studentClassArrayList.clear();
                        studentAdapter.notifyDataSetChanged();
                    }
                });

            }

        });

        SelectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentAdapter.getItemCount()==0){
                    Toast.makeText(AttendanceProf.this, "Please choose a class", Toast.LENGTH_SHORT).show();
                }
                studentAdapter.mselectall();
                Toast.makeText(AttendanceProf.this, "Selected All Students", Toast.LENGTH_SHORT).show();
            }
        });

        SelectNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(studentAdapter.getItemCount()==0){
                    Toast.makeText(AttendanceProf.this, "Please choose a class", Toast.LENGTH_SHORT).show();
            }
                studentAdapter.munselectall();
                Toast.makeText(AttendanceProf.this, "Deselected All Students", Toast.LENGTH_SHORT).show();
            }
        });


        Submit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                subjectpos = AttendProfSub.getSelectedItemPosition();
                StringBuilder stringPresent = new StringBuilder();
                StringBuilder stringAbsent = new StringBuilder();
                String subname,DBFullNameP= "",DBFullNameA= "",Period;
                Boolean DBischecked;

                int i = 0;
                present = studentAdapter.getPresentArray();
                absent = studentAdapter.getAbsentArray();
                stringPresent.append(present);
                stringAbsent.append(absent);

                Toast.makeText(AttendanceProf.this,"Present = "+present+"\nAbsent ="+absent,Toast.LENGTH_LONG).show();

                DBFullNameP = stringPresent.toString();
                DBFullNameA = stringAbsent.toString();

                Period = AttendProfPeriod.getSelectedItem().toString();
                subname = AttendProfSub.getSelectedItem().toString();
                DocumentReference documentReference = db.collection("Attendance").document(subname);
                DocumentReference documentReference1 = documentReference.collection(date).document(Period);
                Map<String,Object> attendanceclass = new HashMap<>();
                attendanceclass.put("Present Student Names",DBFullNameP);
                attendanceclass.put("Absent Student Names",DBFullNameA);
                documentReference1.set(attendanceclass).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG,"User created with ID + " +subname);
                        Toast.makeText(AttendanceProf.this,"Attendance Marked!",Toast.LENGTH_LONG).show();
                    }
                });

                for (int j = 0; j < present.size(); j++) {
                    String name = present.get(j);
                    db.collection("Users").whereEqualTo("FullName",name).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            if(queryDocumentSnapshots.isEmpty()){

                            }else{
                                DocumentReference ref = queryDocumentSnapshots.getDocuments().get(i).getReference();
                                Map<String,Object> addattend = new HashMap<>();
                                addattend.put("Subject 1 Attendance",FieldValue.increment(1));
                                ref.update(addattend).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Toast.makeText(AttendanceProf.this,"Attendance Marked!",Toast.LENGTH_LONG).show();
                                    }
                                });
                            }
                        }
                    });

                }
                stringPresent.setLength(0);
                stringAbsent.setLength(0);
            }
        });

    }

}