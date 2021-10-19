package com.example.quizz;

public class  TrueFalse {

        private  int mQuestionID;
        private boolean mAnswer;

    public TrueFalse(int questionResourceID, boolean trueOrfalse){
         mQuestionID =questionResourceID ;
     mAnswer = trueOrfalse ;

    }





    public int getmQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}




