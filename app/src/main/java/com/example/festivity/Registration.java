package com.example.festivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Registration extends AppCompatActivity {
    private Button button;
    private EditText name;
    private EditText passw;
    private EditText email;
    private EditText college;
    private EditText phno;
    private int regid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.editText3);
        passw = findViewById(R.id.editText5);
        email = findViewById(R.id.editText4);
        phno = findViewById(R.id.editText6);
        college = findViewById(R.id.editText7);


        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference userdb = database.getReference().child("Users");

                //Log.i("CHECK", userdb.toString());
                //DatabaseReference eventdb = database.getReference("Events");

                //Generate unique random 6 digit id
                Random random = new Random();
                regid = random.nextInt(999999);

                userdb.child(Integer.toString(regid)).child("0").setValue(name.getText().toString());
                userdb.child(Integer.toString(regid)).child("1").setValue(email.getText().toString());
                userdb.child(Integer.toString(regid)).child("2").setValue(passw.getText().toString());
                userdb.child(Integer.toString(regid)).child("3").setValue(phno.getText().toString());
                userdb.child(Integer.toString(regid)).child("4").setValue(college.getText().toString());


                //Log.i("CHECK", name.getText().toString());
            }
        });

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
