package com.e.topquiz.model;

import java.util.List;

public class Question {
    private String mQuestion;
    private List<String> mChoiceList;
    private int mAnswerIndex;

    public Question(String question, List<String> choiceList, int answerIndex) {
        mQuestion = question;
        mChoiceList = choiceList;
        mAnswerIndex = answerIndex;
    }

    public String getQuestion() {
        return mQuestion;
    }

    public void setQuestion(String question) {
        mQuestion = question;
    }

    public List<String> getChoiceList() {
        return mChoiceList;
    }

    public void setChoiceList(List<String> choiceList) {
        if (mChoiceList == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        mChoiceList = choiceList;

    }
        public int getAnswerIndex() {
            return mAnswerIndex;
        }

        public void setAnswerIndex ( int answerIndex){
        if (mAnswerIndex<0 || mAnswerIndex >3) {
            throw new IllegalArgumentException("Answer index is out of found");
        }
            mAnswerIndex = answerIndex;


        }

    @Override
    public String toString() {
        return "Question{" +
                "mQuestion='" + mQuestion + '\'' +
                ", mChoiceList=" + mChoiceList +
                ", mAnswerIndex=" + mAnswerIndex +
                '}';
    }
}