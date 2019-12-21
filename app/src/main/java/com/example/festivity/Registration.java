package com.example.festivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class Registration extends AppCompatActivity {
    private Button button;
    private EditText name;
    private EditText passw;
    private EditText Email;
    private EditText college;
    private EditText phno;
    private int regid;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name = findViewById(R.id.editText3);
        passw = findViewById(R.id.editText5);
        Email = findViewById(R.id.editText4);
        phno = findViewById(R.id.editText6);
        college = findViewById(R.id.editText7);

        firebaseAuth = FirebaseAuth.getInstance();


        button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                String email = Email.getText().toString().trim();
                String password = passw.getText().toString().trim();

                if(TextUtils.isEmpty((CharSequence) email)){
                    Toast.makeText(Registration.this, "Please Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty((CharSequence) password)){
                    Toast.makeText(Registration.this, "Please Enter Password", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(Registration.this, new OnCompleteListener<AuthResult>(){
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task){
                            if(task.isSuccessful()){
                                //Registration Success

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference userdb = database.getReference().child("Users");

                                Random random = new Random();
                                regid = random.nextInt(999999);

                                userdb.child(Integer.toString(regid)).child("0").setValue(name.getText().toString());
                                userdb.child(Integer.toString(regid)).child("1").setValue(Email.getText().toString());
                                userdb.child(Integer.toString(regid)).child("2").setValue(regid);
                                userdb.child(Integer.toString(regid)).child("3").setValue(phno.getText().toString());
                                userdb.child(Integer.toString(regid)).child("4").setValue(college.getText().toString());

                                openMainActivity();
                            }
                            else{
                                Toast.makeText(Registration.this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
//
//                //Log.i("CHECK", userdb.toString());
//                //DatabaseReference eventdb = database.getReference("Events");
//
//                //Generate unique random 6 digit id

            }
        });

    }

    public void openMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
