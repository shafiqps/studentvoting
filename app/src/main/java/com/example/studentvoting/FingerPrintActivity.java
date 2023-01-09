package com.example.studentvoting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class FingerPrintActivity extends AppCompatActivity {

    BiometricPrompt biometricPrompt;
    BiometricPrompt.PromptInfo promptInfo;
    RelativeLayout fingerprintSuccess_fragment;
    BiometricManager biometricManager;
    Button confirmBtn;

    private Fragment ElectionPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_print);
        fingerprintSuccess_fragment = findViewById(R.id.fingerprintSuccess_fragment);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(), "data" + bundle.getString("some"), Toast.LENGTH_SHORT).show();
            }
        }

        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate()) {
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    Toast.makeText(getApplicationContext(), "no suitable hardware", Toast.LENGTH_SHORT).show();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                    Toast.makeText(getApplicationContext(), "hardware is unavailable", Toast.LENGTH_SHORT).show();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                    break;
                case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                    Toast.makeText(getApplicationContext(), "no biometric or device credential is enrolled.", Toast.LENGTH_SHORT).show();
                    //getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                    break;
            }

            Executor executor = ContextCompat.getMainExecutor(this);

            biometricPrompt = new BiometricPrompt(FingerPrintActivity.this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                }

                @Override
                public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    Toast.makeText(getApplicationContext(), "Your Vote is verified", Toast.LENGTH_SHORT).show();
                    fingerprintSuccess_fragment.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                }
            });

            promptInfo = new BiometricPrompt.PromptInfo.Builder()
                    .setTitle("Verified Your Vote with Your FingerPrint")
                        .setDescription("Use Fingerprint to Verify Your Vote")
                                .setDeviceCredentialAllowed(true)
                                        .build();

            biometricPrompt.authenticate(promptInfo);

            confirmBtn = findViewById(R.id.buttonToResult);
            confirmBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, ElectionPage).commit();
                }
            });


    }
//    public void replaceFragment(Fragment someFragment) {
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.container, someFragment);
//        transaction.addToBackStack(null);
//        transaction.commit();
//    }

}