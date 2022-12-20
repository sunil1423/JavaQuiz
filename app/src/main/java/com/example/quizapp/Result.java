package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    Button re;
    TextView t1, t2,t3;
    public int data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        t1 = (TextView)findViewById(R.id.textView5);
        t2 = (TextView)findViewById(R.id.textView6);
        t3 = (TextView)findViewById(R.id.textView7);
        re = (Button) findViewById(R.id.button4);

        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =  new Intent(Result.this,MainActivity.class) ;
                startActivity(i);
                finish();
            }
        });

    }

}