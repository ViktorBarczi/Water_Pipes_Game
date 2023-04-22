package sk.stuba.fei.uim.oop.controls;

import lombok.*;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Objects;
import java.util.Random;

public class Logic extends Adapter {
    public static final int INITIAL_SIZE = 8;
    private JFrame main;
    private int boardSize;
    private Direction[] directions = Direction.values();
    @Getter
    private Board board;
    private int level;
    @Setter @Getter
    private JLabel levelLabel;
    @Setter @Getter
    private JLabel boardSizeLabel;
    private Component previous;
    private Random rand;
    private JButton buttonRestart;

    public Logic(JFrame game, JButton bR) {
        this.main = game;
        this.buttonRestart = bR;
        this.rand = new Random();
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
        this.shuffle();
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
        this.main.revalidate();
        this.main.repaint();
        this.main.setFocusable(true);
        this.main.requestFocus();
    }

    private void victory(){
        this.level++;
        this.updateLevelLabel();
        this.restart();
    }

    private void rotate(Tile t) {
        boolean in = false;
        boolean out = false;
        for (int j = 0; j < this.directions.length; j++) {
            if (t.getIn() == this.directions[j] && !in){
                in = true;
                int dIndex = j+1;
                if (dIndex == this.directions.length)
                    dIndex = 0;
                t.setIn(this.directions[dIndex]);
            }
            if (t.getOut() == this.directions[j] && !out){
                out = true;
                int dIndex = j+1;
                if (dIndex == this.directions.length)
                    dIndex = 0;
                t.setOut(this.directions[dIndex]);
            }
        }
    }

    private void shuffle(){
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                int pom = this.rand.nextInt(4);
                for (int k = 0; k < pom; k++) {
                    this.rotate(this.board.getBoard()[i][j]);
                }
            }
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.boardSize = ((JSlider) e.getSource()).getValue();
        this.updateBoardSizeLabel();
        this.level = 1;
        this.updateLevelLabel();
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
            ((Tile) current).setHighlight(true);

        } else {
            if (this.previous != null)
                ((Tile) this.previous).setHighlight(false);
        }
        this.board.repaint();

        this.previous = this.board.getComponentAt(e.getX(), e.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.buttonRestart) {
            this.level = 1;
            this.updateLevelLabel();
            this.restart();
        }
        else {
            this.board.repaint();
            if(this.board.checkForWin()){
                this.victory();
                return;
            }
            this.board.repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
                this.level = 1;
                this.updateLevelLabel();
                this.restart();
                break;
            case KeyEvent.VK_ESCAPE:
                this.main.dispose();
            case KeyEvent.VK_ENTER:
                this.board.repaint();
                if(this.board.checkForWin()){
                    this.victory();
                    return;
                }
                this.board.repaint();
        }
    }


}
