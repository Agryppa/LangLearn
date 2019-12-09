package com.example.langlearn;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.langlearn.MainActivity.getCurrLang;

public class GrammarActivity extends AppCompatActivity {

    private ArrayList<Chapter> chapters;


    private Integer getFlag(){
        switch(getCurrLang()){
            case de:
                return R.drawable.de;
            case is:
                return R.drawable.ice;
            case cn:
                return R.drawable.prc;
            default:
                return null;
        }
    }

    private Integer getChapters(){
        switch(getCurrLang()){
            case de:
                return R.array.grammarQGer;
            case is:
                return R.array.grammarQIce;
            case cn:
                return R.array.grammarQCn;
            default:
                return null;
        }

    }
    private void fill(){
        chapters=new ArrayList<>();
        TypedArray res = getResources().obtainTypedArray(getChapters());

        for(int i=0;i<res.length();i++){
            chapters.add(new Chapter(getString(R.string.chapter)+Integer.toString(i+1),  i, getFlag()));
        }

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
                /*Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();*/
                Intent i=new Intent(getApplicationContext(), GrammarEx.class);
                i.putExtra("pos", position);
                startActivity(i);
            }
        });
    }
}
