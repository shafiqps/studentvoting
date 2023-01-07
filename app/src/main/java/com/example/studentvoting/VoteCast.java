package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class VoteCast extends Fragment {

    //candidate selection using radio button
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_vote_cast, container, false);

        //candidate selection using radio button

        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                switch(checkedButtonId){
                    case R.id.radioBtn1:
                        Toast.makeText(getContext(), "Candidate 1 is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBtn2:
                        Toast.makeText(getContext(), "Candidate 2 is selected", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBtn3:
                        Toast.makeText(getContext(), "Candidate 3 is selected", Toast.LENGTH_SHORT).show();
                        break;
                }


            }
        });

        //confirm Button when done voting
        Button confirmBtn = (Button) rootView.findViewById(R.id.confirmBtn);

        confirmBtn.setOnClickListener(this::onClick);

        return rootView;
    }

    private void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.confirmBtn:
                fragment = new VerifyVote();
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

}