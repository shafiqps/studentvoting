package com.example.studentvoting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class AdapterCompetingCandidates extends RecyclerView.Adapter<AdapterCompetingCandidates.ViewHolder> {
    private List<Candidate> comp_candidates;
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;

    public AdapterCompetingCandidates(List<Candidate> candidateList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.comp_candidates=candidateList;
        this.context=context;
        this.recyclerViewInterface=recyclerViewInterface;
    }

    @Override
    public AdapterCompetingCandidates.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_competing_candidates,parent, false);
        ViewHolder viewHolder = new ViewHolder(view, recyclerViewInterface);


        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCompetingCandidates.ViewHolder holder, int position) {
        Candidate candidateList = comp_candidates.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                CandidateProfile candidateProfile = new CandidateProfile();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.relativelayoutfac, candidateProfile).addToBackStack(null).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return comp_candidates.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView candidateName;

        public ViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            candidateName = itemView.findViewById(R.id.candidatelistTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface!=null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);

                        }
                    }

                }
            });
           };
        }
    }

