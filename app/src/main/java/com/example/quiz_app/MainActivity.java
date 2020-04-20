package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.QuoteSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button falseBtn;
    private Button trueBtn;
    private ImageButton nextBtn;
    private ImageButton prevBtn;
    private TextView textview1;
    private int counterNext = 0;
    private Question [] questions = new Question[]{
            new Question(R.string.my_text_question1,true),
            new Question(R.string.my_text_question2,false),
            new Question(R.string.my_text_question3,true),
            new Question(R.string.my_text_question4,false),
            new Question(R.string.my_text_question5,false),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseBtn = findViewById(R.id.btn_false);
        trueBtn = findViewById(R.id.btn_true);
        nextBtn = findViewById(R.id.btn_next);
        prevBtn = findViewById(R.id.btn_prev);
        textview1 = findViewById(R.id.textview1);

        falseBtn.setOnClickListener(this);//register our buttons to click events
        trueBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
        prevBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
       switch (v.getId()){
           case R.id.btn_false:
            checkAns(false);
               break;
           case R.id.btn_true:
               checkAns(true);
       break;
           case R.id.btn_next:
                counterNext = (counterNext+1)%questions.length;
                updateQuestion();
               break;
           case R.id.btn_prev:
               if(counterNext!=0) {
                   counterNext = (counterNext-1)%questions.length;
                   updateQuestion();
               }
       }
    }
    private void updateQuestion(){
        Log.d("COUNTER","counter incremented" + counterNext);
        textview1.setText(questions[counterNext].getAnswersResId());
    }
    private void checkAns(Boolean checkedAns){
           Boolean choosedOption = questions[counterNext].isAnswerTrue();
           int toastId = 0;
           if(checkedAns==choosedOption){
               toastId = R.string.correct_answer;
           }
           else{
               toastId = R.string.wrong_answer;
           }
           Toast.makeText(MainActivity.this,toastId , Toast.LENGTH_SHORT).show();
    }
}
