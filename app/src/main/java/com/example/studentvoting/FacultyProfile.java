package com.example.studentvoting;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FacultyProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FacultyProfile extends Fragment implements RecyclerViewInterface {

    ArrayList<CandidateList> candidateList = new ArrayList<>();
    int[] gambau = {R.drawable.asalboleh, R.drawable.ahmad, R.drawable.asalboleh, R.drawable.ahmad,
            R.drawable.asalboleh, R.drawable.ahmad, R.drawable.asalboleh, R.drawable.ahmad,
            R.drawable.asalboleh, R.drawable.ahmad};
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
        String[] babis = getResources().getStringArray(R.array.candidateLIST);
        String[] party = getResources().getStringArray(R.array.PARTY);

        for(int i=0; i< babis.length;i++){
            candidateList.add(new CandidateList(babis[i],party[i],gambau[i]));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_faculty_profile, container, false);
        View view = inflater.inflate(R.layout.list_competing_candidates, container, false);
        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recyclerViewfac);
        ImageButton BtnPrevResult = (ImageButton) rootview.findViewById(R.id.BtnPrevResult);
        rv.setOnClickListener(this::onClick);
        BtnPrevResult.setOnClickListener(this::onClick);
        setUpCandidateList();
        rv.setLayoutManager(new LinearLayoutManager(FacultyProfile.this.getContext()));
        CompetingCandidatesAdapter adapterCompetingCandidates = new CompetingCandidatesAdapter(this.getContext(), candidateList);
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

    private List<Candidate> compcandidateList(){
        List<Candidate> facultyList = new ArrayList<>();

        Candidate faculty = new Candidate("FSKTM", "babi", "anjing");
        facultyList.add(faculty);

        return facultyList;
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