package com.jamillabltd.navigationdrawerstyleone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(item -> {
            // Handle navigation view item clicks here
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                // Handle the Home action
                Toast.makeText(MainActivity.this, "Home clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_profile) {
                // Handle the Gallery action
                Toast.makeText(MainActivity.this, "Gallery clicked", Toast.LENGTH_SHORT).show();
            } else if (id == R.id.nav_settings) {
                // Handle the Slideshow action
                Toast.makeText(MainActivity.this, "Setting clicked", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.facebookMenuId) {
                Toast.makeText(MainActivity.this, "Facebook clicked", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.youTubeMenuId) {
                Toast.makeText(MainActivity.this, "YouTube clicked", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.instagramMenuId) {
                Toast.makeText(MainActivity.this, "Instagram clicked", Toast.LENGTH_SHORT).show();
            }else if (id == R.id.exitMenuId) {
                this.finish();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    //option menu in action bar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            // Handle settings item click
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}