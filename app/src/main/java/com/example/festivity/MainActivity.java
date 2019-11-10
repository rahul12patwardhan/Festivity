package com.example.festivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private String val;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference userdb = database.getReference("Users");
        //myRef.setValue("Hello, World!");

        //myRef.child("users").child(userId).setValue(user);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Team, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//        final String text = spinner.getSelectedItem().toString();

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openRegistration();
            }
        });

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                final String text = spinner.getSelectedItem().toString();
//                Log.i("checkooooooooooooo",text);
                if (text.equals("Visitor")) {
                    //Log.i("Visitor","Visitor");

                    openVisitorDashboard();
                } else {

                    openMainDashboard();
                }

                //openVisitorDashboard();
            }
        });
    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        val = parent.getItemAtPosition(pos).toString();
    }

    public void openRegistration(){
        Intent intent = new Intent(this, Registration.class);
        startActivity(intent);
    }

    public void openMainDashboard(){
        Intent intent = new Intent(this, MainDashboard.class);
        startActivity(intent);
    }

    public void openVisitorDashboard(){
        Intent intent = new Intent(this, VisitorDashboard.class);
        startActivity(intent);
    }
}
