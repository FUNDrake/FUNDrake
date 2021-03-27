package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button login,register;
    String email, pass;
    EditText ETemail, ETpass;
    private long backPressedTime;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        login = (Button)findViewById(R.id.buttonLoginMainPage);
        register = (Button)findViewById(R.id.buttonRegisterMainPage);

        ETemail = (EditText) findViewById(R.id.editTextUserEmailID);
        ETpass =  (EditText)findViewById(R.id.editTextPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ETemail.getText().toString().isEmpty()) {
                    ETemail.setError("Enter your email ID");
                    ETemail.requestFocus();
                    return;
                }
                if(ETpass.getText().toString().equals("")) {
                    ETpass.setError("Please enter a password");
                    ETpass.requestFocus(); return;
                }

                email = ETemail.getText().toString();
                pass =  ETpass.getText().toString();


                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                                    startActivity(intent);
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure ", task.getException());
                                    Toast.makeText(MainActivity.this, "Authentication failed."+task.getException(),
                                    Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                                // ...
                            }
                        });
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser user) {
        user = mAuth.getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent intent = new Intent(MainActivity.this,MenuActivity.class);
            startActivity(intent);
        } else {
            // No user is signed in
        }

    }

}