package src.main.java.entities;

public interface Piece {
    int takePiece(Piece piece);
    int move(Square square);

    String getColor();
    String getName();
    String getCoordinate();
    void setColor(String color);
    void setCoordinate(String coordinate);

}
