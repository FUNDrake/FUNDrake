package com.f_u_ndrake.alphacollegeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class StudentAdapter extends FirestoreRecyclerAdapter<StudentClass, StudentAdapter.StudentHolder> {

    public StudentAdapter(@NonNull FirestoreRecyclerOptions<StudentClass> options) { super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull StudentHolder holder, int position, @NonNull StudentClass model) {
        holder.textViewStudName.setText(model.getFullName());
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_student,parent,false);
        return new StudentHolder(v);
    }

    class StudentHolder extends RecyclerView.ViewHolder{
        TextView textViewStudName;
        CheckBox checkBox;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            textViewStudName = itemView.findViewById(R.id.listStudentname);
            checkBox =  itemView.findViewById(R.id.checkBoxAttend);
        }
    }
}
