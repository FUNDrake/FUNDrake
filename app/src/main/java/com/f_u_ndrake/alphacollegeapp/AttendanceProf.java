package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class AttendanceProf extends AppCompatActivity {

    Spinner AttendProfDep,AttendProfYear,AttendProfPeriod;
    Button Submit,GetClass,SelectAll, SelectNone;
    FirestoreRecyclerAdapter adapter;
    FirebaseFirestore db;
    String dep,year,period;
    private static final String TAG = "AttendanceProf";
    RecyclerView mfirestorelist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_prof);

        AttendProfDep = (Spinner)findViewById(R.id.spinnerAttendProfDep);
        AttendProfYear = (Spinner)findViewById(R.id.spinnerAttendProfYear);
        AttendProfPeriod = (Spinner)findViewById(R.id.spinnerAttendProfPeriod);

        GetClass = (Button)findViewById(R.id.buttonGetClass);
        SelectAll = (Button)findViewById(R.id.buttonSelectAll);
        SelectNone = (Button)findViewById(R.id.buttonSelectNone);
        Submit = (Button)findViewById(R.id.buttonAttendProfSubmit);
        mfirestorelist=findViewById(R.id.mfirestorelist);

         db = FirebaseFirestore.getInstance();
        CollectionReference UserRef = db.collection("Users");

        String[] arrayDepart = new String[] {
                "CSE", "BME", "ECE", "MECH", "MBA"};
        String[] arrayYear = new String[] {
                "1st Year", "2nd Year", "3rd Year", "4th Year"};
        String[] arrayPeriod = new String[] {
                "1st Period" , "2nd Period" , "3rd Period" , "4th Period" , "5th Period" , "6th Period" , "7th Period" , "8th Period" , "9th Period" };

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

        //Query query = UserRef.whereEqualTo("Department", dep).whereEqualTo("Year",year);
        Query query = db.collection("Users").whereEqualTo("Department",dep).whereEqualTo("Year",year);

        FirestoreRecyclerOptions<StudentClass> options = new FirestoreRecyclerOptions.Builder<StudentClass>()
                .setQuery(query,StudentClass.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<StudentClass, StudentViewHolder>(options) {
            @NonNull
            @Override
            public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_student,parent,false);
                return new StudentViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull StudentViewHolder holder, int position, @NonNull StudentClass model) {
                holder.listStudentname.setText(model.getName());
            }
        };
        mfirestorelist.setHasFixedSize(true);
        mfirestorelist.setLayoutManager(new LinearLayoutManager(this));
        mfirestorelist.setAdapter(adapter);
    }

    private class StudentViewHolder extends RecyclerView.ViewHolder {
        private TextView listStudentname;
        private CheckBox checkBoxAttend;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);

            listStudentname = itemView.findViewById(R.id.listStudentname);
            checkBoxAttend = itemView.findViewById(R.id.checkBoxAttend);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.stopListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}