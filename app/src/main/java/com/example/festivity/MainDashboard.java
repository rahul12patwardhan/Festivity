package com.example.festivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button groups;
    private Button tasks;
    private Button festdetails;
    private Button registrations;
    private Button raise;
    private TextView tv;
    private TextView title;
    private TextView title2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dashboard);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.title2);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        String email = currentUser.getEmail().toString();

        title = findViewById(R.id.title);
        title.setText(email);
        navUsername.setText(email);

        groups = findViewById(R.id.buttonGroups);
        groups.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openGroupsPage();
            }
        });

        raise = findViewById(R.id.nav_alert);
        raise.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openAlertPage();
            }
        });

        festdetails = findViewById(R.id.buttonDetails);
        festdetails.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openEventsPage();
            }
        });

        tasks = findViewById(R.id.buttonmytasks);
        tasks.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openTasksPage();
            }
        });

        registrations = findViewById(R.id.buttonReg );
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

        int id = item.getItemId();
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
            FirebaseAuth.getInstance().signOut();
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

    public void openAlertPage(){
        Intent intent = new Intent(this, AlertPage.class);
        startActivity(intent);
    }

    public void openEventsPage(){
        Intent intent = new Intent(this, EventsPageMain.class);
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
