package com.example.langlearn;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.langlearn.MainActivity.getCurrLang;

public class TestActivity extends AppCompatActivity {

    private ArrayList<TestQ> qlist= new ArrayList<>();
    private int currQ=0;
    private int chapterNr = 0;

    private int getChapterNr(){
        return getIntent().getIntExtra("pos", 0);
    }

    private Integer getQuestions(){
        TypedArray chapters;
        switch(getCurrLang()){
            case de:
                 chapters = getResources().obtainTypedArray(R.array.chapterQGer);
                return chapters.getResourceId(getChapterNr(), 0);
            case is:
                chapters = getResources().obtainTypedArray(R.array.chapterQICE);
                return chapters.getResourceId(getChapterNr(), 0);
            case cn:
                chapters = getResources().obtainTypedArray(R.array.chapterQCN);
                return chapters.getResourceId(getChapterNr(), 0);
            default:
                return null;
        }
    }

    private Integer getAnswers(){
        TypedArray answers;
        switch(getCurrLang()){
            case de:
                answers = getResources().obtainTypedArray(R.array.chapterAGer);
                return answers.getResourceId(getChapterNr(), 0);
            case is:
                answers = getResources().obtainTypedArray(R.array.chapterAICE);
                return answers.getResourceId(getChapterNr(), 0);
            case cn:
                answers = getResources().obtainTypedArray(R.array.chapterACN);
                return answers.getResourceId(getChapterNr(), 0);
            default:
                return null;
        }
    }

    private Integer getCorrectAnswers() {
        TypedArray correct;
        switch (getCurrLang()) {
            case de:
                correct = getResources().obtainTypedArray(R.array.chapterCGer);
                return correct.getResourceId(getChapterNr(), 0);
            case is:
                correct = getResources().obtainTypedArray(R.array.chapterCICE);
                return correct.getResourceId(getChapterNr(), 0);
            case cn:
                correct = getResources().obtainTypedArray(R.array.chapterCCN);
                return correct.getResourceId(getChapterNr(), 0);
            default:
                return null;
        }
    }

    private void fill(){
        /*qlist.add(new TestQ(getString(R.string.TestQ1), getString(R.string.TestQ1An1),
                getString(R.string.TestQ1An2), getString(R.string.TestQ1An3), getString(R.string.TestQ1An4), 1));


*/
        String[] questionsXML = getResources().getStringArray(getQuestions());
        TypedArray answersXML = getResources().obtainTypedArray(getAnswers());

        int[] correctXML = getResources().getIntArray(getCorrectAnswers());
        //questions = new GrammarQ[questionsXML.length];
        for(int i = 0; i<questionsXML.length;i++){
            int id = answersXML.getResourceId(i, 0);
            String[] aa = getResources().getStringArray(id);
            qlist.add(new TestQ(questionsXML[i], aa[0], aa[1], aa[2], aa[3], correctXML[i]));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int chapterN=getIntent().getIntExtra("pos",0);
        setContentView(R.layout.activity_test_q);
        getSupportActionBar().hide();

        if(chapterN==0)
            fill();
        final Button question=findViewById(R.id.questionTextB1);
        final RadioButton rba=findViewById(R.id.radioA);
        final RadioButton rbb=findViewById(R.id.radioB);
        final RadioButton rbc=findViewById(R.id.radioC);
        final RadioButton rbd=findViewById(R.id.radioD);
        Button checkB=findViewById(R.id.checkButton);
        checkB.setBackgroundColor(getResources().getColor(R.color.button));
        //checkB.setTextColor(getResources().getColor(R.color.background));
        question.setBackgroundColor(getResources().getColor(R.color.button));
        //question.setTextColor(getResources().getColor(R.color.background));
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
                    Toast.makeText(getApplicationContext(), getString(R.string.right), Toast.LENGTH_SHORT).show();
                    currQ++;
                    if(currQ==qlist.size()){
                        Toast.makeText(getApplicationContext(), getString(R.string.chapter_end), Toast.LENGTH_SHORT).show();
                        open();
                        Intent i=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }else{
                        question.setText(qlist.get(currQ).getQuestion());
                        rba.setText(qlist.get(currQ).getA());
                        rbb.setText(qlist.get(currQ).getB());
                        rbc.setText(qlist.get(currQ).getC());
                        rbd.setText(qlist.get(currQ).getD());
                    }
                }else
                    Toast.makeText(getApplicationContext(),getString(R.string.wrong),Toast.LENGTH_SHORT).show();
            }
        });


    }


    public void open(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure You wanted to make decision");
                alertDialogBuilder.setPositiveButton("yes",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(getApplicationContext(),"You clicked yes button",Toast.LENGTH_LONG).show();
                            }
                        });

        /*alertDialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });*/

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
