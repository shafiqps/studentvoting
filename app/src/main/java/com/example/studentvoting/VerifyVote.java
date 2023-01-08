package com.example.studentvoting;

import static android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG;
import static android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL;

import android.content.Intent;
import android.hardware.biometrics.BiometricManager;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
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

//    BiometricPrompt biometricPrompt;
//    BiometricPrompt.PromptInfo promptInfo;
//    RelativeLayout verification_layout;



    public VerifyVote() {
        // Required empty public constructor
    }

//    @RequiresApi(api = Build.VERSION_CODES.Q)
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_verify_vote, container, false);
//
//
//        verification_layout = view.findViewById(R.id.verification_fragment);
//
//        BiometricManager biometricManager = BiometricManager.from(this);
//        switch (biometricManager.canAuthenticate(BIOMETRIC_STRONG | DEVICE_CREDENTIAL)) {
//            case BiometricManager.BIOMETRIC_SUCCESS:
//                Log.d("MY_APP_TAG", "App can authenticate using biometrics.");
//                break;
//            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
//                Log.e("MY_APP_TAG", "No biometric features available on this device.");
//                break;
//            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
//                Log.e("MY_APP_TAG", "Biometric features are currently unavailable.");
//                break;
//            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
//                // Prompts the user to create credentials that your app accepts.
//                final Intent enrollIntent = new Intent(Settings.ACTION_BIOMETRIC_ENROLL);
//                enrollIntent.putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
//                        BIOMETRIC_STRONG | DEVICE_CREDENTIAL);
//                startActivityForResult(enrollIntent, REQUEST_CODE);
//                break;
//        }
//
//        Executor executor = ContextCompat.getMainExecutor(view.getContext());
//
//        biometricPrompt = new androidx.biometric.BiometricPrompt(verification_layout.this, executor, new androidx.biometric.BiometricPrompt.AuthenticationCallback() {
//            @Override
//            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
//                super.onAuthenticationError(errorCode, errString);
//            }
//
//            @Override
//            public void onAuthenticationSucceeded(@NonNull androidx.biometric.BiometricPrompt.AuthenticationResult result) {
//                super.onAuthenticationSucceeded(result);
//                Toast.makeText(getActivity().getApplicationContext(), "Your Vote is verified", Toast.LENGTH_SHORT).show();
//                verification_layout.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAuthenticationFailed() {
//                super.onAuthenticationFailed();
//            }
//        });
//
//        promptInfo = new BiometricPrompt.PromtInfo.Builder().setTitle("Verified Your Vote with Your FingerPrint")
//                .setDescription("Use Fingerprint to Verify Your Vote").setDeviceCredentialAllowed(true).build();
//
//        biometricPrompt.authenticate(promptInfo);


//        return view;

}