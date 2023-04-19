package sk.stuba.fei.uim.oop.controls;

import lombok.*;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.Tile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class Logic extends Adapter {
    public static final int INITIAL_SIZE = 8;
    private JFrame main;
    private int boardSize;
    private Direction[] directions = Direction.values();
    private Board board;
    private int level;
    @Setter @Getter
    private JLabel levelLabel;
    @Setter @Getter
    private JLabel boardSizeLabel;
    private Component previous;

    public Logic(JFrame game) {
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

    private void restart() {
        this.main.remove(this.board);
        this.initializeNewBoard(this.boardSize);
        this.main.add(this.board);
        //this.updateNameLabel();
    }

    private void rotate(Tile t) {
        for (int i = 0; i < t.getType().getDirections().length; i++) {
            for (int j = 0; j < this.directions.length; j++) {
                if (t.getType().getDirections()[i] == this.directions[j]){
                    int dIndex = j+1;
                    if (dIndex == this.directions.length)
                        dIndex = 0;
                    t.getType().getDirections()[i] = this.directions[dIndex];
                    break;
                }
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.boardSize = ((JSlider) e.getSource()).getValue();
        this.updateBoardSizeLabel();
        this.restart();
        this.main.revalidate();
        this.main.repaint();
        this.main.setFocusable(true);
        this.main.requestFocus();
    }


    @Override
    public void mouseMoved(MouseEvent e) {
        Component current = this.board.getComponentAt(e.getX(), e.getY());
        if (!(current instanceof Tile)) {
            return;
        }
        if (Objects.equals(current, this.previous)) {
            //System.out.println("test");
            ((Tile) current).setHighlight(true);

        } else {
            if (this.previous != null)
                ((Tile) this.previous).setHighlight(false);
        }
        this.board.repaint();

        MouseEvent previousLocation = e;
        this.previous = this.board.getComponentAt(previousLocation.getX(), e.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.restart();
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
        if (((Tile) current).isPlayable()) {
            rotate(((Tile) current));
        }
        this.board.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e);
        switch (e.getKeyCode()) {
            case KeyEvent.VK_R:
                this.restart();
                this.main.revalidate();
                this.main.repaint();
                this.main.setFocusable(true);
                this.main.requestFocus();
                break;
            case KeyEvent.VK_ESCAPE:
                this.main.dispose();
        }
    }


}
