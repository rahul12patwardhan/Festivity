package com.example.festivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private String val;
    private FirebaseAuth mAuth;
    private EditText Email;
    private EditText Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference userdb = database.getReference("Users");

        //myRef.child("users").child(userId).setValue(user);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Team, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

//      final String text = spinner.getSelectedItem().toString();



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

                if (text.equals("Visitor")) {
                    openVisitorDashboard();
                } else {
                    openMainDashboard();
                }

            }
        });


    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
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
