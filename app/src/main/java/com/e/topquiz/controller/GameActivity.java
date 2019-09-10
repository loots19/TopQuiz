package com.e.topquiz.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.e.topquiz.R;

public class GameActivity extends AppCompatActivity {
    private TextView mGreetinText;
    private Button mPlayButton1;
    private Button mPlayButton2;
    private Button mPlayButton3;
    private Button mPlayButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        mGreetinText = (TextView) findViewById(R.id.activity_game_question_text);
        mPlayButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mPlayButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mPlayButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mPlayButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);

    }
}
