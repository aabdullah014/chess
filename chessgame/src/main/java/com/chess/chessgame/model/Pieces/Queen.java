package com.chess.chessgame.model.Pieces;

public class Queen implements Piece{

    private final String name = "Q";
    private final int value = 900;
    private String color;

    public Queen(String color){
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

