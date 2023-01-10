package com.example.studentvoting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class SearchPage extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_search_page, container, false);

        //ImageButton btnPrevResult = (ImageButton) rootView.findViewById(R.id.btnPrevResult);
        //btnPrevResult.setOnClickListener(this::onClick);

        return rootView ;
    }
}
