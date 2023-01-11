package com.example.studentvoting;

import static android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG;
import static android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL;

import android.content.Context;
import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.biometric.BiometricPrompt;
import androidx.biometric.BiometricPrompt.PromptInfo;
import androidx.biometric.BiometricPrompt.PromptInfo.Builder;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;




public class VerifyVote extends Fragment {
    DatabaseReference reff;
    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    RelativeLayout fingerprintSuccess_fragment;
    androidx.biometric.BiometricManager biometricManager;
    Button confirmBtn;
//    boolean authenticate = false;

    private Fragment Home;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String currentFac = MainActivity.currentfacultyPage;
        int choice = MainActivity.voteChoice;
        reff = FirebaseDatabase.getInstance("https://studentvoting-fc2ca-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        View rootView = inflater.inflate(R.layout.fragment_verify_vote, container, false);

        fingerprintSuccess_fragment = rootView.findViewById(R.id.fingerprintSuccess_fragment);

        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.getString("some") != null) {
                Toast.makeText(getContext(), "data" + bundle.getString("some"), Toast.LENGTH_SHORT).show();
            }
        }


        androidx.biometric.BiometricManager biometricManager = androidx.biometric.BiometricManager.from(VerifyVote.this.getContext());
        switch (biometricManager.canAuthenticate()) {
            case androidx.biometric.BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getContext(), "no suitable hardware", Toast.LENGTH_SHORT).show();
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                break;
            case androidx.biometric.BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getContext(), "hardware is unavailable", Toast.LENGTH_SHORT).show();
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                break;
            case androidx.biometric.BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getContext(), "no biometric or device credential is enrolled.", Toast.LENGTH_SHORT).show();
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                break;
        }

        Executor executor = ContextCompat.getMainExecutor(VerifyVote.this.getContext());

        biometricPrompt = new BiometricPrompt(VerifyVote.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                switch(choice){
                    case 1:

                        Map<String, Object> updates = new HashMap<>();
                        updates.put("Student/"+MainActivity.currentlyLoggedIn+"/voted", 2);
                        updates.put("Faculty/"+currentFac+"/candidates/1/currentvotes", ServerValue.increment(1));
                        reff.updateChildren(updates);
                        break;
                    case 2:
                        Map<String, Object> updates2 = new HashMap<>();
                        updates2.put("Student/"+MainActivity.currentlyLoggedIn+"/voted", 2);
                        updates2.put("Faculty/"+currentFac+"/candidates/2/currentvotes", ServerValue.increment(1));
                        reff.updateChildren(updates2);
                        break;
                    case 3:
                        Map<String, Object> updates3 = new HashMap<>();

                        updates3.put("Student/"+MainActivity.currentlyLoggedIn+"/voted", 2);

                        updates3.put("Faculty/"+currentFac+"/candidates/3/currentvotes", ServerValue.increment(1));
                        reff.updateChildren(updates3);
                        break;
                }
//                reff.child("Faculty/"+currentFac+"/candidates").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
                MainActivity.hasVoted = 2;
                Toast.makeText(getContext(), "Your Vote is verified", Toast.LENGTH_SHORT).show();
                fingerprintSuccess_fragment.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                //getSupportFragmentManager().beginTransaction().replace(R.id.container, Home).commit();
            }
        });

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Verified Your Vote with Your FingerPrint")
                .setDescription("Use Fingerprint to Verify Your Vote")
                .setDeviceCredentialAllowed(true)
                .build();

        biometricPrompt.authenticate(promptInfo);

        confirmBtn = rootView.findViewById(R.id.buttonToResult);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Result result = new Result();
                getFragmentManager().beginTransaction().replace(R.id.container, result).commit();
            }
        });

        return rootView;
    }

}