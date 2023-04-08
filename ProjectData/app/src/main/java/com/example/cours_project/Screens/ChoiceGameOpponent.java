package com.example.cours_project.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cours_project.R;

public class ChoiceGameOpponent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_game_opponent);
    }

    public void FromChoiceGameToChoiceField(View v)
    {
        Intent ToChoiceField = new Intent(this, ChoiceField.class);
        startActivity(ToChoiceField);
    }
}