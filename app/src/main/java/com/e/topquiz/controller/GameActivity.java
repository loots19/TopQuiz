package com.e.topquiz.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.e.topquiz.R;
import com.e.topquiz.model.Question;
import com.e.topquiz.model.QuestionBank;

import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mQuestionTextView;
    private Button mAnswerButton1;
    private Button mAnswerButton2;
    private Button mAnswerButton3;
    private Button mAnswerButton4;

    private QuestionBank mQuestionBank;
    private Question mCurrentQuestion;

    private int mScore;
    private int mNumberOfQuestions;

    public static final String BUNDLE_EXTRA_SCORE = "BUNDLE_EXTRA_SCORE";
    public static final String BUNDLE_STATE_SCORE = "currentScore";
    public static final String BUNDLE_STATE_QUESTION = "currentQuestion";
    private boolean mEnableTouchEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        System.out.println("GameActivity::onCreate()");


        mQuestionBank = this.generateQuestions();


        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt(BUNDLE_STATE_SCORE);
            mNumberOfQuestions = savedInstanceState.getInt(BUNDLE_STATE_QUESTION);
        } else {
            mScore = 0;
            mNumberOfQuestions = 5;
        }
        mEnableTouchEvent = true;


        mQuestionTextView = (TextView) findViewById(R.id.activity_game_question_text);
        mAnswerButton1 = (Button) findViewById(R.id.activity_game_answer1_btn);
        mAnswerButton2 = (Button) findViewById(R.id.activity_game_answer2_btn);
        mAnswerButton3 = (Button) findViewById(R.id.activity_game_answer3_btn);
        mAnswerButton4 = (Button) findViewById(R.id.activity_game_answer4_btn);

        mAnswerButton1.setTag(0);
        mAnswerButton2.setTag(1);
        mAnswerButton3.setTag(2);
        mAnswerButton4.setTag(3);

        mAnswerButton1.setOnClickListener(this);
        mAnswerButton2.setOnClickListener(this);
        mAnswerButton3.setOnClickListener(this);
        mAnswerButton4.setOnClickListener(this);

        mCurrentQuestion = mQuestionBank.getQuestion();
        this.displayQuestion(mCurrentQuestion);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_STATE_SCORE, mScore);
        outState.putInt(BUNDLE_STATE_QUESTION, mNumberOfQuestions);

        super.onSaveInstanceState(outState);
    }

    @Override
    public void onClick(View v) {
        int responseIndex = (int) v.getTag();

        if (responseIndex == mCurrentQuestion.getAnswerIndex()) {
            // good answer
            Toast.makeText(this, "correct", Toast.LENGTH_SHORT).show();
            mScore++;

        } else {
            // wrong answer
            Toast.makeText(this, "wrong answer!", Toast.LENGTH_SHORT).show();
        }
        mEnableTouchEvent = false;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mEnableTouchEvent = true;
                if (--mNumberOfQuestions == 0) {
                    // end of game
                    endGame();
                } else {
                    mCurrentQuestion = mQuestionBank.getQuestion();
                    displayQuestion(mCurrentQuestion);
                }
            }
        },2000);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return mEnableTouchEvent && super.dispatchTouchEvent(ev);
    }

    private void endGame() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Well done!")
                .setMessage("Your score is " + mScore)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent();
                        intent.putExtra(BUNDLE_EXTRA_SCORE, mScore);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                })
                .create()
                .show();
    }

    private void displayQuestion(final Question question) {
        mQuestionTextView.setText(question.getQuestion());
        mAnswerButton1.setText(question.getChoiceList().get(0));
        mAnswerButton2.setText(question.getChoiceList().get(1));
        mAnswerButton3.setText(question.getChoiceList().get(2));
        mAnswerButton4.setText(question.getChoiceList().get(3));


    }


    private QuestionBank generateQuestions() {

        Question question1 = new Question("Qui est le meilleur ami de Elsa?",
                Arrays.asList("Olaf", "Dingo", "Snoopy", "Hans"),
                0);

        Question question2 = new Question("ou vie la reine des neige?",
                Arrays.asList("New York", "Paris", "Arendal", "Rome"),
                2);

        Question question3 = new Question(" Quel animal est Peppa Pig?",
                Arrays.asList("Vache", "Zebre", "Cochon", "Poule"),
                2);

        Question question4 = new Question("ou habite le pere noel?",
                Arrays.asList("Pole nord", "Inde", "Bouffemont", "Paris"),
                0);

        Question question5 = new Question("Que mange le mouton?",
                Arrays.asList("Mc do", "Pizza", "Herbe", "Viande"),
                2);

        Question question6 = new Question("Que mange la baleine?",
                Arrays.asList("du Foint", "du Plancton", "des Oeufs", "des Moutons"),
                1);

        Question question7 = new Question("Ou habite la pricesse Sophia?",
                Arrays.asList("Maroc", "Paris", "Istamboul", "Avalor"),
                3);

        Question question8 = new Question("Le traineau du Pere noel est trainé par?",
                Arrays.asList("Chevaux", "Lions", "Dindes", "Rennes"),
                3);

        Question question9 = new Question("2+2 est egale a?",
                Arrays.asList("0", "2", "4", "6"),
                2);

        Question question10 = new Question("Les playmobiles sont fabriqués en?",
                Arrays.asList("Carton", "Plastique", "Terre", "Bois"),
                1);

        return new QuestionBank(Arrays.asList(question1, question2, question3, question4, question5, question6, question7, question8, question9, question10));
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
