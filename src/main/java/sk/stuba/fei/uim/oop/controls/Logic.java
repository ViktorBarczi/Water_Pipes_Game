package sk.stuba.fei.uim.oop.controls;

import lombok.*;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.Tile;
import sk.stuba.fei.uim.oop.board.Type;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;

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
    private Component previous;

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
        this.previous = null;
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
        if (Objects.equals(current,this.previous)) {
            if (((Tile) current).isPlayable()) {
                System.out.println("test");
                ((Tile) current).setHighlight(true);
            }
        }
        else{
            if (this.previous != null)
                ((Tile) this.previous).setHighlight(false);
        }
        this.board.repaint();

        MouseEvent previousLocation = e;
        this.previous = this.board.getComponentAt(previousLocation.getX(), e.getY());
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.gameRestart();
        this.main.revalidate();
        this.main.repaint();
        this.main.setFocusable(true);
        this.main.requestFocus();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Component current = this.board.getComponentAt(e.getX(), e.getY());
        if (!(current instanceof Tile)) {
            return;
        }
        Direction[] directions = Direction.values();
        if (((Tile) current).isPlayable()) {
            for (int i = 0; i < directions.length; i++) {
                if (((Tile) current).getForm().getDirection() == directions[i]){
                    ((Tile) current).getForm().setDirection(i == directions.length - 1 ? directions[0] : directions[i + 1]);
                }
            }
        }
        this.board.repaint();
    }

}
