package com.example.studentvoting;

import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.concurrent.Executor;




public class VerifyVote extends Fragment {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    RelativeLayout verification_layout;



    public VerifyVote() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verify_vote, container, false);


        verification_layout = view.findViewById(R.id.verification_fragment);

        BiometricManager biometricManager = (BiometricManager) getActivity().getSystemService(VerifyVote.class);
        switch(biometricManager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getActivity().getApplicationContext(), "Device don't have FingerPrint feature", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getActivity().getApplicationContext(), "FingerPrint doesn't working", Toast.LENGTH_SHORT).show();
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                Toast.makeText(getActivity().getApplicationContext(), "No FingerPrint assigned", Toast.LENGTH_SHORT).show();

        }

        Executor executor = ContextCompat.getMainExecutor(view.getContext());

        biometricPrompt = new androidx.biometric.BiometricPrompt(verification_layout.this, executor, new androidx.biometric.BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull androidx.biometric.BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getActivity().getApplicationContext(), "Your Vote is verified", Toast.LENGTH_SHORT).show();
                verification_layout.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        promptInfo = new BiometricPrompt.PromtInfo.Builder().setTitle("Verified Your Vote with Your FingerPrint")
                .setDescription("Use Fingerprint to Verify Your Vote").setDeviceCredentialAllowed(true).build();

        biometricPrompt.authenticate(promptInfo);


        return view;
    }
}