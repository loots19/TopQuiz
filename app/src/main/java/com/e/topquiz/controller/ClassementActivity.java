package com.e.topquiz.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.e.topquiz.R;
import com.e.topquiz.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.e.topquiz.controller.MainActivity.PREF_KEY_FIRSTNAME;

public class ClassementActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView;
    private RadioButton mScoreButton;
    private RadioButton mAlphabetButton;
    private TextView mTextView1;
    private SharedPreferences mPreferences;
    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_USER = "PREF_KEY_USER";
    private User mUser;
    private List<String> user;

    private String mName;
    private int mScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classement);


        mTextView = (TextView) findViewById(R.id.activity_classement_text);
        mScoreButton = (RadioButton) findViewById(R.id.activity_classement_Button_Score);
        mAlphabetButton = (RadioButton) findViewById(R.id.activity_classement_Button_Alphabet);
        mTextView1 = (TextView) findViewById(R.id.activity_classement_textView1);


        mPreferences = getPreferences(MODE_PRIVATE);
        mScoreButton.setOnClickListener(this);
        mAlphabetButton.setOnClickListener(this);
        mUser = new User();


    }

    @Override
    public void onClick(View v) {

        if (v == mAlphabetButton) {
            classementA();


        } else if (v == mScoreButton) {
            classementS();

        }
    }

    private void classementS() {

    }

    private void classementA() {

        Intent intent = getIntent();
        if (intent != null) {
            String firstname = "";
            if (intent.hasExtra("mName")) ;
            firstname = intent.getStringExtra("mName");

            Set<String> user = new HashSet<>();

                user.add(firstname);
                user.add(firstname);
                user.add(firstname);
                user.add(firstname);
                user.add(firstname);
                String fullText = "" + user;
                mTextView1 = (TextView) findViewById(R.id.activity_classement_textView1);
                mTextView1.setText(fullText);


            }

        }
    }
