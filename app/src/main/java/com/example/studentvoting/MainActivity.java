package com.example.studentvoting;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager2.widget.ViewPager2;

import com.example.studentvoting.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.biometric.BiometricPrompt;

public class MainActivity extends AppCompatActivity {
    public static String currentlyLoggedIn = "";
    public static String currentfacultyPage = "";

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
        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();

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


}