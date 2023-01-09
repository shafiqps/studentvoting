package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompetingCandidatesAdapter extends RecyclerView.Adapter<CompetingCandidatesAdapter.MyViewHolder> {

    Context context;
    ArrayList<CandidateList> candidateList;
    @NonNull
    @Override
    public CompetingCandidatesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_competing_candidates, parent, false);
        return new CompetingCandidatesAdapter.MyViewHolder(view);
    }

    public CompetingCandidatesAdapter(Context context, ArrayList<CandidateList> candidateList){
        this.context = context;
        this.candidateList = candidateList;
    }

    @Override
    public void onBindViewHolder(@NonNull CompetingCandidatesAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(candidateList.get(position).getName());
        holder.tv2.setText(candidateList.get(position).getParty());
        holder.imageView.setImageResource(candidateList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return candidateList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv;
        TextView tv2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gambau);
            tv = itemView.findViewById(R.id.candidatelistTV);
            tv2 = itemView.findViewById(R.id.partylistTV);
        }
    }
}
