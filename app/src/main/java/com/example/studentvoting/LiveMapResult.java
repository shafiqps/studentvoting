package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class LiveMapResult extends Fragment implements OnMapReadyCallback {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SupportMapFragment mapFragment = SupportMapFragment.newInstance();
        getFragmentManager()
                .beginTransaction()
                .add(R.id.VoteMap, mapFragment)
                .commit();

        GoogleMapOptions options = new GoogleMapOptions();
        options.mapType(GoogleMap.MAP_TYPE_SATELLITE);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_live_map_result, container, false);
    }


    public void onMapReady(GoogleMap googleMap) {
        googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));


        LatLngBounds australiaBounds = new LatLngBounds(
                new LatLng(-44, 113), // SW bounds
                new LatLng(-10, 154)  // NE bounds
        );
        googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(australiaBounds, 0));


    }

}
