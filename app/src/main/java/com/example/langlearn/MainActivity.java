package com.example.langlearn;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private enum Language  {de, is, cn}

    private Language currLang;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        settingsB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Settings.class);
                startActivity(i);

            }
        });
        chapterB.setBackgroundColor(getResources().getColor(R.color.button));
        settingsB.setBackgroundColor(getResources().getColor(R.color.button));
        grammarB.setBackgroundColor(getResources().getColor(R.color.button));
        grammarB.setTextColor(getResources().getColor(R.color.background));
        settingsB.setTextColor(getResources().getColor(R.color.background));
        chapterB.setTextColor(getResources().getColor(R.color.background));


        /*final ImageButton ger=findViewById(R.id.gerButton);
        ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ger.setColorFilter(R.color.button);
            }
        });*/
    }
}
