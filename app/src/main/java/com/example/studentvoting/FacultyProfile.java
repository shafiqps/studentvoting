package com.example.studentvoting;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FacultyProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FacultyProfile extends Fragment implements RecyclerViewInterface {
    String currentFac = MainActivity.currentfacultyPage;
    DatabaseReference reff;

    List<String> candidatenigga = new ArrayList<>();
    List<String> partynigga = new ArrayList<>();
    ArrayList<CandidateList> candidateList = new ArrayList<>();
    int[] gambau = {R.drawable.asalboleh};
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FacultyProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FacultyProfile.
     */
    // TODO: Rename and change types and number of parameters
    public static FacultyProfile newInstance(String param1, String param2) {
        FacultyProfile fragment = new FacultyProfile();
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

    private void setUpCandidateList(){
//        String[] babis = candidatenigga.toArray(new String[candidatenigga.size()]);
//        String[] party = partynigga.toArray(new String[partynigga.size()]);
//        for(int i=0; i< babis.length;i++){
//            candidateList.add(new CandidateList(babis[i],party[i],gambau[i]));
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        reff.child("Faculty/"+currentFac+"/candidates").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot :  snapshot.getChildren()){
                    String name = dataSnapshot.child("name").getValue(String.class);
                    String party = dataSnapshot.child("party").getValue(String.class);
                    Log.i("demo",party);
                    candidateList.add(new CandidateList(name,party,gambau[0]));
//
//                    candidatenigga.add(name);
//                    partynigga.add(party);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        View rootview = inflater.inflate(R.layout.fragment_faculty_profile, container, false);
        View view = inflater.inflate(R.layout.list_competing_candidates, container, false);
        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recyclerViewfac);
        ImageButton BtnPrevResult = (ImageButton) rootview.findViewById(R.id.BtnPrevResult);
        TextView tv = rootview.findViewById(R.id.facultyTV);
        rv.setOnClickListener(this::onClick);
        BtnPrevResult.setOnClickListener(this::onClick);
//        setUpCandidateList();
        rv.setLayoutManager(new LinearLayoutManager(FacultyProfile.this.getContext()));
        CompetingCandidatesAdapter adapterCompetingCandidates = new CompetingCandidatesAdapter(this.getContext(), candidateList, this);
        rv.setAdapter(adapterCompetingCandidates);


        return rootview;
    }

    private void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.BtnPrevResult:
                if (getFragmentManager().getBackStackEntryCount() != 0) {
                    getFragmentManager().popBackStack();
                }
                break;
            case R.id.recyclerView:
                fragment = new FacultyProfile();
                replaceFragment(fragment);
                break;
        }
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


    @Override
    public void onItemClick(int position) {
    }
}