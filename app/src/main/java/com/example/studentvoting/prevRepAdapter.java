package com.example.studentvoting;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class prevRepAdapter extends RecyclerView.Adapter<prevRepAdapter.MyViewHolder>{

    Context context;
    ArrayList<prevRep> prevRep;

    public prevRepAdapter (Context context, ArrayList<prevRep> prevRep){
        this.context = context;
        this.prevRep = prevRep;
    }
    @NonNull
    @Override
    public prevRepAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_previous_rep,parent,false);

        return new prevRepAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull prevRepAdapter.MyViewHolder holder, int position) {

        holder.session.setText(prevRep.get(position).getSession());
        holder.name.setText(prevRep.get(position).getName());
        holder.imagerep.setImageResource(prevRep.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return prevRep.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView session;
        ImageView imagerep;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            session = itemView.findViewById(R.id.sessionRep1);
            imagerep = itemView.findViewById(R.id.imageRep1);
            name = itemView.findViewById(R.id.rep1);
        }
    }
}
