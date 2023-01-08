package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AdapterCandidate extends RecyclerView.Adapter<AdapterCandidate.CandidateViewHolder>{

    private List<Candidate> candidateList;

    AdapterCandidate(List<Candidate> candidateList){
        this.candidateList = candidateList;
    }

    @NonNull
    @Override
    public CandidateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.candidate_progressbar, parent, false);
        return new CandidateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateViewHolder viewHolder, int position) {
        Candidate candidate = candidateList.get(position);
        viewHolder.name.setText(candidate.getName());
        viewHolder.party.setText(candidate.getParty());
    }

    @Override
    public int getItemCount() {
        return candidateList.size();
    }

    public class CandidateViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView party;

        public CandidateViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.candidateNameTV);
            party = itemView.findViewById(R.id.partyNameTV);
        }
    }
}
