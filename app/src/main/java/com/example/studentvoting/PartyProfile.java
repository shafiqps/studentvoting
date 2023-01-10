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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PartyProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PartyProfile extends Fragment {

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
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_party_profile, container, false);
        //View view = inflater.inflate(R.layout.list_current_members, container, false);
        RecyclerView rv = (RecyclerView) rootview.findViewById(R.id.recyclerViewparty);
        ImageButton BtnPrev = (ImageButton) rootview.findViewById(R.id.BtnPrev);
        BtnPrev.setOnClickListener(this::onClick);
        setUpCurrentMembers();
        CurrentMembersAdapter currentMembersAdapter = new CurrentMembersAdapter(this.getContext(), currentMembersArrayList);
        rv.setAdapter(currentMembersAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext(), LinearLayoutManager.HORIZONTAL,false));


        RecyclerView rv2 = (RecyclerView) rootview.findViewById(R.id.recyclerViewmanifesto);
        ManifestoAdapter manifestoAdapter = new ManifestoAdapter(this.getContext(), manifestoArrayList);
        setUpManifesto();
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