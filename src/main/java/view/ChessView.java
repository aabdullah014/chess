package src.main.java.view;

import src.main.java.entities.Board;
import src.main.java.entities.Piece;
import src.main.java.entities.Square;

public class ChessView {

    private final UserIO io;

    public ChessView(UserIO io) {
        this.io = io;
    }

    public String getColor(){
        return io.readString("Would you like to play as black (b) or white (w)?");
    }

    public String getMove(){
        return io.readString("What is your move? Enter 'exit' to end game.");
    }

    public void printBoard(Board board){
        for(Square[] s: board.getBoard()){
            System.out.println("\n");
            for(Square t: s){
                String name = "-";
                Piece piece = t.getOccupiedBy();
                if(piece != null) {
                    name = t.getOccupiedBy().getName();
                    if(name.equals("")){
                        name = "p";
                    }
                }
                io.print(name + "  ");
            }
        }
    }
}
