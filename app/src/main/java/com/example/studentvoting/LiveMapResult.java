package com.example.studentvoting;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Map;

public class LiveMapResult extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private GoogleMap map;
    BottomSheetDialog bottomSheetDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_live_map_result, container, false);
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bsd_fac_result, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(bottomSheetView);
        // Get the MapView from the layout file
        MapView mapView = rootView.findViewById(R.id.VoteMap);

        // Initialize the MapView
        mapView.onCreate(savedInstanceState);
        mapView.onResume();

        // Get the GoogleMap object from the MapView
        mapView.getMapAsync(this);

            return rootView;
    }


    public void onMapReady(GoogleMap googleMap) {

        // Set the map boundary to Universiti Malaya
        LatLngBounds universitiMalayaBounds = new LatLngBounds(
                new LatLng(3.108039056846274, 101.64099811309444), // South West corner
                new LatLng(3.136480273984235, 101.66289173863183)); // North East corner

        LatLng universitiMalayaCenter = new LatLng(3.1225205575356245, 101.6546364500923); // Center of Universiti Malaya

        int zoomLevel = 15; // This value can be from 2.0 to 21.0

        googleMap.setLatLngBoundsForCameraTarget(universitiMalayaBounds);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(universitiMalayaCenter, zoomLevel));

        setFacultyMarkers(googleMap);

        googleMap.setOnMarkerClickListener(this::onMarkerClick);
    }

    public void setFacultyMarkers(GoogleMap googleMap){
        LatLng faculty1 = new LatLng(3.128270717822885, 101.65047352403242);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty1)
                .snippet("FSKTM")
                .title("Faculty of Computer Science and Information Technology"));

        LatLng faculty2 = new LatLng(3.1328083688395685, 101.65729390452503);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty2)
                        .snippet("API")
                .title("Academy of Islamic Studies"));

        LatLng faculty3 = new LatLng(3.1303293064453483, 101.65978494815317);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty3)
                        .snippet("Sports")
                .title("Faculty of Sports and Exercise Science"));

        LatLng faculty4 = new LatLng(3.1179682885662965, 101.66090281199799);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty4)
                        .snippet("Law")
                .title("Faculty of Law"));

        LatLng faculty5 = new LatLng(3.1182440077018274, 101.65542123206191);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty5)
                        .snippet("Engine")
                .title("Faculty of Engineering"));

        LatLng faculty6 = new LatLng(3.116169331163629, 101.65540127360998);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty6)
                        .snippet("FBE")
                .title("Faculty of Built Environment"));

        LatLng faculty7 = new LatLng(3.115780282039391, 101.65306852990486);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty7)
                        .snippet("Med")
                .title("Faculty of Medicine"));

        LatLng faculty8 = new LatLng(3.1116032037059145, 101.65309240558207);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty8)
                        .snippet("Dentist")
                .title("Faculty of Dentistry"));

        LatLng faculty9 = new LatLng(3.1187229733361614, 101.65398433323936);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty9)
                        .snippet("FBA")
                .title("Faculty of Business and Accountancy"));

        LatLng faculty10 = new LatLng(3.118576727657633, 101.65267309321126);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty10)
                        .snippet("Econs")
                .title("Faculty of Economics and Administration"));

        LatLng faculty11 = new LatLng(3.1202720879144277, 101.65299253414233);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty11)
                        .snippet("Edu")
                .title("Faculty of Education"));

        LatLng faculty12 = new LatLng(3.121228809712015, 101.65293636300903);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty12)
                        .snippet("FASS")
                .title("Faculty of Arts and Social Sciences"));

        LatLng faculty13 = new LatLng(3.1224406448373236, 101.65405448362047);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty13)
                        .snippet("Science")
                .title("Faculty of Science"));

        LatLng faculty14 = new LatLng(3.121056009089897, 101.65704804753187);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty14)
                        .snippet("Arts")
                .title("Faculty of Creative Arts"));

        LatLng faculty15 = new LatLng(3.122273528218598, 101.65121034317339);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty15)
                        .snippet("FLL")
                .title("Faculty of Languages and Linguistics"));

        LatLng faculty16 = new LatLng(3.124742545657762, 101.65250434310985);
        googleMap.addMarker(new MarkerOptions()
                .position(faculty16)
                        .snippet("APM")
                .title("Academy of Malay Studies"));
    }


    public boolean onMarkerClick(Marker marker){
        String name = marker.getSnippet();
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bsd_fac_result, null);
        TextView textView = bottomSheetView.findViewById(R.id.FacNameResult);

        switch(name){
            case "FSKTM": showBottomSheetDialog("Faculty of CS&IT", "Wywy", "Angkatan Mahasiswa", "Ahmad Ilham", "Neo Siswa", "Shafiq Aiman", "Bunga Raya");
                return true;

            case "API": showBottomSheetDialog("Academy of Islamic Studies", "Capang", "Angkatan Mahasiswa", "Tareq", "Neo Siswa", "Lamek", "Bunga Raya");
                return true;

            case "Sports": showBottomSheetDialog("Faculty of Sports and Exercise Science", "Ammar", "Angkatan Mahasiswa", "Ikhwan", "Neo Siswa", "Theo", "Bunga Raya");
                return true;

            case "Law": showBottomSheetDialog("Faculty of Law", "Umar", "Angkatan Mahasiswa", "Daus", "Neo Siswa", "Mizwar", "Bunga Raya");
                return true;

            case "Engine": showBottomSheetDialog("Faculty of Engineering", "Icap", "Angkatan Mahasiswa", "Thesha", "Neo Siswa", "Aniq", "Bunga Raya");
                return true;

            case "FBE": showBottomSheetDialog("Faculty of Built Environment", "Eyena", "Angkatan Mahasiswa", "Sham", "Neo Siswa", "Midol", "Bunga Raya");
                return true;

            case "Med": showBottomSheetDialog("Faculty of Medicine", "Deen", "Angkatan Mahasiswa", "Sar", "Neo Siswa", "Yasmint", "Bunga Raya");
                return true;

            case "Dentist": showBottomSheetDialog("Faculty of Dentistry", "Adham", "Angkatan Mahasiswa", "Kumaran", "Neo Siswa", "Lily", "Bunga Raya");
                return true;

            case "FBA": showBottomSheetDialog("Faculty of Business and Accountancy", "Keat", "Angkatan Mahasiswa", "Ukhta", "Neo Siswa", "Umi", "Bunga Raya");
                return true;

            case "Econs": showBottomSheetDialog("Faculty of Economics and Administration", "Nik", "Angkatan Mahasiswa", "Lutfi", "Neo Siswa", "Zahid", "Bunga Raya");
                return true;

            case "Edu": showBottomSheetDialog("Faculty of Education", "Farah", "Angkatan Mahasiswa", "Zul", "Neo Siswa", "Fatin", "Bunga Raya");
                return true;

            case "FASS": showBottomSheetDialog("Faculty of Arts and Social Sciences", "Billie", "Angkatan Mahasiswa", "Adam", "Neo Siswa", "Durra", "Bunga Raya");
                return true;

            case "Science": showBottomSheetDialog("Faculty of Science", "Bali", "Angkatan Mahasiswa", "Dibo", "Neo Siswa", "Idris", "Bunga Raya");
                return true;

            case "Arts": showBottomSheetDialog("Faculty of Creative Arts", "Farees", "Angkatan Mahasiswa", "Haris", "Neo Siswa", "Amisha", "Bunga Raya");
                return true;

            case "FLL": showBottomSheetDialog("Faculty of Languages and Linguistics", "Rozi", "Angkatan Mahasiswa", "Masnaini", "Neo Siswa", "Usha", "Bunga Raya");
                return true;

            case "APM": showBottomSheetDialog("Academy of Malay Studies", "Sazeli", "Angkatan Mahasiswa", "Zainumey", "Neo Siswa", "Aluna", "Bunga Raya");
                return true;

            default: return false;
        }
    }

    private void showBottomSheetDialog(String Faculty, String CandidateA, String PartyA,
                                       String CandidateB, String PartyB,
                                       String CandidateC, String PartyC){

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(getActivity());
        bottomSheetDialog.setContentView(R.layout.fragment_candidates_list_faculty_based);

        //Faculty
        TextView facText = (TextView) bottomSheetDialog.findViewById(R.id.FacNameResult);
        facText.setText(Faculty);

        //Candidate A
        TextView candA = (TextView) bottomSheetDialog.findViewById(R.id.textCandidateA);
        candA.setText(CandidateA);
        TextView facA = (TextView) bottomSheetDialog.findViewById(R.id.textPartyX);
        facA.setText(PartyA);

        //Candidate B
        TextView candB = (TextView) bottomSheetDialog.findViewById(R.id.textCandidateB);
        candB.setText(CandidateB);
        TextView facB = (TextView) bottomSheetDialog.findViewById(R.id.textPartyY);
        facB.setText(PartyB);

        //Candidate C
        TextView candC = (TextView) bottomSheetDialog.findViewById(R.id.textCandidateC);
        candC.setText(CandidateC);
        TextView facC = (TextView) bottomSheetDialog.findViewById(R.id.textPartyZ);
        facC.setText(PartyC);

        bottomSheetDialog.show();
    }
}
