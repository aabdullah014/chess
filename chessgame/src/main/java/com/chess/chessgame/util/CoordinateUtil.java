package com.chess.chessgame.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

import com.chess.chessgame.model.Board;
import com.chess.chessgame.model.Tile;

public class CoordinateUtil {

    private static Map<String, Integer> coordinateStrIntMapping;

    public static String calculateStrCoordByIntCoord(int intCoordinate){
        // assuming a8 = 0 and h1 = 63

        for(Entry<String, Integer> e: coordinateStrIntMapping.entrySet()){
            if(Objects.equals(intCoordinate, e.getValue())){
                return e.getKey();
            }
        }

        return null;
    }

    public static void generateBoardStringCoordinates(Board board){
        coordinateStrIntMapping = new HashMap<>();
        String strCoord = "";
        int count = 0;
        for(int row = 0; row < 8; row++){
            String suffix = "";

            switch(row){
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
            for(int col = 0; col < 8; col++){
                String prefix = "";

                switch(col){
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
                strCoord = prefix + suffix;
                coordinateStrIntMapping.put(strCoord,  count);
                board.getTileList().add(new Tile(strCoord)); // add new Tile to board
                count++;
            }
        }
    }

}
