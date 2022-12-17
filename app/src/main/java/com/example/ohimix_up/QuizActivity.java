package com.example.ohimix_up;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {
    TextView txtQuestionNum, txtQuestion;
    RadioGroup rg;
    RadioButton rgO, rgX;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0; //현재 질문의 인덱스
    int random = (int) (Math.random() * totalQuestion); //난수 발생
    String selectedAnswer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        txtQuestionNum = findViewById(R.id.txtQuestionNum);
        txtQuestion = findViewById(R.id.txtQuestion);
        rg = findViewById(R.id.rg);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                currentQuestionIndex++;
                loadNewQuestion();
                switch (checkedId){
                    case R.id.rgO:
                        selectedAnswer = "O";
                        if(selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
                            Toast.makeText(getApplicationContext(), "맞았습니다.", Toast.LENGTH_SHORT).show();
                            score++;
                        }
                        break;
                    case R.id.rgX:
                        selectedAnswer = "X";
                        if(!selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex])){
                            Toast.makeText(getApplicationContext(), "틀렸습니다.", Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
            }
        });
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        txtQuestion.setText(QuestionAnswer.question[currentQuestionIndex]);
        txtQuestionNum.setText((currentQuestionIndex+1)+"/5");
        if(currentQuestionIndex==5) finishQuiz();
    }

    void finishQuiz(){
        String passStatus = "";
        Toast.makeText(getApplicationContext(), "끝", Toast.LENGTH_SHORT).show();
    }
}