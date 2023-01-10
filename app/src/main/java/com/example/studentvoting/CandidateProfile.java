package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CandidateProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CandidateProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
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
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_candidate_profile, container, false);
        View view = inflater.inflate(R.layout.list_featured_info, container, false);
        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recyclerViewInfo);
        ImageButton BtnPrev = (ImageButton) rootview.findViewById(R.id.BtnPrev);
        BtnPrev.setOnClickListener(this::onClick);

        setUpFeaturedInfo();
        featuredInfoAdapter featuredInfoAdapter = new featuredInfoAdapter(this.getContext(), featuredInfoArrayList);
        rv.setAdapter(featuredInfoAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));
        TextView partyTV = (TextView) rootview.findViewById(R.id.partyTV);
        partyTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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