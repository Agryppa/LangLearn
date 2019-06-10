package com.example.langlearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    String[] logins={"test1", "ja"};
    String[] passwords={"test", "haslo"};
    boolean checkLogin(String login, String pass){
        for(int i=0;i<logins.length;i++){
            if(logins[i].equals(login)&&passwords[i].equals(pass)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Button login=findViewById(R.id.createB);

        final TextView loginTV=findViewById(R.id.loginInS);
        final TextView passTV=findViewById(R.id.passwordInS);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginT;
                String passwordT;
                loginT=loginTV.getText().toString();
                passwordT=passTV.getText().toString();
                if(checkLogin(loginT,passwordT)){
                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("login", loginT);
                    startActivity(i);
                }
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
