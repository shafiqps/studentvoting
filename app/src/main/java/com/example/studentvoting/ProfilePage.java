package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class ProfilePage extends Fragment {
    DatabaseReference reff;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_profile_page, container, false);
        String matrixno = MainActivity.currentlyLoggedIn;
        ImageView rImage = rootview.findViewById(R.id.profile_IV);
        TextView nameTV = (TextView) rootview.findViewById(R.id.partyNameTV);
        TextView addressTV = (TextView) rootview.findViewById(R.id.homeAddress_TV);
        TextView emailTV = (TextView) rootview.findViewById(R.id.email_TV);
        TextView facultyTV = (TextView) rootview.findViewById(R.id.facultyTV);
        TextView matrixnoTV = (TextView) rootview.findViewById(R.id.positionTV);


        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        reff.child("Student").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                final String address = snapshot.child(matrixno).child("address").getValue(String.class);
                final String name = snapshot.child(matrixno).child("name").getValue(String.class);
                final String faculty = snapshot.child(matrixno).child("faculty").getValue(String.class);
                final String siswamail = snapshot.child(matrixno).child("siswamail").getValue(String.class);
                final String link = snapshot.child(matrixno).child("image").getValue(String.class);

                nameTV.setText(name);
                addressTV.setText(address);
                emailTV.setText(siswamail);
                facultyTV.setText(faculty);
                matrixnoTV.setText(matrixno);
                Picasso.get().load(link).into(rImage);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        TextView facTV = (TextView) rootview.findViewById(R.id.facultyTV);
        facTV.setOnClickListener(this::onClick);
        return rootview;
    }

    private void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.facultyTV:
                fragment = new FacultyProfile();
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