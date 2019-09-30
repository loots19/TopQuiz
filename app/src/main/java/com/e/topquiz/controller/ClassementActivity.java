package com.e.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.e.topquiz.R;

public class ClassementActivity extends AppCompatActivity {
    private TextView mTextView;
    private RadioButton mScoreButton;
    private RadioButton mAlphabetButton;
    private TextView mTextView1;

    private int score;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);


        mTextView = (TextView) findViewById(R.id.activity_classement_text);
        mScoreButton = (RadioButton) findViewById(R.id.activity_classement_Button_Score);
        mAlphabetButton = (RadioButton) findViewById(R.id.activity_classement_Button_Alphabet);
        mTextView1 = (TextView) findViewById(R.id.activity_classement_textView1);

        mScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                classementScore();

            }


        });
        mAlphabetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }

    private void classementScore() {
    }


}
