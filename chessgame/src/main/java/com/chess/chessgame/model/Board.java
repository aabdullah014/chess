package com.chess.chessgame.model;

import java.util.ArrayList;


public class Board {
    
    private ArrayList<Tile> tileList = new ArrayList<>();

    public Tile getTile(String tileId){
        for(Tile tile: tileList){
            if(tile.getTileId().equals(tileId)){
                return tile;
            }
        }

        return null;
    }

    public ArrayList<Tile> getTileList() {
        return this.tileList;
    }

}
