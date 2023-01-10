package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartyProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyProfile extends Fragment {
DatabaseReference reff;
DatabaseReference reff2;
DatabaseReference reff3;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<currentMembers> currentMembersArrayList = new ArrayList<>();
    ArrayList<Manifesto> manifestoArrayList = new ArrayList<>();
    int[] gambau = {R.drawable.asalboleh};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PartyProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PartyProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static PartyProfile newInstance(String param1, String param2) {
        PartyProfile fragment = new PartyProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    public void setUpCurrentMembers(){
        String[] members = getResources().getStringArray(R.array.member);
        String[] position = getResources().getStringArray(R.array.position);

        for(int i=0; i<members.length;i++){
            currentMembersArrayList.add(new currentMembers(members[i],position[i],gambau[0]));
        }
    }

    public void setUpManifesto(){
        String[] manifesto = getResources().getStringArray(R.array.manifesto);

        for(int i=0; i<manifesto.length;i++){
            manifestoArrayList.add(new Manifesto(manifesto[i]));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String partyID = MainActivity.partybro;
        // Inflate the layout for this fragment
        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        reff3 = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        reff2 = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        currentMembersArrayList.clear();
        View rootview = inflater.inflate(R.layout.fragment_party_profile, container, false);
        //View view = inflater.inflate(R.layout.list_current_members, container, false);
        TextView partyName = rootview.findViewById(R.id.partyNameTV);
        TextView aboutTV = rootview.findViewById(R.id.about_TV);

        partyName.setText(partyID);

        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recyclerViewparty);
        ImageButton BtnPrev = (ImageButton) rootview.findViewById(R.id.BtnPrev);
        BtnPrev.setOnClickListener(this::onClick);
//        setUpCurrentMembers();

        reff.child("Party/"+partyID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String about = snapshot.child("about").getValue(String.class);


                aboutTV.setText(about);

//                Picasso.get().load(link).into(rImage);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        reff.child("Party/"+partyID+"/currentmembers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :  snapshot.getChildren()){
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String position = dataSnapshot.child("position").getValue(String.class);
                    currentMembersArrayList.add(new currentMembers(name,position,gambau[0]));
//
//                    candidatenigga.add(name);
//                    partynigga.add(party);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        CurrentMembersAdapter currentMembersAdapter = new CurrentMembersAdapter(this.getContext(), currentMembersArrayList);
        rv.post(new Runnable(){ @Override public void run(){ currentMembersAdapter.notifyDataSetChanged();}});

        rv.setAdapter(currentMembersAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));

        reff2.child("Party/"+partyID+"/manifesto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :  snapshot.getChildren()){
                    String content = dataSnapshot.child("content").getValue(String.class);
                    manifestoArrayList.add(new Manifesto(content));
//
//                    candidatenigga.add(name);
//                    partynigga.add(party);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        RecyclerView rv2 = (RecyclerView) rootview.findViewById(R.id.recyclerViewmanifesto);
        ManifestoAdapter manifestoAdapter = new ManifestoAdapter(this.getContext(), manifestoArrayList);
        rv.post(new Runnable(){ @Override public void run(){ manifestoAdapter.notifyDataSetChanged();}});
//        setUpManifesto();
        rv2.setAdapter(manifestoAdapter);
        rv2.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return rootview;
    }

    private void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.BtnPrev:
                if (getFragmentManager().getBackStackEntryCount() != 0) {
                    getFragmentManager().popBackStack();
                }
                break;
        }
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}