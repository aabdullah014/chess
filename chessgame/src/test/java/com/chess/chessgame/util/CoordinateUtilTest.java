package com.chess.chessgame.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoordinateUtilTest {

    private CoordinateUtil util;

    @BeforeEach 
    void setup(){
        util = new CoordinateUtil();
    }
    @Test
    void testCalculateStrCoordByIntCoord() {
        util.generateBoardStringCoordinates();

        // can check all 64 squares but we can just test boundaries and a couple on the inside
        String coord = util.calculateStrCoordByIntCoord(0);
        assertEquals("a8", coord);
        coord = util.calculateStrCoordByIntCoord(7);
        assertEquals("h8", coord);
        coord = util.calculateStrCoordByIntCoord(56);
        assertEquals("a1", coord);
        coord = util.calculateStrCoordByIntCoord(63);
        assertEquals("h1", coord);
        coord = util.calculateStrCoordByIntCoord(32);
        assertEquals("a4", coord);
        coord = util.calculateStrCoordByIntCoord(3);
        assertEquals("d8", coord);
        coord = util.calculateStrCoordByIntCoord(39);
        assertEquals("h4", coord);
        coord = util.calculateStrCoordByIntCoord(60);
        assertEquals("e1", coord);
        coord = util.calculateStrCoordByIntCoord(42);
        assertEquals("c3", coord);
    }

}
