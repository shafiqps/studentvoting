package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        /*Button BtnToResult = (Button) rootView.findViewById(R.id.buttonToResultPage);
        BtnToResult.setOnClickListener(this::onClick);
        */

        return rootView;
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