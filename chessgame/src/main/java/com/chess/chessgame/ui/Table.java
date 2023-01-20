package com.chess.chessgame.ui;

import javax.swing.*;

import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

@Component
public class Table {

    private final JFrame tableJFrame;
    private final BoardPanel boardPanel;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(800,800);
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 400);
    private final static Dimension TILE_PANEL_DIMENSION =  new Dimension(5,5);

    private final Color lightColor = Color.decode("#FFFACD");
    private final Color darkColor =  Color.decode("#593E1A");

    public Table() {
        this.tableJFrame = new JFrame("Chess");
        this.tableJFrame.setLayout(new BorderLayout());
        final JMenuBar tableMenuBar = new JMenuBar();
        populateMenuBar(tableMenuBar);

        this.tableJFrame.setJMenuBar(tableMenuBar);
        this.tableJFrame.setSize(OUTER_FRAME_DIMENSION);

        this.boardPanel = new BoardPanel();
        this.tableJFrame.add(this.boardPanel, BorderLayout.CENTER);

        this.tableJFrame.setVisible(true);
    }

    private void populateMenuBar(JMenuBar tableMenuBar){
        tableMenuBar.add(createFileMenu());
    }

    private JMenu createFileMenu() {
        // creates file menu at top
        final JMenu fileMenu = new JMenu("File");

        final JMenuItem openPGN = new JMenuItem("Load PGN File");
        openPGN.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("open pgn file");
            }
        });
        fileMenu.add(openPGN);

        final JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        return fileMenu;
    }

    private class BoardPanel extends JPanel {

        final ArrayList<TilePanel> boardTiles;

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

    private class TilePanel extends JPanel {

        private final int tileId;

        TilePanel(BoardPanel boardPanel, int tileId) {
            super(new GridBagLayout());
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
    
}
