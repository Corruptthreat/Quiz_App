package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button falseBtn;
    private Button trueBtn;
    private TextView textview1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        falseBtn = findViewById(R.id.btn_false);
        trueBtn = findViewById(R.id.btn_true);
        textview1 = findViewById(R.id.textview1);

        falseBtn.setOnClickListener(this);//register our buttons to click events
        trueBtn.setOnClickListener(this);
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
       }
    }
}
