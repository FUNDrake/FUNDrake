package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {

    String[] arrayDepart = new String[] {
            "CSE", "BME", "ECE", "MECH", "MBA"};
    String[] arrayYear = new String[] {
            "1st Year", "2nd Year", "3rd Year", "4th Year"};
    String[] arraySem12 = new String[] {
            "1st Semester", "2nd Semester"};
    String[] arraySem34 = new String[] {
            "3rd Semester", "4th Semester"};
    String[] arraySem56 = new String[] {
            "5th Semester", "6th Semester"};
    String[] arraySem78 = new String[] {
            "7th Semester", "8th Semester"};
    String userid;

    Spinner Department, Year, Semester;
    Button RegisterButton;

    EditText ETname, ETemail,ETpass,ETphone,ETau,ETaddress;

    RadioGroup rgGen;
    RadioButton rbGender;

    private static final String TAG = "RegisterActivity";
    private FirebaseUser user;
    FirebaseAuth mAuth;
    FirebaseFirestore fStore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        user = mAuth.getCurrentUser();

        rgGen = (RadioGroup) findViewById(R.id.RadioGroup);

        RegisterButton = (Button)findViewById(R.id.buttonReg);

        ETname = (EditText)findViewById(R.id.editTextTextPersonName);
        ETemail = (EditText)findViewById(R.id.editTextTextEmailAddress);
        ETpass = (EditText)findViewById(R.id.editTextTextPassword);
        ETphone = (EditText)findViewById(R.id.editTextPhone);
        ETau = (EditText)findViewById(R.id.editTextAUNumber);
        ETaddress = (EditText)findViewById(R.id.editTextTextPostalAddress);


        Department = (Spinner)findViewById(R.id.spinnerDepartment);
        Year = (Spinner)findViewById(R.id.spinnerYear);
        Semester = (Spinner)findViewById(R.id.spinnerSemester);
        RegisterButton = (Button)findViewById(R.id.buttonReg);

        ArrayAdapter<String> adapterDepart = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayDepart);
        adapterDepart.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterYear = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arrayYear);
        adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem12 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem12);
        adapterSem12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem34 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem34);
        adapterSem34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem56 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem56);
        adapterSem56.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapterSem78 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arraySem78);
        adapterSem78.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Department.setAdapter(adapterDepart);
        Year.setAdapter(adapterYear);

        Year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (Year.getSelectedItemPosition()){
                case 0 : Semester.setAdapter(adapterSem12); break;
                case 1 : Semester.setAdapter(adapterSem34); break;
                case 2 : Semester.setAdapter(adapterSem56); break;
                case 3 : Semester.setAdapter(adapterSem78); break;
            }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               /* if ((TextUtils.isEmpty(ETname.getText()))){
                    ETname.setError("Name is required!");
                    ETname.requestFocus();
                }

                if ((TextUtils.isEmpty(ETemail.getText().toString().trim()))){
                    ETemail.setError("E-Mail ID is required!");
                    ETemail.requestFocus();
                }
                if ((TextUtils.isEmpty(ETpass.getText().toString().trim()))){
                    ETpass.setError("Password is required!");
                    ETpass.requestFocus();
                }
                if ((TextUtils.isEmpty(ETphone.getText().toString().trim()))){
                    ETphone.setError("Number is required!");
                    ETphone.requestFocus();
                }
                if ((TextUtils.isEmpty(ETau.getText().toString().trim()))){
                    ETau.setError("Anna University Roll Number is required!");
                    ETau.requestFocus();
                }
                if(rgGen.getCheckedRadioButtonId()==-1){
                    Toast.makeText(getApplicationContext(),"Please select one gender!", Toast.LENGTH_SHORT).show();
                    rgGen.requestFocus();
                }
                if ((TextUtils.isEmpty(ETaddress.getText().toString().trim()))){
                    ETaddress.setError("Enter your Address!");
                    ETaddress.requestFocus();
                }
*/

                int pass=0;

                String DBfullname = ETname.getText().toString().trim();
                String DBphonenumber = ETphone.getText().toString().trim();
                String DBaurollno = ETau.getText().toString().trim();
                String DBgender;
                String DByear = Year.getSelectedItem().toString();
                String DBdepartment = Department.getSelectedItem().toString();
                String DBsemester = Semester.getSelectedItem().toString();
                String DBaddress = ETaddress.getText().toString().trim();

                int selectedidGen = rgGen.getCheckedRadioButtonId();
                rbGender = (RadioButton)findViewById(selectedidGen);
                DBgender =  rbGender.getText().toString();

                String email = ETemail.getText().toString().trim();
                String password = ETpass.getText().toString().trim();



                if (TextUtils.isEmpty(ETname.getText().toString().trim())){
                    ETname.setError("Enter Name");
                    ETname.requestFocus(); return;
                }
                if(TextUtils.isEmpty(email)){
                    ETemail.setError("Enter Email");
                    ETemail.requestFocus(); return;
                }
                if(TextUtils.isEmpty(password)){
                    ETemail.setError("Enter Email");
                    ETemail.requestFocus(); return;
                }
                if (TextUtils.isEmpty(ETphone.getText().toString().trim())){
                    ETphone.setError("Enter Phone Number");
                    ETphone.requestFocus(); return;
                }
                if (TextUtils.isEmpty(ETau.getText().toString().trim())){
                    ETau.setError("Enter AU Roll Number");
                    ETau.requestFocus(); return;
                }
                if(rgGen.getCheckedRadioButtonId()==-1){
                    rbGender.requestFocus();
                    Toast.makeText(getApplicationContext(),"Please select one gender!", Toast.LENGTH_SHORT).show(); return;
                }
                if (TextUtils.isEmpty(ETaddress.getText().toString().trim())){
                    ETaddress.setError("Enter Address");
                    ETaddress.requestFocus(); return;
                }
                else  {
                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful()){
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        updateUI(user);
                                        userid = mAuth.getCurrentUser().getUid();
                                        DocumentReference documentReference = fStore.collection("Users").document(userid);
                                        Map<String,Object> users = new HashMap<>();
                                        users.put("FullName",DBfullname);
                                        users.put("EMailID",email);
                                        users.put("Password",password);
                                        users.put("Phone Number",DBphonenumber);
                                        users.put("AU Roll No",DBaurollno);
                                        users.put("Gender",DBgender);
                                        users.put("Address",DBaddress);
                                        users.put("Department",DBdepartment);
                                        users.put("Year",DByear);
                                        users.put("Semester",DBsemester);
                                        documentReference.set(users).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                Log.d(TAG,"User created with ID + " +userid);
                                            }
                                        });
                                        Intent intent = new Intent(RegisterActivity.this,MenuActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(RegisterActivity.this, "Authentication failed."+ task.getException().getMessage(),
                                                Toast.LENGTH_SHORT).show();
                                        updateUI(null);
                                    }
                                }
                            });


                }



            }
        });





    }


      /*  private void storeNewUserData() {
        String fullname = ETname.getText().toString().trim();
        String emailid = ETemail.getText().toString().trim();
        String pass = ETpass.getText().toString().trim();
        String phonenumber = ETphone.getText().toString().trim();
        String aurollno = ETau.getText().toString().trim();
        String gender;
        String year = Year.getSelectedItem().toString();
        String department = Department.getSelectedItem().toString();
        String semester = Semester.getSelectedItem().toString();
        String address = ETaddress.getText().toString().trim();
        int selectedidGen = rgGen.getCheckedRadioButtonId();

        rbGender = (RadioButton)findViewById(selectedidGen);

        gender =  rbGender.getText().toString();



        FirebaseDatabase rootnode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootnode.getReference("Users").push();

        UserData addNewUser = new UserData(fullname,emailid,pass,phonenumber,aurollno,gender,address,department,year,semester);

        reference.setValue(addNewUser);

    }*/


    private void updateUI(FirebaseUser user) {
        user = mAuth.getCurrentUser();
        if (user != null) {
            if(user.isEmailVerified()){
                Toast.makeText(RegisterActivity.this, "Login Success.",
                        Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(RegisterActivity.this, "Your Email is not verified.",
                        Toast.LENGTH_SHORT).show();
            }
        }

    }

    public static boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN
                = Pattern.compile(
                "[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");

        return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
    }
}