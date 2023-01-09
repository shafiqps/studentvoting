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

import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.concurrent.Executor;




public class VerifyVote extends Fragment {

    BiometricPrompt biometricPrompt;
    PromptInfo promptInfo;
    RelativeLayout verification_fragment;
    BiometricManager biometricManager;



    public VerifyVote() {
        // Required empty public constructor
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        //Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verify_vote, container, false);


        verification_fragment = view.findViewById(R.id.verification_fragment);

        BiometricManager biometricManager = (BiometricManager) getActivity().getSystemService(Context.BIOMETRIC_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {//check if the version of the Android operating system that the device is running is Android 10 (API level 29) or higher
            switch (biometricManager.canAuthenticate()) {
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    Toast.makeText(getContext().getApplicationContext(), "no suitable hardware", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                    Toast.makeText(getContext().getApplicationContext(), "hardware is unavailable", Toast.LENGTH_SHORT).show();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                    Toast.makeText(getContext().getApplicationContext(), "no biometric or device credential is enrolled.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        Executor executor = ContextCompat.getMainExecutor(getActivity());

        biometricPrompt = new BiometricPrompt(getActivity(), executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getActivity().getApplicationContext(), "Your Vote is verified", Toast.LENGTH_SHORT).show();
                verification_fragment.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });

        /*
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Verified Your Vote with Your FingerPrint")
                .setDescription("Use Fingerprint to Verify Your Vote")
                .setDeviceCredentialAllowed(true)
                .build();

        biometricPrompt.authenticate(promptInfo);

         */


        return view;
    }

//        public void startAuthentication(){
//            // Call the authenticate method on the BiometricPrompt object
//            biometricPrompt.authenticate(promptInfo);
//        }

}