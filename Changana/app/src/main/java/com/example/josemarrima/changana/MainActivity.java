package com.example.josemarrima.changana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         //Link the Layout Family Members to FamilyActivity.java
         LinearLayout family = (LinearLayout) findViewById(R.id.family);
         family.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(MainActivity.this, FamilyActivity.class);
                 startActivity(i);
             }
         });

         //Link Layout Colors to ColorsActivity.java
         LinearLayout colors = (LinearLayout) findViewById(R.id.colors);
         colors.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(MainActivity.this, ColorsActivity.class);
                 startActivity(i);
             }
         });


         //Link Layout Phrases to PhrasesActivity.java
         LinearLayout phrases = (LinearLayout) findViewById(R.id.phrases);
         phrases.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(MainActivity.this, PhrasesActivity.class);
                 startActivity(i);
             }
         });

        //Link Layout Quiz to QuizActivity.java
        LinearLayout quiz = (LinearLayout) findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(i);
            }
        });

    }

    //this function is to link Numbers Category in activity_main layout to NumbersActivity
    public void OpenNumbersActivity(View view) {
        Intent i = new Intent(this, NumbersActivity.class);
        startActivity(i);
    }


}
