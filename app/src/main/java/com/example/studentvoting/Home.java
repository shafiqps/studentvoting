package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class Home extends Fragment {

    private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    private String[] newsDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        /*Button BtnToResult = (Button) rootView.findViewById(R.id.buttonToResultPage);
        BtnToResult.setOnClickListener(this::onClick);
        */

        return rootView;
    }

    //for recyclerView news
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dataInitialize();
        recyclerview = view.findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerview.setHasFixedSize(true);
        Adapter_News adapter_news = new Adapter_News( newsArrayList);
    }

    private void dataInitialize(){

        newsArrayList = new ArrayList<>();

        newsHeading =  new String[]{
                getString(R.string.head_1),
                getString(R.string.head_2),
                getString(R.string.head_3),

        };

        imageResourceID = new int[]{

                R.drawable.news1,
                R.drawable.news2,
                R.drawable.news3,

        };

        newsDescription = new String[]{
                String.valueOf(R.string.desc_1),
                String.valueOf(R.string.desc_2),
                String.valueOf(R.string.desc_3),

        };

        for(int i=0; i<newsHeading.length; i++){

            News news = new News(newsHeading[i], imageResourceID[i], newsDescription[i]);
            newsArrayList.add(news);
        }

    }

    /*public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.buttonToResultPage:
                fragment = new Result();
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

     */


  /*  @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        Button BtnToResult = view.findViewById(R.id.buttonToResultPage);
        View.OnClickListener OCLToResultPage = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_Home_to_liveMapResult);
            }
        };
        BtnToResult.setOnClickListener(OCLToResultPage);
    }*/
}