package com.example.langlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    void base(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(getApplicationContext(),value,Toast.LENGTH_SHORT).show();
                //Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(, "Failed to read value.", error.toException());
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        base();
        String login=getIntent().getStringExtra("login");
        Button userB=findViewById(R.id.userB);
        userB.setText(login);
        Button chapterB= findViewById(R.id.chapter_button);
        chapterB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Chapters.class);
                startActivity(i);

            }
        });
        Button grammarB= findViewById(R.id.grammar_button);
        grammarB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), GrammarActivity.class);
                startActivity(i);

            }
        });
        Button settingsB= findViewById(R.id.settings_button);
        /*settingsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Chapters.class);
                startActivity(i);

            }
        });*/
        chapterB.setBackgroundColor(getResources().getColor(R.color.button));
        settingsB.setBackgroundColor(getResources().getColor(R.color.button));
        grammarB.setBackgroundColor(getResources().getColor(R.color.button));
        grammarB.setTextColor(getResources().getColor(R.color.background));
        settingsB.setTextColor(getResources().getColor(R.color.background));
        chapterB.setTextColor(getResources().getColor(R.color.background));


        final ImageButton ger=findViewById(R.id.imageView);
        ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ger.setColorFilter(R.color.button);
            }
        });
    }
}
