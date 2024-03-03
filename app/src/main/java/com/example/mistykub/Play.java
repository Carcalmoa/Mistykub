package com.example.mistykub;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;


public class Play {
    private ArrayList<Tile> tilesOfPlay;

    public Play(ArrayList<Tile> tiles) {
        this.tilesOfPlay = tiles;

    }

    public ArrayList<Tile> getTiles() {
        return tilesOfPlay;
    }

    public void addTile(Tile tile) {
        tilesOfPlay.add(tile);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(" ");
        for (Tile tile : tilesOfPlay) {
            result.append(tile.toString()).append(" ");
        }
        return result.toString().trim();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Play play = (Play) o;
        return Objects.equals(tilesOfPlay, play.tilesOfPlay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tilesOfPlay);
    }
}