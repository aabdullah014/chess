package com.chess.chessgame.ui;

import javax.swing.JPanel;
import java.awt.*;

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
}
