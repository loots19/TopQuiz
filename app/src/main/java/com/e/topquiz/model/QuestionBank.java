package com.e.topquiz.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuestionBank {

    private List<Question> mQuestionList;
    private int mNextQuestionIndex;

    public QuestionBank(List<Question> questionList) {
        mQuestionList=questionList;

        // Shuffle the question list before storing it
        Collections.shuffle(mQuestionList);

        mNextQuestionIndex = 0;
    }


    public Question getQuestion() {
        if (mNextQuestionIndex==mQuestionList.size()){
            mNextQuestionIndex=0;
        }

        // Loop over the questions and return a new one at each call
        return mQuestionList.get(mNextQuestionIndex++);
    }


}


