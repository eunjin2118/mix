package com.example.ohimix_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class QuizResultActivity extends AppCompatActivity {
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        Intent intent = getIntent();
        String getScore = intent.getStringExtra("score");

        txtResult = findViewById(R.id.txtResult);
        txtResult.setText(getScore+"개 맞췄어요!");

    }
}