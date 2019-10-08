package com.e.topquiz.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.e.topquiz.R;
import com.e.topquiz.model.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private TextView mGreetinText;
    private EditText mNameInput;
    private Button mPlayButton;
    private Button mScoreButton;
    private User mUser;
    public static final int Game_Activity_Request_Code = 1;
    public static final int Score_Activity_request_code = 2;
    private SharedPreferences mPreferences;
    private String mName;
    private int mScore;
    


    public static final String PREF_KEY_SCORE = "PREF_KEY_SCORE";
    public static final String PREF_KEY_FIRSTNAME = "PREF_KEY_FIRSTNAME";
    public static final String PREF_KEY_USER = "PREF_KEY_USER";


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (Game_Activity_Request_Code == requestCode && RESULT_OK == resultCode) {
            int score = data.getIntExtra(GameActivity.BUNDLE_EXTRA_SCORE,0);
            mPreferences.edit().putInt(PREF_KEY_SCORE,score).apply();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("MainActivity :: onStart()");

        mUser = new User();


        mPreferences = getPreferences(MODE_PRIVATE);

        mGreetinText = (TextView) findViewById(R.id.activity_main_greetin_txt);
        mNameInput = (EditText) findViewById(R.id.activity_main_name_input);
        mPlayButton = (Button) findViewById(R.id.activity_main_btn);
        mScoreButton = (Button)findViewById(R.id.activity_score_btn);


        mPlayButton.setEnabled(false);

        greetUser();


        mNameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mPlayButton.setEnabled(s.toString().length() != 0);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        {
            mPlayButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String firstnanme = mNameInput.getText().toString();
                    mUser.setFirstName(firstnanme);
                    mPreferences.edit().putString(PREF_KEY_FIRSTNAME,mUser.getFirstName()).apply();
                    Intent gameActivityIntent = new Intent(MainActivity.this, GameActivity.class);
                    startActivityForResult(gameActivityIntent,Game_Activity_Request_Code);

                }
            });
            mScoreButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String firstnanme = mNameInput.getText().toString();
                    int score = mPreferences.getInt(PREF_KEY_SCORE, 0);
                    Intent ClassementActivityIntent = new Intent(MainActivity.this, ClassementActivity.class);
                    ClassementActivityIntent.putExtra("mName",firstnanme);
                    ClassementActivityIntent.putExtra("mScore",score);
                    startActivity(ClassementActivityIntent);
                }


            });


        }

    }

    private void greetUser() {
        String Firstname = mPreferences.getString(PREF_KEY_FIRSTNAME, null);

        if (null != Firstname) {
            int score = mPreferences.getInt(PREF_KEY_SCORE, 0);
            String fullText = "welcomme back," + Firstname
                    + "\n last time your score was " + score
                    + ", do better this time";
            mGreetinText.setText(fullText);
            mNameInput.setText(Firstname);
            mNameInput.setSelection(Firstname.length());
            mPlayButton.setEnabled(true);
        }




        }


    @Override
    protected void onPostResume() {
        super.onPostResume();
        System.out.println("GameActivity::onResume()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("GameActivity::onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("GameActivity::onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("GameActivity::onDestroy()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("GameActivity::onPause()");
    }


}
