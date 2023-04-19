package sk.stuba.fei.uim.oop.board;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Tile[][] board;
    private Map map;

    public Board(int dimension){
        this.initializeBoard(dimension);
        this.map = new Map(dimension);
    }


    private void initializeBoard(int dimension) {
        this.board = new Tile[dimension][dimension];
        this.setLayout(new GridLayout(dimension, dimension));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.board[i][j] = new Tile();
                if (i == 2 && j == 2){
                    this.board[i][j].setType(Type.PIPE);
                    this.board[i][j].getType().setDirections(Direction.WEST,Direction.NORTH);
                    this.board[i][j].setPlayable(true);
                }
                if (i == 1 && j == 1){
                    this.board[i][j].setType(Type.END);
                    this.board[i][j].getType().setDirections(Direction.WEST,Direction.WEST);
                    this.board[i][j].setPlayable(true);
                }
                this.add(this.board[i][j]);
            }
        }
    }
}
