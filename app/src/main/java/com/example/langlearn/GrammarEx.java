package com.example.langlearn;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.langlearn.MainActivity.getCurrLang;
import static com.example.langlearn.R.*;
import static com.example.langlearn.R.string.*;

public class GrammarEx extends AppCompatActivity {
    private GrammarQ[] questions;
    private int questionNumber=0;
    private String userAnswer;

    private Integer getQuestions(){
        switch(getCurrLang()){
            case de:
                return array.grammarQGER;
            case is:
                return array.grammarQICE;
            case cn:
                return array.grammarQCN;
            default:
                return null;
        }
    }

    private Integer getAnswers(){
        switch(getCurrLang()){
            case de:
                return array.grammarAGER;
            case is:
                return array.grammarAICE;
            case cn:
                return array.grammarACN;
            default:
                return null;
        }
    }

    private void fillQ(){
        String[] questionsXML = getResources().getStringArray(getQuestions());
        String[] answersXML = getResources().getStringArray(getAnswers());
        questions = new GrammarQ[questionsXML.length];
        for(int i = 0; i<questionsXML.length;i++){
            questions[i] = new GrammarQ(questionsXML[i], new String[]{answersXML[i]});
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fillQ();
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_grammar_ex);

        getSupportActionBar().hide();
        final Button question =findViewById(id.questionTextB2);
        final EditText answer=findViewById(id.answerGrammar);
        answer.getText().clear();
        question.setText(questions[questionNumber].getQuestion());
        Button check=findViewById(id.checkGrammar);
        check.setBackgroundColor(getResources().getColor(color.button));
        //check.setTextColor(getResources().getColor(color.background));
        question.setBackgroundColor(getResources().getColor(color.button));
        //question.setTextColor(getResources().getColor(color.background));
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAnswer=answer.getText().toString();
                for(int i=0;i<questions[questionNumber].getPosAnswers().length;i++){
                    if(questions[questionNumber].getPosAnswers()[i].equals(userAnswer)){
                        Toast.makeText(getApplicationContext(), right,Toast.LENGTH_SHORT).show();
                        questionNumber++;
                        if(questionNumber<questions.length){
                            question.setText(questions[questionNumber].getQuestion());
                            answer.getText().clear();
                        }else
                        {
                            Toast.makeText(getApplicationContext(), chapter_end, Toast.LENGTH_SHORT).show();
                            Intent i1=new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(i1);
                        }
                        break;
                    }else
                        Toast.makeText(getApplicationContext(), wrong,Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
