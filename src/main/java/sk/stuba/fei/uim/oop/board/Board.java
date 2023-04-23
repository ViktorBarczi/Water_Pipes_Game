package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import sk.stuba.fei.uim.oop.board.tile.Begin;
import sk.stuba.fei.uim.oop.board.tile.Pipe;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Board extends JPanel {
    @Getter
    private Tile[][] board;
    private Map map;
    private int boardSize;
    private Tile begin;
    private Tile end;
    private boolean out;
    private Tile current;

    public Board(int dimension){
        this.boardSize = dimension;
        this.map = new Map(dimension);
        this.board = new Tile[dimension][dimension];
        this.initializeBoard(dimension);
    }


    private void initializeBoard(int dimension) {
        this.setLayout(new GridLayout(dimension, dimension));
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (Objects.equals(this.map.getMap()[i][j].getType(),Type.EMPTY))
                    this.board[i][j] = new Tile(i,j,Color.BLACK);
                else if (Objects.equals(this.map.getMap()[i][j].getType(),Type.PIPE))
                    this.board[i][j] = new Pipe(i,j,Color.BLACK);
                else if (Objects.equals(this.map.getMap()[i][j].getType(),Type.BEGIN))
                    this.board[i][j] = new Begin(i,j,new Color(0,150,0));
                else if (Objects.equals(this.map.getMap()[i][j].getType(),Type.END))
                    this.board[i][j] = new Begin(i,j,Color.RED);

                this.board[i][j].setType(this.map.getMap()[i][j].getType());
                this.board[i][j].setIn(this.map.getMap()[i][j].getIn());
                this.board[i][j].setOut(this.map.getMap()[i][j].getOut());
                this.board[i][j].setOccupied(this.map.getMap()[i][j].isOccupied());

                this.add(this.board[i][j]);
            }
        }
        this.begin = this.board[this.map.getBegin().getX()][this.map.getBegin().getY()];
        this.end = this.board[this.map.getEnd().getX()][this.map.getEnd().getY()];
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

    public boolean checkForWin() {
        current = this.begin;
        out = true;
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                if (!this.board[i][j].getColor().equals(new Color(0, 150, 0)) && this.board[i][j].getColor() != Color.RED) {
                    this.board[i][j].setGood(false);
                    this.board[i][j].setColor(Color.BLACK);
                }
            }
        }
        while (true) {
            if (Objects.equals(current,this.end)) {
                return true;
            }
            if (out) {
                if (Objects.equals(current.getOut(),Direction.NORTH) && current.getXX() - 1 >= 0) {
                    if (check(current.getXX() - 1,current.getYY(),Direction.SOUTH)){
                        continue;
                    }
                    break;
                } else if (Objects.equals(current.getOut(),Direction.SOUTH) && current.getXX() + 1 < this.boardSize) {
                    if (check(current.getXX() + 1,current.getYY(),Direction.NORTH)){
                        continue;
                    }
                    break;
                } else if (Objects.equals(current.getOut(),Direction.WEST) && current.getYY() - 1 >= 0) {
                    if (check(current.getXX(),current.getYY()-1,Direction.EAST)){
                        continue;
                    }
                    break;
                } else if (Objects.equals(current.getOut(),Direction.EAST) && current.getYY() + 1 < this.boardSize) {
                    if (check(current.getXX(),current.getYY()+1,Direction.WEST)){
                        continue;
                    }
                    break;
                } else
                    break;
            } else {
                if (Objects.equals(current.getIn(),Direction.NORTH) && current.getXX() - 1 >= 0) {
                    if (check(current.getXX() - 1,current.getYY(),Direction.SOUTH)){
                        continue;
                    }
                    break;
                } else if (Objects.equals(current.getIn(),Direction.SOUTH) && current.getXX() + 1 < this.boardSize) {
                    if (check(current.getXX() + 1,current.getYY(),Direction.NORTH)){
                        continue;
                    }
                    break;
                } else if (Objects.equals(current.getIn(),Direction.WEST) && current.getYY() - 1 >= 0) {
                    if (check(current.getXX(),current.getYY()-1,Direction.EAST)){
                        continue;
                    }
                    break;
                } else if (Objects.equals(current.getIn(),Direction.EAST) && current.getYY() + 1 < this.boardSize) {
                    if (check(current.getXX(),current.getYY()+1,Direction.WEST)){
                        continue;
                    }
                    break;
                } else
                    break;
            }
        }
        return false;
    }

    private boolean check(int x,int y,Direction dir){
        if (Objects.equals(this.board[x][y].getIn(),dir)) {
            this.out = true;
            current = this.board[x][y];
            current.setGood(true);
            current.changeColor();
            return true;
        } else if (Objects.equals(this.board[x][y].getOut(),dir)) {
            this.out = false;
            current = this.board[x][y];
            current.setGood(true);
            current.changeColor();
            return true;
        }
        else
            return false;
    }
}
