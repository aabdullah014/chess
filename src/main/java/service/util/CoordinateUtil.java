package src.main.java.service.util;

import src.main.java.entities.*;
import src.main.java.service.BoardService;

public class CoordinateUtil {

    private Square[][] tileGrid = new Square[8][8];
    public String determineStringCoordinateForSquare(int x_coordinate, int y_coordinate) {
        String prefix = "";
        String suffix = "";

        switch (x_coordinate){
            case 0:
                prefix = "a";
                break;
            case 1:
                prefix = "b";
                break;
            case 2:
                prefix = "c";
                break;
            case 3:
                prefix = "d";
                break;
            case 4:
                prefix = "e";
                break;
            case 5:
                prefix = "f";
                break;
            case 6:
                prefix = "g";
                break;
            case 7:
                prefix = "h";
                break;
        }

        switch (y_coordinate){ // matrix starts at top left but chess board starts bottom right so backwards
            case 0:
                suffix = "8";
                break;
            case 1:
                suffix = "7";
                break;
            case 2:
                suffix = "6";
                break;
            case 3:
                suffix = "5";
                break;
            case 4:
                suffix = "4";
                break;
            case 5:
                suffix = "3";
                break;
            case 6:
                suffix = "2";
                break;
            case 7:
                suffix = "1";
                break;
        }

        return prefix+suffix;
    }

    public int[] determineXYCoordinate(String coordinate){
        String prefix = coordinate.substring(0,1);
        String suffix = coordinate.substring(1);

        int x_coordinate = 0;
        int y_coordinate = 0;

        switch (prefix){
            case "a":
                x_coordinate = 0;
                break;
            case "b":
                x_coordinate = 1;
                break;
            case "c":
                x_coordinate = 2;
                break;
            case "d":
                x_coordinate = 3;
                break;
            case "e":
                x_coordinate = 4;
                break;
            case "f":
                x_coordinate = 5;
                break;
            case "g":
                x_coordinate = 6;
                break;
            case "h":
                x_coordinate = 7;
                break;
        }

        switch (suffix){ // matrix starts at top left but chess board starts bottom right so backwards
            case "1":
                y_coordinate = 7;
                break;
            case "2":
                y_coordinate = 6;
                break;
            case "3":
                y_coordinate = 5;
                break;
            case "4":
                y_coordinate = 4;
                break;
            case "5":
                y_coordinate = 3;
                break;
            case "6":
                y_coordinate = 2;
                break;
            case "7":
                y_coordinate = 1;
                break;
            case "8":
                y_coordinate = 0;
                break;
        }

        int[] xyCoordinate = {x_coordinate, y_coordinate};

        return xyCoordinate;
    }

    public Square findSquareGivenCoordinate(Board board, String coordinate) {
        for(Square[] row: board.getBoard()) {
            for(Square s: row) {
                if(s.getCoordinate().equals(coordinate)){
                    return s;
                }
            }
        }

        return null;
    }

    public Square[][] getTileGrid(){
        return tileGrid;
    }

    public void setTileGrid(Square[][] tileGrid){
        this.tileGrid = tileGrid;
    }
}
