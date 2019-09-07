package com.example.eatapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

public class CustomerMainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_main);


        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {



                mDrawerLayout.closeDrawers();


                int id = menuItem.getItemId();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();


                if (id == R.id.nav_restaurant) {
                    transaction.replace(R.id.content_frame, new ResautrantlistFragment()).commit();
                } else if (id == R.id.nav_order) {
                    transaction.replace(R.id.content_frame, new TrayFragment()).commit();
                } else if (id == R.id.nav_tray){
                    Intent intent = new Intent(CustomerMainActivity.this, MapsActivity.class);
                    startActivity(intent);


                } else if (id == R.id.nav_logout) {
                    transaction.replace(R.id.content_frame, new logout()).commit();

                }



                return true;
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content_frame, new ResautrantlistFragment()).commit();
    }


}
