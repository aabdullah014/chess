package src.main.java.service;

import src.main.java.entities.Board;
import src.main.java.entities.Pawn;
import src.main.java.entities.Piece;
import src.main.java.entities.Square;
import src.main.java.service.util.CoordinateUtil;

import java.util.ArrayList;

public class PawnService {
    private ArrayList<Square> validMoves;
    private CoordinateUtil coordinateUtil = new CoordinateUtil();

    public PawnService(){
        validMoves = new ArrayList<>();
    }

    public boolean isValidMove(Board board, Pawn pawn, Square destSquare){
        generateValidSquaresToMoveTo(board, pawn);
        if(validMoves.contains(destSquare)){
            return true;
        }

        return false;
    }

    public ArrayList<Square> generateValidSquaresToMoveTo(Board board, Pawn pawn){
        /*
            What are valid pawn moves?
            1. Pawn on starting square
                a. pawn can move one or two squares forward, assuming no piece blocks it
                b. pawn can take a piece directly diagonal
            2. Pawn on other square
                a. can only move one square forward, assuming no piece blocks it
                b. can take a piece directly diagonal
                c. en passant (can take diagonal if pawn two squares up and one across moves two spaces forward)
         */
        int currentCoordinate_x = coordinateUtil.determineXYCoordinate(pawn.getCoordinate())[0];
        int currentCoordinate_y = coordinateUtil.determineXYCoordinate(pawn.getCoordinate())[1];
        int newCoordinate_y = 0;
        int newCoordinate_x = 0;

        String newCoordinate = "";

//        Square oldSquare = coordinateUtil.findSquareGivenCoordinate(pawn.getCoordinate());
        Square newSquare = null;
        Piece pieceOnNewSquare = null;

        if(pawn.getColor().equals("w")){
            if(currentCoordinate_y == 6){
                for(int i=1; i<=2; i++){ // case 1a
                    newCoordinate_y = currentCoordinate_y-i;
                    newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
                    newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
                    pieceOnNewSquare = newSquare.getOccupiedBy();
                    if(pieceOnNewSquare == null){
                        validMoves.add(newSquare);
                    }
                }
            }

            newCoordinate_y = currentCoordinate_y-1;
            if(newCoordinate_y >= 0) {
                if (newCoordinate_y == 5) { // case 1b && 2b
                    newCoordinate_x = currentCoordinate_x - 1;
                    if (newCoordinate_x >= 0) {
                        newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
                        newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
                        pieceOnNewSquare = newSquare.getOccupiedBy();
                        if (pieceOnNewSquare != null && !pieceOnNewSquare.getColor().equals(pawn.getColor())) {
                            validMoves.add(newSquare);
                        }
                    }

                    newCoordinate_x = currentCoordinate_x + 1;
                    if (newCoordinate_x <= 7) {
                        newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
                        newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
                        pieceOnNewSquare = newSquare.getOccupiedBy();
                        if (pieceOnNewSquare != null && !pieceOnNewSquare.getColor().equals(pawn.getColor())) {
                            validMoves.add(newSquare);
                        }
                    }
                }
            }

            newCoordinate_y = currentCoordinate_y-1; // case 2a
            newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
            newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
            pieceOnNewSquare = newSquare.getOccupiedBy();
            if(newCoordinate_y >= 0 && pieceOnNewSquare == null){
                validMoves.add(newSquare);
            }

            // TODO: en passant

        } else if(pawn.getColor().equals("b")) { // same thing but for black pieces
            if(currentCoordinate_y == 1){
                for(int i=1; i<=2; i++){ // case 1a
                    newCoordinate_y = currentCoordinate_y+i;
                    newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
                    newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
                    pieceOnNewSquare = newSquare.getOccupiedBy();
                    if(pieceOnNewSquare == null){
                        validMoves.add(newSquare);
                    }
                }
            }

            newCoordinate_y = currentCoordinate_y+1;
            if(newCoordinate_y <=7) {
                if (newCoordinate_y == 2) { // case 1b && 2b
                    newCoordinate_x = currentCoordinate_x - 1;
                    if (newCoordinate_x >= 0) {
                        newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
                        newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
                        pieceOnNewSquare = newSquare.getOccupiedBy();
                        if (pieceOnNewSquare != null && !pieceOnNewSquare.getColor().equals(pawn.getColor())) {
                            validMoves.add(newSquare);
                        }
                    }

                    newCoordinate_x = currentCoordinate_x + 1;
                    if (newCoordinate_x <= 7) {
                        newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
                        newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
                        pieceOnNewSquare = newSquare.getOccupiedBy();
                        if (pieceOnNewSquare != null && !pieceOnNewSquare.getColor().equals(pawn.getColor())) {
                            validMoves.add(newSquare);
                        }
                    }
                }
            }

            newCoordinate_y = currentCoordinate_y+1; // case 2a
            newCoordinate = coordinateUtil.determineStringCoordinateForSquare(currentCoordinate_x, newCoordinate_y);
            newSquare = coordinateUtil.findSquareGivenCoordinate(board, newCoordinate);
            pieceOnNewSquare = newSquare.getOccupiedBy();
            if(newCoordinate_y <= 7 && pieceOnNewSquare == null){
                validMoves.add(newSquare);
            }

            // TODO: en passant
        }
        return validMoves;
    }
}
