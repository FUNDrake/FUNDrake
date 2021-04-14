package com.f_u_ndrake.alphacollegeapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.DocumentSnapshot;

public class StudentAdapter extends FirestoreRecyclerAdapter<StudentClass, StudentAdapter.StudentHolder> {

    private OnItemClickListener listener;
    private boolean isSelectedAll;

    public StudentAdapter(@NonNull FirestoreRecyclerOptions<StudentClass> options) { super(options);
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_student,parent,false);
        return new StudentHolder(v);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public StudentClass getItem(int position) {
        return super.getItem(position);
    }

    public void selectAll(){
        Log.e("onClickSelectAll","yes");
        isSelectedAll = true;
        notifyDataSetChanged();
    }

    @Override
    protected void onBindViewHolder(@NonNull StudentHolder holder, int position, @NonNull StudentClass model) {
        holder.checkBox.setText(model.getFullName());

    }

    class StudentHolder extends RecyclerView.ViewHolder{
        CheckBox checkBox;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            checkBox =  itemView.findViewById(R.id.checkBoxAttend);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    String name = checkBox.getText().toString();
                    if(position != RecyclerView.NO_POSITION && listener != null){
                        listener.onItemClick(getSnapshots().getSnapshot(position),position);
                    }


                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(DocumentSnapshot documentSnapshot, int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
}


