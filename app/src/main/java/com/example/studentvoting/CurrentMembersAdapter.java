package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CurrentMembersAdapter extends RecyclerView.Adapter<CurrentMembersAdapter.MyViewHolder>{

    Context context;
    ArrayList<currentMembers> currentMembersArrayList;
    public CurrentMembersAdapter (Context context, ArrayList<currentMembers> currentMembersArrayList){
        this.context = context;
        this.currentMembersArrayList = currentMembersArrayList;
    }

    @NonNull
    @Override
    public CurrentMembersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_current_members,parent,false);

        return new CurrentMembersAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentMembersAdapter.MyViewHolder holder, int position) {

        holder.name.setText(currentMembersArrayList.get(position).getName());
        Picasso.get().load(currentMembersArrayList.get(position).getImage()).into(holder.imageMember);
//        holder.imageMember.setImageResource(currentMembersArrayList.get(position).getImage());
        holder.position.setText(currentMembersArrayList.get(position).getPosition());
    }

    @Override
    public int getItemCount() {
        return currentMembersArrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name, position;
        ImageView imageMember;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageMember = itemView.findViewById(R.id.imageMember1);
            name = itemView.findViewById(R.id.member1NAME);
            position = itemView.findViewById(R.id.member1POS);
        }
    }
}
