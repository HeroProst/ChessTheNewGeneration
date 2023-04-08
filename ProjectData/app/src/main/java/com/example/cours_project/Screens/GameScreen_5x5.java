package com.example.cours_project.Screens;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.cours_project.ClassFolder.Cell;
import com.example.cours_project.ClassFolder.GameField;
import com.example.cours_project.ClassFolder.King;
import com.example.cours_project.R;
import com.example.cours_project.SupportClass.DataGiver;

import java.util.ArrayList;

public class GameScreen_5x5 extends AppCompatActivity {

    ImageButton[][] imageButtonsList;
    GameField gameField;
    public Cell currentCell;
    Boolean currentTurn = true;
    Intent backToMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen5x5);
        imageButtonsList = createBtnField();
        gameField = new GameField(5,5,imageButtonsList);
        GameField whiteAndBlackField = DataGiver.BlackAndWhiteField_5x5;
        backToMain = new Intent(this, MainActivity.class);
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(whiteAndBlackField.gameField[i][j].linketButton != null) {
                    gameField.gameField[i][j].linketButton.setTag(whiteAndBlackField.gameField[i][j].linketButton.getTag());
                    gameField.gameField[i][j].linketButton.setImageDrawable(whiteAndBlackField.gameField[i][j].linketButton.getDrawable());
                    gameField.gameField[i][j].currentFigure = null;
                    gameField.gameField[i][j].linketButton.setEnabled(true);
                }
            }
        }
        gameField.searchFigure();
        disableEverythingExceptFigure();
        setStandartForFigure();
        setStandartForNonFigure();
        disableNotPlayerTurn();
    }

    public void getFigureMove(View view)
    {
        setStandartForNonFigure();
        disableNotPlayerTurn();
        ImageButton currentButton = findViewById(view.getId());
        this.currentCell = new Cell();
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton == currentButton) {
                    currentCell = gameField.gameField[i][j];
                    break;
                }
            }
        }
        disableEverythingExceptFigure();
        ArrayList<Cell> arrayList = currentCell.getFigureMove(gameField);
        for(Cell cell : arrayList)
        {
            cell.linketButton.setEnabled(true);
            cell.linketButton.setOnClickListener(this::moveFigure);
        }
    }

    public void moveFigure(View view)
    {
        ImageButton newButton = findViewById(view.getId());
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if (gameField.gameField[i][j].linketButton == newButton) {
                    newButton.setTag(currentCell.linketButton.getTag());
                    newButton.setImageDrawable(currentCell.linketButton.getDrawable());
                    newButton.setOnClickListener(this::getFigureMove);
                    newButton.setEnabled(true);
                    gameField.gameField[i][j].currentFigure = currentCell.currentFigure;
                    currentCell.linketButton.setTag(null);
                    currentCell.linketButton.setImageDrawable(null);
                    currentCell.linketButton.setOnClickListener(this::moveFigure);
                    currentCell.currentFigure = null;
                    break;
                }
            }
        }
        disableEverythingExceptFigure();
        setStandartForFigure();
        setStandartForNonFigure();
        changePlayerTurn();
        disableNotPlayerTurn();
    }

    public void disableEverythingExceptFigure()
    {
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if (gameField.gameField[i][j].currentFigure == null) {
                    gameField.gameField[i][j].linketButton.setEnabled(false);
                }
                gameField.gameField[i][j].linketButton.setBackgroundColor(0);
            }
        }
    }

    public void setStandartForFigure() {
        for (int i = 0; i < gameField.gameField.length; i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if (gameField.gameField[i][j].currentFigure != null) {
                    gameField.gameField[i][j].linketButton.setOnClickListener(this::getFigureMove);
                }
                gameField.gameField[i][j].linketButton.setBackgroundColor(0);
            }
        }
    }
    public void setStandartForNonFigure() {
        for (int i = 0; i < gameField.gameField.length; i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if (gameField.gameField[i][j].currentFigure == null) {
                    gameField.gameField[i][j].linketButton.setOnClickListener(this::moveFigure);
                }
                gameField.gameField[i][j].linketButton.setBackgroundColor(0);
            }
        }
    }



    public void disableNotPlayerTurn()
    {
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].currentFigure != null)
                    if(gameField.gameField[i][j].currentFigure.player != currentTurn)
                        gameField.gameField[i][j].linketButton.setEnabled(false);
                    else
                        gameField.gameField[i][j].linketButton.setEnabled(true);
            }
        }
        KingSecurity();
    }

    public void changePlayerTurn()
    {
        currentTurn = !currentTurn;
    }

    public void moveFigureToSaveKing(View view)
    {
        setStandartForNonFigure();
        disableNotPlayerTurn();
        ImageButton newButton = findViewById(view.getId());
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if (gameField.gameField[i][j].linketButton == newButton) {
                    currentCell = gameField.gameField[i][j];
                    break;
                }
            }
        }

        ArrayList<Cell> dangerPath = new ArrayList<>();
        for(int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                if(gameField.gameField[y][x].currentFigure != null)
                    if(gameField.gameField[y][x].currentFigure.player != currentTurn)
                        if(gameField.gameField[y][x].currentFigure.getClass() != King.class)
                        {
                            for(Cell cell : gameField.gameField[y][x].currentFigure.checkMate(gameField,x,y))
                                if(cell.currentFigure != null)
                                    if(cell.currentFigure.getClass() == King.class){
                                        dangerPath.addAll(gameField.gameField[y][x].currentFigure.wayToKing(gameField,x,y));
                                        break;
                                    }
                        }
                        else
                            for(Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMoveForKing(gameField, x, y))
                                if(cell.currentFigure != null)
                                    if(cell.currentFigure.getClass() == King.class){
                                        dangerPath.addAll(gameField.gameField[y][x].currentFigure.wayToKing(gameField,x,y));
                                        break;
                                    }
            }
        }

        disableEverythingExceptFigure();
        ArrayList<Cell> arrayList = currentCell.currentFigure.typeMoveToSaveKing(gameField, dangerPath, currentCell.x_position, currentCell.y_position);
        for(Cell cell : arrayList)
        {
            cell.linketButton.setEnabled(true);
            cell.linketButton.setOnClickListener(this::moveFigure);
        }
    }

    public void KingSecurity()
    {
        ArrayList<Cell> dangerPath = new ArrayList<>();
        for(int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                if(gameField.gameField[y][x].currentFigure != null)
                    if(gameField.gameField[y][x].currentFigure.player != currentTurn)
                        if(gameField.gameField[y][x].currentFigure.getClass() != King.class)
                        {
                            for(Cell cell : gameField.gameField[y][x].currentFigure.checkMate(gameField,x,y))
                                if(cell.currentFigure != null)
                                    if(cell.currentFigure.getClass() == King.class){
                                        dangerPath.addAll(gameField.gameField[y][x].currentFigure.wayToKing(gameField,x,y));
                                        break;
                                    }
                        }
                        else
                            for(Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMoveForKing(gameField, x, y))
                                if(cell.currentFigure != null)
                                    if(cell.currentFigure.getClass() == King.class){
                                        dangerPath.addAll(gameField.gameField[y][x].currentFigure.wayToKing(gameField,x,y));
                                        break;
                                    }
            }
        }
        if(!dangerPath.isEmpty()) {
            for (int y = 0; y < gameField.gameField.length; y++) {
                for (int x = 0; x < gameField.gameField[0].length; x++) {
                    if (gameField.gameField[y][x].currentFigure != null )
                        if(gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            gameField.gameField[y][x].linketButton.setEnabled(false);
                }
            }
            for (int y = 0; y < gameField.gameField.length; y++) {
                for (int x = 0; x < gameField.gameField[0].length; x++) {
                    if (gameField.gameField[y][x].currentFigure != null)
                        if (gameField.gameField[y][x].currentFigure.player == currentTurn) {
                            if(gameField.gameField[y][x].currentFigure.getClass() == King.class)
                                for (Cell cell : gameField.gameField[y][x].currentFigure.traceTypeMove(gameField, x, y))
                                    if (dangerPath.contains(cell)) {
                                        gameField.gameField[y][x].linketButton.setEnabled(true);
                                        gameField.gameField[y][x].linketButton.setOnClickListener(this::moveFigureToSaveKing);
                                    }
                        }
                }
            }
            checkEndGame();
        }
        else
            checkPat();
    }

    public void checkPat()
    {
        ArrayList<Cell> enabledCell = new ArrayList<>();
        for(int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                if(gameField.gameField[y][x].currentFigure != null)
                    if(gameField.gameField[y][x].currentFigure.player == currentTurn)
                        if(gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            enabledCell.addAll(gameField.gameField[y][x].currentFigure.traceTypeMove(gameField,x,y));
                        else
                            enabledCell.addAll(gameField.gameField[y][x].currentFigure.saveEnabledCellForKing(gameField,x,y));
            }
        }
        if(enabledCell.isEmpty())
            Pat();

    }
    public void Pat()
    {
        for (int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                gameField.gameField[y][x].linketButton.setEnabled(false);
                gameField.gameField[y][x].linketButton.setOnClickListener(null);
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Пат!")
                .setCancelable(false)
                .setNegativeButton("Перейти на главное меню",
                        (dialog, id) -> startActivity(backToMain));
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void checkEndGame()
    {
        Boolean startCheckMate = false;
        int countFigureToSaveKing = 1;
        for (int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                if (gameField.gameField[y][x].currentFigure != null )
                    if(gameField.gameField[y][x].currentFigure.getClass() == King.class)
                        if(gameField.gameField[y][x].currentFigure.countEnabledCellForKing(gameField, x, y) == 0) {
                            startCheckMate = true;
                            break;
                        }
            }
        }
        if(startCheckMate) {
            countFigureToSaveKing = 0;
            for (int y = 0; y < gameField.gameField.length; y++) {
                for (int x = 0; x < gameField.gameField[0].length; x++) {
                    if (gameField.gameField[y][x].currentFigure != null)
                        if (gameField.gameField[y][x].currentFigure.getClass() != King.class)
                            if (gameField.gameField[y][x].linketButton.isEnabled())
                                countFigureToSaveKing++;
                }
            }
        }
        if(countFigureToSaveKing == 0)
            endGame();
    }

    public void endGame()
    {
        String winningSite;
        if(!currentTurn)
            winningSite = "Белые";
        else
            winningSite = "Черные";
        for (int y = 0; y < gameField.gameField.length; y++) {
            for (int x = 0; x < gameField.gameField[0].length; x++) {
                gameField.gameField[y][x].linketButton.setEnabled(false);
                gameField.gameField[y][x].linketButton.setOnClickListener(null);
            }
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(winningSite + " победили!")
                .setCancelable(false)
                .setNegativeButton("Перейти на главное меню",
                        (dialog, id) -> startActivity(backToMain));
        AlertDialog alert = builder.create();
        alert.show();
    }

    public ImageButton[][] createBtnField()
    {
        ImageButton[][] btnList = new ImageButton[5][5];
        ImageButton btn = findViewById(R.id.A1_figure);
        btnList[0][0] = btn;
        btn = findViewById(R.id.A2_figure);
        btnList[0][1] = btn;
        btn = findViewById(R.id.A3_figure);
        btnList[0][2] = btn;
        btn = findViewById(R.id.A4_figure);
        btnList[0][3] = btn;
        btn = findViewById(R.id.A5_figure);
        btnList[0][4] = btn;
        btn = findViewById(R.id.B1_figure);
        btnList[1][0] = btn;
        btn = findViewById(R.id.B2_figure);
        btnList[1][1] = btn;
        btn = findViewById(R.id.B3_figure);
        btnList[1][2] = btn;
        btn = findViewById(R.id.B4_figure);
        btnList[1][3] = btn;
        btn = findViewById(R.id.B5_figure);
        btnList[1][4] = btn;
        btn = findViewById(R.id.C1_figure);
        btnList[2][0] = btn;
        btn = findViewById(R.id.C2_figure);
        btnList[2][1] = btn;
        btn = findViewById(R.id.C3_figure);
        btnList[2][2] = btn;
        btn = findViewById(R.id.C4_figure);
        btnList[2][3] = btn;
        btn = findViewById(R.id.C5_figure);
        btnList[2][4] = btn;
        btn = findViewById(R.id.D1_figure);
        btnList[3][0] = btn;
        btn = findViewById(R.id.D2_figure);
        btnList[3][1] = btn;
        btn = findViewById(R.id.D3_figure);
        btnList[3][2] = btn;
        btn = findViewById(R.id.D4_figure);
        btnList[3][3] = btn;
        btn = findViewById(R.id.D5_figure);
        btnList[3][4] = btn;
        btn = findViewById(R.id.E1_figure);
        btnList[4][0] = btn;
        btn = findViewById(R.id.E2_figure);
        btnList[4][1] = btn;
        btn = findViewById(R.id.E3_figure);
        btnList[4][2] = btn;
        btn = findViewById(R.id.E4_figure);
        btnList[4][3] = btn;
        btn = findViewById(R.id.E5_figure);
        btnList[4][4] = btn;
        return btnList;
    }
}