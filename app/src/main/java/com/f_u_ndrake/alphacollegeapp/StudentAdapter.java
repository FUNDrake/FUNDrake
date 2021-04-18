package com.f_u_ndrake.alphacollegeapp;

import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder>{
    private ArrayList<StudentClass> studentClassArrayList;
    public static List<String> presentArray = new ArrayList<>();
    public static List<String> absentArray = new ArrayList<>();
    public SparseBooleanArray array = new SparseBooleanArray();
    private int selectedPosition= -1;
    private Context context;
    boolean selectall,selectnone;

    public StudentAdapter(ArrayList<StudentClass> studentClassArrayList, Context context) {
        this.studentClassArrayList = studentClassArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_student, parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentClass courses = studentClassArrayList.get(position);
        holder.box.setText(courses.getFullName());
        if(selectall){
            holder.box.setChecked(true);
            absentArray.clear();
            presentArray.add(holder.box.getText().toString());
        }if (selectnone) {
            holder.box.setChecked(false);
            presentArray.clear();
            absentArray.clear();
            absentArray.add(holder.box.getText().toString());
        }else{
            absentArray.add(holder.box.getText().toString());
        }

    }

    @Override
    public int getItemCount() {
        return studentClassArrayList.size();
    }

    public List<String> getPresentArray(){
        return presentArray;
    }

    public List<String> getAbsentArray(){
        return absentArray;
    }

    public void mselectall(){
        selectall = true;
        selectnone = false;
        notifyDataSetChanged();
    }

    public void munselectall(){
        selectnone = true;
        selectall = false;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox box;
        Boolean aBoolean;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            box = itemView.findViewById(R.id.checkBoxAttend);
            aBoolean = box.isChecked();
            box.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (box.isChecked()){
                        box.setSelected(true);
                        presentArray.add(box.getText().toString());
                        absentArray.remove(box.getText().toString());
                        //Toast.makeText(itemView.getContext(),"True Selected = "+box.getText().toString(),Toast.LENGTH_SHORT).show();
                    }else {
                        box.setSelected(false);
                        presentArray.remove(box.getText().toString());
                        absentArray.add(box.getText().toString());
                        //Toast.makeText(itemView.getContext(),"False Selected = "+box.getText().toString(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }




}