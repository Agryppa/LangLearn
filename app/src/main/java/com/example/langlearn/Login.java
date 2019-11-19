package com.example.langlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Login extends AppCompatActivity {

    public static ArrayList<String> logins=new ArrayList<>();
    public static ArrayList passwords=new ArrayList<>();
    boolean checkLogin(String login, String pass){
        for(int i=0;i<logins.size();i++){
            if(logins.get(i)!=null)
                if(logins.get(i).equals(login)&&passwords.get(i).equals(pass)){
                    return true;
                }
        }
        return false;
    }
    void base() {


        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("login").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                ArrayList<String> loginAL = (ArrayList<String>) dataSnapshot.getValue();
                logins = loginAL;
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

                ArrayList<String> passAL = (ArrayList<String>) dataSnapshot.getValue();
                //Toast.makeText(getApplicationContext(), logins.get(1), Toast.LENGTH_SHORT).show();

                passwords = passAL;

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Button login=findViewById(R.id.createB);
        base();
        final TextView loginTV=findViewById(R.id.loginInS);
        final TextView passTV=findViewById(R.id.passwordInS);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginT;
                String passwordT;
                loginT=loginTV.getText().toString();
                passwordT=passTV.getText().toString();
                //if(checkLogin(loginT,passwordT)){
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("login", loginT);
                    startActivity(i);
                //}
            }
        });

        Button signin=findViewById(R.id.signUp);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignIn.class);
                startActivity(i);
            }
        });

    }
}
