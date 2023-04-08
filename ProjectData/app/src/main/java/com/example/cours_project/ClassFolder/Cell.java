package com.example.cours_project.ClassFolder;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

import com.example.cours_project.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Cell implements Serializable {
    public int x_position;
    public int y_position;
    public Figure currentFigure;
    public ImageButton linketButton;

    public Cell(){}

    public Cell(int x_position, int y_position, ImageButton linketButton) {
        this.x_position = x_position;
        this.y_position = y_position;
        this.linketButton = linketButton;
    }

    public ArrayList<Cell> getFigureMove(GameField gameField)
    {
        ArrayList<Cell> arrayList = currentFigure.typeMove(gameField,this.x_position,this.y_position);
        return arrayList;
    }

}
