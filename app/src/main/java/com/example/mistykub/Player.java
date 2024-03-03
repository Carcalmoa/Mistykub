package com.example.mistykub;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import android.os.AsyncTask;

public class Player {
    double bestPuntuation;
    int timeoutduration = 50;
    ArrayList<Play> bestPlayToChoose ;
    int id;
    int intelligent; // 1 if intelligent, 0 no intelligent
    ArrayList<Tile> handTiles;
    long startTime;
    ArrayList<ArrayList<Play>> bakcupSimulationsFinished;
    Player() {
    }

    Player(int id, int intelligent) {
        this.id = id;
        this.intelligent = intelligent;
    }

    public void setHandTiles(ArrayList<Tile> handTiles) {
        this.handTiles = handTiles;
    }

    public ArrayList<Tile> getHandTiles() {
        return handTiles;
    }

    public ArrayList<Tile> getHandTilesSortedByColor() {
        ArrayList<Tile> handTilesToSortByColor = new ArrayList<>(handTiles);
        Collections.sort(handTilesToSortByColor, Comparator.comparingInt(tile -> tile.value));
        handTilesToSortByColor.sort(Comparator.comparing(tile -> tile.color));

        return handTilesToSortByColor;
    }

    public ArrayList<Tile> getHandTilesSortedByNumber() {
        ArrayList<Tile> handTilesToSortByNumber = new ArrayList<>(handTiles);
        Collections.sort(handTilesToSortByNumber, Comparator.comparingInt(tile -> tile.value));
        return handTilesToSortByNumber;
    }

    public void setTimeoutDuration(int duration) {
        timeoutduration = duration;
    }
    public int getNumberHandTiles() {
        return handTiles.size();
    }

    public boolean removeTileFromHandTile(Tile tile) {
        for (int i = 0; i < handTiles.size(); i++) {
            if (handTiles.get(i).equals(tile)) {
                handTiles.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Play> getAllPossibleCombinations (Player currentPlayer, Board board, ArrayList<Tile> allTiles){
        ArrayList<Play> allPossibleCombinations = new ArrayList<>();
        allPossibleCombinations = getAllPossibleCombinationsProcedure(currentPlayer, board, allTiles, allPossibleCombinations);

        ArrayList<Tile> allTilesWithoutRepeatedTiles = new ArrayList<>();
        for (Tile tile : allTiles) {

            if (!allTilesWithoutRepeatedTiles.contains(tile)) {
                allTilesWithoutRepeatedTiles.add(tile);
            }
        }
        allPossibleCombinations = getAllPossibleCombinationsProcedure(currentPlayer, board, allTilesWithoutRepeatedTiles, allPossibleCombinations);
        ArrayList<Play> allPossibleCombinationsWithoutRepeatedPlays = new ArrayList<>();
        for (Play play : allPossibleCombinations) {

            if (!allPossibleCombinationsWithoutRepeatedPlays.contains(play)) {
                allPossibleCombinationsWithoutRepeatedPlays.add(play);
            }
        }

        return allPossibleCombinationsWithoutRepeatedPlays;
    }

    public ArrayList<Play> getAllPossibleCombinationsProcedure (Player currentPlayer, Board board, ArrayList<Tile> allTiles, ArrayList<Play> allPossibleCombinations){
        ArrayList <Tile> handTilesToSortByColor =  new ArrayList<>(getHandTilesSortedByColor(allTiles));
        int positionIndex = 0;
        boolean endGroup = false;
        ArrayList<Tile> tilesOfGroup = new ArrayList<>();

        while (positionIndex < handTilesToSortByColor.size()) {
            // Loop to create a group of tiles with the same color and increasing value
            while(!endGroup){
                // We add the tile on the positionIndex to tilesOfGroup if it is empty
                if(tilesOfGroup.size() == 0){
                    tilesOfGroup.add(handTilesToSortByColor.get(positionIndex));
                    positionIndex++;
                }
                if(positionIndex>=handTilesToSortByColor.size()){
                    break;
                }
                // Check if the following tile has the same color and one more value than the current one
                if ( (handTilesToSortByColor.get(positionIndex).color.equals(tilesOfGroup.get(tilesOfGroup.size()-1).color))
                        && (handTilesToSortByColor.get(positionIndex).value == tilesOfGroup.get(tilesOfGroup.size()-1).value+1) ) {
                    tilesOfGroup.add(handTilesToSortByColor.get(positionIndex));
                    // Check if we have more tiles in the hand
                    if(positionIndex != handTilesToSortByColor.size()-1){
                        positionIndex++;
                    }else{
                        // We end the group because we have no more tiles
                        positionIndex++;
                        endGroup = true;
                    }

                }else{
                    // The following tile does not meet the conditions to join the group, we have a possible combination, we exit the loop to check it
                    // If the actual tile is the last tile we increment the positionIndex to end the loop
                    // If it is not, we do not increment the positionIndex beacuse maybe it can be grouped with the following tiles
                    if(positionIndex == handTilesToSortByColor.size()-1){
                        positionIndex++;
                    }
                    endGroup = true;
                }
            }
            // Check if the group has the minimum size
            if(tilesOfGroup.size() >= 3){
                // Loop to change the starting tile
                for(int start = 0; start <= tilesOfGroup.size()-3; start++){
                    // Loop to increase the window size
                    for(int window_size = start+3; window_size <= tilesOfGroup.size(); window_size++){
                        ArrayList<Tile> newCombinationList = new ArrayList<>(tilesOfGroup.subList(start, window_size));
                        Play newCombination = new Play(newCombinationList);
                        allPossibleCombinations.add(newCombination);
                    }
                }
            }
            tilesOfGroup.clear();
            endGroup = false;

        }

        positionIndex = 0;
        ArrayList <Tile> handTilesToSortByNumber =  new ArrayList<>(getHandTilesSortedByNumber(allTiles));
        while (positionIndex < handTilesToSortByNumber.size()-1) {
            // Loop to create a group of tiles with the different color and the same value
            while(!endGroup){
                tilesOfGroup.add(handTilesToSortByNumber.get(positionIndex));
                positionIndex++;
                for(int i = 0; i< tilesOfGroup.size(); i++){
                    // Check if the actual tile has different color and the same value than the tiles in the group
                    // Check if the tile on the position index is the last one
                    if(positionIndex == handTilesToSortByNumber.size()){
                        endGroup = true;
                        break;
                    }

                    if ( (!handTilesToSortByNumber.get(positionIndex).color.equals(tilesOfGroup.get(i).color))
                            && (handTilesToSortByNumber.get(positionIndex).value == tilesOfGroup.get(i).value) ) {
                        tilesOfGroup.add(handTilesToSortByNumber.get(positionIndex));
                        positionIndex ++;
                    }else{
                        endGroup = true;
                        break;
                    }
                }
            }
            // Check if the group has the minimum size
            if(tilesOfGroup.size() >= 3){

                if(tilesOfGroup.size() == 4){
                    allPossibleCombinations.add(new Play(new ArrayList<>(tilesOfGroup)));
                    // Loop to create new possible combinations of 3 tiles from the original one
                    // We remove the tile on the i position in each iteration
                    for (int i = 0; i < tilesOfGroup.size(); i++) {
                        ArrayList<Tile> newGroup = new ArrayList<>(tilesOfGroup);
                        newGroup.remove(i);
                        allPossibleCombinations.add(new Play(new ArrayList<>(newGroup)));
                    }
                }

                else{
                    allPossibleCombinations.add(new Play(new ArrayList<>(tilesOfGroup)));
                }
            }
            endGroup = false;
            tilesOfGroup.clear();
        }
        return allPossibleCombinations;
    }

    public ArrayList<Tile> simulateMonteCarlo(Play combination, Random random, Board board, ArrayList<Tile> noSimulatedAllTiles, ArrayList<Tile> noSimulatedTilesFromCurrentCombinations, ArrayList<Tile> noSimulatedHandTiles) {

        ArrayList<Tile> noSimulatedAllTilesUpdated = new ArrayList<>(board.checkMoveMonteCarlo(this, combination.getTiles(), noSimulatedAllTiles, noSimulatedTilesFromCurrentCombinations, noSimulatedHandTiles));
        return noSimulatedAllTilesUpdated;
    }

    public ArrayList<Play> selectBestPLay(ArrayList<Play> allCombinations, Board board, ArrayList<Tile> allTiles) {
        bestPlayToChoose = new ArrayList<>();
        ArrayList<Play> playsOfSimulation = new ArrayList<>();
        ArrayList<Tile> currentCombinationsTileArrayBackup = new ArrayList<>(board.convertPlayInTiles(board.getPlaysOnBoard()));
        startTime = System.nanoTime();
        bakcupSimulationsFinished = new ArrayList<>();
        for(Play play : allCombinations){
            playsOfSimulation = new ArrayList<>();
            recursive(play,allCombinations, board, new ArrayList<>(allTiles), currentCombinationsTileArrayBackup, this.getHandTiles(), playsOfSimulation, 0);
        }
        bestPuntuation = 0.0;
        return bestPlayToChoose;
    }

    public ArrayList<Play> recursive(Play remainingPlay,ArrayList<Play> allCombinations, Board board, ArrayList<Tile> allTiles, ArrayList<Tile> noSimulatedCurrentCombinations, ArrayList<Tile> noSimulatedHandTiles, ArrayList<Play> playsOfSimulation, int iteration){
        Random random = new Random();
        double totalScore = 0.0;
        ArrayList<Tile> noSimulatedAllTilesBackup = new ArrayList<>();
        ArrayList<Play> remainingCombinationsAfter = new ArrayList<>();
        ArrayList<Tile> noSimulatedHandTilesBackup = new ArrayList<>(noSimulatedHandTiles);
        ArrayList<Tile> noSimulatedTilesFromCurrentCombinationsBackup = new ArrayList<>(noSimulatedCurrentCombinations);
        ArrayList<Tile> noSimulatedAllTiles = new ArrayList<>(allTiles);
        noSimulatedAllTiles = new ArrayList<>(simulateMonteCarlo(remainingPlay, random, board, noSimulatedAllTiles, noSimulatedTilesFromCurrentCombinationsBackup, noSimulatedHandTilesBackup));

        playsOfSimulation.add(remainingPlay);
        noSimulatedAllTilesBackup = new ArrayList<>(noSimulatedAllTiles);
        ArrayList<Play> remainingCombinations = new ArrayList<>(getAllPossibleCombinations(this, board, new ArrayList<>(noSimulatedAllTiles)));
        remainingCombinationsAfter = new ArrayList<>(remainingCombinations);

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        // Recursive call
        if (remainingCombinationsAfter.size() != 0) {

            if (elapsedTime < TimeUnit.SECONDS.toNanos(timeoutduration)) {
                for(Play nextPlay: remainingCombinationsAfter){ //555
                    recursive(nextPlay, remainingCombinationsAfter, board, new ArrayList<>(noSimulatedAllTilesBackup), new ArrayList<>(noSimulatedTilesFromCurrentCombinationsBackup), new ArrayList<>(noSimulatedHandTilesBackup), new ArrayList<>(playsOfSimulation), iteration+1);
                }

            }else{
                return bestPlayToChoose;
            }

        } else {
            bakcupSimulationsFinished.add(new ArrayList<>(playsOfSimulation));
            totalScore = getReward(noSimulatedAllTilesBackup, noSimulatedTilesFromCurrentCombinationsBackup, noSimulatedHandTilesBackup);
            // Update results with the recursive call
            if (playsOfSimulation != null && totalScore > bestPuntuation) {
                bestPuntuation = totalScore;
                bestPlayToChoose = new ArrayList<>(playsOfSimulation);
            }
        }


        return bestPlayToChoose;
    }

    public double getReward(ArrayList<Tile> allTilesNotSimulated, ArrayList<Tile> noSimulatedTilesFromCurrentCombinations, ArrayList<Tile> noSimulatedHandTiles){
        double reward = 0.0;

        if (noSimulatedTilesFromCurrentCombinations.size()==0 && this.handTiles.size()>noSimulatedHandTiles.size()){
            reward = 1.0 / ((double) noSimulatedHandTiles.size() + 1);
            return reward;
        }else{
            return reward;
        }
    }
    public ArrayList<Tile> getHandTilesSortedByNumber(ArrayList <Tile> handTilesToSortByNumber){
        Collections.sort(handTilesToSortByNumber, Comparator.comparingInt(tile -> tile.value));
        return handTilesToSortByNumber;
    }

    public ArrayList<Tile> getHandTilesSortedByColor(ArrayList <Tile> handTilesToSortByColor){
        Collections.sort(handTilesToSortByColor, Comparator.comparingInt(tile -> tile.value));
        handTilesToSortByColor.sort(Comparator.comparing(tile -> tile.color));

        return handTilesToSortByColor;
    }

}