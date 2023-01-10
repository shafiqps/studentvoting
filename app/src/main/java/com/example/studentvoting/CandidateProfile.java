package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CandidateProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CandidateProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    DatabaseReference reff;
    DatabaseReference reff2;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<featuredInfo> featuredInfoArrayList = new ArrayList<>();
    int[] gambau = {R.drawable.asalboleh};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CandidateProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CandidateProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static CandidateProfile newInstance(String param1, String param2) {
        CandidateProfile fragment = new CandidateProfile();
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

    public void setUpFeaturedInfo(){
        String[] info = getResources().getStringArray(R.array.info);

        for(int i=0; i<info.length;i++){
            featuredInfoArrayList.add(new featuredInfo(gambau[0],info[i]));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String candidateID = MainActivity.candidateID;
        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        reff2 = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        // Inflate the layout for this fragment


        View rootview = inflater.inflate(R.layout.fragment_candidate_profile, container, false);
        View view = inflater.inflate(R.layout.list_featured_info, container, false);
        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recyclerViewInfo);
        ImageButton BtnPrev = (ImageButton) rootview.findViewById(R.id.BtnPrev);
        BtnPrev.setOnClickListener(this::onClick);

        TextView nameTV = (TextView) rootview.findViewById(R.id.partyNameTV);
        TextView facultyTV = (TextView) rootview.findViewById(R.id.facultyTV);
        TextView positionTV = (TextView) rootview.findViewById(R.id.positionTV);
        TextView partyTV = (TextView) rootview.findViewById(R.id.partyTV);
        reff.child("Candidate/"+candidateID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String name = snapshot.child("name").getValue(String.class);
                final String faculty = snapshot.child("faculty").getValue(String.class);
                final String position = snapshot.child("position").getValue(String.class);
                final String party = snapshot.child("party").getValue(String.class);

                nameTV.setText(name);
                partyTV.setText(party);
                facultyTV.setText(faculty);
                positionTV.setText(position);
//                Picasso.get().load(link).into(rImage);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        reff2.child("Candidate/"+candidateID+"/featuredInfo").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :  snapshot.getChildren()){
                    String description = dataSnapshot.child("description").getValue(String.class);
//                    String image = dataSnapshot.child("image").getValue(String.class);
                    featuredInfoArrayList.add(new featuredInfo(gambau[0],description));

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
//        setUpFeaturedInfo();
        featuredInfoAdapter featuredInfoAdapter = new featuredInfoAdapter(this.getContext(), featuredInfoArrayList);
        rv.post(new Runnable(){ @Override public void run(){ featuredInfoAdapter.notifyDataSetChanged();}});
        rv.setAdapter(featuredInfoAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));

        partyTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.partybro = partyTV.toString();
                Fragment fragment = null;
                fragment = new PartyProfile();
                replaceFragment(fragment);
            }
        });
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