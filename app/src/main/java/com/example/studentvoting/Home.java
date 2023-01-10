package com.example.studentvoting;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class Home extends Fragment implements RecyclerViewInterface {

    //private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private String[] newsDescription;
    private int[] imageResourceID;
    private RecyclerView recyclerview;
    private RecyclerViewInterface recylerViewInterface;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ((MainActivity)getActivity()).showBottomNav();

        Button BtnToResult = (Button) rootView.findViewById(R.id.buttonToResultPage);

        BtnToResult.setOnClickListener(this::onClick);

        //dataInitialize();
        recyclerview = rootView.findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext())); //getActivity()
        recyclerview.setHasFixedSize(true);

        News[] news = new News[]{
                new News("Angkatan Mahasiswa", "Majoriti 112 kerusi adalah sasaran utama Angakatan", R.drawable.news1),
                new News("Mahasiswa Progresif", "Perubahan keadaan politik merisaukan semua mahasiswa/i", R.drawable.news2),
                new News("Neo Siswa", "Keadilan ingin dituntut atas tindakan MP melompat parti ", R.drawable.news3),
                new News("Angkatan Mahasiswa", "Keadilan ingin dituntut atas tindakan MP melompat parti ", R.drawable.news4),
                new News("UM Chanselor", "Mahasiswa/i perlu membuat pilihan yang bijak dan tepat ", R.drawable.news5),
                new News("Associate Prof Dr Ali", "Masa hadapan kepimpinan mahasiswa/i terletak pada undian semua", R.drawable.news6),
                new News("Mohd Anuar", "Sebagai wakil parti saya membawa mandat yang besar", R.drawable.news7),
                new News("Astro Awani", "Pilihanraya Umum yang ke 19 Universiti Malaya menjadi tumpuan negara", R.drawable.news8),
                new News("Jejaka Sengkek", "Kemelut menyiapkan tugasan MAD semakin dirasai", R.drawable.news9),

        };


        AdapterNews adapter_news = new AdapterNews(news,Home.this, this); //(list, clickListener this)
        recyclerview.setAdapter(adapter_news);

        return rootView;
    }



    public void onClick(View view) {
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

    @Override
    public void onItemClick(int position) {

    }

}