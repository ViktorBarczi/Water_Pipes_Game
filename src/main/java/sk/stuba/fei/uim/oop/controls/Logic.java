package sk.stuba.fei.uim.oop.controls;

import lombok.*;
import sk.stuba.fei.uim.oop.board.Board;

import javax.swing.*;

public class Logic extends Adapter{
    public static final int INITIAL_SIZE = 8;
    JFrame main;
    private int boardSize;
    private Board currentBoard;
    private int level;
    @Setter @Getter
    private JLabel levelLabel;
    @Setter @Getter
    private JLabel boardSizeLabel;

    public Logic (JFrame game){
        this.main = game;
        this.boardSize = INITIAL_SIZE;
        this.initializeNewBoard(this.boardSize);
        this.main.add(this.currentBoard);
        this.level = 1;
        this.boardSizeLabel = new JLabel();
        this.levelLabel = new JLabel();
        this.updateBoardSizeLabel();
        this.updateLevelLabel();
    }
    private void initializeNewBoard(int dimension) {
        this.currentBoard = new Board(dimension);
        this.currentBoard.addMouseMotionListener(this);
        this.currentBoard.addMouseListener(this);
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
}
