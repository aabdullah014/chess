package com.chess.chessgame.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.chess.chessgame.model.Board;

public class CoordinateUtilTest {

    @Test
    void testCalculateStrCoordByIntCoord() {
        Board board = new Board();
        CoordinateUtil.generateBoardStringCoordinates(board);

        // can check all 64 squares but we can just test boundaries and a couple on the inside
        String coord = CoordinateUtil.calculateStrCoordByIntCoord(0);
        assertEquals("a8", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(7);
        assertEquals("h8", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(56);
        assertEquals("a1", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(63);
        assertEquals("h1", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(32);
        assertEquals("a4", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(3);
        assertEquals("d8", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(39);
        assertEquals("h4", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(60);
        assertEquals("e1", coord);
        coord = CoordinateUtil.calculateStrCoordByIntCoord(42);
        assertEquals("c3", coord);

        assertEquals(64, board.getTileList().size());
    }

}
