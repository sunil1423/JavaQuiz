package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button , button1;
    EditText editText;
    String EditText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       button = (Button)findViewById(R.id.button);
       button1 = (Button)findViewById(R.id.button1);
       editText = (EditText)findViewById(R.id.edit);

       button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,About.class);
               startActivity(intent);
               finish();




           }
       });

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if (editText.length() == 0) {
                   Toast toast = Toast.makeText(getApplicationContext(), "Enter Your Name!",Toast.LENGTH_SHORT);
                   toast.show();
               }

               else {

                   Intent i = new Intent(MainActivity.this, Start.class);
                   EditText = editText.getText().toString();

                   i.putExtra("keyname", EditText);
                   startActivity(i);
                   finish();
               }
           }
       });

    }
}