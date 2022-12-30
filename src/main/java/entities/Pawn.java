package src.main.java.entities;

public class Pawn implements Piece {

    private final int pointValue = 1;
    private String name = "";
    private String color = "w";
    private String coordinate;
    private boolean onStartingSquare = true;
    @Override
    public int takePiece(Piece piece) {
        return 0;
    }

    @Override
    public int move(Square square) {
        //on first move we want to have the option to move two spaces
        onStartingSquare = false;
        return 0;
    }

    public int getPointValue() {
        return pointValue;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCoordinate(){
        return coordinate;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setCoordinate(String coordinate){
        this.coordinate = coordinate;
    }
    public void setName(String name){
        this.name = name;
    }
}
