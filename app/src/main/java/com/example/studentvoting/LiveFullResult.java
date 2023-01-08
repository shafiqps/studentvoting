package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class LiveFullResult extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_live_full_result, container, false);

        recyclerView = rootView.findViewById(R.id.livefullresultRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(LiveFullResult.this.getContext()));
        recyclerView.setHasFixedSize(true);
        AdapterFaculty adapterFaculty = new AdapterFaculty(facultyList());
        recyclerView.setAdapter(adapterFaculty);

        // Inflate the layout for this fragment
        return rootView;
    }

    private List<Faculty> facultyList(){
        List<Faculty> facultyList = new ArrayList<>();

        Faculty faculty = new Faculty("FSKTM", candidateList());
        facultyList.add(faculty);

        Faculty faculty1 = new Faculty("FLL", candidateList());
        facultyList.add(faculty1);

        return facultyList;
    }

    private List<Candidate> candidateList(){
        List<Candidate> candidateList = new ArrayList<>();

        candidateList.add(new Candidate("Abu", "Ayam", "FSKTM"));
        candidateList.add(new Candidate("Ho", "Ikan", "FLL"));
        return candidateList;
    }
}