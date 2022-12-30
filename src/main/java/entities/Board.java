package src.main.java.entities;


public class Board {
    private Square[][] board;

    public Board(Square[][] board) {
        this.board = board;
    }

    public Square[][] getBoard() {
        return board;
    }
}
