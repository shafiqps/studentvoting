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

    private ArrayList<Faculty> facultyList(){
        ArrayList<Faculty> facultyList = new ArrayList<>();

        Faculty faculty1 = new Faculty("Academy of Islamic Studies", candidateList());
        facultyList.add(faculty1);

        Faculty faculty2 = new Faculty("Academy of Malay Studies", candidateList());
        facultyList.add(faculty2);

        Faculty faculty3 = new Faculty("Faculty of Arts and Social Sciences", candidateList());
        facultyList.add(faculty3);

        Faculty faculty4 = new Faculty("Faculty of Built Environment", candidateList());
        facultyList.add(faculty4);

        Faculty faculty5 = new Faculty("Faculty of Business and Accountancy", candidateList());
        facultyList.add(faculty5);

        Faculty faculty6 = new Faculty("Faculty of Computer Science and Information Technology", candidateList());
        facultyList.add(faculty6);

        Faculty faculty7 = new Faculty("Faculty of Creative Arts", candidateList());
        facultyList.add(faculty7);

        Faculty faculty8 = new Faculty("Faculty of Dentistry", candidateList());
        facultyList.add(faculty8);

        Faculty faculty9 = new Faculty("Faculty of Economics and Administration", candidateList());
        facultyList.add(faculty9);

        Faculty faculty10 = new Faculty("Faculty of Education", candidateList());
        facultyList.add(faculty10);

        Faculty faculty11 = new Faculty("Faculty of Engineering", candidateList());
        facultyList.add(faculty11);

        Faculty faculty12 = new Faculty("Faculty of Languages and Linguistics", candidateList());
        facultyList.add(faculty12);

        Faculty faculty13 = new Faculty("Faculty of Law", candidateList());
        facultyList.add(faculty13);

        Faculty faculty14 = new Faculty("Faculty of Medicine", candidateList());
        facultyList.add(faculty14);

        Faculty faculty15 = new Faculty("Faculty of Science", candidateList());
        facultyList.add(faculty15);

        Faculty faculty16 = new Faculty("Faculty of Sports and Exercise Science", candidateList());
        facultyList.add(faculty16);
        return facultyList;
    }

    private ArrayList<Candidate> candidateList(){
        ArrayList<Candidate> candidateList = new ArrayList<>();

        candidateList.add(new Candidate("Abu","Ayam", "FSKTM"));
        candidateList.add(new Candidate("Ho", "Ikan", "FLL"));
        return candidateList;
    }
}