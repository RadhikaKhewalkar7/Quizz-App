package com.example.quizz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void spaceScreen(View v){
        Intent spaceScreenLoad = new Intent(  this,Space.class);
        startActivity(spaceScreenLoad);
    }

    public void scienceScreen(View v){
        Intent scienceScreenLoad = new Intent(  this,Science.class);
        startActivity(scienceScreenLoad);
    }

    public void foodScreen(View v){
        Intent foodScreenLoad = new Intent(  this,Food.class);
        startActivity(foodScreenLoad);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}