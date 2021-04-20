package com.f_u_ndrake.alphacollegeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class UpdateAdapter extends FirestoreRecyclerAdapter<UpdateEvent, UpdateAdapter.UpdateHolder> {

    public UpdateAdapter(@NonNull FirestoreRecyclerOptions<UpdateEvent> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull UpdateHolder holder, int position, @NonNull UpdateEvent model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getDescription());
        holder.textViewTimestamp.setText(model.getTimestamp().toString());
    }

    @NonNull
    @Override
    public UpdateHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.updateevent,parent,false);
        return new UpdateHolder(v);
    }

    class UpdateHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewDescription;
        TextView textViewTimestamp;

        public UpdateHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.updateTitle);
            textViewDescription = itemView.findViewById(R.id.updateDescription);
            textViewTimestamp = itemView.findViewById(R.id.updateTimestamp);
        }
    }
}
