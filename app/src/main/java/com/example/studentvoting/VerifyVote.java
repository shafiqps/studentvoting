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

import java.util.concurrent.Executor;




public class VerifyVote extends Fragment {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    RelativeLayout fingerprintSuccess_fragment;
    androidx.biometric.BiometricManager biometricManager;
    Button confirmBtn;

    private Fragment Home;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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