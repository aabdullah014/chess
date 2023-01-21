package com.chess.chessgame.model.Pieces;

public class Bishop implements Piece {

    private final String name = "B";
    private final int value = 300;
    private String color;

    public Bishop(String color){
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
