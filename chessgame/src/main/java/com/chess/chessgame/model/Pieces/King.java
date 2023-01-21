package com.chess.chessgame.model.Pieces;

public class King implements Piece {

    private final String name = "K";
    private final int value = 10000;
    private String color;

    public King(String color){
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
