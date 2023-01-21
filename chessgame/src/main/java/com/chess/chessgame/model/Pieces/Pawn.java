package com.chess.chessgame.model.Pieces;

public class Pawn implements Piece {
    
    private final String name = "p";
    private final int value = 100;
    private String color;

    public Pawn(String color){
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
