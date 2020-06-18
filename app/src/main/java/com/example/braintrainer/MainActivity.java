package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button GObuton;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    Button B0;Random random;TextView SumText;
    Button B1;
    Button B2;
    Button B3;GridLayout grid;
    TextView result;TextView endText;
    TextView Scores;TextView timer;
    int a, b, locationAnswers, score = 0, numQuest = 0;
    Button reset; ConstraintLayout laysecond;


    public void start(View v) {
        GObuton.setVisibility(View.INVISIBLE);
        laysecond.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.timeText));

    }
    public void playAgain(View v){
        score=0;numQuest=0;timer.setText("30s");
        Scores.setText(score+"/"+numQuest);
        grid.setVisibility(View.VISIBLE);
        result.setText(" ");
        endText.setVisibility(View.INVISIBLE);
        SumText.setVisibility(View.VISIBLE);
        newquestion();



        new CountDownTimer(30100,1000){
            @Override
            public void onTick(long l) {
                timer.setText(String.valueOf(l/1000)+"s");

            }

            @Override
            public void onFinish() {
                result.setText("Time's Up!!");
                reset.setVisibility(View.VISIBLE);
                grid.setVisibility(View.INVISIBLE);
                endText.setText("Your Final Score Is "+score+"/"+numQuest);
                endText.setVisibility(View.VISIBLE);
                SumText.setVisibility(View.INVISIBLE);






            }
        }.start();
    }

    public void newquestion() {
        a= random.nextInt(21);
        b= random.nextInt(21);


        SumText.setText(Integer.toString(a)+"+"+Integer.toString(b));

        locationAnswers= random.nextInt(4);
        answers.clear();

        for(int i=0;i<4;i++) {

            if (i == locationAnswers) {
                answers.add(a + b);
            } else {
                int x=random.nextInt(41);
                while (x==a+b){
                    x=random.nextInt(41);
                }
                answers.add(x);
            }
        }
        B0.setText(Integer.toString(answers.get(0)));
        B1.setText(Integer.toString(answers.get(1)));
        B2.setText(Integer.toString(answers.get(2)));
        B3.setText(Integer.toString(answers.get(3)));




    }

    public void chooseAnswer(View v) {
        numQuest++;
        if (v.getTag().toString().equals(Integer.toString(locationAnswers))) {
            score++;
            result.setText("Congratulation!!\n" + Integer.toString(a + b) + " " + "Is the Correct Answer");
        } else {
            result.setText("Incorrect answer!!");
        }
        Scores.setText(score + "/" + numQuest);
        newquestion();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GObuton = findViewById(R.id.goButton);
         SumText = findViewById(R.id.questionText);
        random = new Random();
        result = findViewById(R.id.resultText);
         grid= findViewById(R.id.gridLay);
        B0 = findViewById(R.id.button0);
        B1 = findViewById(R.id.button1);
        B2 = findViewById(R.id.button2);
        B3 = findViewById(R.id.button3);
        Scores = findViewById(R.id.scoreText);
         endText= findViewById(R.id.finalText);
        timer = findViewById(R.id.timeText);
        reset=findViewById(R.id.playAgainButton);
        laysecond=findViewById(R.id.secondlay);
        GObuton.setVisibility(View.VISIBLE);
        laysecond.setVisibility(View.INVISIBLE);





    }
}
