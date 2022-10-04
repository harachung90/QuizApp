package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionTextView;
    Button answer_a, answer_b, answer_c, answer_d;
    Button submitBtn;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalQuestionsTextView = findViewById(R.id.total_question);
        questionTextView = findViewById(R.id.question);
        answer_a = findViewById(R.id.answer_a);
        answer_b = findViewById(R.id.answer_b);
        answer_c = findViewById(R.id.answer_c);
        answer_d = findViewById(R.id.answer_d);

        submitBtn = findViewById(R.id.submit_btn);

        answer_a.setOnClickListener(this);
        answer_b.setOnClickListener(this);
        answer_c.setOnClickListener(this);
        answer_d.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total questions: " + totalQuestion);

        loadNewQuestion();
    }

    @Override
    public void onClick(View view) {

        answer_a.setBackgroundColor(Color.WHITE);
        answer_b.setBackgroundColor(Color.WHITE);
        answer_c.setBackgroundColor(Color.WHITE);
        answer_d.setBackgroundColor(Color.WHITE);

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {
            if (selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])) {
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();

        } else {
            //choices button clicked
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color.MAGENTA);
        }
    }

    void loadNewQuestion() {

        if (currentQuestionIndex == totalQuestion) {
            finishQuiz();
            return;
        }
        questionTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        answer_a.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        answer_b.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        answer_c.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        answer_d.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz() {
        String passStatus =  "";
        if (score > totalQuestion * 0.60) {
            passStatus = "Passed!";
        } else {
            passStatus = "Failed!";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Your score is " + score + " out of " + totalQuestion)
                .setPositiveButton("Restart", ((dialogInterface, i) -> restartQuiz()))
                .setCancelable(false)
                .show();
    }

    void restartQuiz() {
        score = 0;
        currentQuestionIndex = 0;
        loadNewQuestion();
    }
}