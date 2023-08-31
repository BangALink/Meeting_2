package com.example.meeting2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    private Questions[]questionBank = new Questions[]{
            new Questions(R.string.Question1,true),
            new Questions(R.string.Question2,false),
            new Questions(R.string.Question3,false),
            new Questions(R.string.Question4,true),
            new Questions(R.string.Question5,false),
            new Questions(R.string.Question6,true)
    };
    private int current = 0;

    private TextView tv1;
    private Button buttonT;
    private Button buttonF;
    private Button buttonN;
    private Button Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.textView);
        buttonT = findViewById(R.id.buttonT);
        buttonF = findViewById(R.id.buttonF);
        buttonN = findViewById(R.id.buttonN);
        Result = findViewById(R.id.Result);

        buttonT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        buttonF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        buttonN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = (current+1)%questionBank.length;
                updateQuestions();
            }
        });
        Result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=dQw4w9WgXcQ&pp=ygUJcmljayByb2xs"));
                startActivity(i);
            }
        });
        //Toast.makeText(getApplicationContext(), R.string.welcome, Toast.LENGTH_SHORT).show();

        //Toast.makeText(getApplicationContext(),questionBank[0].getResId(),Toast.LENGTH_LONG).show();
    }

    private void updateQuestions() {
        int question = questionBank[current].getResId();
        tv1.setText(question);
    }

    private void checkAnswer(boolean b){
        boolean trueAnswer = questionBank[current].getAnswer();
        if (trueAnswer==b){
            Toast.makeText(getApplicationContext(),R.string.responsetrue,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),R.string.responsefalse,Toast.LENGTH_LONG).show();
        }
    }
}