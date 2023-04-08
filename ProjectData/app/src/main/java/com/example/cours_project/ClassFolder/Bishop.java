package com.example.cours_project.ClassFolder;

import android.graphics.Color;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Bishop extends Figure {

    public Bishop()
    {
        this.price = 3;
    }

    public Bishop(int localId, Boolean player) {
        this.localId = localId;
        this.globalId = 1;
        this.player = player;
        this.price = 3;
    }

    public ArrayList<Cell> typeMove(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos + i != gameField.gameField.length) {
                if (gameField.gameField[y_pos + i][x_pos + i].currentFigure != null) {
                    if (player != gameField.gameField[y_pos + i][x_pos + i].currentFigure.player) {
                        gameField.gameField[y_pos + i][x_pos + i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos + i][x_pos + i]);
                    }
                    break;
                }
                gameField.gameField[y_pos + i][x_pos + i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                gameField.gameField[y_pos + i][x_pos + i].linketButton.setEnabled(true);
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos + i != gameField.gameField.length) {
                if (gameField.gameField[y_pos - i][x_pos + i].currentFigure != null) {
                    if (player != gameField.gameField[y_pos - i][x_pos + i].currentFigure.player) {
                        gameField.gameField[y_pos - i][x_pos + i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos - i][x_pos + i]);
                    }
                    break;
                }
                gameField.gameField[y_pos - i][x_pos + i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                gameField.gameField[y_pos - i][x_pos + i].linketButton.setEnabled(true);
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos - i + 1 != 0) {
                if (gameField.gameField[y_pos + i][x_pos - i].currentFigure != null) {
                    if (player != gameField.gameField[y_pos + i][x_pos - i].currentFigure.player) {
                        gameField.gameField[y_pos + i][x_pos - i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos + i][x_pos - i]);
                    }
                    break;
                }
                gameField.gameField[y_pos + i][x_pos - i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                gameField.gameField[y_pos + i][x_pos - i].linketButton.setEnabled(true);
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos - i + 1 != 0) {
                if (gameField.gameField[y_pos - i][x_pos - i].currentFigure != null) {
                    if (player != gameField.gameField[y_pos - i][x_pos - i].currentFigure.player) {
                        gameField.gameField[y_pos - i][x_pos - i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                        arrayList.add(gameField.gameField[y_pos - i][x_pos - i]);
                    }
                    break;
                }
                gameField.gameField[y_pos - i][x_pos - i].linketButton.setBackgroundColor(Color.parseColor("#ADFF2F"));
                gameField.gameField[y_pos - i][x_pos - i].linketButton.setEnabled(true);
            } else
                break;
        }
        return arrayList;
    }

    public ArrayList<Cell> checkMate(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> dangerForKingCell = new ArrayList<>();
        ArrayList<Cell> kingZone = findEnemyKing(gameField);
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos + i != gameField.gameField.length) {
                if (gameField.gameField[y_pos + i][x_pos + i].currentFigure == null || gameField.gameField[y_pos + i][x_pos + i].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + i][x_pos + i]))
                        dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos + i]);
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos + i != gameField.gameField.length) {
                if (gameField.gameField[y_pos - i][x_pos + i].currentFigure == null || gameField.gameField[y_pos - i][x_pos + i].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - i][x_pos + i]))
                        dangerForKingCell.add(gameField.gameField[y_pos - i][x_pos + i]);
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos - i + 1 != 0) {
                if (gameField.gameField[y_pos + i][x_pos - i].currentFigure == null || gameField.gameField[y_pos + i][x_pos - i].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos + i][x_pos - i]))
                        dangerForKingCell.add(gameField.gameField[y_pos + i][x_pos - i]);
                } else
                    break;
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos - i + 1 != 0) {
                if (gameField.gameField[y_pos - i][x_pos - i].currentFigure == null || gameField.gameField[y_pos - i][x_pos - i].currentFigure.getClass() == King.class) {
                    if (kingZone.contains(gameField.gameField[y_pos - i][x_pos - i]))
                        dangerForKingCell.add(gameField.gameField[y_pos - i][x_pos - i]);
                } else
                    break;
            } else
                break;
        }
        return dangerForKingCell;
    }

    public ArrayList<Cell> wayToKing(@NonNull GameField gameField, int x_pos, int y_pos) {
        ArrayList<Cell> arrayList = new ArrayList<Cell>();
        arrayList.add(gameField.gameField[y_pos][x_pos]);
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos + i != gameField.gameField.length) {
                arrayList.add(gameField.gameField[y_pos + i][x_pos + i]);
                if(gameField.gameField[y_pos + i][x_pos + i].currentFigure != null) {
                    if(gameField.gameField[y_pos + i][x_pos + i].currentFigure.player != this.player)
                        if(gameField.gameField[y_pos + i][x_pos + i].currentFigure.getClass() == King.class)
                            return arrayList;
                        else
                            break;
                }
            } else
                break;
        }
        arrayList.clear();
        arrayList.add(gameField.gameField[y_pos][x_pos]);
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos + i != gameField.gameField.length) {
                arrayList.add(gameField.gameField[y_pos - i][x_pos + i]);
                if(gameField.gameField[y_pos - i][x_pos + i].currentFigure != null) {
                    if(gameField.gameField[y_pos - i][x_pos + i].currentFigure.player != this.player)
                        if(gameField.gameField[y_pos - i][x_pos + i].currentFigure.getClass() == King.class)
                            return arrayList;
                        else
                            break;
                }
            } else
                break;
        }
        arrayList.clear();
        arrayList.add(gameField.gameField[y_pos][x_pos]);
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos - i + 1 != 0) {
                arrayList.add(gameField.gameField[y_pos + i][x_pos - i]);
                if(gameField.gameField[y_pos + i][x_pos - i].currentFigure != null) {
                    if(gameField.gameField[y_pos + i][x_pos - i].currentFigure.player != this.player)
                        if(gameField.gameField[y_pos + i][x_pos - i].currentFigure.getClass() == King.class)
                            return arrayList;
                        else
                            break;
                }
            } else
                break;
        }
        arrayList.clear();
        arrayList.add(gameField.gameField[y_pos][x_pos]);
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos - i + 1 != 0) {
                arrayList.add(gameField.gameField[y_pos - i][x_pos - i]);
                if(gameField.gameField[y_pos - i][x_pos - i].currentFigure != null) {
                    if(gameField.gameField[y_pos - i][x_pos - i].currentFigure.player != this.player)
                        if(gameField.gameField[y_pos - i][x_pos - i].currentFigure.getClass() == King.class)
                            return arrayList;
                        else
                            break;
                }
            } else
                break;
        }
        for (Cell cell : arrayList) {
            if (cell.currentFigure.getClass() == King.class)
                return arrayList;
        }
        arrayList.clear();
        return arrayList;
    }

    public ArrayList<Cell> traceTypeMove(@NonNull GameField gameField, int x_pos, int y_pos)
    {
        ArrayList<Cell> arrayList = new ArrayList<>();
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos + i != gameField.gameField.length) {
                if(gameField.gameField[y_pos + i][x_pos + i].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + i][x_pos + i].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + i][x_pos + i]);
                    }
                    break;
                }
                else
                    arrayList.add(gameField.gameField[y_pos + i][x_pos + i]);
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos + i != gameField.gameField.length) {
                if(gameField.gameField[y_pos - i][x_pos + i].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - i][x_pos + i].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos - i][x_pos + i]);
                    }
                    break;
                }
                else
                    arrayList.add(gameField.gameField[y_pos - i][x_pos + i]);
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos + i != gameField.gameField.length && x_pos - i + 1 != 0) {
                if(gameField.gameField[y_pos + i][x_pos - i].currentFigure != null) {
                    if(player != gameField.gameField[y_pos + i][x_pos - i].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos + i][x_pos - i]);
                    }
                    break;
                }
                else
                    arrayList.add(gameField.gameField[y_pos + i][x_pos - i]);
            } else
                break;
        }
        for (int i = 1; i < gameField.gameField.length; i++) {
            if (y_pos - i + 1 != 0 && x_pos - i + 1 != 0) {
                if(gameField.gameField[y_pos - i][x_pos - i].currentFigure != null) {
                    if(player != gameField.gameField[y_pos - i][x_pos - i].currentFigure.player) {
                        arrayList.add(gameField.gameField[y_pos - i][x_pos - i]);
                    }
                    break;
                }
                else
                    arrayList.add(gameField.gameField[y_pos - i][x_pos - i]);
            } else
                break;
        }
        return arrayList;
    }
}
