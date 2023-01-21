package com.chess.chessgame.util;


import com.chess.chessgame.model.Board;
import com.chess.chessgame.model.Tile;
import com.chess.chessgame.model.Pieces.Bishop;
import com.chess.chessgame.model.Pieces.King;
import com.chess.chessgame.model.Pieces.Knight;
import com.chess.chessgame.model.Pieces.Pawn;
import com.chess.chessgame.model.Pieces.Queen;
import com.chess.chessgame.model.Pieces.Rook;

public class BoardUtil {

    public static Board generateStartingBoard(){
        Board board = new Board();

        CoordinateUtil.generateBoardStringCoordinates(board);
        assignStartingPieceTiles(board);
        return board;
    }

    private static void assignStartingPieceTiles(Board board){
        for(Tile tile: board.getTileList()){
            // black pawns
            if(tile.getTileId().substring(1).equals("7")){
                tile.setTileOccupied(true);
                Pawn pawn = new Pawn("b");
                tile.setPiece(pawn);
            } else if(tile.getTileId().substring(1).equals("2")){ // white pawns
                tile.setTileOccupied(true);
                Pawn pawn = new Pawn("w");
                tile.setPiece(pawn);
            } else if(tile.getTileId().equals("a8") || tile.getTileId().equals("h8")){ // black rooks
                tile.setTileOccupied(true);
                Rook rook = new Rook("b");
                tile.setPiece(rook);
            } else if(tile.getTileId().equals("b8") || tile.getTileId().equals("g8")){ // black knights
                tile.setTileOccupied(true);
                Knight knight = new Knight("b");
                tile.setPiece(knight);
            } else if(tile.getTileId().equals("c8") || tile.getTileId().equals("f8")){ // black bishops
                tile.setTileOccupied(true);
                Bishop bishop = new Bishop("b");
                tile.setPiece(bishop);
            } else if(tile.getTileId().equals("d8")){ // black queen
                tile.setTileOccupied(true);
                Queen queen = new Queen("b");
                tile.setPiece(queen);
            } else if(tile.getTileId().equals("e8")){ // black king
                tile.setTileOccupied(true);
                King king = new King("b");
                tile.setPiece(king);
            } else if(tile.getTileId().equals("a1") || tile.getTileId().equals("h1")){ // white rooks
                tile.setTileOccupied(true);
                Rook rook = new Rook("w");
                tile.setPiece(rook);
            } else if(tile.getTileId().equals("b1") || tile.getTileId().equals("g1")){ // white knights
                tile.setTileOccupied(true);
                Knight knight = new Knight("w");
                tile.setPiece(knight);
            } else if(tile.getTileId().equals("c1") || tile.getTileId().equals("f1")){ // white bishops
                tile.setTileOccupied(true);
                Bishop bishop = new Bishop("w");
                tile.setPiece(bishop);
            } else if(tile.getTileId().equals("d1")){ // white queen
                tile.setTileOccupied(true);
                Queen queen = new Queen("w");
                tile.setPiece(queen);
            } else if(tile.getTileId().equals("e1")){ // white king
                tile.setTileOccupied(true);
                King king = new King("w");
                tile.setPiece(king);
            }
        }
    }
}