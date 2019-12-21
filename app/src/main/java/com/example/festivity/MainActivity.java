package com.example.festivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private TextView tv1;
    private String val;
    private EditText Email;
    private EditText Password;
    private FirebaseAuth firebaseAuth;

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

        Email = findViewById(R.id.editText);
        Password = findViewById(R.id.editText2);

        tv1 = findViewById(R.id.sup);
        tv1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                openRegistration();
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        button1 = findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                final String email = Email.getText().toString();
                String password = Password.getText().toString();

                if(TextUtils.isEmpty((CharSequence) email)){
                    Toast.makeText(MainActivity.this, "Please Enter Email", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty((CharSequence) password)){
                    Toast.makeText(MainActivity.this, "Please Enter Password", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    firebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        final String text = spinner.getSelectedItem().toString();

                                        if (text.equals("Visitor")) {
                                            openVisitorDashboard();
                                        } else {
                                            if(email.equals("raghav15074@iiitd.ac.in")){
                                                openMainDashboard();
                                            }
                                            if(email.equals("rahul16075@iiitd.ac.in")){
                                                openMainDashboard();
                                            }
                                            if(email.equals("ayush17334@iiitd.ac.in")){
                                                openMainDashboard();
                                            }
                                            if(email.equals("manvendernara@gmail.com")){
                                                openMainDashboard();
                                            }
                                            else{
                                                Toast.makeText(MainActivity.this, "You are not a member of " + text, Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    } else {
                                        Toast.makeText(MainActivity.this, "Login Unsuccessful", Toast.LENGTH_LONG).show();
                                    }

                                    // ...
                                }
                            });
                }

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference userdb = database.getReference().child("Users");

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
