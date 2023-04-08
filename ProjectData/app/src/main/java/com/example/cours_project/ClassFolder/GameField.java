package com.example.cours_project.ClassFolder;

import android.widget.ImageButton;

import com.example.cours_project.ClassFolder.Cell;
import com.example.cours_project.R;

import java.io.Serializable;

public class GameField implements Serializable {

    public Cell[][] gameField;
    public int rowCount;
    public int collumnCount;

    public GameField(int rowCount, int collumnCount, ImageButton[][] imageButtonList)
    {
        this.collumnCount = collumnCount;
        this.rowCount = rowCount;
        this.gameField = new Cell[rowCount][collumnCount];
        for(int i = 0;i < this.rowCount;i++)
            for(int j = 0;j < this.collumnCount;j++)
            {
                gameField[i][j] = new Cell(j,i, imageButtonList[i][j]);
            }
    }
    public void searchFigure()
    {
        String buttonTag;
        for(int i = 0; i < gameField.length;i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if(gameField[i][j].linketButton != null)
                    if(gameField[i][j].linketButton.getTag() != null) {
                        buttonTag = (String) gameField[i][j].linketButton.getTag();
                        switch (buttonTag){
                            case "Pawns": {
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new Pawns(1, false);
                                else
                                    gameField[i][j].currentFigure = new Pawns(1, true);
                                break;
                            }
                            case "Rook":{
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new Rook(1, false);
                                else
                                    gameField[i][j].currentFigure = new Rook(1, true);
                                break;
                            }
                            case "Bishop": {
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new Bishop(1, false);
                                else
                                    gameField[i][j].currentFigure = new Bishop(1, true);
                                break;
                            }
                            case "Horse":{
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new Horse(1, false);
                                else
                                    gameField[i][j].currentFigure = new Horse(1, true);
                                break;
                            }
                            case "King":{
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new King(1, false);
                                else
                                    gameField[i][j].currentFigure = new King(1, true);
                                break;
                            }
                            case "Queen":{
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new Queen(1, false);
                                else
                                    gameField[i][j].currentFigure = new Queen(1, true);
                                break;
                            }
                            case "Pony":{
                                if (i < gameField.length / 2)
                                    gameField[i][j].currentFigure = new Pony(1, false);
                                else
                                    gameField[i][j].currentFigure = new Pony(1, true);
                                break;
                            }
                            case "None":
                                break;

                        }
                    }
            }
        }
    }

    public int countPriceOnBoard()
    {
        int price = 0;
        for(int i = 0; i < gameField.length;i++) {
            for (int j = 0; j < gameField[0].length; j++) {
                if(gameField[i][j].linketButton != null)
                    if(gameField[i][j].currentFigure != null)
                        price += gameField[i][j].currentFigure.price;
            }
        }
        return price;
    }
}
