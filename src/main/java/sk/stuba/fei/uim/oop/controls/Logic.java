package sk.stuba.fei.uim.oop.controls;

import lombok.*;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.board.Tile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Logic extends Adapter{
    public static final int INITIAL_SIZE = 8;
    JFrame main;
    private int boardSize;
    private Board board;
    private int level;
    @Setter @Getter
    private JLabel levelLabel;
    @Setter @Getter
    private JLabel boardSizeLabel;

    public Logic (JFrame game){
        this.main = game;
        this.boardSize = INITIAL_SIZE;
        this.initializeNewBoard(this.boardSize);
        this.main.add(this.board);
        this.level = 1;
        this.boardSizeLabel = new JLabel();
        this.levelLabel = new JLabel();
        this.updateBoardSizeLabel();
        this.updateLevelLabel();
    }
    private void initializeNewBoard(int dimension) {
        this.board = new Board(dimension);
        this.board.addMouseMotionListener(this);
        this.board.addMouseListener(this);
    }

    private void updateLevelLabel() {
        this.levelLabel.setText("LEVEL: " + this.level);
        this.main.revalidate();
        this.main.repaint();
    }

    private void updateBoardSizeLabel() {
        this.boardSizeLabel.setText("BOARD SIZE: " + this.boardSize);
        this.main.revalidate();
        this.main.repaint();
    }

    private void gameRestart() {
        this.main.remove(this.board);
        this.initializeNewBoard(this.boardSize);
        this.main.add(this.board);
        //this.updateNameLabel();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Component current = this.board.getComponentAt(e.getX(), e.getY());
        if (!(current instanceof Tile)) {
            return;
        }
        if (((Tile) current).isPlayable()) {
            ((Tile) current).setHighlight(true);
        }
        this.board.repaint();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameRestart();
        this.main.revalidate();
        this.main.repaint();
        this.main.setFocusable(true);
        this.main.requestFocus();
    }

}
