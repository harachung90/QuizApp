package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

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
    }

    @Override
    public void onClick(View view) {

    }
}