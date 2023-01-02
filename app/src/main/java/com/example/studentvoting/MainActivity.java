package com.example.studentvoting;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.studentvoting.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    BottomNavigationView bottomNavigationView;
    Home homeFragment = new Home();
    ElectionPage electionPageFragment = new ElectionPage();
    ProfilePage profilePageFragment = new ProfilePage();
    SettingsPage settingsPageFragment = new SettingsPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav_view);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
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
}