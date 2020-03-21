package com.example.logindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private ViewPager viewPager;
    



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbarid);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        ViewPageAdapter adapter = new ViewPageAdapter((getSupportFragmentManager()));
        adapter.AddFragment(new FragmentAboutUs(),"About Us");
        adapter.AddFragment(new FragmentReservation(), "Reservation");
        adapter.AddFragment(new FragmentContact(), "Contact");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


    }




}
