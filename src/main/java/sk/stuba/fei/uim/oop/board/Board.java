package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import sk.stuba.fei.uim.oop.board.tile.Begin;
import sk.stuba.fei.uim.oop.board.tile.End;
import sk.stuba.fei.uim.oop.board.tile.Pipe;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {
    @Getter
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
                if (this.map.getMap()[i][j].getType() == Type.EMPTY)
                    this.board[i][j] = new Tile();
                else if (this.map.getMap()[i][j].getType() == Type.PIPE)
                    this.board[i][j] = new Pipe();
                else if (this.map.getMap()[i][j].getType() == Type.BEGIN)
                    this.board[i][j] = new Begin();
                else if (this.map.getMap()[i][j].getType() == Type.END)
                    this.board[i][j] = new End();

                this.board[i][j].setType(this.map.getMap()[i][j].getType());
                this.board[i][j].setIn(this.map.getMap()[i][j].getIn());
                this.board[i][j].setOut(this.map.getMap()[i][j].getOut());
                this.board[i][j].setOccupied(this.map.getMap()[i][j].isOccupied());

                this.add(this.board[i][j]);
            }
        }
        this.initializeMap(dimension);
    }
    private void initializeMap(int dimension){
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                this.board[i][j].setType(this.map.getMap()[i][j].getType());
                if(this.map.getMap()[i][j].getType() != Type.EMPTY){
                    this.board[i][j].setPlayable(true);
                }
            }
        }
    }
}
