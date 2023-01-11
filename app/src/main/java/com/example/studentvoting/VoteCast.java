package com.example.studentvoting;

import android.app.Activity;
import android.content.Intent;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Bundle;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class VoteCast extends Fragment {
    DatabaseReference reff;
    //candidate selection using radio button
    RadioGroup radioGroup;
    RadioButton radioButton;
    Fragment ElectionPage;
    Activity context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String facultyID = MainActivity.currentfacultyPage;
        // Inflate the layout for this fragment
        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        View rootView = inflater.inflate(R.layout.fragment_vote_cast, container, false);
        TextView facultyName = rootView.findViewById(R.id.textFacultyName);
        TextView candidateA = rootView.findViewById(R.id.candidateNameA);
        TextView partyA = rootView.findViewById(R.id.candidatePartyA);
        TextView candidateB = rootView.findViewById(R.id.candidateNameB);
        TextView partyB = rootView.findViewById(R.id.candidatePartyB);
        TextView candidateC = rootView.findViewById(R.id.candidateNameC);
        TextView partyC = rootView.findViewById(R.id.candidatePartyC);

        ImageView imageA = rootView.findViewById(R.id.candidateIVA);
        ImageView imageB = rootView.findViewById(R.id.candidateIVB);
        ImageView imageC = rootView.findViewById(R.id.candidateIVC);


        facultyName.setText(facultyID);
        reff.child("Faculty/"+facultyID+"/candidates").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String nameA = snapshot.child("1").child("name").getValue(String.class);
                final String partA = snapshot.child("1").child("party").getValue(String.class);
                final String urlA = snapshot.child("1").child("image").getValue(String.class);

                final String nameB = snapshot.child("2").child("name").getValue(String.class);
                final String partB = snapshot.child("2").child("party").getValue(String.class);
                final String urlB = snapshot.child("2").child("image").getValue(String.class);

                final String nameC = snapshot.child("3").child("name").getValue(String.class);
                final String partC = snapshot.child("3").child("party").getValue(String.class);
                final String urlC = snapshot.child("3").child("image").getValue(String.class);



                candidateA.setText(nameA);
                partyA.setText(partA);
                candidateB.setText(nameB);
                partyB.setText(partB);
                candidateC.setText(nameC);
                partyC.setText(partC);
                Picasso.get().load(urlA).into(imageA);
                Picasso.get().load(urlB).into(imageB);
                Picasso.get().load(urlC).into(imageC);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        context = getActivity();
        //candidate selection using radio button
        RadioGroup radioGroup = (RadioGroup) rootView.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedButtonId) {
                switch(checkedButtonId){
                    case R.id.radioBtn1:
                        Toast.makeText(getContext(), "Candidate 1 is selected", Toast.LENGTH_SHORT).show();
                        MainActivity.voteChoice=1;
                        break;
                    case R.id.radioBtn2:
                        Toast.makeText(getContext(), "Candidate 2 is selected", Toast.LENGTH_SHORT).show();
                        MainActivity.voteChoice=2;
                        break;
                    case R.id.radioBtn3:
                        Toast.makeText(getContext(), "Candidate 3 is selected", Toast.LENGTH_SHORT).show();
                        MainActivity.voteChoice=3;
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
                VerifyVote fragment = new VerifyVote();
                replaceFragment(fragment);
//                Intent intent = new Intent(context, FingerPrintActivity.class);
//                startActivity(intent);
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