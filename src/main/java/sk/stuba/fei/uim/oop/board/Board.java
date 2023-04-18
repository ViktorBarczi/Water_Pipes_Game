package sk.stuba.fei.uim.oop.board;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Tile[][] board;

    public Board(int dimension){
        this.initializeBoard(dimension);
    }


    private void initializeBoard(int dimension) {
        this.board = new Tile[dimension][dimension];
        this.setLayout(new GridLayout(dimension, dimension));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.board[i][j] = new Tile();
                this.board[i][j].setType(Type.EMPTY);
                if (i == 1 && j == 1){
                    this.board[i][j].setType(Type.STRAIGHT);
                    this.board[i][j].setPlayable(true);
                }
                this.add(this.board[i][j]);
            }
        }
    }
}
