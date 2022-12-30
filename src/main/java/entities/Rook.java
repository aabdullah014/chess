package src.main.java.entities;

public class Rook implements Piece {
    private final int pointValue = 5;
    private final String name = "R";
    private String color = "w";
    private String coordinate;
    @Override
    public int takePiece(Piece piece) {
        return 0;
    }

    @Override
    public int move(Square square) {
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
}
