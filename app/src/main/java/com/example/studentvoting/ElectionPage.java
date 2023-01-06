package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ElectionPage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_election_page, container, false);

        Button BtnToCastVote = (Button) rootView.findViewById(R.id.goToVotingButton);
        Button BtnToResult = (Button) rootView.findViewById(R.id.buttonToResultPage);
        TextView tvToImportantDates = (TextView) rootView.findViewById(R.id.textView16);

        BtnToResult.setOnClickListener(this::onClick1);
        BtnToCastVote.setOnClickListener(this::onClick);
        tvToImportantDates.setOnClickListener(this::onClick2);

        return rootView;
    }

    private void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.goToVotingButton:
                fragment = new VoteCast();
                replaceFragment(fragment);
                break;
        }
    }
    public void onClick1(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.buttonToResultPage:
                fragment = new Result();
                replaceFragment(fragment);
                break;
        }
    };

    private void onClick2(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.textView16:
                fragment = new ImportantDates();
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