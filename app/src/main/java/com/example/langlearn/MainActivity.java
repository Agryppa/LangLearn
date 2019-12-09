package com.example.langlearn;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public enum Language  {de, is, cn}

    private static Language currLang = Language.de;
    private ImageView ger;
    private ImageView is;
    private ImageView cn;

    public static Language getCurrLang(){
        return currLang;
    }


    View.OnClickListener startActivity(final Class activity){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), activity);
                startActivity(i);

            }
        };
        return listener;

    }

    private void setFlag(){
        cn.clearColorFilter();
        ger.clearColorFilter();
        is.clearColorFilter();
        if(getCurrLang()==null)
            return;
        switch(getCurrLang()){
            case de:
                ger.setColorFilter(R.color.button);
                break;
            case is:
                is.setColorFilter(R.color.button);
                break;
            case cn:
                cn.setColorFilter(R.color.button);
                break;
            default:

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        String login=getIntent().getStringExtra("login");
        Button userB=findViewById(R.id.userB);
        userB.setText(login);
        Button chapterB= findViewById(R.id.chapter_button);
        chapterB.setOnClickListener(startActivity(Chapters.class));
        Button grammarB= findViewById(R.id.grammar_button);
        grammarB.setOnClickListener(startActivity(GrammarActivity.class));
        Button settingsB= findViewById(R.id.settings_button);
        settingsB.setOnClickListener(startActivity(Settings.class));

        chapterB.setBackgroundColor(getResources().getColor(R.color.button));
        settingsB.setBackgroundColor(getResources().getColor(R.color.button));
        grammarB.setBackgroundColor(getResources().getColor(R.color.button));
        //grammarB.setTextColor(getResources().getColor(R.color.background));
        //settingsB.setTextColor(getResources().getColor(R.color.background));
        //chapterB.setTextColor(getResources().getColor(R.color.background));
        ger=findViewById(R.id.gerButton);
        is=findViewById(R.id.iceButton);
        cn=findViewById(R.id.cnButton);
        setFlag();

        ger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currLang = Language.de;
                setFlag();
            }
        });


        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currLang = Language.cn;
                setFlag();
            }
        });

        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currLang = Language.is;
                setFlag();

            }
        });
    }
}
