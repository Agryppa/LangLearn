package com.example.langlearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private ArrayList<TestQ> qlist= new ArrayList<>();
    int currQ=0;


    void fill(){
        qlist.add(new TestQ("Wie geht es __", "dir", "dich", "du", "sie", 1));
        qlist.add(new TestQ("Was machst __", "dir", "dich", "du", "sie", 3));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int chapterN=getIntent().getIntExtra("pos",0);
        setContentView(R.layout.activity_test_q);
        if(chapterN==0)
            fill();
        final Button question=findViewById(R.id.questionTextB1);
        final RadioButton rba=findViewById(R.id.radioA);
        final RadioButton rbb=findViewById(R.id.radioB);
        final RadioButton rbc=findViewById(R.id.radioC);
        final RadioButton rbd=findViewById(R.id.radioD);
        Button checkB=findViewById(R.id.checkButton);
        checkB.setBackgroundColor(getResources().getColor(R.color.button));
        checkB.setTextColor(getResources().getColor(R.color.background));
        question.setBackgroundColor(getResources().getColor(R.color.button));
        question.setTextColor(getResources().getColor(R.color.background));
        question.setText(qlist.get(currQ).getQuestion());
        rba.setText(qlist.get(currQ).getA());
        rbb.setText(qlist.get(currQ).getB());
        rbc.setText(qlist.get(currQ).getC());
        rbd.setText(qlist.get(currQ).getD());


        checkB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean f=false;
                switch(qlist.get(currQ).getRight()) {
                    case 1:
                        if(rba.isChecked())
                            f=true;
                        rba.setChecked(false);
                        break;
                    case 2:
                        if(rbb.isChecked())
                            f=true;
                        rbb.setChecked(false);
                        break;
                    case 3:
                        if(rbc.isChecked())
                            f=true;
                        rbc.setChecked(false);
                        break;
                    case 4:
                        if(rbd.isChecked())
                            f=true;
                        rbd.setChecked(false);
                        break;
                }
                if(f){
                    Toast.makeText(getApplicationContext(), "Richtig!", Toast.LENGTH_SHORT).show();
                    currQ++;
                    if(currQ==qlist.size()){
                        Toast.makeText(getApplicationContext(), "Kapitel beendet!", Toast.LENGTH_SHORT).show();
                    }else{
                        question.setText(qlist.get(currQ).getQuestion());
                        rba.setText(qlist.get(currQ).getA());
                        rbb.setText(qlist.get(currQ).getB());
                        rbc.setText(qlist.get(currQ).getC());
                        rbd.setText(qlist.get(currQ).getD());
                    }
                }else
                    Toast.makeText(getApplicationContext(),"Leider falsch!",Toast.LENGTH_SHORT).show();
            }
        });


    }
}
