package com.example.cours_project.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.cours_project.R;

public class ChoiceField extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice_field);
    }

    public void FromChoiceFieldToGameScreen_8x8(View v)
    {
        Intent intent = new Intent(this, WhitePick_8x8.class);
        startActivity(intent);
    }

    public void FromChoiceFieldToGameScreen_5x5(View v)
    {
        Intent intent = new Intent(this, WhitePick_5x5.class);
        startActivity(intent);
    }

    public void FromChoiceFieldToGameScreen_10x10(View v)
    {
        Intent intent = new Intent(this, WhitePick_10x10.class);
        startActivity(intent);
    }

}