package com.chess.chessgame.ui;

import java.util.ArrayList;

import javax.swing.JPanel;
import java.awt.*;

public class BoardPanel extends JPanel {

    final ArrayList<TilePanel> boardTiles;
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 400);

    BoardPanel() {
        // make 8x8 layout
        super(new GridLayout(8,8));
        this.boardTiles = new ArrayList<>();

        for(int i = 0; i< 64; i++) {
            final TilePanel tp = new TilePanel(this, i);
            this.boardTiles.add(tp);
            add(tp);
        }
        setPreferredSize(BOARD_PANEL_DIMENSION);
        validate();
    }

}
