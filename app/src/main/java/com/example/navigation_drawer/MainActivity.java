package com.example.navigation_drawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.navigation_drawer.fragments.HomeFragment;
import com.example.navigation_drawer.fragments.LoginFragment;
import com.example.navigation_drawer.fragments.MessageFragment;
import com.example.navigation_drawer.fragments.SettingsFragment;
import com.example.navigation_drawer.fragments.SyncFragment;
import com.example.navigation_drawer.fragments.TrashFragment;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            //public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {
            public boolean onNavigationItemSelected(@NotNull MenuItem item) {

                Fragment newFragment;
                int id = item.getItemId();

                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id)
                {
                    case R.id.nav_home:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, new HomeFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Home is Clicked", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.nav_message:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, new MessageFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Message is Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.sync:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, new SyncFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Synch is Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.trash:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, new TrashFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Trash is Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, new SettingsFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Settings is Clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_login:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragmentContainer, new LoginFragment())
                                .commit();
                        Toast.makeText(MainActivity.this, "Login is Clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this, "Share is clicked",Toast.LENGTH_SHORT).show();break;
                    case R.id.nav_rate:
                    Toast.makeText(MainActivity.this, "Rate us is Clicked",Toast.LENGTH_SHORT).show();break;
                    default:
                    return true;

                }
                return true;
            }
        });


    }
}