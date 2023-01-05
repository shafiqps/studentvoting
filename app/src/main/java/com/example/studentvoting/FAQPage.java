package com.example.studentvoting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class FAQPage extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_faq_page, container, false);
        ImageButton BtnPrevResult = (ImageButton) rootView.findViewById(R.id.BtnPrevResult);
        BtnPrevResult.setOnClickListener(this::onClick);
        return rootView;
    }

    private void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.BtnPrevResult:
                fragment = new SettingsPage();
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
