package com.f_u_ndrake.alphacollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class AttendanceStud9 extends AppCompatActivity {

    TextView SubCode1,SubName1,Attend1,SubCode2,SubName2,Attend2,SubCode3,SubName3,Attend3,SubCode4,SubName4,Attend4,SubCode5,SubName5,Attend5,SubCode6,SubName6,Attend6,SubCode7,SubName7,Attend7,SubCode8,SubName8,Attend8,SubCode9,SubName9,Attend9;
    String attendance1,attendance2,attendance3,attendance4,attendance5,attendance6,attendance7,attendance8,attendance9;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    public String firstName,dep,sem;
    private static final String TAG = "AttendanceStud9";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_stud9);

        SubCode1 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode1);
        SubCode2 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode2);
        SubCode3 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode3);
        SubCode4 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode4);
        SubCode5 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode5);
        SubCode6 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode6);
        SubCode7 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode7);
        SubCode8 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode8);
        SubCode9 = (TextView)findViewById(R.id.tvAttend9StudSubjectCode9);

        SubName1 = (TextView)findViewById(R.id.tvAttend9StudSubjectName1);
        SubName2 = (TextView)findViewById(R.id.tvAttend9StudSubjectName2);
        SubName3 = (TextView)findViewById(R.id.tvAttend9StudSubjectName3);
        SubName4 = (TextView)findViewById(R.id.tvAttend9StudSubjectName4);
        SubName5 = (TextView)findViewById(R.id.tvAttend9StudSubjectName5);
        SubName6 = (TextView)findViewById(R.id.tvAttend9StudSubjectName6);
        SubName7 = (TextView)findViewById(R.id.tvAttend9StudSubjectName7);
        SubName8 = (TextView)findViewById(R.id.tvAttend9StudSubjectName8);
        SubName9 = (TextView)findViewById(R.id.tvAttend9StudSubjectName9);

        Attend1 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend1);
        Attend2 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend2);
        Attend3 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend3);
        Attend4 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend4);
        Attend5 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend5);
        Attend6 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend6);
        Attend7 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend7);
        Attend8 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend8);
        Attend9 = (TextView)findViewById(R.id.tvAttend9StudSubjectAttend9);

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
                attendance9 = task.getResult().get("Subject 9 Attendance").toString();
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
        Attend9.setText(attendance9);

        if(dep.equals("CSE")){
            if(sem.equals("3rd Semester")){
                SubCode1.setText("MA8351");
                SubName1.setText("Discrete Mathematics");
                SubCode2.setText("CS8351");
                SubName2.setText("Digital Principles and System Design");
                SubCode3.setText("CS8391");
                SubName3.setText("Data Structures");
                SubCode4.setText("CS8392");
                SubName4.setText("Object Oriented Programming");
                SubCode5.setText("EC8395");
                SubName5.setText("Communication Engineering");
                SubCode6.setText("CS8381");
                SubName6.setText("Data Structures Laboratory");
                SubCode7.setText("CS8383");
                SubName7.setText("Object Oriented Programming Laboratory");
                SubCode8.setText("CS8382");
                SubName8.setText("Digital Systems Laboratory");
                SubCode9.setText("HS8381");
                SubName9.setText("Interpersonal Skills / Listening & Speaking");
            }
            if(sem.equals("4th Semester")){
                SubCode1.setText("MA8402");
                SubName1.setText("Probability and Queueing Theory");
                SubCode2.setText("CS8491");
                SubName2.setText("Computer Architecture");
                SubCode3.setText("CS8492");
                SubName3.setText("Database Management Systems");
                SubCode4.setText("CS8451");
                SubName4.setText("Design and Analysis of Algorithms");
                SubCode5.setText("CS8493");
                SubName5.setText("Operating Systems");
                SubCode6.setText("CS8494");
                SubName6.setText("Software Engineering");
                SubCode7.setText("CS8481");
                SubName7.setText("Database Management Systems Laboratory");
                SubCode8.setText("CS8461");
                SubName8.setText("Operating Systems Laboratory");
                SubCode9.setText("HS8461");
                SubName9.setText("Advanced Reading and Writing");
            }
            if(sem.equals("5th Semester")){
                SubCode1.setText("MA8551");
                SubName1.setText("Algebra and Number Theory");
                SubCode2.setText("CS8591");
                SubName2.setText("Computer Networks");
                SubCode3.setText("EC8691");
                SubName3.setText("Microprocessors and Microcontrollers");
                SubCode4.setText("CS8501");
                SubName4.setText("Theory of Computation");
                SubCode5.setText("CS8592");
                SubName5.setText("Object Oriented Analysis and Design");
                SubCode6.setText(" - ");
                SubName6.setText("Open Elective I");
                SubCode7.setText("EC8681");
                SubName7.setText("Microprocessors and Microcontrollers Laboratory");
                SubCode8.setText("CS8582");
                SubName8.setText("Object Oriented Analysis and Design Laboratory");
                SubCode9.setText("CS8581");
                SubName9.setText("Networks Laboratory");
            }
            if(sem.equals("6th Semester")){
                SubCode1.setText("CS8651");
                SubName1.setText("Internet Programming");
                SubCode2.setText("CS8691");
                SubName2.setText("Artificial Intelligence");
                SubCode3.setText("CS8601");
                SubName3.setText("Mobile Computing");
                SubCode4.setText("CS8602");
                SubName4.setText("Compiler Design");
                SubCode5.setText("CS8603");
                SubName5.setText("Distributed Systems");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective I");
                SubCode7.setText("CS8661");
                SubName7.setText("Internet Programming Laboratory");
                SubCode8.setText("CS8662");
                SubName8.setText("Mobile ApplicationDevelopment Laboratory");
                SubCode9.setText("CS8611");
                SubName9.setText("Mini Project");
            }
        }if(dep.equals("BME")){
            if(sem.equals("3rd Semester")){
                SubCode1.setText("MA8352");
                SubName1.setText("Linear Algebra and Partial Differential Equations");
                SubCode2.setText("EC8352");
                SubName2.setText("Signals and Systems");
                SubCode3.setText("BM8351");
                SubName3.setText("Anatomy and Human Physiology");
                SubCode4.setText("BM8301");
                SubName4.setText("Sensors and Measurements");
                SubCode5.setText("EC8353");
                SubName5.setText("Electron Devices and Circuits");
                SubCode6.setText("BM8302");
                SubName6.setText("Pathology and Microbiology");
                SubCode7.setText("BM8311");
                SubName7.setText("Pathology and Microbiology Laboratory");
                SubCode8.setText("BM8312");
                SubName8.setText("Devices and Circuits Laboratory");
                SubCode9.setText("BM8313");
                SubName9.setText("Human Physiology Laboratory");
            }
            if(sem.equals("5th Semester")){
                SubCode1.setText("EC8394");
                SubName1.setText("Analog and Digital Communication");
                SubCode2.setText("BM8501");
                SubName2.setText("Biocontrol Systems");
                SubCode3.setText("BM8502");
                SubName3.setText("Biomedical Instrumentation");
                SubCode4.setText("EC8553");
                SubName4.setText("Discrete-Time Signal Processing");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective - I");
                SubCode6.setText(" - ");
                SubName6.setText("Open Elective -I");
                SubCode7.setText("EC8562");
                SubName7.setText("Digital Signal Processing Laboratory");
                SubCode8.setText("BM8511");
                SubName8.setText("Biomedical Instrumentation Laboratory");
                SubCode9.setText("HS8381");
                SubName9.setText("Interpersonal Skills / Listening & Speaking");
            }
            if(sem.equals("6th Semester")){
                SubCode1.setText("EC8691");
                SubName1.setText("Microprocessors and Microcontrollers");
                SubCode2.setText("BM8601");
                SubName2.setText("Diagnostic and Therapeutic Equipment - I");
                SubCode3.setText("BM8651");
                SubName3.setText("Biomechanics");
                SubCode4.setText("GE8291");
                SubName4.setText("Environmental Science and Engineering");
                SubCode5.setText("MD8091");
                SubName5.setText("Hospital Management");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective - II");
                SubCode7.setText("EC8681");
                SubName7.setText("Microprocessors and Microcontrollers Laboratory");
                SubCode8.setText("BM8611");
                SubName8.setText("Diagnostic and Therapeutic Equipment Laboratory");
                SubCode9.setText("BM8612");
                SubName9.setText("Mini Project");
            }
        }if(dep.equals("ECE")){
            if(sem.equals("3rd Semester")){
                SubCode1.setText("MA8352");
                SubName1.setText("Linear Algebra and Partial Differential Equations");
                SubCode2.setText("EC8393");
                SubName2.setText("Fundamentals of Data Structures In C");
                SubCode3.setText("EC8351");
                SubName3.setText("Electronic Circuits- I");
                SubCode4.setText("EC8352");
                SubName4.setText("Signals and Systems");
                SubCode5.setText("EC8392");
                SubName5.setText("Digital Electronics");
                SubCode6.setText("EC8391");
                SubName6.setText("Control Systems Engineering");
                SubCode7.setText("EC8381");
                SubName7.setText("Fundamentals of Data Structures in C Laboratory");
                SubCode8.setText("EC8361");
                SubName8.setText("Analog and Digital Circuits Laboratory");
                SubCode9.setText("HS8381");
                SubName9.setText("Interpersonal Skills / Listening & Speaking");
            }
            if(sem.equals("5th Semester")){
                SubCode1.setText("EC8501");
                SubName1.setText("Digital Communication");
                SubCode2.setText("EC8553");
                SubName2.setText("Discrete-Time Signal Processing");
                SubCode3.setText("EC8552");
                SubName3.setText("Computer Architecture and Organization");
                SubCode4.setText("EC8551");
                SubName4.setText("Communication Networks");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective - I");
                SubCode6.setText(" - ");
                SubName6.setText("Open Elective -I");
                SubCode7.setText("EC8562");
                SubName7.setText("Digital Signal Processing Laboratory");
                SubCode8.setText("EC8561");
                SubName8.setText("Communication Systems Laboratory");
                SubCode9.setText("EC8563");
                SubName9.setText("Communication Networks Laboratory");
            }
            if(sem.equals("6th Semester")){
                SubCode1.setText("EC8691");
                SubName1.setText("Microprocessors and Microcontrollers");
                SubCode2.setText("EC8095");
                SubName2.setText("VLSI Design");
                SubCode3.setText("EC8652");
                SubName3.setText("Wireless Communication");
                SubCode4.setText("MG8591");
                SubName4.setText("Principles of Management");
                SubCode5.setText("EC8651");
                SubName5.setText("Transmission Lines and RF Systems");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective - II");
                SubCode7.setText("EC8681");
                SubName7.setText("Microprocessors and Microcontrollers Laboratory");
                SubCode8.setText("EC8661");
                SubName8.setText("VLSI Design Laboratory");
                SubCode9.setText("EC8611");
                SubName9.setText("Technical Seminar");
            }
        }if(dep.equals("MECH")){
            if(sem.equals("3rd Semester")){
                SubCode1.setText("MA8353");
                SubName1.setText("Transforms and Partial Differential Equations");
                SubCode2.setText("ME8391");
                SubName2.setText("Engineering Thermodynamics");
                SubCode3.setText("CE8394");
                SubName3.setText("Fluid Mechanics and Machinery");
                SubCode4.setText("ME8351");
                SubName4.setText("Manufacturing Technology - I");
                SubCode5.setText("EE8353");
                SubName5.setText("Electrical Drives and Controls");
                SubCode6.setText("ME8361");
                SubName6.setText("Manufacturing Technology Laboratory - I");
                SubCode7.setText("ME8381");
                SubName7.setText("Computer Aided Machine Drawing");
                SubCode8.setText("EE8361");
                SubName8.setText("Electrical Engineering Laboratory");
                SubCode9.setText("HS8381");
                SubName9.setText("Interpersonal Skills / Listening & Speaking");
            }
            if(sem.equals("4th Semester")){
                SubCode1.setText("MA8452");
                SubName1.setText("Statistics and Numerical Methods");
                SubCode2.setText("ME8492");
                SubName2.setText("Kinematics of Machinery");
                SubCode3.setText("ME8451");
                SubName3.setText("Manufacturing Technology – II");
                SubCode4.setText("ME8491");
                SubName4.setText("Engineering Metallurgy");
                SubCode5.setText("CE8395");
                SubName5.setText("Strength of Materials for Mechanical Engineers");
                SubCode6.setText("ME8493");
                SubName6.setText("Thermal Engineering- I");
                SubCode7.setText("ME8462");
                SubName7.setText("Manufacturing Technology Laboratory – II");
                SubCode8.setText("CE8381");
                SubName8.setText("Strength of Materials and Fluid Mechanics and Machinery Laboratory");
                SubCode9.setText("HS8461");
                SubName9.setText("Advanced Reading and Writing");
            }
            if(sem.equals("6th Semester")){
                SubCode1.setText("ME8651");
                SubName1.setText("Design of Transmission Systems");
                SubCode2.setText("ME8691");
                SubName2.setText("Computer Aided Design and Manufacturing");
                SubCode3.setText("ME8693");
                SubName3.setText("Heat and Mass Transfer");
                SubCode4.setText("ME8692");
                SubName4.setText("Finite Element Analysis");
                SubCode5.setText("ME8694");
                SubName5.setText("Hydraulics and Pneumatics");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective - I");
                SubCode7.setText("ME8681");
                SubName7.setText("CAD / CAM Laboratory");
                SubCode8.setText("ME8682");
                SubName8.setText("Design and Fabrication Project");
                SubCode9.setText("HS8581");
                SubName9.setText("Professional Communication");
            }if(sem.equals("7th Semester")){
                SubCode1.setText("ME8792");
                SubName1.setText("Power Plant Engineering");
                SubCode2.setText("ME8793");
                SubName2.setText("Process Planning and Cost Estimation");
                SubCode3.setText("ME8791");
                SubName3.setText("Mechatronics");
                SubCode4.setText(" - ");
                SubName4.setText("Open Elective - II");
                SubCode5.setText(" - ");
                SubName5.setText("Professional Elective – II");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective – III");
                SubCode7.setText("ME8711");
                SubName7.setText("Simulation and Analysis Laboratory");
                SubCode8.setText("ME8781");
                SubName8.setText("Mechatronics Laboratory");
                SubCode9.setText("ME8712");
                SubName9.setText("Technical Seminar");
            }
        }if(dep.equals("IT")){
            if(sem.equals("2nd Semester")){
                SubCode1.setText("HS8251");
                SubName1.setText("Technical English");
                SubCode2.setText("MA8251");
                SubName2.setText("Engineering Mathematics - II");
                SubCode3.setText("PH8252");
                SubName3.setText("Physics for Information Science");
                SubCode4.setText("BE8255");
                SubName4.setText("Basic Electrical, Electronics and Measurement Engineering");
                SubCode5.setText("IT8201");
                SubName5.setText("Information Technology Essentials");
                SubCode6.setText("CS8251");
                SubName6.setText("Programming in C");
                SubCode7.setText("GE8261");
                SubName7.setText("Engineering Practices Laboratory");
                SubCode8.setText("CS8261");
                SubName8.setText("C Programming Laboratory");
                SubCode9.setText("IT8211");
                SubName9.setText("Information Technology Essentials Laboratory");
            }
            if(sem.equals("3rd Semester")){
                SubCode1.setText("MA8351");
                SubName1.setText("Discrete Mathematics");
                SubCode2.setText("CS8351");
                SubName2.setText("Digital Principles and System Design");
                SubCode3.setText("CS8391");
                SubName3.setText("Data Structures");
                SubCode4.setText("CS8392");
                SubName4.setText("Object Oriented Programming");
                SubCode5.setText("EC8394");
                SubName5.setText("Analog and Digital Communication");
                SubCode6.setText("CS8381");
                SubName6.setText("Data Structures Laboratory");
                SubCode7.setText("CS8383");
                SubName7.setText("Object Oriented Programming Laboratory");
                SubCode8.setText("CS8382");
                SubName8.setText("Digital Systems Laboratory");
                SubCode9.setText("HS8381");
                SubName9.setText("Interpersonal Skills / Listening & Speaking");
            }
            if(sem.equals("4th Semester")){
                SubCode1.setText("MA8391");
                SubName1.setText("Probability and Statistics");
                SubCode2.setText("CS8491");
                SubName2.setText("Computer Architecture");
                SubCode3.setText("CS8492");
                SubName3.setText("Database Management Systems");
                SubCode4.setText("CS8451");
                SubName4.setText("Design and Analysis of Algorithms");
                SubCode5.setText("CS8493");
                SubName5.setText("Operating Systems");
                SubCode6.setText("GE8291");
                SubName6.setText("Environmental Science and Engineering");
                SubCode7.setText("CS8481");
                SubName7.setText("Database Management Systems Laboratory");
                SubCode8.setText("CS8461");
                SubName8.setText("Operating Systems Laboratory");
                SubCode9.setText("HS8461");
                SubName9.setText("Advanced Reading and Writing");
            }
            if(sem.equals("5th Semester")){

                SubCode1.setText("MA8551");
                SubName1.setText("Algebra and Number Theory");
                SubCode2.setText("CS8591");
                SubName2.setText("Computer Networks");
                SubCode3.setText("EC8691");
                SubName3.setText("Microprocessors and Microcontrollers");
                SubCode4.setText("IT8501");
                SubName4.setText("Web Technology");
                SubCode5.setText("CS8494");
                SubName5.setText("Software Engineering");
                SubCode6.setText(" - ");
                SubName6.setText("Open Elective I");
                SubCode7.setText("EC8681");
                SubName7.setText("Microprocessors and Microcontrollers Laboratory");
                SubCode8.setText("CS8581");
                SubName8.setText("Networks Laboratory");
                SubCode9.setText("IT8511");
                SubName9.setText("Web Technology Laboratory");
            }
            if(sem.equals("6th Semester")){
                SubCode1.setText("IT8601");
                SubName1.setText("Computational Intelligence");
                SubCode2.setText("CS8592");
                SubName2.setText("Object Oriented Analysis and Design");
                SubCode3.setText("IT8602");
                SubName3.setText("Mobile Communication");
                SubCode4.setText("CS8091");
                SubName4.setText("Big Data Analytics");
                SubCode5.setText("CS8092");
                SubName5.setText("Computer Graphics and Multimedia");
                SubCode6.setText(" - ");
                SubName6.setText("Professional Elective I");
                SubCode7.setText("CS8662");
                SubName7.setText("Mobile Application Development Laboratory");
                SubCode8.setText("CS8582");
                SubName8.setText("Object Oriented Analysis and Design Laboratory");
                SubCode9.setText("IT8611");
                SubName9.setText("Mini Project");
            }
        }
    }
}
