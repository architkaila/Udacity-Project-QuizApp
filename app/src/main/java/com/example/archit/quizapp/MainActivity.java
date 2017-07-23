package com.example.archit.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ScrollView scroll;
    private RadioGroup radioGroupOne;
    private RadioGroup radioGroupTwo;
    private RadioGroup radioGroupThree;
    private RadioGroup radioGroupFour;
    private RadioGroup radioGroupFive;
    private RadioButton question1;
    private RadioButton question2;
    private RadioButton question3;
    private RadioButton question4;
    private RadioButton question7;
    private CheckBox question8_1;
    private CheckBox question8_2;
    private CheckBox question8_4;
    private CheckBox wrongAnswerEight;
    private EditText question5;
    private EditText question6;
    private int correctAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scroll = (ScrollView) findViewById(R.id.Scroll);

        question1 = (RadioButton) findViewById(R.id.correctAnswerOne);
        question2 = (RadioButton) findViewById(R.id.correctAnswerTwo);
        question3 = (RadioButton) findViewById(R.id.correctAnswerThree);
        question4 = (RadioButton) findViewById(R.id.correctAnswerFour);
        question5 = (EditText) findViewById(R.id.userResponseFive);
        question6 = (EditText) findViewById(R.id.userResponseSix);
        question7 = (RadioButton) findViewById(R.id.correctAnswerSeven);
        question8_1 = (CheckBox) findViewById(R.id.correctAnswerEight_1);
        question8_2 = (CheckBox) findViewById(R.id.correctAnswerEight_2);
        question8_4 = (CheckBox) findViewById(R.id.correctAnswerEight_3);

        wrongAnswerEight = (CheckBox) findViewById(R.id.wrongAnswerEight);
        radioGroupOne = (RadioGroup) findViewById(R.id.radioGroupOne);
        radioGroupTwo = (RadioGroup) findViewById(R.id.radioGroupTwo);
        radioGroupThree = (RadioGroup) findViewById(R.id.radioGroupThree);
        radioGroupFour = (RadioGroup) findViewById(R.id.radioGroupFour);
        radioGroupFive = (RadioGroup) findViewById(R.id.radioGroupFive);

    }

    public void SubmitResponse(View v) {

        String answerFive = getResources().getString(R.string.AnswerFive);
        String answerSix = getResources().getString(R.string.AnswerSix);
        String wrongAnswers = "Check :";
        if (question1.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q1\n";
        }
        if (question2.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q2\n";
        }
        if (question3.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q3\n";
        }

        if (question4.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q4\n";
        }

        if (answerFive.equals(question5.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q5\n";
        }

        if (answerSix.equals(question6.getText().toString())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q6\n";
        }

        if (question7.isChecked()) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q7\n";
        }

        if (question8_1.isChecked() && question8_2.isChecked() && question8_4.isChecked() && !(wrongAnswerEight.isChecked())) {
            correctAnswers++;
        } else {
            wrongAnswers = wrongAnswers + "Q8\n";
        }


        if (correctAnswers == 8) {
            Toast.makeText(this, "Congrats, All Answers Correct", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Correct Answers: " + correctAnswers + " /8\n" + wrongAnswers, Toast.LENGTH_LONG).show();
        }

        ResetQuiz(findViewById(R.id.all));

    }

    public void ResetQuiz(View v) {

        correctAnswers = 0;

        question5.getText().clear();
        question6.getText().clear();

        radioGroupOne.clearCheck();
        radioGroupTwo.clearCheck();
        radioGroupThree.clearCheck();
        radioGroupFour.clearCheck();
        radioGroupFive.clearCheck();

        if (question8_1.isChecked()) {
            question8_1.toggle();
        }

        if (question8_2.isChecked()) {
            question8_2.toggle();
        }

        if (question8_4.isChecked()) {
            question8_4.toggle();
        }

        if (wrongAnswerEight.isChecked()) {
            wrongAnswerEight.toggle();
        }

        scroll.fullScroll(ScrollView.FOCUS_UP);
    }
}
