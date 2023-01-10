package com.example.studentvoting;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFaculty extends RecyclerView.Adapter<AdapterFaculty.FacultyViewHolder> {

    private  RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private List<Faculty> facultyList;

    AdapterFaculty(List<Faculty> facultyList){
        this.facultyList = facultyList;
    }

    @NonNull
    @Override
    public FacultyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.livefullresult_cardview, parent, false);
        return new FacultyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacultyViewHolder viewHolder, int position) {
        Faculty faculty = facultyList.get(position);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(viewHolder.ChildRecyclerView.getContext(),
                LinearLayoutManager.VERTICAL,
                false);

        viewHolder.facName.setText(faculty.getName());
        layoutManager.setInitialPrefetchItemCount(faculty.getCandidateList().size());

        AdapterCandidate adapterCandidate = new AdapterCandidate(faculty.getCandidateList());
        viewHolder.ChildRecyclerView.setLayoutManager(layoutManager);
        viewHolder.ChildRecyclerView.post(new Runnable(){ @Override public void run(){ adapterCandidate.notifyDataSetChanged(); } });
        viewHolder.ChildRecyclerView.setAdapter(adapterCandidate);

        viewHolder.ChildRecyclerView.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return facultyList.size();
    }

    public class FacultyViewHolder extends RecyclerView.ViewHolder {
        private TextView facName;
        private RecyclerView ChildRecyclerView;

        public FacultyViewHolder(@NonNull View itemView) {
            super(itemView);
            facName = itemView.findViewById(R.id.facNameTV);
            ChildRecyclerView = itemView.findViewById(R.id.candidateprogressRV);
        }
    }
}
