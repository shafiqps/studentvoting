package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsPage extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SettingsPage() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingsPage.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingsPage newInstance(String param1, String param2) {
        SettingsPage fragment = new SettingsPage();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings_page, container, false);
        Button BtnToResult = (Button) rootView.findViewById(R.id.FAQbtn);

        BtnToResult.setOnClickListener(this::onClick);

        Button BtnToResult2 = (Button) rootView.findViewById(R.id.FeedbackBTN);

        BtnToResult2.setOnClickListener(this::onClick);

        Button BtnToResult3 = (Button) rootView.findViewById(R.id.logoutBTN);

        BtnToResult3.setOnClickListener(this::onClick);

        return rootView;
    }

    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.FAQbtn:
                fragment = new FAQPage();
                replaceFragment(fragment);
                break;
            case R.id.FeedbackBTN:
                fragment = new Feedback();
                replaceFragment(fragment);
                break;
            case R.id.logoutBTN:

                fragment = new Login();
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