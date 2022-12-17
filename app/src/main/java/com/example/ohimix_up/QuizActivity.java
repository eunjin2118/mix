package com.example.ohimix_up;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    TextView txtQuestionNum, txtQuestion;
    RadioGroup rg;
    RadioButton rgO, rgX;

    int score = 0;
    int totalQuestion = QuestionAnswer.question.length;
    int currentQuestionIndex = 0; //현재 질문의 인덱스
    int questionIndex[] = randomNum();
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
                loadNewQuestion();
                switch (checkedId){
                    case R.id.rgO:
                        selectedAnswer = "O";
                        if(!selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex++])){//맞음
//                            Toast.makeText(getApplicationContext(), "맞았습니다.", Toast.LENGTH_SHORT).show();
                            score++;
                        }else{//틀림
                        }
                        rg.clearCheck();
                        break;
                    case R.id.rgX:
                        selectedAnswer = "X";
                        if(!selectedAnswer.equals(QuestionAnswer.correctAnswer[currentQuestionIndex++])){//맞음
                        }else{//틀림
                        }
                        rg.clearCheck();
                        break;
                }
            }
        });
        loadNewQuestion();
    }

    private void loadNewQuestion() {
        if(currentQuestionIndex<=4){
            txtQuestion.setText(QuestionAnswer.question[questionIndex[currentQuestionIndex]]);
            txtQuestionNum.setText((currentQuestionIndex+1)+"/5");
        }else{
            finishQuiz();
        }

    }

    void finishQuiz(){
        Intent intent = new Intent(this, QuizResultActivity.class);
        intent.putExtra("score", String.valueOf(score));
//        finishAffinity();
        startActivities(new Intent[]{intent});
    }

    int[] randomNum(){
        int a[] = new int[5];
        for(int i=0; i<5; i++){
            int random = (int) (Math.random() * totalQuestion); //난수 발생
            a[i]=random;
            for(int j=0; j<i; j++){
                if(a[i]==a[j]) i--;
            }
        }
//        int a[]= {2,3,3,4,6};
        return a;
    }
}