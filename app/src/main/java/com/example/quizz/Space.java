package com.example.quizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;



public class Space extends AppCompatActivity {

    TextView nQuestionTextView;
    TextView nScoreText;
    ProgressBar nProgressBar;


    final int PROGRESS_BAR_INCREMENT = 10;
    int nScore;
    int mIndex;
    int mQuestion;

    private final TrueFalse[] nQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),

    };

    public void trueButton(View v) {


        checkAnswer(true);
        updateQuestion();

    }

    public void falseButton(View v) {

        checkAnswer(true);
        updateQuestion();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space);

        nQuestionTextView = (TextView) findViewById(R.id.textView);
        nScoreText = (TextView) findViewById(R.id.textView4);
        nProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

        mQuestion = nQuestionBank[mIndex].getmQuestionID();

        nQuestionTextView.setText(mQuestion);


    }

    public void updateQuestion() {
        nScoreText.setText("Score " + nScore + "/10");
        nProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);

        mIndex = (mIndex + 1) % 10;
        mQuestion = nQuestionBank[mIndex].getmQuestionID();
        nQuestionTextView.setText(mQuestion);

        if(mIndex == 0){
            AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(this);
            myAlertDialog.setTitle("Game Over");
            myAlertDialog.setCancelable(false);
            myAlertDialog.setMessage("You Scored" + nScore);
            myAlertDialog.setPositiveButton("Close Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            myAlertDialog.show();
        }
    }

    public void checkAnswer(boolean userSelection) {
        boolean correctAnswer = nQuestionBank[mIndex].ismAnswer();
        if (userSelection == correctAnswer) {
            nScore = nScore + 1;
            Toast.makeText(getApplicationContext(),"You Got It", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Wrong", Toast.LENGTH_SHORT).show();
        }


    }
}