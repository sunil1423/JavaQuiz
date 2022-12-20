package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Start extends AppCompatActivity {

    TextView textname,tv  ;
    String EditText;
    Button submitbutton , quitbutton;
    RadioButton rb1, rb2,rb3,rb4;
    RadioGroup radio_g;
   TextView score;

    String questions[]={
            "Which method can be defined only once in a program?",
            "Which keyword is used by method to refer to the current object thatinvoked it?",
            "Which of these access specifiers can be used for an interface?",
            "Which of the following is correct way of importing an entire package‘pkg’?",
            "What is the return type of Constructors?"
    };

    String answer[] = {"main method","this","public","import pkg.*","None of the mentioned"};

    String option[] = {
            "finalize method","main method","static method","private method",
            "import","this","catch","abstract",
            "public","protected","private","All of the mentioned",
            "Import pkg.","import pkg.*","Import pkg.*","import pkg.",
            "int","float","void","None of the mentioned"
    };

    int flag = 0;
    public static int marks=0,correct=0,wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


         score =(TextView)findViewById(R.id.textView4);
        textname = findViewById(R.id.text_name);
         EditText = getIntent().getStringExtra("keyname");
        textname.setText("   Hello "+EditText);


        submitbutton = (Button) findViewById(R.id.button3);
        quitbutton = (Button) findViewById(R.id.buttonquit);
        tv = (TextView) findViewById(R.id.tvque);

        radio_g = (RadioGroup) findViewById(R.id.radioGroup);
        rb1 =(RadioButton) findViewById(R.id.radio1);
        rb2 =(RadioButton) findViewById(R.id.radio2);
        rb3 =(RadioButton) findViewById(R.id.radio3);
        rb4 =(RadioButton) findViewById(R.id.radio4);
        tv.setText(questions[flag]);
        rb1.setText(option[0]);
        rb2.setText(option[1]);
        rb3.setText(option[2]);
        rb4.setText(option[3]);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(),"Please text one choice",Toast.LENGTH_SHORT).show();
                    return;
                }

                RadioButton v =(RadioButton) findViewById(radio_g.getCheckedRadioButtonId());

                String ans = v.getText().toString();

                if(ans.equals(answer[flag]))
                {
                    correct++;
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();

                }

                else
                {
                    wrong++;
                    Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                }

                flag++;

                if(score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(option[flag*4 ]);
                    rb2.setText(option[flag*4 +1]);
                    rb3.setText(option[flag*4 +2]);
                    rb4.setText(option[flag*4 +3]);
                }


                else
                {
                    marks = correct;
                    Intent iy =  new Intent(getApplicationContext(),Result.class) ;
                    startActivity(iy);
                    finish();

                }


                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent it =  new Intent(getApplicationContext(),Result.class) ;
                startActivity(it);
                finish();

            }
        });



    }
}