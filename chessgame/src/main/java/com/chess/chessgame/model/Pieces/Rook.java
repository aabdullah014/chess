package com.chess.chessgame.model.Pieces;

public class Rook implements Piece {
    
    private final String name = "R";
    private final int value = 500;
    private String color;

    public Rook(String color){
        this.color = color;
    }
    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getValue() {
        return this.value;
    }

}
