package com.chess.chessgame.ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chess.chessgame.model.Board;
import com.chess.chessgame.model.Tile;
import com.chess.chessgame.util.BoardUtil;
import com.chess.chessgame.util.CoordinateUtil;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOError;
import java.io.IOException;

public class TilePanel extends JPanel {

    private final int tileId;
    private final static Dimension TILE_PANEL_DIMENSION =  new Dimension(5,5);
    
    private final Color lightColor = Color.decode("#FFFACD");
    private final Color darkColor =  Color.decode("#593E1A");

    TilePanel(BoardPanel boardPanel, int tileId) {

        super();
        this.tileId = tileId;
        setPreferredSize(TILE_PANEL_DIMENSION);
        assignTileColor(tileId);

        Board board = BoardUtil.generateStartingBoard();
        assignTilePieceIcon(board);

        validate();
    }

    private void assignTileColor(int flipper) {
            // create checkerboard pattern
            if(tileId%16<=7 ){
                setBackground(flipper%2 == 0 ? lightColor : darkColor);
            } else {
                setBackground(flipper%2 != 0 ? lightColor : darkColor);
            }
            setToolTipText(String.valueOf(flipper));
    }

    private void assignTilePieceIcon(Board board){
        
        String tileString = CoordinateUtil.calculateStrCoordByIntCoord(this.tileId);
        String pieceIconPath = "chessgame/src/main/resources/assets/img/";
        String extension = ".png";
        Tile tile = board.getTile(tileString);

        this.removeAll();
        if(tile.getTileOccupied()) {
            try{
                final BufferedImage image = ImageIO.read(
                    new File(pieceIconPath + tile.getPiece().getColor() + tile.getPiece().getName() + extension));
                add(new JLabel(new ImageIcon(image)));
            } catch (IOException e) {
                System.err.println("Unable to create piece images: " + e);
            }
        }
    }
}
