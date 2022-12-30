package src.main.java.controller;

import src.main.java.entities.Board;
import src.main.java.entities.Piece;
import src.main.java.entities.Square;
import src.main.java.service.BoardService;
import src.main.java.service.PieceService;
import src.main.java.view.ChessView;
import src.main.java.view.UserIOConsoleImpl;

public class BoardController{
    private BoardService boardService = new BoardService();
    private PieceService pieceService = new PieceService();
    private UserIOConsoleImpl io = new UserIOConsoleImpl();
    private ChessView view = new ChessView(io);
    private boolean continueGame = true;
    private Square[][] tileGrid;
    public void run(){
        Board board = boardService.generateInitialBoard();
        view.printBoard(board);

        // get color you wish to play as
        String color = view.getColor().toLowerCase();
        while(continueGame){
            String move = view.getMove(); //get move

            if(move.equals("exit")){ // option to leave game
                continueGame = false;
                break;
            }

            String pieceName = move.substring(0,1); // first letter of move
            String coordinate = move.substring(1);
            String pawnPosition = "";

            // logic for pawn
            if(pieceName.equals("a") ||
                    pieceName.equals("b") ||
                    pieceName.equals("c") ||
                    pieceName.equals("d") ||
                    pieceName.equals("e") ||
                    pieceName.equals("f") ||
                    pieceName.equals("g") ||
                    pieceName.equals("h")) {
                pawnPosition = pieceName;
                pieceName = "p";

                coordinate = move;
            }
            tileGrid = board.getBoard();

            Piece piece = pieceService.determinePieceByAbbreviationAndColor(color, pieceName, pawnPosition, tileGrid);
            Square originSquare = boardService.findSquareGivenCoordinate(board, piece.getCoordinate());
            Square destSquare = boardService.findSquareGivenCoordinate(board, coordinate);
            pieceService.move(board, piece, coordinate, originSquare, destSquare);

            view.printBoard(board);
        }
    }
}