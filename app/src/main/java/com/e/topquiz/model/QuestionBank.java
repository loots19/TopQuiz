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

    Question question1 = new Question("Qui est le meilleur ami de Elsa?",
             Arrays.asList("Olaf","Dingo","Snoopy","Hans"),
            0);

    Question question2 = new Question("ou vie la reine des neige?",
             Arrays.asList("New York","Paris","Arendal","Rome"),
            2);

    Question question3 = new Question(" Quel animal est Peppa Pig?",
             Arrays.asList("Vache","Zebre","Cochon","Poule"),
            2);

    Question question4 = new Question("ou habite le pere noel?",
             Arrays.asList("Pole nord","Inde","Bouffemont","Paris"),
            0);

    Question question5 = new Question("Que mange le mouton?",
            Arrays.asList("Mc do","Pizza","Herbe","Viande"),
                    2);

    Question question6 = new Question("Que mange la baleine?",
            Arrays.asList("du Foint","du Plancton","des Oeufs","des Moutons"),
            1);

    Question question7 = new Question("Ou habite la pricesse Sophia?",
            Arrays.asList("Maroc","Paris","Istamboul","Avalor"),
            3);

    Question question8 = new Question("Le traineau du Pere noel est trainé par?",
            Arrays.asList("Chevaux","Lions","Dindes","Rennes"),
            3);

    Question question9 = new Question("2+2 est egale a?",
            Arrays.asList("0","2","4","6"),
            3);

    Question question10 = new Question("Les playmobiles sont fabriqués en?",
            Arrays.asList("Carton","Plastique","Terre","Bois"),
            1);



}


