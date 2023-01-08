package com.example.studentvoting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {
    String usernameDB = "nigga";
    String passwordDB = "n1gga";
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

        EditText username =  (EditText) rootView.findViewById(R.id.username_textbox);

        EditText password =  (EditText) rootView.findViewById(R.id.password_textbox);

        Button BtnToResult = (Button) rootView.findViewById(R.id.login_btn);

        TextView tv = (TextView) rootView.findViewById(R.id.noaccount_tv);

        BtnToResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                if(username.getText().toString().equals(usernameDB) &&
                        password.getText().toString().equals(passwordDB)) {
                    fragment = new Home();
                    replaceFragment(fragment);
                }else{
                    Toast.makeText(rootView.getContext(), "Wrong Credentials",
                            Toast.LENGTH_SHORT).show();

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