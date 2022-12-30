package src.main.java.service;

import src.main.java.entities.*;
import src.main.java.service.util.CoordinateUtil;

public class BoardService {
    private CoordinateUtil coordinateUtil = new CoordinateUtil();
    private Square[][] tileGrid;

    public Board generateInitialBoard(){
        tileGrid = new Square[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                Square square = new Square(
                        coordinateUtil.determineStringCoordinateForSquare(j, i),
                        determineWhatPieceOccupiesSquareInitial(j,i),
                        i,
                        j
                );
                tileGrid[i][j] = square;
            }
        }

        Board board = new Board(tileGrid);
        coordinateUtil.setTileGrid(tileGrid);

        return board;
    }

    private Piece determineWhatPieceOccupiesSquareInitial(int x_coordinate, int y_coordinate) {
        Piece piece = null;

        if(y_coordinate == 1 || y_coordinate == 6){
            piece = new Pawn();
        }

        if((x_coordinate == 0 && y_coordinate == 0) ||
                (x_coordinate == 7 && y_coordinate == 0) ||
                (x_coordinate == 0 && y_coordinate == 7) ||
                (x_coordinate == 7 && y_coordinate == 7)) {
            piece = new Rook();
        }

        if((x_coordinate == 1 && y_coordinate == 0) ||
                (x_coordinate == 6 && y_coordinate == 0) ||
                (x_coordinate == 1 && y_coordinate == 7) ||
                (x_coordinate == 6 && y_coordinate == 7)) {
            piece = new Knight();
        }

        if((x_coordinate == 2 && y_coordinate == 0) ||
                (x_coordinate == 5 && y_coordinate == 0) ||
                (x_coordinate == 2 && y_coordinate == 7) ||
                (x_coordinate == 5 && y_coordinate == 7)) {
            piece = new Bishop();
        }

        if((x_coordinate == 3 && y_coordinate == 0) ||
                (x_coordinate == 3 && y_coordinate == 7)) {
            piece = new Queen();
        }

        if((x_coordinate == 4 && y_coordinate == 0) ||
                (x_coordinate == 4 && y_coordinate == 7)) {
            piece = new King();
        }

        // backwards because of how for loop is
        if (y_coordinate < 2 && piece != null){
            piece.setColor("b");
        }

        if(piece != null){
            piece.setCoordinate(coordinateUtil.determineStringCoordinateForSquare(x_coordinate, y_coordinate));
        }

        return piece;
    }

    public Square findSquareGivenCoordinate(Board board, String coordinate) {
        return coordinateUtil.findSquareGivenCoordinate(board, coordinate);
    }
}
