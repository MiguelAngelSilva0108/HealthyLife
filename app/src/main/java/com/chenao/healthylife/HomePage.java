package com.chenao.healthylife;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.fpt.adapter.AdapterViewPager;
import com.fpt.fragment.FragmentCalorias;
import com.fpt.fragment.FragmentDietas;
import com.fpt.fragment.FragmentInicio;
import com.fpt.fragment.FragmentPerfil;
import com.fpt.fragment.FragmentRutinas;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import android.view.MenuItem;


import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    ViewPager2 pagerMain;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        pagerMain = findViewById(R.id.pagerMain);
        bottomNav = findViewById(R.id.bottomNav);

        fragmentArrayList.add(new FragmentInicio());
        fragmentArrayList.add(new FragmentPerfil());
        fragmentArrayList.add(new FragmentDietas()); // Cambiado el orden, ahora FragmentDietas está en el índice 2
        fragmentArrayList.add(new FragmentRutinas());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        pagerMain.setAdapter(adapterViewPager);
        pagerMain.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    bottomNav.setSelectedItemId(R.id.itInicio);
                } else if (position == 1) {
                    bottomNav.setSelectedItemId(R.id.itPerfil);
                } else if (position == 2) {
                    bottomNav.setSelectedItemId(R.id.itDietas);
                } else if (position == 4) {
                    bottomNav.setSelectedItemId(R.id.itRutinas);
                }
                super.onPageSelected(position);
            }
        });
        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.itInicio) {
                    pagerMain.setCurrentItem(0);
                } else if (item.getItemId() == R.id.itPerfil) {
                    pagerMain.setCurrentItem(1);
                } else if (item.getItemId() == R.id.itDietas) {
                    pagerMain.setCurrentItem(2);
                } else if (item.getItemId() == R.id.itRutinas) {
                    pagerMain.setCurrentItem(4);
                }
                return true;
            }
        });
    }
}
