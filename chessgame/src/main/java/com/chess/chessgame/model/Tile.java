package com.chess.chessgame.model;

import com.chess.chessgame.model.Pieces.Piece;

public class Tile {
    
    private String tileId;
    private boolean tileOccupied;
    private Piece piece;

    public Tile(String tileId){
        this.tileId = tileId;
    }

    public boolean getTileOccupied(){
        return this.tileOccupied;
    }

    public String getTileId(){
        return this.tileId;
    }

    public Piece getPiece(){
        return this.piece;
    }


    public void setTileOccupied(boolean tileOccupied){
        this.tileOccupied = tileOccupied;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }

}
