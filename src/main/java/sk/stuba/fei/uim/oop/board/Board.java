package sk.stuba.fei.uim.oop.board;

import sk.stuba.fei.uim.oop.board.tile.Begin;
import sk.stuba.fei.uim.oop.board.tile.End;
import sk.stuba.fei.uim.oop.board.tile.Pipe;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    private Tile[][] board;
    private Map map;

    public Board(int dimension){
        this.map = new Map(dimension);
        this.initializeBoard(dimension);
    }


    private void initializeBoard(int dimension) {
        this.board = new Tile[dimension][dimension];
        this.setLayout(new GridLayout(dimension, dimension));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (this.map.getMap()[i][j] == Type.EMPTY)
                    this.board[i][j] = new Tile();
                else if (this.map.getMap()[i][j] == Type.PIPE)
                    this.board[i][j] = new Pipe();
                else if (this.map.getMap()[i][j] == Type.BEGIN)
                    this.board[i][j] = new Begin();
                else if (this.map.getMap()[i][j] == Type.END)
                    this.board[i][j] = new End();

                this.board[i][j].setType(this.map.getMap()[i][j]);

                this.add(this.board[i][j]);
            }
        }
        this.initializeMap(dimension);
        return;
    }
    private void initializeMap(int dimension){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.board[i][j].setType(this.map.getMap()[i][j]);
                if(this.map.getMap()[i][j] != Type.EMPTY){
                    this.board[i][j].setPlayable(true);
                }
            }
        }
    }
}
