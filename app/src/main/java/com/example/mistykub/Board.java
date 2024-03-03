package com.example.mistykub;

import static androidx.fragment.app.FragmentManager.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Board  extends AppCompatActivity {
    private GridLayout handGrid;
    private GridLayout combinationGrid1;
    private  GridLayout combinationGrid2;
    private GridLayout combinationGrid3;
    private  GridLayout combinationGrid4;
    private GridLayout combinationGrid5;
    private GridLayout combinationGrid6;
    private  GridLayout combinationGrid7;
    private GridLayout combinationGrid8;
    private  GridLayout combinationGrid9;
    private GridLayout combinationGrid10;
    private GridLayout combinationGrid11;
    private GridLayout combinationGrid12;
    private GridLayout combinationGrid13;
    private GridLayout combinationGrid14;
    private GridLayout combinationGrid15;
    private FloatingActionButton takeTileButton;
    private FloatingActionButton CheckButton;
    private FloatingActionButton sortButton;
    private TextView botTileCount;
    private TextView textNonPlayedTiles;
    public ArrayList<Tile> nonPlayedTiles;
    public int nonPlayedTilesNumber;
    private ArrayList<Play> playsOnBoard;
    private ArrayList<Tile> ungroupedTilesOnTheBoard;
    private ArrayList<Play> backupPlaysOnBoard;
    private ArrayList<Tile> backupPlayerTiles;
    String[] colors = {"black", "red", "blue", "green"};
    int maxNumber = 7;
    int tilesForPlayer = 8;
    Player player1 = new Player(1,0);
    Player player2 = new Player(1,1);
    private boolean isPlayer1Turn = true;
    private boolean confirm = false;
    private boolean condition_sort = true;
    Player currentPlayer = player1;
    Player otherPlayer = player2;
    List<GridLayout> combinationGrids;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int difficultyValue = getIntent().getIntExtra("difficultyValue", 4);
        player2.setTimeoutDuration(difficultyValue);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.board);
        CheckButton= findViewById(R.id.CheckButton);
        takeTileButton = findViewById(R.id.TakeTileButton);
        sortButton = findViewById(R.id.Sort);

        botTileCount = findViewById(R.id.botTileCount);
        textNonPlayedTiles = findViewById(R.id.nonPlayedTiles);
        combinationGrid1 = findViewById(R.id.combinationGrid1);
        combinationGrid2 = findViewById(R.id.combinationGrid2);
        combinationGrid3 = findViewById(R.id.combinationGrid3);
        combinationGrid4 = findViewById(R.id.combinationGrid4);
        combinationGrid5 = findViewById(R.id.combinationGrid5);
        combinationGrid6 = findViewById(R.id.combinationGrid6);
        combinationGrid7 = findViewById(R.id.combinationGrid7);
        combinationGrid8 = findViewById(R.id.combinationGrid8);
        combinationGrid9 = findViewById(R.id.combinationGrid9);
        combinationGrid10 = findViewById(R.id.combinationGrid10);
        combinationGrid11 = findViewById(R.id.combinationGrid11);
        combinationGrid12 = findViewById(R.id.combinationGrid12);
        combinationGrid13 = findViewById(R.id.combinationGrid13);
        combinationGrid14 = findViewById(R.id.combinationGrid14);
        combinationGrid15 = findViewById(R.id.combinationGrid15);
        combinationGrid1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrid15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleGridClick((GridLayout) v);
            }
        });
        combinationGrids = Arrays.asList(
                combinationGrid1, combinationGrid2, combinationGrid3,
                combinationGrid4, combinationGrid5, combinationGrid6,
                combinationGrid7, combinationGrid8, combinationGrid9,
                combinationGrid10, combinationGrid11, combinationGrid12,
                combinationGrid13, combinationGrid14, combinationGrid15
        );

        takeTileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayer1Turn && !confirm) {
                    addTileToHand(currentPlayer);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            switchTurn();
                            if (currentPlayer == player2) {
                                isPlayer1Turn = false;
                                playAIturn();
                            } else if (currentPlayer == player1) {
                                isPlayer1Turn = true;
                            }
                        }
                    }, 350);
                }else{
                    if(!isPlayer1Turn) {
                        Toast.makeText(Board.this, "It is not your turn", Toast.LENGTH_SHORT).show();
                    } else if(confirm){
                        Toast.makeText(Board.this, "You have entered a combination", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });

        CheckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlayer1Turn && confirm) {
                    if(checkMove(player1)) {
                        if(getWinner()!=null){
                            Toast.makeText(Board.this, "YOU WIN!!!", Toast.LENGTH_SHORT).show();

                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(Board.this, NewGame.class);
                                    startActivity(intent);
                                }
                            }, 5000);
                        }else{
                            playsOnBoard.clear();
                            ArrayList<Tile> tiles = new ArrayList<>();

                            for (GridLayout grid : combinationGrids) {
                                if (grid != null) {

                                    if (grid.getChildCount() != 0) {
                                        for (int i = 0; i < grid.getChildCount(); i++) {
                                            Tile tile = (Tile) grid.getChildAt(i);
                                            tiles.add(tile);
                                        }

                                        playsOnBoard.add(new Play(new ArrayList<>(tiles)));

                                    }
                                }
                                tiles.clear();
                            }

                            switchTurn();
                            confirm = false;
                            isPlayer1Turn = false;
                            playAIturn();
                        }
                    }else{
                        handGrid.removeAllViews();
                        player1.setHandTiles(backupPlayerTiles);
                        for (Tile tile : backupPlayerTiles){
                            if (tile.getParent() != null) {
                                ((ViewGroup) tile.getParent()).removeView(tile);
                            }

                            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                            int margin = 10;
                            layoutParams.setMargins(margin, margin, margin, margin);

                            int row = 0;
                            int col = handGrid.getChildCount();

                            layoutParams.rowSpec = GridLayout.spec(row);
                            layoutParams.columnSpec = GridLayout.spec(col);

                            tile.setLayoutParams(layoutParams);
                            handGrid.addView(tile);
                        }
                        setPlaysOnBoard(new ArrayList<>(backupPlaysOnBoard));
                        while(!backupPlaysOnBoard.isEmpty()) {
                            for (GridLayout grid : combinationGrids) {
                                grid.removeAllViews();
                                if (grid != null) {
                                    if (grid.getChildCount() == 0) {
                                        if (!backupPlaysOnBoard.isEmpty()) {
                                            ArrayList<Tile> play = backupPlaysOnBoard.get(0).getTiles();
                                            for (Tile tile : play) {
                                                if (tile.getParent() != null) {
                                                    ((ViewGroup) tile.getParent()).removeView(tile);
                                                }
                                                tile.setLayoutParams(new RelativeLayout.LayoutParams(60, 60));

                                                if ( String.valueOf(tile.value).length() >1) {
                                                    tile.setPadding(5, 15, 5, 15);
                                                }
                                                else {
                                                    tile.setPadding(15, 15, 15, 15);
                                                }
                                                grid.addView(tile, new GridLayout.LayoutParams());
                                                player2.removeTileFromHandTile(tile);
                                                botTileCount.setText("Mistybot          "+String.valueOf(player2.getNumberHandTiles()));
                                            }
                                            backupPlaysOnBoard.remove(0);
                                        }
                                    }
                                }
                            }
                        }
                        Toast.makeText(Board.this, "There is a wrong combination, a tile is added to your hand", Toast.LENGTH_SHORT).show();
                        backupPlaysOnBoard = new ArrayList<>(playsOnBoard);
                        confirm = false;
                        takeTileButton.performClick();
                    }
                }else{
                    if(!isPlayer1Turn){
                        Toast.makeText(Board.this, "It is not your turn", Toast.LENGTH_SHORT).show();
                    }else if(!confirm){
                        Toast.makeText(Board.this, "You have to enter a combination", Toast.LENGTH_SHORT).show();
                    }

                }
            }

        });

        sortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (condition_sort) {

                    ArrayList<Tile> selectedTiles = new ArrayList<>(player1.getHandTilesSortedByColor());

                    if (!selectedTiles.isEmpty()) {
                        handGrid.removeAllViews();
                        for (Tile selectedTile : selectedTiles) {
                            Tile newTile = new Tile(Board.this,selectedTile.getValue(),selectedTile.getColor());

                            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                            int margin = 10;
                            layoutParams.setMargins(margin, margin, margin, margin);

                            int row = 0;
                            layoutParams.rowSpec = GridLayout.spec(row);

                            newTile.setLayoutParams(layoutParams);
                            handGrid.addView(newTile);
                        }
                    }
                    condition_sort = false;
                }else{
                    ArrayList<Tile> selectedTiles = new ArrayList<>(player1.getHandTilesSortedByNumber());
                    if (!selectedTiles.isEmpty()) {
                        handGrid.removeAllViews();
                        for (Tile selectedTile : selectedTiles) {
                            Tile newTile = new Tile(Board.this,selectedTile.getValue(),selectedTile.getColor());

                            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                            int margin = 10;
                            layoutParams.setMargins(margin, margin, margin, margin);

                            int row = 0;
                            layoutParams.rowSpec = GridLayout.spec(row);

                            newTile.setLayoutParams(layoutParams);
                            handGrid.addView(newTile);
                        }
                    }
                    condition_sort = true;
                }
            }

        });

        FloatingActionButton openUpperDrawerButton = findViewById(R.id.openUpperDrawerButton);

        openUpperDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openUpperDrawer(player2);
            }
        });

        handGrid = findViewById(R.id.handGrid);
        this.playsOnBoard = new ArrayList<>();
        this.nonPlayedTiles = new ArrayList<>();
        this.backupPlaysOnBoard = new ArrayList<>();
        this.backupPlayerTiles = new ArrayList<>();
        this.ungroupedTilesOnTheBoard =  new ArrayList<>();


        createAllTilesAndInitialHands(colors, maxNumber, tilesForPlayer, player1, player2);
        backupPlayerTiles = new ArrayList<>(player1.getHandTiles());

    }

    private boolean isCurrentPlayerTurn() {
        return isPlayer1Turn;
    }

    private void openUpperDrawer(Player player) {
        UpperDrawerFragment upperDrawerFragment = new UpperDrawerFragment(player);
        upperDrawerFragment.show(getSupportFragmentManager(), upperDrawerFragment.getTag());

    }

    @SuppressLint("RestrictedApi")
    private void handleGridClick(GridLayout clickedGrid) {
        if(isCurrentPlayerTurn()) {
            ArrayList<Pair<Tile, GridLayout>> selectedTiles = getAllSelectedTiles();
            if (!selectedTiles.isEmpty()) {
                Collections.sort(selectedTiles, new Comparator<Pair<Tile, GridLayout>>() {
                    @Override
                    public int compare(Pair<Tile, GridLayout> pair1, Pair<Tile, GridLayout> pair2) {
                        return Integer.compare(pair1.first.getValue(), pair2.first.getValue());
                    }
                });

                for (Pair<Tile, GridLayout> selectedPair : selectedTiles) {
                    Tile selectedTile = selectedPair.first;
                    if(player1.removeTileFromHandTile(selectedTile)){
                        confirm = true;
                    }
                    GridLayout parentGrid = selectedPair.second;
                    parentGrid.removeView(selectedTile);
                    selectedTile.toggleSelection();

                    selectedTile.setLayoutParams(new RelativeLayout.LayoutParams(60, 60));

                    if ( String.valueOf(selectedTile.value).length() >1) {
                        selectedTile.setPadding(5, 15, 5, 15);
                    }
                    else {
                        selectedTile.setPadding(15, 15, 15, 15);
                    }
                    clickedGrid.addView(selectedTile);
                    organizeTilesInGridLayout(clickedGrid);

                }
            }
        }
    }

    private void organizeTilesInGridLayout(GridLayout grid) {
        ArrayList<Tile> tiles = new ArrayList<>();
        for (int i = 0; i < grid.getChildCount(); i++) {
            View child = grid.getChildAt(i);
            if (child instanceof Tile) {
                tiles.add((Tile) child);
            }
        }

        Collections.sort(tiles, new Comparator<Tile>() {
            @Override
            public int compare(Tile tile1, Tile tile2) {
                return Integer.compare(tile1.getValue(), tile2.getValue());
            }
        });
        grid.removeAllViews();

        for (Tile tile : tiles) {
            tile.setLayoutParams(new RelativeLayout.LayoutParams(60, 60));

            if ( String.valueOf(tile.value).length() >1) {
                tile.setPadding(5, 15, 5, 15);
            }
            else {
                tile.setPadding(15, 15, 15, 15);
            }
            grid.addView(tile, new GridLayout.LayoutParams());
        }
    }

    private ArrayList<Pair<Tile, GridLayout>> getAllSelectedTiles() {
        ArrayList<Pair<Tile, GridLayout>> selectedTiles = new ArrayList<>();

        checkAndAddSelectedTile(handGrid, selectedTiles);
        checkAndAddSelectedTile(combinationGrid1, selectedTiles);
        checkAndAddSelectedTile(combinationGrid2, selectedTiles);
        checkAndAddSelectedTile(combinationGrid3, selectedTiles);
        checkAndAddSelectedTile(combinationGrid4, selectedTiles);
        checkAndAddSelectedTile(combinationGrid5, selectedTiles);
        checkAndAddSelectedTile(combinationGrid6, selectedTiles);
        checkAndAddSelectedTile(combinationGrid7, selectedTiles);
        checkAndAddSelectedTile(combinationGrid8, selectedTiles);
        checkAndAddSelectedTile(combinationGrid9, selectedTiles);
        checkAndAddSelectedTile(combinationGrid10, selectedTiles);
        checkAndAddSelectedTile(combinationGrid11, selectedTiles);
        checkAndAddSelectedTile(combinationGrid12, selectedTiles);
        checkAndAddSelectedTile(combinationGrid13, selectedTiles);
        checkAndAddSelectedTile(combinationGrid14, selectedTiles);
        checkAndAddSelectedTile(combinationGrid15, selectedTiles);

        return selectedTiles;
    }

    private void checkAndAddSelectedTile(GridLayout grid, ArrayList<Pair<Tile, GridLayout>> selectedTiles) {
        for (int i = 0; i < grid.getChildCount(); i++) {
            View child = grid.getChildAt(i);
            if (child instanceof Tile) {
                Tile tile = (Tile) child;
                if (tile.isSelected()) {
                    selectedTiles.add(new Pair<>(tile, grid));
                }
            }
        }
    }

    public void createAllTilesAndInitialHands(String[] colors, int maxNumber, int tilesForPlayer ,Player player1, Player player2) {
        for (int i=0;i<colors.length;i++) {
            for (int number = 1; number <= maxNumber; number++) {
                Tile tile1 = new Tile(this, number, colors[i]);
                Tile tile2 = new Tile(this, number, colors[i]);
                nonPlayedTiles.add(tile1);
                nonPlayedTiles.add(tile2);
            }
        }
        Collections.shuffle(nonPlayedTiles);


        distributeTilesToPlayer(player1, tilesForPlayer, handGrid);
        distributeTilesToPlayer(player2, tilesForPlayer, handGrid);

        informationTopScreen(player1,botTileCount,textNonPlayedTiles);

    }

    private void distributeTilesToPlayer(Player player, int tilesToDistribute, GridLayout area) {
        ArrayList<Tile> initialHand = new ArrayList<>();
        for (int i = 0; i < tilesToDistribute; i++) {
            Tile tile = nonPlayedTiles.remove(0);
            initialHand.add(tile);
            if(player.intelligent==0) {

                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                int margin = 10;
                layoutParams.setMargins(margin, margin, margin, margin);
                int row = 0;
                int col = i;

                layoutParams.rowSpec = GridLayout.spec(row);
                layoutParams.columnSpec = GridLayout.spec(col);
                tile.setLayoutParams(layoutParams);
                area.addView(tile);
            }
        }
        area.invalidate();
        player.setHandTiles(initialHand);
    }
    @SuppressLint("RestrictedApi")
    private void addTileToHand(Player player) {
        if(!nonPlayedTiles.isEmpty()) {
            Tile tile = nonPlayedTiles.remove(0);
            if(player.intelligent==0) {

                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
                int margin = 10;
                layoutParams.setMargins(margin, margin, margin, margin);

                int row = 0;
                layoutParams.rowSpec = GridLayout.spec(row);

                tile.setLayoutParams(layoutParams);
                handGrid.addView(tile);
                player1.handTiles.add(tile);
            }
            else if(player.intelligent==1){
                ArrayList<Tile> handTilesArray = new ArrayList<>(player.handTiles);
                handTilesArray.add(tile);
                player.setHandTiles(handTilesArray);

                botTileCount.setText("Mistybot          "+String.valueOf(player2.getNumberHandTiles()));
            }
            updatedeck(textNonPlayedTiles);
        } else {
            Toast.makeText(this, "No more tiles in the deck", Toast.LENGTH_SHORT).show();
        }
    }

    public void informationTopScreen(Player player, TextView textTilesPlayer, TextView textNonPlayedTiles){
        nonPlayedTilesNumber = getNumberNonPlayedTiles();
        textTilesPlayer.setText("Mistybot          "+String.valueOf(player.getNumberHandTiles()));
        textNonPlayedTiles.setText(String.valueOf(nonPlayedTiles.size())+" ");
    }
    public void updatedeck(TextView textNonPlayedTiles){
        textNonPlayedTiles.setText(String.valueOf(nonPlayedTiles.size())+" ");
    }

    public int getNumberNonPlayedTiles() {
        return nonPlayedTiles.size();
    }

    public static void shuffleTiles(ArrayList<Tile> tiles) {
        Collections.shuffle(tiles);
    }

    public ArrayList<Play> getPlaysOnBoard() {
        return playsOnBoard;
    }

    public void setPlaysOnBoard(ArrayList<Play>playsOnBoard) {
        this.playsOnBoard = playsOnBoard;
    }

    public ArrayList<Tile> getUngroupedTilesOnTheBoard() {
        return ungroupedTilesOnTheBoard;
    }

    public void clearUngroupedTilesOnTheBoard() {
        ungroupedTilesOnTheBoard.clear();
    }

    @SuppressLint("RestrictedApi")
    public boolean checkMove(Player currentPlayer) {
        ArrayList<Tile> currentHand = currentPlayer.getHandTiles();
        ArrayList<Tile> tiles = new ArrayList<>();

        for (GridLayout grid : combinationGrids) {
            if (grid != null) {
                if (grid.getChildCount() != 0) {
                    for (int i = 0; i < grid.getChildCount(); i++) {
                        Tile tile = (Tile) grid.getChildAt(i);
                        tiles.add(tile);
                    }

                    if (tiles.size() < 3) {
                        return false;
                    }

                    if (!isValidGroup(tiles)) {
                        return false;
                    }
                    createPlay(tiles);
                }
            }
            tiles.clear();
        }

        return true;
    }


    public boolean checkEdit(Player currentPlayer, ArrayList<Tile> newPlayTiles, ArrayList<Tile> oldPlayTiles) {
        ArrayList<Tile> currentHand = currentPlayer.getHandTiles();
        ArrayList<Tile> newAddedTiles = new ArrayList<>();

        for (Tile newPlayTile : newPlayTiles) {
            if (!oldPlayTiles.contains(newPlayTile)) {
                newAddedTiles.add(newPlayTile);
            }
        }

        if(newPlayTiles.containsAll(oldPlayTiles)){

            if(newAddedTiles.size()>0){
                for (Tile addedTile : newAddedTiles) {

                    if(ungroupedTilesOnTheBoard.size()!=0){
                        if ((!currentHand.contains(addedTile)) && (!ungroupedTilesOnTheBoard.contains(addedTile))) {
                            return false;
                        }
                    }else{
                        if (!currentHand.contains(addedTile)){
                            return false;
                        }
                    }
                }
                if (!isValidGroup(newPlayTiles)) {

                    return false;
                }

                for (Tile addedTile : newAddedTiles) {
                    if(ungroupedTilesOnTheBoard.size()!=0){
                        if(ungroupedTilesOnTheBoard.contains(addedTile)){
                            ungroupedTilesOnTheBoard.remove(addedTile);
                        }
                    }else{
                        currentPlayer.removeTileFromHandTile(addedTile);
                    }
                }
            }else{
                return false;
            }

        }else{
            for (Tile tileFromOldPlayTiles : oldPlayTiles) {
                if(!newPlayTiles.contains(tileFromOldPlayTiles)){
                    ungroupedTilesOnTheBoard.add(tileFromOldPlayTiles);
                }
            }
        }
        return true;
    }

    private boolean isValidGroup(ArrayList<Tile> tiles) {
        boolean sameNumber = true;
        boolean sameColor = true;

        int referenceNumber = tiles.get(0).getValue();
        for (Tile tile : tiles) {
            if (tile.getValue() != referenceNumber) {
                sameNumber = false;
                break;
            }
        }

        String referenceColor = tiles.get(0).getColor();
        for (Tile tile : tiles) {
            if (!tile.getColor().equals(referenceColor)) {
                sameColor = false;
                break;
            }
        }

        return (sameNumber && areColorsDifferent(tiles)) || (sameColor && areConsecutiveNumbers(tiles));
    }

    private boolean areColorsDifferent(ArrayList<Tile> tiles) {
        ArrayList<String> colors = new ArrayList<>();
        for (Tile tile : tiles) {
            String color = tile.getColor();
            if (colors.contains(color)) {
                return false;
            }
            colors.add(color);
        }
        return true;
    }

    private boolean areConsecutiveNumbers(ArrayList<Tile> tiles) {
        tiles.sort(Comparator.comparingInt(Tile::getValue));
        for (int i = 0; i < tiles.size() - 1; i++) {
            if (tiles.get(i).getValue() + 1 != tiles.get(i + 1).getValue()) {
                return false;
            }
        }
        return true;
    }
    @SuppressLint("RestrictedApi")
    public void createPlay(ArrayList<Tile> tiles) {
        Play play = new Play(new ArrayList<>(tiles));
        boolean existeJugada = false;
        for (Play jugada : playsOnBoard) {
            if (jugada.equals(play)) {
                existeJugada = true;
                break;
            }
        }
        if (!existeJugada) {
            playsOnBoard.add(play);
        }
    }

    public void editPlay(int position, ArrayList<Tile> newPlayTiles){
        Play play = new Play(newPlayTiles);
        playsOnBoard.set(position-1,play);
    }

    public Player getWinner(){

        if (player1.getNumberHandTiles() == 0){
            return player1;
        }else if(player2.getNumberHandTiles() == 0){
            return player2;
        }else{
            return null;
        }

    }
    @SuppressLint("RestrictedApi")
    public void playAIturn(){

        ArrayList<Tile> allTiles = new ArrayList<>();
        ArrayList<Tile> currentCombinationsTileArray = new ArrayList<>(this.convertPlayInTiles(this.getPlaysOnBoard()));
        for(Tile tile:currentCombinationsTileArray){
            allTiles.add(tile);
        }

        for(Tile tile:player2.getHandTiles()){
            allTiles.add(tile);
        }

        Collections.shuffle(allTiles);
        ArrayList<Play> allPossibleCombinations = currentPlayer.getAllPossibleCombinations(currentPlayer, this, new ArrayList<>(allTiles));

        ArrayList<Play> bestPlays = currentPlayer.selectBestPLay(allPossibleCombinations, this, allTiles);

        if(bestPlays.isEmpty()){
            addTileToHand(currentPlayer);
            Toast.makeText(Board.this, "Mistybot has taken a tile", Toast.LENGTH_SHORT).show();
        }else{
            for (GridLayout grid : combinationGrids) {
                if (grid != null) {
                    grid.removeAllViews();
                    playsOnBoard.clear();
                }
            }
            while(!bestPlays.isEmpty()) {
                for (GridLayout grid : combinationGrids) {
                    if (grid != null) {
                        if (grid.getChildCount() == 0) {
                            if (!bestPlays.isEmpty()) {
                                ArrayList<Tile> play = bestPlays.get(0).getTiles();
                                createPlay(bestPlays.get(0).getTiles());
                                for (Tile tile : play) {

                                    Tile newTile = new Tile(Board.this, tile.getValue(), tile.getColor());
                                    newTile.setLayoutParams(new RelativeLayout.LayoutParams(60, 60));
                                    if ( String.valueOf(tile.value).length() >1) {
                                        newTile.setPadding(5, 15, 5, 15);
                                    }
                                    else {
                                        newTile.setPadding(15, 15, 15, 15);
                                    }
                                    grid.addView(newTile, new GridLayout.LayoutParams());

                                    player2.removeTileFromHandTile(tile);
                                    botTileCount.setText("Mistybot          "+String.valueOf(player2.getNumberHandTiles()));
                                }
                                bestPlays.remove(0);
                            }
                        }
                    }
                }
            }
            Toast.makeText(Board.this, "Mistybot has played", Toast.LENGTH_SHORT).show();
        }
        if(getWinner()!=null){
            Toast.makeText(Board.this, "MISTYBOT HAS WON!!! Good luck next time", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Board.this, NewGame.class);
                    startActivity(intent);
                }
            }, 5000);
        }else{
            isPlayer1Turn=true;
            switchTurn();
        }
    }
    @SuppressLint("RestrictedApi")
    public void  switchTurn() {

        Player temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;
        backupPlayerTiles = new ArrayList<>(player1.getHandTiles());
        backupPlaysOnBoard = new ArrayList<>(getPlaysOnBoard());
        confirm = false;
    }

    public static String getColorFromCode(String code) {
        switch (code) {
            case "r":
                return "red";
            case "d":
                return "black";
            case "b":
                return "blue";
            case "y":
                return "yellow";
            default:
                throw new IllegalArgumentException("Invalid color code: " + code);
        }
    }
    
    public ArrayList<Tile> checkMoveMonteCarlo(Player currentPlayer, ArrayList<Tile> playtiles, ArrayList<Tile> noSimulatedAllTiles, ArrayList<Tile> noSimulatedTilesFromCurrentCombinations, ArrayList<Tile> noSimulatedHandTiles) {
        ArrayList<Tile> copy = new ArrayList<>(noSimulatedAllTiles);

        Boolean removed = false;
        Boolean removed_from_hand = false;

        for (int i = 0; i < playtiles.size(); i++) {
            removed = false;
            removed_from_hand=false;
            Iterator<Tile> iterator = copy.iterator();
            while (iterator.hasNext()&&!removed&&!removed_from_hand) {
                Tile tile = iterator.next();

                if (tile.equals(playtiles.get(i))) {

                    for (Iterator<Tile> tilesIterator = noSimulatedTilesFromCurrentCombinations.iterator(); tilesIterator.hasNext();) {
                        Tile t = tilesIterator.next();
                        if (t.equals(playtiles.get(i)) ) {

                            tilesIterator.remove();
                            iterator.remove();
                            removed = true;
                            break;
                        }
                    }
                    if(!removed){
                        for (Iterator<Tile> handTilesIterator = noSimulatedHandTiles.iterator(); handTilesIterator.hasNext();) {
                            Tile t = handTilesIterator.next();
                            if (t.equals(playtiles.get(i))) {
                                removed_from_hand= true;
                                handTilesIterator.remove();
                                iterator.remove();
                                break;
                            }
                        }
                    }
                }
            }
        }
        return copy;
    }

    public ArrayList<Tile> convertPlayInTiles(ArrayList<Play> playArray){
        ArrayList<Tile> tileArraylist = new ArrayList<>();
        for(Play play:playArray){
            for(Tile tile:play.getTiles()){
                tileArraylist.add(tile);
            }
        }
        return tileArraylist;
    }
}

