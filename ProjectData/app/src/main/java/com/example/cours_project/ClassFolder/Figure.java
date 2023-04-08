package com.example.cours_project.ClassFolder;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Figure {

    int globalId;
    int localId;
    public Boolean player;
    public int price = 1;

    public ArrayList<Cell> typeMove(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        return arrayList;
    }

    public ArrayList<Cell> checkMate(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        return  arrayList;
    }

    public ArrayList<Cell> findEnemyKing(GameField gameField)
    {
        ArrayList<Cell> kingZone = new ArrayList<>();
        Cell kingCell = new Cell();
        for(int y = 0; y < gameField.gameField.length; y++)
        {
            for(int x = 0; x < gameField.gameField[y].length;x++)
            {
                if(gameField.gameField[y][x].currentFigure != null)
                    if(gameField.gameField[y][x].currentFigure.player != this.player)
                        if(gameField.gameField[y][x].currentFigure.getClass() == King.class) {
                            kingCell = gameField.gameField[y][x];
                            break;
                        }
            }
        }
        if(kingCell.y_position + 1 < gameField.gameField.length)
            if(gameField.gameField[kingCell.y_position + 1][kingCell.x_position].currentFigure == null) {
                kingZone.add(gameField.gameField[kingCell.y_position + 1][kingCell.x_position]);
            }
        if(kingCell.y_position - 1 >= 0)
            if(gameField.gameField[kingCell.y_position - 1][kingCell.x_position].currentFigure == null) {
                kingZone.add(gameField.gameField[kingCell.y_position - 1][kingCell.x_position]);
            }

        for(int i = -1; i <= 1;i++)
        {
            if(kingCell.y_position + i < gameField.gameField.length && kingCell.y_position + i >= 0 && kingCell.x_position + 1 < gameField.gameField.length)
                if(gameField.gameField[kingCell.y_position + i][kingCell.x_position + 1].currentFigure == null) {
                    kingZone.add(gameField.gameField[kingCell.y_position + i][kingCell.x_position + 1]);
                }
        }
        for(int i = -1; i <= 1;i++)
        {
            if(kingCell.y_position + i < gameField.gameField.length && kingCell.y_position + i >= 0 && kingCell.x_position - 1 >= 0)
                if(gameField.gameField[kingCell.y_position + i][kingCell.x_position - 1].currentFigure == null) {
                    kingZone.add(gameField.gameField[kingCell.y_position + i][kingCell.x_position - 1]);
                }
        }
        kingZone.add(kingCell);
        return kingZone;
    }

    public ArrayList<Cell> wayToKing(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        return arrayList;
    }

    public ArrayList<Cell> traceTypeMove(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        return arrayList;
    }

    public ArrayList<Cell> typeMoveToSaveKing(GameField gameField, ArrayList<Cell> dangerPath,int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        for (Cell cell : traceTypeMove(gameField, x_pos, y_pos))
            if (dangerPath.contains(cell)) {
                if(cell.currentFigure != null){
                    cell.linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    arrayList.add(cell);
                }
                else {
                    cell.linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                    cell.linketButton.setEnabled(true);
                }
            }
        return arrayList;
    }

    public ArrayList<Cell> traceTypeMoveForKing(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> dangerForKingCell = new ArrayList<>();
        return dangerForKingCell;
    }

    public ArrayList<Cell> saveEnabledCellForKing(GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arr = new ArrayList<>();
        return arr;
    }

    public int countEnabledCellForKing(GameField gameField, int x_pos, int y_pos)
    {
        int count = 1;
        return count;
    }
}
