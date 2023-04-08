package com.example.cours_project.ClassFolder;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class King extends Figure{

    public King(int localId, Boolean player)
    {
        this.localId = localId;
        this.globalId = 1;
        this.player = player;
        price = 0;
    }

    public ArrayList<Cell> typeMove(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        ArrayList dangerZone = new ArrayList();
        for(int y = 0; y < gameField.gameField.length; y++)
        {
            for(int x = 0; x < gameField.gameField[0].length;x++)
            {
                if(gameField.gameField[y][x].currentFigure != null)
                    if (gameField.gameField[y][x].currentFigure.player != this.player) {
                        if (gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            for (Cell cell : gameField.gameField[y][x].currentFigure.checkMate(gameField, x, y))
                                dangerZone.add(cell);
                        else
                            for(Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMoveForKing(gameField, x, y))
                                dangerZone.add(cell);
                    }
            }
        }
        if(y_pos + 1 < gameField.gameField.length)
            if(!dangerZone.contains(gameField.gameField[y_pos + 1][x_pos]))
                if(gameField.gameField[y_pos + 1][x_pos].currentFigure == null) {
                    gameField.gameField[y_pos + 1][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos + 1][x_pos].linketButton.setEnabled(true);
                }
                else
                {
                    if(player != gameField.gameField[y_pos + 1][x_pos].currentFigure.player)
                    {
                        arrayList.add(gameField.gameField[y_pos + 1][x_pos]);
                        gameField.gameField[y_pos + 1][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    }
                }
        if(y_pos - 1 >= 0)
            if(!dangerZone.contains(gameField.gameField[y_pos - 1][x_pos]))
                if(gameField.gameField[y_pos - 1][x_pos].currentFigure == null) {
                    gameField.gameField[y_pos - 1][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    gameField.gameField[y_pos - 1][x_pos].linketButton.setEnabled(true);
                }
                else
                {
                    if(player != gameField.gameField[y_pos - 1][x_pos].currentFigure.player)
                    {
                        arrayList.add(gameField.gameField[y_pos - 1][x_pos]);
                        gameField.gameField[y_pos - 1][x_pos].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    }
                }

        for(int i = -1; i <= 1;i++)
        {
            if(y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos + 1 < gameField.gameField.length)
                if(!dangerZone.contains(gameField.gameField[y_pos + i][x_pos + 1]))
                    if(gameField.gameField[y_pos + i][x_pos + 1].currentFigure == null) {
                        gameField.gameField[y_pos + i][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        gameField.gameField[y_pos + i][x_pos + 1].linketButton.setEnabled(true);
                    }
                    else
                    {
                        if(player != gameField.gameField[y_pos + i][x_pos + 1].currentFigure.player)
                        {
                            arrayList.add(gameField.gameField[y_pos + i][x_pos + 1]);
                            gameField.gameField[y_pos + i][x_pos + 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        }
                    }
        }
        for(int i = -1; i <= 1;i++)
        {
            if(y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos - 1 >= 0)
                if(!dangerZone.contains(gameField.gameField[y_pos + i][x_pos - 1]))
                    if(gameField.gameField[y_pos + i][x_pos - 1].currentFigure == null) {
                        gameField.gameField[y_pos + i][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        gameField.gameField[y_pos + i][x_pos - 1].linketButton.setEnabled(true);
                    }
                    else
                    {
                        if(player != gameField.gameField[y_pos + i][x_pos - 1].currentFigure.player)
                        {
                            arrayList.add(gameField.gameField[y_pos + i][x_pos - 1]);
                            gameField.gameField[y_pos + i][x_pos - 1].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        }
                    }
        }
        return arrayList;
    }

    public ArrayList<Cell> checkMate(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> dangerForKingCell = new ArrayList<>();
        ArrayList<Cell> kingZone = findEnemyKing(gameField);
        ArrayList dangerZone = new ArrayList();
        for (int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                if (gameField.gameField[y][x].currentFigure != null)
                    if (gameField.gameField[y][x].currentFigure.player != this.player) {
                        if (gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            for (Cell cell : gameField.gameField[y][x].currentFigure.checkMate(gameField, x, y))
                                dangerZone.add(cell);
                        else
                            for(Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMoveForKing(gameField, x, y))
                                dangerZone.add(cell);
                    }
            }
        }
        if (y_pos + 1 < gameField.gameField.length)
            if (!dangerZone.contains(gameField.gameField[y_pos + 1][x_pos]))
                if (gameField.gameField[y_pos + 1][x_pos].currentFigure == null || gameField.gameField[y_pos + 1][x_pos].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + 1][x_pos]))
                        dangerForKingCell.add(gameField.gameField[y_pos + 1][x_pos]);
                }
        if (y_pos - 1 >= 0)
            if (!dangerZone.contains(gameField.gameField[y_pos - 1][x_pos]))
                if (gameField.gameField[y_pos - 1][x_pos].currentFigure == null || gameField.gameField[y_pos - 1][x_pos].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - 1][x_pos]))
                        dangerForKingCell.add(gameField.gameField[y_pos - 1][x_pos]);
                }

        for (int i = -1; i <= 1; i++) {
            if (y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos + 1 < gameField.gameField.length)
                if (!dangerZone.contains(gameField.gameField[y_pos + i][x_pos + 1]))
                    if (gameField.gameField[y_pos + i][x_pos + 1].currentFigure == null || gameField.gameField[y_pos + i][x_pos + 1].currentFigure.getClass() == King.class) {
                        if (kingZone.contains(gameField.gameField[y_pos + i][x_pos + 1]))
                            dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos + 1]);
                    }
        }
        for (int i = -1; i <= 1; i++) {
            if (y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos - 1 >= 0)
                if (!dangerZone.contains(gameField.gameField[y_pos + i][x_pos - 1]))
                    if (gameField.gameField[y_pos + i][x_pos - 1].currentFigure == null || gameField.gameField[y_pos + i][x_pos - 1].currentFigure.getClass() == King.class) {
                        if (kingZone.contains(gameField.gameField[y_pos + i][x_pos - 1]))
                            dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos - 1]);

                    }
        }
        return dangerForKingCell;
    }

    public ArrayList<Cell> traceTypeMoveForKing(@NonNull GameField gameField, int x_pos, int y_pos){
        ArrayList<Cell> dangerForKingCell = new ArrayList<>();
        if (y_pos + 1 < gameField.gameField.length) {
            if (gameField.gameField[y_pos + 1][x_pos].currentFigure != null) {
                if (gameField.gameField[y_pos + 1][x_pos].currentFigure.player != player)
                    dangerForKingCell.add(gameField.gameField[y_pos + 1][x_pos]);
            } else
                dangerForKingCell.add(gameField.gameField[y_pos + 1][x_pos]);
        }

        if (y_pos - 1 >= 0) {
            if (gameField.gameField[y_pos - 1][x_pos].currentFigure != null) {
                if (gameField.gameField[y_pos - 1][x_pos].currentFigure.player != player)
                    dangerForKingCell.add(gameField.gameField[y_pos - 1][x_pos]);
            } else
                dangerForKingCell.add(gameField.gameField[y_pos - 1][x_pos]);
        }

        for (int i = -1; i <= 1; i++) {
            if (y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos + 1 < gameField.gameField.length) {
                if (gameField.gameField[y_pos + i][x_pos + 1].currentFigure != null) {
                    if (gameField.gameField[y_pos + i][x_pos + 1].currentFigure.player != player)
                        dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos + 1]);
                    break;
                } else
                    dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos + 1]);
            }

        }
        for (int i = -1; i <= 1; i++) {
            if (y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos - 1 >= 0) {
                if (gameField.gameField[y_pos + i][x_pos - 1].currentFigure != null) {
                    if (gameField.gameField[y_pos + i][x_pos - 1].currentFigure.player != player)
                        dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos - 1]);
                    break;
                } else
                    dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos - 1]);
            }
        }
        return dangerForKingCell;
    }

    public ArrayList<Cell> saveEnabledCellForKing(GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arr = new ArrayList<>();
        ArrayList dangerZone = new ArrayList();
        for(int y = 0; y < gameField.gameField.length; y++)
        {
            for(int x = 0; x < gameField.gameField[0].length;x++)
            {
                if(gameField.gameField[y][x].currentFigure != null)
                    if (gameField.gameField[y][x].currentFigure.player != this.player) {
                        if (gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            for (Cell cell : gameField.gameField[y][x].currentFigure.checkMate(gameField, x, y))
                                dangerZone.add(cell);
                        else
                            for(Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMoveForKing(gameField, x, y))
                                dangerZone.add(cell);
                    }
            }
        }
        if(y_pos + 1 < gameField.gameField.length)
            if(!dangerZone.contains(gameField.gameField[y_pos + 1][x_pos]))
                if(gameField.gameField[y_pos + 1][x_pos].currentFigure == null) {
                    arr.add(gameField.gameField[y_pos + 1][x_pos]);
                }
                else
                {
                    if(player != gameField.gameField[y_pos + 1][x_pos].currentFigure.player)
                    {
                        arr.add(gameField.gameField[y_pos + 1][x_pos]);
                    }
                }
        if(y_pos - 1 >= 0)
            if(!dangerZone.contains(gameField.gameField[y_pos - 1][x_pos]))
                if(gameField.gameField[y_pos - 1][x_pos].currentFigure == null) {
                    arr.add(gameField.gameField[y_pos - 1][x_pos]);
                }
                else
                {
                    if(player != gameField.gameField[y_pos - 1][x_pos].currentFigure.player)
                    {
                        arr.add(gameField.gameField[y_pos - 1][x_pos]);
                    }
                }

        for(int i = -1; i <= 1;i++)
        {
            if(y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos + 1 < gameField.gameField.length)
                if(!dangerZone.contains(gameField.gameField[y_pos + i][x_pos + 1]))
                    if(gameField.gameField[y_pos + i][x_pos + 1].currentFigure == null) {
                        arr.add(gameField.gameField[y_pos + i][x_pos + 1]);
                    }
                    else
                    {
                        if(player != gameField.gameField[y_pos + i][x_pos + 1].currentFigure.player)
                        {
                            arr.add(gameField.gameField[y_pos + i][x_pos + 1]);
                        }
                    }
        }
        for(int i = -1; i <= 1;i++)
        {
            if(y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos - 1 >= 0)
                if(!dangerZone.contains(gameField.gameField[y_pos + i][x_pos - 1]))
                    if(gameField.gameField[y_pos + i][x_pos - 1].currentFigure == null) {
                        arr.add(gameField.gameField[y_pos + i][x_pos - 1]);
                    }
                    else
                    {
                        if(player != gameField.gameField[y_pos + i][x_pos - 1].currentFigure.player)
                        {
                            arr.add(gameField.gameField[y_pos + i][x_pos - 1]);
                        }
                    }
        }
        return arr;
    }

    public int countEnabledCellForKing(GameField gameField, int x_pos, int y_pos)
    {
        int count = 0;
        ArrayList dangerZone = new ArrayList();
        for(int y = 0; y < gameField.gameField.length; y++)
        {
            for(int x = 0; x < gameField.gameField[0].length;x++)
            {
                if(gameField.gameField[y][x].currentFigure != null)
                    if (gameField.gameField[y][x].currentFigure.player != this.player) {
                        if (gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            for (Cell cell : gameField.gameField[y][x].currentFigure.checkMate(gameField, x, y))
                                dangerZone.add(cell);
                        else
                            for(Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMoveForKing(gameField, x, y))
                                dangerZone.add(cell);
                    }
            }
        }
        if(y_pos + 1 < gameField.gameField.length)
            if(!dangerZone.contains(gameField.gameField[y_pos + 1][x_pos]))
                if(gameField.gameField[y_pos + 1][x_pos].currentFigure == null) {
                    count++;
                }
                else
                {
                    if(player != gameField.gameField[y_pos + 1][x_pos].currentFigure.player)
                    {
                        count++;
                    }
                }
        if(y_pos - 1 >= 0)
            if(!dangerZone.contains(gameField.gameField[y_pos - 1][x_pos]))
                if(gameField.gameField[y_pos - 1][x_pos].currentFigure == null) {
                    count++;
                }
                else
                {
                    if(player != gameField.gameField[y_pos - 1][x_pos].currentFigure.player)
                    {
                        count++;
                    }
                }

        for(int i = -1; i <= 1;i++)
        {
            if(y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos + 1 < gameField.gameField.length)
                if(!dangerZone.contains(gameField.gameField[y_pos + i][x_pos + 1]))
                    if(gameField.gameField[y_pos + i][x_pos + 1].currentFigure == null) {
                        count++;
                    }
                    else
                    {
                        if(player != gameField.gameField[y_pos + i][x_pos + 1].currentFigure.player)
                        {
                            count++;
                        }
                    }
        }
        for(int i = -1; i <= 1;i++)
        {
            if(y_pos + i < gameField.gameField.length && y_pos + i >= 0 && x_pos - 1 >= 0)
                if(!dangerZone.contains(gameField.gameField[y_pos + i][x_pos - 1]))
                    if(gameField.gameField[y_pos + i][x_pos - 1].currentFigure == null) {
                        count++;
                    }
                    else
                    {
                        if(player != gameField.gameField[y_pos + i][x_pos - 1].currentFigure.player)
                        {
                            count++;
                        }
                    }
        }
        return count;
    }
}
