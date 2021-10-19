package com.example.quizz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Food extends AppCompatActivity {
    TextView nQuestionTextView;
    TextView nScoreText;
    ProgressBar nProgressBar;


    final int PROGRESS_BAR_INCREMENT = 10;
    int nScore;
    int mIndex;
    int mQuestion;

    private final TrueFalse[] nQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_21, false),
            new TrueFalse(R.string.question_22, true),
            new TrueFalse(R.string.question_23, true),
            new TrueFalse(R.string.question_24, false),
            new TrueFalse(R.string.question_25, true),
            new TrueFalse(R.string.question_26, false),
            new TrueFalse(R.string.question_27, true),
            new TrueFalse(R.string.question_28, false),
            new TrueFalse(R.string.question_29, true),
            new TrueFalse(R.string.question_30, true),

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
        setContentView(R.layout.activity_food);

        nQuestionTextView = (TextView) findViewById(R.id.textView6);
        nScoreText = (TextView) findViewById(R.id.textView5);
        nProgressBar = (ProgressBar) findViewById(R.id.progressBar4);

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