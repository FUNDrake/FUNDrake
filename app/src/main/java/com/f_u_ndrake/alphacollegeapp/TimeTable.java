package com.f_u_ndrake.alphacollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TimeTable extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_table);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new fragment_monday()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFrag = null;
                    switch ( item.getItemId()){
                        case R.id.TTMonday:
                            selectedFrag = new fragment_monday();
                            break;
                        case R.id.TTTuesday:
                            selectedFrag = new fragment_tuesday();
                            break;
                        case R.id.TTWednesday:
                            selectedFrag = new fragment_wednesday();
                            break;
                        case R.id.TTThursday:
                            selectedFrag = new fragment_thursday();
                            break;
                        case R.id.TTFriday:
                            selectedFrag = new fragment_friday();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,selectedFrag).commit();
                    return  true;
                }
            };
}