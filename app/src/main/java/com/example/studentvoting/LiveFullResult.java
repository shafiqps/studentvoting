package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import java.util.ArrayList;
import java.util.List;

public class LiveFullResult extends Fragment {

    private RecyclerView recyclerView;
    DatabaseReference reff;
//    ArrayList<FacultyList> candidateList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live_full_result, container, false);


        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

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
//
//        reff.child("Faculty").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                for(DataSnapshot dataSnapshot :  snapshot.getChildren()){
//                    String name = dataSnapshot.getKey();
//
//                    facultyList.add(new Faculty(name, candidateList()));
//
//                }
//
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        Faculty faculty1 = new Faculty("Academy of Islamic Studies", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty1);

        Faculty faculty2 = new Faculty("Academy of Malay Studies", candidateList("Faculty of Computer Science and Information Technology"));
        facultyList.add(faculty2);

        Faculty faculty3 = new Faculty("Faculty of Arts and Social Sciences", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty3);

        Faculty faculty4 = new Faculty("Faculty of Built Environment", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty4);

        Faculty faculty5 = new Faculty("Faculty of Business and Accountancy", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty5);

        Faculty faculty6 = new Faculty("Faculty of Computer Science and Information Technology", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty6);

        Faculty faculty7 = new Faculty("Faculty of Creative Arts", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty7);

        Faculty faculty8 = new Faculty("Faculty of Dentistry", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty8);

        Faculty faculty9 = new Faculty("Faculty of Economics and Administration", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty9);

        Faculty faculty10 = new Faculty("Faculty of Education", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty10);

        Faculty faculty11 = new Faculty("Faculty of Engineering", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty11);

        Faculty faculty12 = new Faculty("Faculty of Languages and Linguistics", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty12);

        Faculty faculty13 = new Faculty("Faculty of Law", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty13);

        Faculty faculty14 = new Faculty("Faculty of Medicine", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty14);

        Faculty faculty15 = new Faculty("Faculty of Science", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty15);

        Faculty faculty16 = new Faculty("Faculty of Sports and Exercise Science", candidateList("Academy of Islamic Studies"));
        facultyList.add(faculty16);
        return facultyList;
    }

    private ArrayList<Candidate> candidateList(String facultyname){
        ArrayList<Candidate> candidateList = new ArrayList<>();


        reff.child("Faculty/"+facultyname+"/candidates").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :  snapshot.getChildren()){
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String party = dataSnapshot.child("party").getValue(String.class);
                    Log.i("demo",party);
                    candidateList.add(new Candidate(name,party,facultyname));

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

//        candidateList.add(new Candidate("Abu", "Ayam", "FSKTM"));
//        candidateList.add(new Candidate("Ho", "Ikan", "FLL"));
        return candidateList;
    }
}