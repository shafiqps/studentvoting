package com.example.studentvoting;

import android.app.Activity;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class VoteCast extends Fragment {

    //candidate selection using radio button
    RadioGroup radioGroup;
    RadioButton radioButton;
    Fragment ElectionPage;
    Activity context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_vote_cast, container, false);

        context = getActivity();
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

        ImageButton btnprevResult = (ImageButton) rootView.findViewById(R.id.btnprevResult);
        btnprevResult.setOnClickListener(this::onClick);

        return rootView;
    }

    public void onClick(View view){
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.btnprevResult:
                if (getFragmentManager().getBackStackEntryCount() != 0) {
                    getFragmentManager().popBackStack();
                }
        }
    }

    public void onStart() {
        super.onStart();
        Button confirmBtn = (Button) context.findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FingerPrintActivity.class);
                startActivity(intent);
            }
        });
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}