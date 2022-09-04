package com.example.howltoolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.findViewById(R.id.toolbar_email).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"아직 도착한 메세지가 없습니다.",Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.findViewById(R.id.toolbar_lowbattery).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"배터리 부족. 충전 바람.",Toast.LENGTH_SHORT).show();
            }
        });

        toolbar.findViewById(R.id.toolbar_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"알림 확인 바람.",Toast.LENGTH_SHORT).show();
            }
        });


        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

         NavigationView navigationView = (NavigationView) findViewById(R.id.main_navigationView);

         navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                 if(item.getItemId() ==R.id.first){
                      getFragmentManager().beginTransaction().replace(R.id.main_framelayout,new FirstFragment()).commit();
                 }
                 if(item.getItemId() ==R.id.second){
                     getFragmentManager().beginTransaction().replace(R.id.main_framelayout,new SecondFragment()).commit();
                 }
                 if(item.getItemId() ==R.id.third){
                     getFragmentManager().beginTransaction().replace(R.id.main_framelayout,new ThirdFragment()).commit();
                 }
                 if(item.getItemId() ==R.id.first2){
                     getFragmentManager().beginTransaction().replace(R.id.main_framelayout,new First2Fragment()).commit();
                 }
                 if(item.getItemId() ==R.id.second2){
                     getFragmentManager().beginTransaction().replace(R.id.main_framelayout,new Second2Fragment()).commit();
                 }
                 if(item.getItemId() ==R.id.third2){
                     getFragmentManager().beginTransaction().replace(R.id.main_framelayout,new Third2Fragment()).commit();
                 }

                 drawerLayout.closeDrawer(GravityCompat.START);

                 return true;
             }
         });

    }
}