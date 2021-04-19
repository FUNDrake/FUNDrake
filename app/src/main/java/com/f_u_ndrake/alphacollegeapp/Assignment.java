package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Assignment extends AppCompatActivity {

    Button upload,selectfile;
    TextView tvfile;
    Uri pdfURL;
    FirebaseAuth firebaseAuth;
    FirebaseStorage firebaseStorage;
    FirebaseDatabase firebaseDatabase;
    ProgressDialog progressDialog;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    String fullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment);

        upload = (Button)findViewById(R.id.buttonAssUploadFile);
        selectfile = (Button)findViewById(R.id.buttonAssSelectFile);
        tvfile = (TextView) findViewById(R.id.tvAssFileDetails);

        firebaseStorage = FirebaseStorage.getInstance();
        firebaseDatabase =  FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        db.collection("Users").document(FirebaseAuth.getInstance().getCurrentUser().getUid())
                .get().addOnCompleteListener(task -> {
            if(task.isSuccessful() && task.getResult() != null){
                fullName = task.getResult().getString("FullName");
                //other stuff
            }//deal with error
            if(!task.isSuccessful()){
                Toast.makeText(Assignment.this,"There was some problem retrieving data",Toast.LENGTH_LONG).show();
            }
        });

        selectfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Assignment.this,"Accepted File Format is \"PDF\"",Toast.LENGTH_SHORT).show();
                if(ContextCompat.checkSelfPermission(Assignment.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectPDF();
                }else{
                    ActivityCompat.requestPermissions(Assignment.this,new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }

        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdfURL!=null){
                    uploadFile();
                }else{
                    Toast.makeText(Assignment.this,"Select a file",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void selectPDF() {
        Intent intent = new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    private void uploadFile() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading File ... ");
        progressDialog.setProgress(0);
        progressDialog.show();

        String filename = System.currentTimeMillis() + " ";
        StorageReference storageReference = firebaseStorage.getReference();
        storageReference.child("Student Uploads").child(fullName).child(filename).putFile((pdfURL))
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(Assignment.this,"File Uploaded Successfully",Toast.LENGTH_LONG).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Assignment.this,"File Upload Failed \n"+e,Toast.LENGTH_SHORT).show();
                    }
                }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                int currentprogress = (int) (100*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                progressDialog.setProgress(currentprogress);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==86 && resultCode==RESULT_OK && data!=null){
            pdfURL =  data.getData();
            tvfile.setText("File = "+data.getData().getPath());
        }else{
            Toast.makeText(Assignment.this,"Please select a file!",Toast.LENGTH_SHORT).show();
        }
    }
}

