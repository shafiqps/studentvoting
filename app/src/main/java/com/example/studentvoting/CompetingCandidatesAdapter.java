package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CompetingCandidatesAdapter extends RecyclerView.Adapter<CompetingCandidatesAdapter.MyViewHolder> {

    Context context;
    private final RecyclerViewInterface recyclerViewInterface;
    ArrayList<CandidateList> candidateList;
    @NonNull
    @Override
    public CompetingCandidatesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_competing_candidates, parent, false);
        return new CompetingCandidatesAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    public CompetingCandidatesAdapter(Context context, ArrayList<CandidateList> candidateList, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.candidateList = candidateList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @Override
    public void onBindViewHolder(@NonNull CompetingCandidatesAdapter.MyViewHolder holder, int position) {
        holder.tv.setText(candidateList.get(position).getName());
        holder.tv2.setText(candidateList.get(position).getParty());
        Picasso.get().load(candidateList.get(position).getImage()).into(holder.imageView);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.candidateID = candidateList.get(holder.getAdapterPosition()).getId();

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                CandidateProfile candidateProfile = new CandidateProfile();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.relativelayoutfac, candidateProfile).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return candidateList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tv;
        TextView tv2;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            imageView = itemView.findViewById(R.id.gambau);
            tv = itemView.findViewById(R.id.candidatelistTV);
            tv2 = itemView.findViewById(R.id.partylistTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface!=null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
