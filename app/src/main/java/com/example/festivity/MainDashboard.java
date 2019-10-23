package com.example.festivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;

public class MainDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button groups;
    private Button tasks;
    private Button festdetails;
    private Button registrations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        groups = findViewById(R.id.button3);
        groups.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openGroupsPage();
            }
        });

        festdetails = findViewById(R.id.button5);
        festdetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openEventsPage();
            }
        });

        tasks = findViewById(R.id.button8);
        tasks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openTasksPage();
            }
        });

        registrations = findViewById(R.id.button6);
        registrations.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openEventsPage2();
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_notifications) {

        } else if (id == R.id.nav_alert) {
            Intent intent = new Intent(this, AlertPage.class);
            startActivity(intent);

        } else if (id == R.id.nav_changefest) {
            Intent intent = new Intent(this, ChangeFest.class);
            startActivity(intent);

        }  else if (id == R.id.nav_send) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void openGroupsPage(){
        Intent intent = new Intent(this, GroupsPage.class);
        startActivity(intent);
    }

    public void openEventsPage(){
        Intent intent = new Intent(this, EventsPage.class);
        startActivity(intent);
    }

    public void openTasksPage(){
        Intent intent = new Intent(this, TasksPage.class);
        startActivity(intent);
    }

    public void openEventsPage2(){
        Intent intent = new Intent(this, EventsPage2.class);
        startActivity(intent);
    }
}
