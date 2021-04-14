package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    EditText forgotpassEmail;
    Button forgotpass;
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotpass = findViewById(R.id.butForgotPassSubmit);
        forgotpassEmail = findViewById(R.id.etForgotPassEmailID);

        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email;
                if(forgotpassEmail.getText().toString().isEmpty()){
                    forgotpassEmail.setError("Enter Address");
                    forgotpassEmail.requestFocus();
                    return;
                    //Toast.makeText(ForgotPassword.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                }
                email = forgotpassEmail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPassword.this,"Email Sent",Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(ForgotPassword.this,task.getException().toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}