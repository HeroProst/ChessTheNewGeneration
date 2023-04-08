package com.example.cours_project.ClassFolder;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Horse extends Figure{

    public Horse()
    {this.price = 4;}

    public Horse(int localId, Boolean player)
    {
        this.localId = localId;
        this.globalId = 1;
        this.player = player;
        this.price = 4;
    }

    public ArrayList<Cell> typeMove(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        if(x_pos + 2  < gameField.gameField.length)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos + 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 1][x_pos + 2].currentFigure.player) {
                        gameField.gameField[y_pos + 1][x_pos + 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos + 1][x_pos + 2]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos + 1][x_pos + 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos + 1][x_pos + 2].linketButton.setEnabled(true);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos + 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 1][x_pos + 2].currentFigure.player) {
                        gameField.gameField[y_pos - 1][x_pos + 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos - 1][x_pos + 2]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos - 1][x_pos + 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos - 1][x_pos + 2].linketButton.setEnabled(true);
                }
            }
        }
        if(x_pos - 2 >= 0)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos - 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 1][x_pos - 2].currentFigure.player) {
                        gameField.gameField[y_pos + 1][x_pos - 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos + 1][x_pos - 2]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos + 1][x_pos - 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos + 1][x_pos - 2].linketButton.setEnabled(true);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos - 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 1][x_pos - 2].currentFigure.player) {
                        gameField.gameField[y_pos - 1][x_pos - 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos - 1][x_pos - 2]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos - 1][x_pos - 2].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos - 1][x_pos - 2].linketButton.setEnabled(true);
                }
            }
        }
        if(y_pos + 2 < gameField.gameField.length)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 2][x_pos + 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 2][x_pos + 1].currentFigure.player) {
                        gameField.gameField[y_pos + 2][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos + 2][x_pos + 1]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos + 2][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos + 2][x_pos + 1].linketButton.setEnabled(true);
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos + 2][x_pos - 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 2][x_pos - 1].currentFigure.player) {
                        gameField.gameField[y_pos + 2][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos + 2][x_pos - 1]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos + 2][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos + 2][x_pos - 1].linketButton.setEnabled(true);
                }
            }
        }
        if(y_pos - 2 >= 0)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos - 2][x_pos + 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 2][x_pos + 1].currentFigure.player) {
                        gameField.gameField[y_pos - 2][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos - 2][x_pos + 1]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos - 2][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos - 2][x_pos + 1].linketButton.setEnabled(true);
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 2][x_pos - 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 2][x_pos - 1].currentFigure.player) {
                        gameField.gameField[y_pos - 2][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos - 2][x_pos - 1]);
                    }
                }
                else
                {
                    gameField.gameField[y_pos - 2][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos - 2][x_pos - 1].linketButton.setEnabled(true);
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Cell> checkMate(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> dangerForKingCell = new ArrayList<>();
        ArrayList<Cell> kingZone = findEnemyKing(gameField);
        if(x_pos + 2  < gameField.gameField.length)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos + 2].currentFigure == null || gameField.gameField[y_pos + 1][x_pos + 2].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + 1][x_pos + 2]))
                        dangerForKingCell.add(gameField.gameField[y_pos + 1][x_pos + 2]);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos + 2].currentFigure == null || gameField.gameField[y_pos - 1][x_pos + 2].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - 1][x_pos + 2]))
                        dangerForKingCell.add(gameField.gameField[y_pos - 1][x_pos + 2]);
                }
            }
        }
        if(x_pos - 2 >= 0)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos - 2].currentFigure == null || gameField.gameField[y_pos + 1][x_pos - 2].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + 1][x_pos - 2]))
                        dangerForKingCell.add(gameField.gameField[y_pos + 1][x_pos - 2]);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos - 2].currentFigure == null || gameField.gameField[y_pos - 1][x_pos - 2].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - 1][x_pos - 2]))
                        dangerForKingCell.add(gameField.gameField[y_pos - 1][x_pos - 2]);
                }
            }
        }
        if(y_pos + 2 < gameField.gameField.length)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 2][x_pos + 1].currentFigure == null || gameField.gameField[y_pos + 2][x_pos + 1].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + 2][x_pos + 1]))
                        dangerForKingCell.add(gameField.gameField[y_pos + 2][x_pos + 1]);
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos + 2][x_pos - 1].currentFigure == null || gameField.gameField[y_pos + 2][x_pos - 1].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + 2][x_pos - 1]))
                        dangerForKingCell.add(gameField.gameField[y_pos + 2][x_pos - 1]);
                }
            }
        }
        if(y_pos - 2 >= 0)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos - 2][x_pos + 1].currentFigure == null || gameField.gameField[y_pos - 2][x_pos + 1].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - 2][x_pos + 1]))
                        dangerForKingCell.add(gameField.gameField[y_pos - 2][x_pos + 1]);
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 2][x_pos - 1].currentFigure == null || gameField.gameField[y_pos - 2][x_pos - 1].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - 2][x_pos - 1]))
                        dangerForKingCell.add(gameField.gameField[y_pos - 2][x_pos - 1]);
                }
            }
        }
        return dangerForKingCell;
    }

    public ArrayList<Cell> wayToKing(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        arrayList.add(gameField.gameField[y_pos][x_pos]);
        if(x_pos + 2  < gameField.gameField.length)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos + 2].currentFigure != null) {
                    if(this.player != gameField.gameField[y_pos + 1][x_pos + 2].currentFigure.player)
                        if(gameField.gameField[y_pos + 1][x_pos + 2].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos + 1][x_pos + 2]);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos + 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 1][x_pos + 2].currentFigure.player) {
                        if(gameField.gameField[y_pos - 1][x_pos + 2].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos - 1][x_pos + 2]);
                    }
                }
            }
        }
        if(x_pos - 2 >= 0)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos - 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 1][x_pos - 2].currentFigure.player) {
                        if(gameField.gameField[y_pos + 1][x_pos - 2].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos + 1][x_pos - 2]);
                    }
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos - 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 1][x_pos - 2].currentFigure.player) {
                        if(gameField.gameField[y_pos - 1][x_pos - 2].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos - 1][x_pos - 2]);
                    }
                }
            }
        }
        if(y_pos + 2 < gameField.gameField.length)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 2][x_pos + 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 2][x_pos + 1].currentFigure.player) {
                        if(gameField.gameField[y_pos + 2][x_pos + 1].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos + 2][x_pos + 1]);
                    }
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos + 2][x_pos - 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 2][x_pos - 1].currentFigure.player) {
                        if(gameField.gameField[y_pos + 2][x_pos - 1].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos + 2][x_pos - 1]);
                    }
                }
            }
        }
        if(y_pos - 2 >= 0)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos - 2][x_pos + 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 2][x_pos + 1].currentFigure.player) {
                        if(gameField.gameField[y_pos - 2][x_pos + 1].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos - 2][x_pos + 1]);
                    }
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 2][x_pos - 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 2][x_pos - 1].currentFigure.player) {
                        if(gameField.gameField[y_pos - 2][x_pos - 1].currentFigure.getClass() == King.class)
                            arrayList.add(gameField.gameField[y_pos - 2][x_pos - 1]);
                    }
                }
            }
        }
        return arrayList;
    }

    public ArrayList<Cell> traceTypeMove(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> arrayList = new ArrayList<>();
        if(x_pos + 2  < gameField.gameField.length)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos + 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 1][x_pos + 2].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + 1][x_pos + 2]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos + 1][x_pos + 2]);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos + 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 1][x_pos + 2].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos - 1][x_pos + 2]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos - 1][x_pos + 2]);
                }
            }
        }
        if(x_pos - 2 >= 0)
        {
            if(y_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 1][x_pos - 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 1][x_pos - 2].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + 1][x_pos - 2]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos + 1][x_pos - 2]);
                }
            }
            if(y_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 1][x_pos - 2].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 1][x_pos - 2].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos - 1][x_pos - 2]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos - 1][x_pos - 2]);
                }
            }
        }
        if(y_pos + 2 < gameField.gameField.length)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos + 2][x_pos + 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 2][x_pos + 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + 2][x_pos + 1]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos + 2][x_pos + 1]);
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos + 2][x_pos - 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + 2][x_pos - 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + 2][x_pos - 1]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos + 2][x_pos - 1]);
                }
            }
        }
        if(y_pos - 2 >= 0)
        {
            if(x_pos + 1 < gameField.gameField.length)
            {
                if(gameField.gameField[y_pos - 2][x_pos + 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 2][x_pos + 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos - 2][x_pos + 1]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos - 2][x_pos + 1]);
                }
            }
            if(x_pos - 1 >= 0)
            {
                if(gameField.gameField[y_pos - 2][x_pos - 1].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - 2][x_pos - 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos - 2][x_pos - 1]);
                    }
                }
                else
                {
                    arrayList.add(gameField.gameField[y_pos - 2][x_pos - 1]);
                }
            }
        }
        return arrayList;
    }


}
