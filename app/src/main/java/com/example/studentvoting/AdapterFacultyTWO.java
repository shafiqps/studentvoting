package com.example.studentvoting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterFacultyTWO extends RecyclerView.Adapter<AdapterFacultyTWO.MyViewHolder> {

    Context context;
    ArrayList<Faculty> facultyList;
    private  RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    @NonNull
    @Override
    public AdapterFacultyTWO.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater =  LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_competing_candidates, parent, false);
        return new AdapterFacultyTWO.MyViewHolder(view);
    }

    public AdapterFacultyTWO(Context context, ArrayList<Faculty> facultyList){
        this.context = context;
        this.facultyList = facultyList;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFacultyTWO.MyViewHolder holder, int position) {
        Faculty faculty = facultyList.get(position);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(holder.ChildRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL,
                false);

        holder.facName.setText(facultyList.get(position).getName());
        layoutManager.setInitialPrefetchItemCount(faculty.getCandidateList().size());

        AdapterCandidate adapterCandidate = new AdapterCandidate(faculty.getCandidateList());
        holder.ChildRecyclerView.setLayoutManager(layoutManager);
        holder.ChildRecyclerView.setAdapter(adapterCandidate);
        holder.ChildRecyclerView.setRecycledViewPool(viewPool);

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
        return facultyList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView facName;
        private RecyclerView ChildRecyclerView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            facName = itemView.findViewById(R.id.facNameTV);
            ChildRecyclerView = itemView.findViewById(R.id.candidateprogressRV);
        }
    }
}
