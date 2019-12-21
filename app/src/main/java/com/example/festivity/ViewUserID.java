package com.example.festivity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewUserID extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase database;
    private DatabaseReference userdb;
    private String user;
    private TextView user_id;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_userid);

        user_id = findViewById(R.id.userid);

        UserInformation ui = null;

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
//       String email = currentUser.getEmail().toString();
        user = currentUser.getUid();

        userdb = database.getReference().child("Users");

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                    if(user != null) {
                        //User is signed in
                    }
                    else{
                        //User is signed out
                    }
            }
        };

        userdb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                showData(dataSnapshot);
//              System.out.println(dataSnapshot.getValue());
//              id = dataSnapshot.child("Users").child(user).child("2").getValue().toString();

//                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
////                   UserInformation ui = childSnapshot.getValue(UserInformation.class);
//                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
//            Log.d("CHECK",id);
            user_id.setText(user);

    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if(mAuthListener != null){
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

//    private void showData(DataSnapshot dataSnapshot) {
//
//        for(DataSnapshot ds : dataSnapshot.getChildren()){
//              UserInformation ui = new UserInformation();
//              ui.setName(ds.child(user).getValue(UserInformation.class).getName());
//              ui.setEmail(ds.child(user).getValue(UserInformation.class).getEmail());
//              ui.setUserID(ds.child(user).getValue(UserInformation.class).getUserID());
//              ui.setPhone(ds.child(user).getValue(UserInformation.class).getPhone());
//              ui.setCollege(ds.child(user).getValue(UserInformation.class).getCollege());
//
//              id = ui.getUserID();
//
//        }

//        user_id = findViewById(R.id.userid);
//        UserInformation uInfo = new UserInformation();
//        String str = dataSnapshot.child(String.valueOf(2)).getValue().toString();
//        user_id.setText(str);

//    }
}
