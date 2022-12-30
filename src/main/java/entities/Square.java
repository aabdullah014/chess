package src.main.java.entities;

public class Square {
    private String coordinate;
    private int x_coordinate;
    private int y_coordinate;
    private Piece occupiedBy;

    public Square(String coordinate, Piece occupiedBy, int x_coordinate, int y_coordinate) {
        this.coordinate = coordinate;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.occupiedBy = occupiedBy;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public Piece getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(Piece occupiedBy) {
        this.occupiedBy = occupiedBy;
    }
}
