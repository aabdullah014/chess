package com.chess.chessgame.ui;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.chess.chessgame.model.Board;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class Table {

    private final JFrame tableJFrame;
    private final BoardPanel boardPanel;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(800,800);


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
                System.out.println("Exited game.");
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);

        return fileMenu;
    }
    
}
