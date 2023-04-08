package com.example.cours_project.ClassFolder;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.example.cours_project.R;

import java.util.ArrayList;

public class Pawns extends Figure {

    public Pawns(){this.price = 1;}

    public Pawns(int localId, Boolean player) {
        this.localId = localId;
        this.globalId = 1;
        this.player = player;
        this.price = 1;
    }

    public ArrayList<Cell> typeMove(@NonNull GameField gameField, int x_pos, int y_pos) {
        int offset = 0;
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
            if (this.player) {
                offset = -1;
                if(y_pos == gameField.gameField.length - 1 || y_pos == gameField.gameField.length - 2)
                    if (gameField.gameField[y_pos - 2][x_pos].currentFigure == null) {
                        gameField.gameField[y_pos - 2][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        gameField.gameField[y_pos - 2][x_pos].linketButton.setEnabled(true);
                    }
            }
            else {
                offset = 1;
                if(y_pos == 0 || y_pos == 1)
                    if (gameField.gameField[y_pos + 2][x_pos].currentFigure == null) {
                        gameField.gameField[y_pos + 2][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        gameField.gameField[y_pos + 2][x_pos].linketButton.setEnabled(true);
                    }
            }
        if (y_pos + offset >= 0 && y_pos + offset < gameField.gameField.length) {
            if (gameField.gameField[y_pos + offset][x_pos].currentFigure == null) {
                gameField.gameField[y_pos + offset][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                gameField.gameField[y_pos + offset][x_pos].linketButton.setEnabled(true);
            }

            if (x_pos + 1 < gameField.gameField.length)
                if (gameField.gameField[y_pos + offset][x_pos + 1].currentFigure != null)
                    if (player != gameField.gameField[y_pos + offset][x_pos + 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + offset][x_pos + 1]);
                        gameField.gameField[y_pos + offset][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    }
            if (x_pos - 1 >= 0)
                if (gameField.gameField[y_pos + offset][x_pos - 1].currentFigure != null)
                    if (player != gameField.gameField[y_pos + offset][x_pos - 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + offset][x_pos - 1]);
                        gameField.gameField[y_pos + offset][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    }
        }
        return arrayList;
    }

    public ArrayList<Cell> checkMate(@NonNull GameField gameField, int x_pos, int y_pos) {
        int offset = 0;
        ArrayList<Cell> dangerForKingCell = new ArrayList<>();
        ArrayList<Cell> kingZone = findEnemyKing(gameField);
        if (y_pos != 0 && y_pos + 1 != gameField.gameField.length) {
            if (this.player)
                offset = -1;
            else
                offset = 1;
            if (x_pos + 1 < gameField.gameField.length)
                if (gameField.gameField[y_pos + offset][x_pos + 1].currentFigure == null || gameField.gameField[y_pos + offset][x_pos + 1].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + offset][x_pos + 1]))
                        dangerForKingCell.add(gameField.gameField[y_pos + offset][x_pos + 1]);
                }
            if (x_pos - 1 >= 0)
                if (gameField.gameField[y_pos + offset][x_pos - 1].currentFigure == null || gameField.gameField[y_pos + offset][x_pos - 1].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + offset][x_pos - 1]))
                        dangerForKingCell.add(gameField.gameField[y_pos + offset][x_pos - 1]);
                }
        }
        return dangerForKingCell;
    }

    public ArrayList<Cell> wayToKing(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        arrayList.add(gameField.gameField[y_pos][x_pos]);
        int offset = 0;
        if (y_pos != 0 && y_pos + 1 != gameField.gameField.length) {
            if (this.player)
                offset = -1;
            else
                offset = 1;
            if (gameField.gameField[y_pos + offset][x_pos].currentFigure != null) {
                if (gameField.gameField[y_pos + offset][x_pos].currentFigure.player != this.player)
                    if (gameField.gameField[y_pos + offset][x_pos].currentFigure.getClass() == King.class) {
                        arrayList.add(gameField.gameField[y_pos + offset][x_pos]);
                    }
            }
        }
        return arrayList;
    }

    public ArrayList<Cell> traceTypeMove(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        int offset;
        ArrayList<Cell> arrayList = new ArrayList<>();
        if (y_pos != 0 && y_pos + 1 != gameField.gameField.length) {
            if (this.player)
                offset = -1;
            else
                offset = 1;
            if (gameField.gameField[y_pos + offset][x_pos].currentFigure == null) {
                arrayList.add(gameField.gameField[y_pos + offset][x_pos]);
            }
            if (x_pos + 1 < gameField.gameField.length)
                if (gameField.gameField[y_pos + offset][x_pos + 1].currentFigure != null)
                    if (player != gameField.gameField[y_pos + offset][x_pos + 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + offset][x_pos + 1]);
                    }
            if (x_pos - 1 >= 0)
                if (gameField.gameField[y_pos + offset][x_pos - 1].currentFigure != null)
                    if (player != gameField.gameField[y_pos + offset][x_pos - 1].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + offset][x_pos - 1]);
                    }
        }
        return arrayList;
    }
}
