package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Home extends Fragment {

    //private ArrayList<News> newsArrayList;
    private String[] newsHeading;
    private String[] newsDescription;
    private int[] imageResourceID;
    private RecyclerView recyclerview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        /*Button BtnToResult = (Button) rootView.findViewById(R.id.buttonToResultPage);
        BtnToResult.setOnClickListener(this::onClick);
        */
        //dataInitialize();
        recyclerview = rootView.findViewById(R.id.recyclerView);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext())); //getActivity()
        recyclerview.setHasFixedSize(true);
//        //Adapter_News adapter_news = new Adapter_News(getContext(), newsArrayList);
//        recyclerview.setAdapter(adapter_news);
//        adapter_news.notifyDataSetChanged();

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

        AdapterNews adapter_news = new AdapterNews(news, Home.this );
        recyclerview.setAdapter(adapter_news);

        return rootView;
    }

//    //for recyclerView news
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//
//    }

//    private void dataInitialize(){
//
//        newsArrayList = new ArrayList<>();
//
//        newsHeading =  new String[]{
//                getString(R.string.head_1),
//                getString(R.string.head_2),
//                getString(R.string.head_3),
//
//        };
//
//        imageResourceID = new int[]{
//
//                R.drawable.news1,
//                R.drawable.news2,
//                R.drawable.news3,
//
//        };
//
//        newsDescription = new String[]{
//                getString(R.string.desc_1),
//                getString(R.string.desc_2),
//                getString(R.string.desc_3),
//
//        };
//
//        for(int i=0; i<newsHeading.length; i++){
//
//            News news = new News(newsHeading[i], newsDescription[i], imageResourceID[i]);
//            newsArrayList.add(news);
//        }
//
//    }

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