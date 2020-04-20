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
        textview1 = findViewById(R.id.textview1);

        falseBtn.setOnClickListener(this);//register our buttons to click events
        trueBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
       switch (v.getId()){
           case R.id.btn_false:
               Toast.makeText(MainActivity.this,"False",Toast.LENGTH_SHORT).show();
               break;
           case R.id.btn_true:
               Toast.makeText(MainActivity.this,"True",Toast.LENGTH_SHORT).show();
       break;
           case R.id.btn_next:
                counterNext = (counterNext+1)%questions.length;
               Log.d("COUNTER","counter incremented" + counterNext);
               textview1.setText(questions[counterNext].getAnswersResId());
               break;
       }
    }
}
