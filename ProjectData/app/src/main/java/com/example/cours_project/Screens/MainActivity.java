package com.example.cours_project.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cours_project.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void FromMainToChoiceGame(View v)
    {
        Intent inte = new Intent(this, ChoiceGameOpponent.class);
        startActivity(inte);
    }
}