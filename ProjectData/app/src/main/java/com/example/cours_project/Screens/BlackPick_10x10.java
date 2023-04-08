package com.example.cours_project.Screens;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.cours_project.ClassFolder.Bishop;
import com.example.cours_project.ClassFolder.Cell;
import com.example.cours_project.ClassFolder.GameField;
import com.example.cours_project.ClassFolder.Horse;
import com.example.cours_project.ClassFolder.Pawns;
import com.example.cours_project.ClassFolder.Pony;
import com.example.cours_project.ClassFolder.Queen;
import com.example.cours_project.ClassFolder.Rook;
import com.example.cours_project.R;
import com.example.cours_project.SupportClass.DataGiver;
import com.example.cours_project.SupportClass.ListFigure;
import com.example.cours_project.SupportClass.ListFigureAdapter;

import java.util.ArrayList;
import java.util.List;

public class BlackPick_10x10 extends AppCompatActivity {

    RecyclerView listFigureRecycler;
    ListFigureAdapter listFigureAdapter;

    ImageButton[][] imageButtonsList;
    GameField gameField;

    GameField whiteField;

    int price = 0;

    final int MAX_PRICE = 35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_pick10x10);

        ListFigureAdapter.DrawableListFigure = null;
        ListFigureAdapter.TagListFigure = null;

        TextView maxPrice = findViewById(R.id.maxPrice);
        runOnUiThread(() -> maxPrice.setText(String.valueOf(MAX_PRICE)));

        setListFigureRecycler(createListFigureList());

        imageButtonsList = createBtnField();

        gameField = new GameField(10,10,imageButtonsList);
        whiteField = DataGiver.WhiteField_10x10;

        setMethod();

        disableKingCell();
    }

    public void setSelectedFigure(View view)
    {
        ImageButton newButton = findViewById(view.getId());
        ImageButton clearButton = findViewById(R.id.C8_figure);
        Cell btnCell = new Cell();
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton == newButton) {
                    btnCell = gameField.gameField[i][j];
                    break;
                }
            }
        }
        newButton.setImageDrawable(ListFigureAdapter.DrawableListFigure);
        newButton.setTag(ListFigureAdapter.TagListFigure);
        if(!updatePrice()){
            newButton.setImageDrawable(clearButton.getDrawable());
            newButton.setTag("None");
            btnCell.currentFigure = null;
            updatePrice();
        }
        else
            newButton.setOnClickListener(this::removeFigure);
    }

    public void removeFigure(View view)
    {
        ImageButton newButton = findViewById(view.getId());
        ImageButton clearButton = findViewById(R.id.C8_figure); //cell with clear square
        Cell btnCell = new Cell();
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton == newButton) {
                    btnCell = gameField.gameField[i][j];
                    break;
                }
            }
        }
        newButton.setImageDrawable(clearButton.getDrawable());
        newButton.setTag("None");
        btnCell.currentFigure = null;
        updatePrice();
        newButton.setOnClickListener(this::setSelectedFigure);
    }

    public void setMethod()
    {
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton != null) {
                    gameField.gameField[i][j].linketButton.setOnClickListener(this::setSelectedFigure);
                }
            }
        }
    }

    public void disableKingCell()
    {
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton != null)
                    if(gameField.gameField[i][j].linketButton.getTag() != null)
                        if(gameField.gameField[i][j].linketButton.getTag().toString().equals("King"))
                            gameField.gameField[i][j].linketButton.setEnabled(false);
            }
        }
    }

    public Boolean updatePrice()
    {
        TextView priceView = findViewById(R.id.priceView);
        gameField.searchFigure();
        price = gameField.countPriceOnBoard();
        if(price <= MAX_PRICE)
        {
            runOnUiThread(() -> priceView.setText(String.valueOf(price)));
            return true;
        }
        else
            return false;
    }

    public void inToTheGame(View view)
    {
        Intent gameScreen = new Intent(this, GameScreen_10x10.class);
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton == null)
                    if(whiteField.gameField[i][j] != null)
                        gameField.gameField[i][j] = whiteField.gameField[i][j];
            }
        }
        DataGiver.BlackAndWhiteField_10x10 = gameField;
        startActivity(gameScreen);
    }

    public ImageButton[][] createBtnField()
    {
        ImageButton[][] btnList = new ImageButton[10][10];
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
        btn = findViewById(R.id.A6_figure);
        btnList[0][5] = btn;
        btn = findViewById(R.id.A7_figure);
        btnList[0][6] = btn;
        btn = findViewById(R.id.A8_figure);
        btnList[0][7] = btn;
        btn = findViewById(R.id.A9_figure);
        btnList[0][8] = btn;
        btn = findViewById(R.id.A10_figure);
        btnList[0][9] = btn;
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
        btn = findViewById(R.id.B6_figure);
        btnList[1][5] = btn;
        btn = findViewById(R.id.B7_figure);
        btnList[1][6] = btn;
        btn = findViewById(R.id.B8_figure);
        btnList[1][7] = btn;
        btn = findViewById(R.id.B9_figure);
        btnList[1][8] = btn;
        btn = findViewById(R.id.B10_figure);
        btnList[1][9] = btn;
        return btnList;
    }

    public List<ListFigure> createListFigureList()
    {
        List<ListFigure> ListFigureList = new ArrayList<>();
        ListFigureList.add(new ListFigure(R.drawable.pawns_black, "Пешка", "Pawns", new Pawns().price));
        ListFigureList.add(new ListFigure(R.drawable.bishop_black, "Ладья", "Bishop", new Bishop().price));
        ListFigureList.add(new ListFigure(R.drawable.rook_black, "Слон", "Rook", new Rook().price));
        ListFigureList.add(new ListFigure(R.drawable.horse_black, "Конь", "Horse", new Horse().price));
        ListFigureList.add(new ListFigure(R.drawable.queen_black, "Королева", "Queen", new Queen().price));
        ListFigureList.add(new ListFigure(R.drawable.pony_black, "Пони", "Pony", new Pony().price));

        return ListFigureList;
    }

    public void setListFigureRecycler (List<ListFigure> listFigureList)
    {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        listFigureRecycler = findViewById(R.id.listFigureRecycler);
        listFigureRecycler.setLayoutManager(layoutManager);

        listFigureAdapter = new ListFigureAdapter(this, listFigureList);

        listFigureRecycler.setAdapter(listFigureAdapter);
    }
}