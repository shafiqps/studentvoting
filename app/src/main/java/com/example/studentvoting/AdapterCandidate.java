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


public class AdapterCandidate extends RecyclerView.Adapter<AdapterCandidate.ViewHolder>{

    Candidate[] candidates;
    Context context;

    public AdapterCandidate(Candidate[] candidates, LiveFullResult liveFullResult){
        this.candidates = candidates;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.livefullresult_cardview, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCandidate.ViewHolder holder, int position) {
        final Candidate candidateList = candidates[position];
        holder.nameTextView.setText(candidateList.getName());
        holder.partyTextView.setText(candidateList.getParty());
        holder.facultyTextView.setText(candidateList.getFaculty());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, candidateList.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { return candidates.length;}

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        public TextView nameTextView;
        public TextView partyTextView;
        public TextView facultyTextView;

        public ViewHolder(View v) {
            super(v);
            cardView = (CardView) v.findViewById(R.id.livefullresultCV);
            nameTextView = (TextView) v.findViewById(R.id.candidateNameTV);
            partyTextView = (TextView) v.findViewById(R.id.partyNameTV);
            facultyTextView = (TextView) v.findViewById(R.id.facNameTV);
        }
    }
}
