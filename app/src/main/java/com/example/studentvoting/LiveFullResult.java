package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext())); //getActivity()
        recyclerView.setHasFixedSize(true);

        Candidate[] candidates = new Candidate[]{
                new Candidate("Abu", "Ayam", "FSKTM"),
                new Candidate("Ali", "Ikan", "FLL"),
        };

        AdapterCandidate adapterCandidate = new AdapterCandidate(candidates, LiveFullResult.this);
        recyclerView.setAdapter(adapterCandidate);

        // Inflate the layout for this fragment
        return rootView;
    }
}