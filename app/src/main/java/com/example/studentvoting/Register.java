package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Register#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Register extends Fragment {
DatabaseReference reff;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Register() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Register.
     */
    // TODO: Rename and change types and number of parameters
    public static Register newInstance(String param1, String param2) {
        Register fragment = new Register();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);

        // Hide bottom nav menu
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_nav_view);
        ((MainActivity)getActivity()).hideBottomNav();

        //get the spinner from the xml.

        Spinner dropdown = rootView.findViewById(R.id.facultySpinner);
        EditText nameET = rootView.findViewById(R.id.nameTB);
        EditText siswamailET = rootView.findViewById(R.id.siswamailTB);
        EditText passwordET = rootView.findViewById(R.id.passwordTB);
        EditText addressET = rootView.findViewById(R.id.addressTB);
        Spinner facultySpinner = rootView.findViewById(R.id.facultySpinner);


        Button btn = rootView.findViewById(R.id.login_btn);


        String[] items = new String[]{
                "Faculty of Computer Science and Information Technology",
                "Academy of Islamic Studies",
                "Faculty of Sports and Exercise Science",
                "Faculty of Law",
                "Faculty of Engineering",
                "Faculty of Built Environment",
                "Faculty of Medicine",
                "Faculty of Dentistry",
                "Faculty of Business and Accountancy",
                "Faculty of Economics and Administration",
                "Faculty of Education",
                "Faculty of Arts and Social Sciences",
                "Faculty of Science",
                "Faculty of Creative Arts",
                "Faculty of Languages and Linguistics",
                "Academy of Malay Studies"};


        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference().child("Student");
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString();
                String matrixnumber = siswamailET.getText().toString().toUpperCase(Locale.ROOT);
                String siswamail = siswamailET.getText().toString() + "@um.edu.my";
                String password = passwordET.getText().toString();
                String address = addressET.getText().toString();
                String faculty = facultySpinner.getSelectedItem().toString();
                insertStudentData(name,matrixnumber,siswamail,password,address,faculty);
                Fragment fragment = null;
                fragment = new Home();
                replaceFragment(fragment);

            }
        });
        return rootView;
    }

//    public void onClick(View view) {
//        Fragment fragment = null;
//        switch (view.getId()) {
//            case R.id.login_btn:
//                insertStudentData();
//                fragment = new FAQPage();
//                replaceFragment(fragment);
//                break;
//            case R.id.FeedbackBTN:
//                fragment = new Feedback();
//                replaceFragment(fragment);
//                break;
//            case R.id.logoutBTN:
//                fragment = new Login();
//                replaceFragment(fragment);
//                break;
//        }
//    }

    public void insertStudentData(String name, String matrix,String siswamail, String password, String address, String faculty){
        Student student1 = new Student(name,matrix,siswamail,password,address,faculty);
        reff.child(student1.getMatrixno()).setValue(student1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                } else {

                }
            }
        });
    }
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}