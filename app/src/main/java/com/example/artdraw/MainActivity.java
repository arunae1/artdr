package com.example.artdraw;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.artdraw.fragment.FragmentOne;
import com.example.artdraw.fragment.Fragmentthree;
import com.example.artdraw.fragment.Fragmenttwo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.btnav);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        bottomNav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;
                int itemId = item.getItemId();
                if (itemId == R.id.nav_home) {
                    selectedFragment = new Fragmenttwo();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
                } else if (itemId == R.id.nav_about) {
                    selectedFragment = new Fragmentthree();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
                } else if (itemId == R.id.nav_share) {
                    selectedFragment = new Fragmentthree();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
                }
                // It will help to replace the
                // one fragment to other.
                if (selectedFragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                }
               
            }
        });
        // as soon as the application opens the first
        // fragment should be shown to the user
        // in this case it is algorithm fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
    }

    private final BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Fragment selectedFragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            selectedFragment = new Fragmenttwo();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
        } else if (itemId == R.id.nav_about) {
            selectedFragment = new Fragmentthree();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
        } else if (itemId == R.id.nav_share) {
            selectedFragment = new Fragmentthree();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentOne()).commit();
        }
        // It will help to replace the
        // one fragment to other.
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
        }
        return true;
    };

}
