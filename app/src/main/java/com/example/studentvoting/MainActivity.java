package com.example.studentvoting;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import com.example.studentvoting.databinding.ActivityMainBinding;

import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {
    public static String currentlyLoggedIn = "";
    public static String currentfacultyPage = "";
    public static String candidateID = "";

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;


    BottomNavigationView bottomNavigationView;
    Login loginFragment = new Login();
    Home homeFragment = new Home();
    ElectionPage electionPageFragment = new ElectionPage();
    ProfilePage profilePageFragment = new ProfilePage();
    SettingsPage settingsPageFragment = new SettingsPage();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Phone status bar setup
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.darkblue));
            window.setNavigationBarColor(this.getResources().getColor(R.color.darkblue));
        }

        // Bottom navigation menu setup
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                        return true;
                    case R.id.electionPage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, electionPageFragment).commit();
                        return true;
                    case R.id.profilePage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profilePageFragment).commit();
                        return true;
                    case R.id.settingsPage:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, settingsPageFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    void hideBottomNav(){
        bottomNavigationView.setVisibility(View.GONE);
    }

    void showBottomNav(){
        bottomNavigationView.setVisibility(View.VISIBLE);
    }
}