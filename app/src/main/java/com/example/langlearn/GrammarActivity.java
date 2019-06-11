package com.example.langlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class GrammarActivity extends AppCompatActivity {

    private ArrayList<Chapter> chapters;
    private void fill(){
        chapters=new ArrayList<>();
        chapters.add(new Chapter("Kapitel 1", 0, R.drawable.de));
        chapters.add(new Chapter("Kapitel 2", 1, R.drawable.de));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar);
        fill();

        ListView lv=findViewById(R.id.chapterList2);
        ListAdapter la=new ListAdapter(getApplicationContext(), chapters);
        lv.setAdapter(la);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
                Intent i=new Intent(getApplicationContext(), GrammarEx.class);
                i.putExtra("pos", position);
                startActivity(i);
            }
        });
    }
}