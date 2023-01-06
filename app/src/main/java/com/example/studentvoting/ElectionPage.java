package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class ElectionPage extends Fragment implements OnMapReadyCallback {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_election_page, container, false);

        // Map To View Faculties (shoutout umar)
        // Get the MapView from the layout file
        MapView mapView = rootView.findViewById(R.id.mapView);
        // Initialize the MapView
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        // Get the GoogleMap object from the MapView
        mapView.getMapAsync(this);

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

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Set the map boundary to Universiti Malaya
        LatLngBounds universitiMalayaBounds = new LatLngBounds(
                new LatLng(3.108039056846274, 101.64099811309444), // South West corner
                new LatLng(3.136480273984235, 101.66289173863183)); // North East corner

        LatLng universitiMalayaCenter = new LatLng(3.1225205575356245, 101.6546364500923); // Center of Universiti Malaya

        int zoomLevel = 14; // This value can be from 2.0 to 21.0

        googleMap.setLatLngBoundsForCameraTarget(universitiMalayaBounds);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(universitiMalayaCenter, zoomLevel));

        setFacultyMarkers(googleMap);
    }

    public void setFacultyMarkers(GoogleMap googleMap){
        LatLng faculty1 = new LatLng(3.128270717822885, 101.65047352403242);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty1)
                .title("Faculty of Computer Science and Information Technology"));

        LatLng faculty2 = new LatLng(3.1328083688395685, 101.65729390452503);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty2)
                .title("Academy of Islamic Studies"));

        LatLng faculty3 = new LatLng(3.1303293064453483, 101.65978494815317);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty3)
                .title("Faculty of Sports and Exercise Science"));

        LatLng faculty4 = new LatLng(3.1179682885662965, 101.66090281199799);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty4)
                .title("Faculty of Law"));

        LatLng faculty5 = new LatLng(3.1182440077018274, 101.65542123206191);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty5)
                .title("Faculty of Engineering"));

        LatLng faculty6 = new LatLng(3.116169331163629, 101.65540127360998);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty6)
                .title("Faculty of Built Environment"));

        LatLng faculty7 = new LatLng(3.115780282039391, 101.65306852990486);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty7)
                .title("Faculty of Medicine"));

        LatLng faculty8 = new LatLng(3.1116032037059145, 101.65309240558207);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty8)
                .title("Faculty of Medicine"));

        LatLng faculty9 = new LatLng(3.1187229733361614, 101.65398433323936);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty9)
                .title("Faculty of Business and Accountancy"));

        LatLng faculty10 = new LatLng(3.118576727657633, 101.65267309321126);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty10)
                .title("Faculty of Economics and Administration"));

        LatLng faculty11 = new LatLng(3.1202720879144277, 101.65299253414233);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty11)
                .title("Faculty of Education"));

        LatLng faculty12 = new LatLng(3.121228809712015, 101.65293636300903);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty12)
                .title("Faculty of Arts and Social Sciences"));

        LatLng faculty13 = new LatLng(3.1224406448373236, 101.65405448362047);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty13)
                .title("Faculty of Science"));

        LatLng faculty14 = new LatLng(3.121056009089897, 101.65704804753187);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty14)
                .title("Faculty of Creative Arts"));

        LatLng faculty15 = new LatLng(3.122273528218598, 101.65121034317339);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty15)
                .title("Faculty of Languages and Linguistics"));

        LatLng faculty16 = new LatLng(3.124742545657762, 101.65250434310985);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty16)
                .title("Academy of Malay Studies"));
    }
}