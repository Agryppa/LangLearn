package com.example.langlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class SignIn extends AppCompatActivity {
    ArrayList<String> passAL;
    ArrayList<String>loginAL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        final TextView loginS=findViewById(R.id.loginInS);
        final TextView passS=findViewById(R.id.passwordInS);
        Button button=findViewById(R.id.createB);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference ref = FirebaseDatabase.getInstance().getReference();

                ref.child("login").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        loginAL = (ArrayList<String>) dataSnapshot.getValue();

                        //Toast.makeText(getApplicationContext(), logins.get(1), Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });
                ref.child("haslo").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        passAL = (ArrayList<String>) dataSnapshot.getValue();
                        //Toast.makeText(getApplicationContext(), logins.get(1), Toast.LENGTH_SHORT).show();



                    }

                    @Override
                    public void onCancelled(DatabaseError error) {
                        // Failed to read value

                    }
                });

                Login.logins.add(loginS.getText().toString());
                ref.child("login").setValue(Login.logins);
                ArrayList<String> temp2= Login.passwords;
                Login.passwords.add(passS.getText().toString());
                ref.child("haslo").setValue(Login.passwords);


                Intent i=new Intent(getApplicationContext(),Login.class);
                startActivity(i);
            }
        });
    }
}
