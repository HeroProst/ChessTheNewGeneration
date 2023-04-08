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

public class WhitePick_10x10 extends AppCompatActivity {

    RecyclerView listFigureRecycler;
    ListFigureAdapter listFigureAdapter;

    ImageButton[][] imageButtonsList;
    GameField gameField;

    int price = 0;

    final int MAX_PRICE = 35;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_pick10x10);

        ListFigureAdapter.DrawableListFigure = null;
        ListFigureAdapter.TagListFigure = null;

        TextView maxPrice = findViewById(R.id.maxPrice);
        runOnUiThread(() -> maxPrice.setText(String.valueOf(MAX_PRICE)));

        setListFigureRecycler(createListFigureList());

        imageButtonsList = createBtnField();

        gameField = new GameField(10,10,imageButtonsList);

        setMethod();

        disableKingCell();
    }

    public void setSelectedFigure(View view)
    {
        ImageButton newButton = findViewById(view.getId());
        ImageButton clearButton = findViewById(R.id.H1_figure);
        Cell btnCell = new Cell();
        for(int i = 0; i < gameField.gameField.length;i++) {
            for (int j = 0; j < gameField.gameField[0].length; j++) {
                if(gameField.gameField[i][j].linketButton == newButton) {
                    btnCell = gameField.gameField[i][j];
                    break;
                }
            }
        }
        if(ListFigureAdapter.DrawableListFigure != null) {
            newButton.setImageDrawable(ListFigureAdapter.DrawableListFigure);
            newButton.setTag(ListFigureAdapter.TagListFigure);
        }
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
        ImageButton clearButton = findViewById(R.id.H1_figure); //cell with clear square
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

    public void done(View view)
    {
        Intent blackPick = new Intent(this, BlackPick_10x10.class);
        DataGiver.WhiteField_10x10 = gameField;
        startActivity(blackPick);
    }

    public ImageButton[][] createBtnField()
    {
        ImageButton[][] btnList = new ImageButton[10][10];
        ImageButton btn = findViewById(R.id.I1_figure);
        btnList[8][0] = btn;
        btn = findViewById(R.id.I2_figure);
        btnList[8][1] = btn;
        btn = findViewById(R.id.I3_figure);
        btnList[8][2] = btn;
        btn = findViewById(R.id.I4_figure);
        btnList[8][3] = btn;
        btn = findViewById(R.id.I5_figure);
        btnList[8][4] = btn;
        btn = findViewById(R.id.I6_figure);
        btnList[8][5] = btn;
        btn = findViewById(R.id.I7_figure);
        btnList[8][6] = btn;
        btn = findViewById(R.id.I8_figure);
        btnList[8][7] = btn;
        btn = findViewById(R.id.I9_figure);
        btnList[8][8] = btn;
        btn = findViewById(R.id.I10_figure);
        btnList[8][9] = btn;
        btn = findViewById(R.id.J1_figure);
        btnList[9][0] = btn;
        btn = findViewById(R.id.J2_figure);
        btnList[9][1] = btn;
        btn = findViewById(R.id.J3_figure);
        btnList[9][2] = btn;
        btn = findViewById(R.id.J4_figure);
        btnList[9][3] = btn;
        btn = findViewById(R.id.J5_figure);
        btnList[9][4] = btn;
        btn = findViewById(R.id.J6_figure);
        btnList[9][5] = btn;
        btn = findViewById(R.id.J7_figure);
        btnList[9][6] = btn;
        btn = findViewById(R.id.J8_figure);
        btnList[9][7] = btn;
        btn = findViewById(R.id.J9_figure);
        btnList[9][8] = btn;
        btn = findViewById(R.id.J10_figure);
        btnList[9][9] = btn;
        return btnList;
    }

    public List<ListFigure> createListFigureList()
    {
        List<ListFigure> ListFigureList = new ArrayList<>();
        ListFigureList.add(new ListFigure(R.drawable.pawns_white, "Пешка", "Pawns", new Pawns().price));
        ListFigureList.add(new ListFigure(R.drawable.bishop_white, "Ладья", "Bishop", new Bishop().price));
        ListFigureList.add(new ListFigure(R.drawable.rook_white, "Слон", "Rook", new Rook().price));
        ListFigureList.add(new ListFigure(R.drawable.horse_white, "Конь", "Horse", new Horse().price));
        ListFigureList.add(new ListFigure(R.drawable.queen_white, "Королева", "Queen", new Queen().price));
        ListFigureList.add(new ListFigure(R.drawable.pony_white, "Пони", "Pony", new Pony().price));

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