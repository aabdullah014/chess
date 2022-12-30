package src.main.java.service;

import src.main.java.entities.Board;
import src.main.java.entities.Pawn;
import src.main.java.entities.Piece;
import src.main.java.entities.Square;

public class PieceService {

    private PawnService pawnService = new PawnService();

    public void move(Board board, Piece piece, String coordinate, Square originSquare, Square destSquare){
        if(piece.getClass() == Pawn.class){
            if(pawnService.isValidMove(board, (Pawn) piece, destSquare)){
                piece.setCoordinate(coordinate);
                originSquare.setOccupiedBy(null);
                destSquare.setOccupiedBy(piece);
            }
        } else {
            piece.setCoordinate(coordinate);
            originSquare.setOccupiedBy(null);
            destSquare.setOccupiedBy(piece);
        }
    }

    public Piece determinePieceByAbbreviationAndColor(String color, String pieceName, String file, Square[][] tileGrid){
        if(pieceName.equals("p")){
            return determineSpecificPawn(color, file, tileGrid);
        }
        for(Square[] row: tileGrid){
            for(Square s: row){
                Piece piece = s.getOccupiedBy();
                if (piece != null &&
                    piece.getColor().equals(color) &&
                    piece.getName().equals(pieceName)){
                    return piece;
                }
            }
        }

        return null;
    }

    public Pawn determineSpecificPawn(String color, String file, Square[][] tileGrid){
        for(Square[] row: tileGrid){
            for(Square s: row){
                Piece piece = s.getOccupiedBy();
                if (piece != null &&
                        piece.getColor().equals(color) &&
                        piece.getCoordinate().substring(0,1).equals(file) &&
                        piece.getName().equals("")){
                    return (Pawn) piece;
                }
            }
        }

        return null;
    }
}
