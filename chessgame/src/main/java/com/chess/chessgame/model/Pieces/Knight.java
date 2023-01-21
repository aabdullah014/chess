package com.chess.chessgame.model.Pieces;

public class Knight implements Piece{
    
    private final String name = "N";
    private final int value = 300;
    private String color;

    public Knight(String color){
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
