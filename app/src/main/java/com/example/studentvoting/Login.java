package com.example.studentvoting;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {
    DatabaseReference reff;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
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
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        // Hide bottom nav menu
        BottomNavigationView bottomNavigationView = requireActivity().findViewById(R.id.bottom_nav_view);
        ((MainActivity)getActivity()).hideBottomNav();

        EditText username =  (EditText) rootView.findViewById(R.id.username_textbox);

        EditText password =  (EditText) rootView.findViewById(R.id.password_textbox);

        Button BtnToResult = (Button) rootView.findViewById(R.id.submit_btn);

        TextView tv = (TextView) rootView.findViewById(R.id.noaccount_tv);

        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();
        BtnToResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String matrixno = username.getText().toString().toUpperCase(Locale.ROOT);
                    String pass = password.getText().toString();
                    if(matrixno.isEmpty()){
                        username.requestFocus();
                        username.setError("Cannot be empty!");
                    } else if (pass.isEmpty()){
                        password.requestFocus();
                        password.setError("Cannot be empty!");
                    } else {
                        reff.child("Student").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                if (snapshot.hasChild(matrixno)) {
                                    final String getPassword = snapshot.child(matrixno).child("password").getValue(String.class);

                                    if (getPassword.equals(pass)) {
                                        Fragment fragment = null;
                                        fragment = new Home();
                                        replaceFragment(fragment);
                                        MainActivity.currentlyLoggedIn = matrixno;
                                        MainActivity.hasVoted = snapshot.child(matrixno).child("voted").getValue(Integer.class);
                                        MainActivity.currentlyuserpage = snapshot.child(matrixno).child("faculty").getValue(String.class);
                                        MainActivity.currentfacultyPage = snapshot.child(matrixno).child("faculty").getValue(String.class);

                                    } else {
                                        password.requestFocus();
                                        password.setError("Invalid Password!");
                                    }

                                } else {
                                    username.requestFocus();
                                    username.setError("User doesn't exist!");
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(getContext(), "Error in connection", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                fragment = new Register();
                replaceFragment(fragment);

                }
            }
        );

        return rootView;
    }

//    public void onClick(View view) {
//        Fragment fragment = null;
//        switch (view.getId()) {
//            case R.id.noaccount_tv:
//                fragment = new Register();
//                replaceFragment(fragment);
//                break;
//            case R.id.login_btn:
//
//                if(password.equals(passwordDB) && usernameInput.equals(usernameDB)){
//                    fragment = new Feedback();
//                    replaceFragment(fragment);
//                } else if(!passwordInput.equals(passwordDB) && usernameInput.equals(usernameDB)){
//                    Toast.makeText(view.getContext(),"Wrong Password!",Toast.LENGTH_SHORT).show();
//                } else if(passwordInput.equals(passwordDB) && !usernameInput.equals(usernameDB)){
//                    Toast.makeText(view.getContext(),"Wrong Username!",Toast.LENGTH_SHORT).show();
//                } else{
//                    Toast.makeText(view.getContext(),"Both Username and Password wrong!",Toast.LENGTH_SHORT).show();
//                }
//
//                break;
////            case R.id.logoutBTN:
//                fragment = new Login();
//                replaceFragment(fragment);
//                break;
//        }
//    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}