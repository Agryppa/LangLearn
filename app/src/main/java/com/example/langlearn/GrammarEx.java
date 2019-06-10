package com.example.langlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GrammarEx extends AppCompatActivity {
    private GrammarQ[] questions;
    private int questionNumber=0;
    private String userAnswer;
    private void fillQ(){
        questions=new GrammarQ[3];
        questions[0]=new GrammarQ("Auf den gut __________________ Straßen meiner Stadt kann man auch nachts " +
                "spazieren gehen. (beleuchten)", new String[]{"beleuchteten"});
        questions[1]=new GrammarQ("Nach der __________________ Prüfung haben die Studenten gefeiert. (bestehen)", new String[]{"bestandenen"});
        questions[2]=new GrammarQ(". Ich habe die auf die Straße __________________ Verpackung in den Mülleimer" +
                "getan. (wegwerfen)", new String[]{"weggeworfene"});

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fillQ();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar_ex);
        final Button question =findViewById(R.id.questionTextB2);
        final EditText answer=findViewById(R.id.answerGrammar);
        answer.getText().clear();
        question.setText(questions[questionNumber].getQuestion());
        Button check=findViewById(R.id.checkGrammar);
        check.setBackgroundColor(getResources().getColor(R.color.button));
        check.setTextColor(getResources().getColor(R.color.background));
        question.setBackgroundColor(getResources().getColor(R.color.button));
        question.setTextColor(getResources().getColor(R.color.background));
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer=answer.getText().toString();
                for(int i=0;i<questions[questionNumber].getPosAnswers().length;i++){
                    if(questions[questionNumber].getPosAnswers()[i].equals(userAnswer)){
                        Toast.makeText(getApplicationContext(),"Richtig!",Toast.LENGTH_SHORT).show();
                        questionNumber++;
                        if(questionNumber<questions.length){
                            question.setText(questions[questionNumber].getQuestion());
                            answer.getText().clear();
                        }else
                        {
                            Toast.makeText(getApplicationContext(), "Kapitel beendet!", Toast.LENGTH_SHORT).show();
                            Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i1);
                        }
                        break;
                    }else
                        Toast.makeText(getApplicationContext(),"Leider falsch!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
