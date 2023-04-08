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

public class WhitePick_5x5 extends AppCompatActivity {

    RecyclerView listFigureRecycler;
    ListFigureAdapter listFigureAdapter;

    ImageButton[][] imageButtonsList;
    GameField gameField;

    int price = 0;

    final int MAX_PRICE = 15;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_white_pick5x5);

        ListFigureAdapter.DrawableListFigure = null;
        ListFigureAdapter.TagListFigure = null;

        TextView maxPrice = findViewById(R.id.maxPrice);
        runOnUiThread(() -> maxPrice.setText(String.valueOf(MAX_PRICE)));

        setListFigureRecycler(createListFigureList());

        imageButtonsList = createBtnField();

        gameField = new GameField(5,5,imageButtonsList);

        setMethod();

        disableKingCell();
    }

    public void setSelectedFigure(View view)
    {
        ImageButton newButton = findViewById(view.getId());
        ImageButton clearButton = findViewById(R.id.C1_figure);
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
        ImageButton clearButton = findViewById(R.id.C1_figure); //cell with clear square
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
        Intent blackPick = new Intent(this, BlackPick_5x5.class);
        DataGiver.WhiteField_5x5 = gameField;
        startActivity(blackPick);
    }

    public ImageButton[][] createBtnField()
    {
        ImageButton[][] btnList = new ImageButton[5][5];
        ImageButton btn = findViewById(R.id.D1_figure);
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

    public List<ListFigure> createListFigureList()
    {
        List<ListFigure> ListFigureList = new ArrayList<>();
        ListFigureList.add(new ListFigure(R.drawable.pawns_white, "Пешка", "Pawns", new Pawns().price));
        ListFigureList.add(new ListFigure(R.drawable.bishop_white, "Ладья", "Bishop", new Bishop().price));
        ListFigureList.add(new ListFigure(R.drawable.rook_white, "Слон", "Rook", new Rook().price));
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