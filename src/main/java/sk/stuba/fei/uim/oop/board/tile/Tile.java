package sk.stuba.fei.uim.oop.board.tile;

import lombok.*;
import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.Type;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Tile extends JPanel {
    @Setter
    protected boolean highlight;
    @Getter @Setter
    protected Type type;
    @Getter @Setter
    protected boolean playable;
    @Setter @Getter
    protected Direction in;
    @Setter @Getter
    protected Direction out;
    @Setter @Getter
    protected boolean occupied;
    protected Graphics graphics;
    @Setter @Getter
    protected Color color;
    @Setter
    protected boolean good;
    @Setter @Getter
    protected int xX;
    @Setter @Getter
    protected int yY;



    public Tile(int a, int b) {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY);
        this.type = Type.EMPTY;
        this.good = false;
        this.xX = a;
        this.yY = b;
    }
    public void paintComponent(Graphics g) {
        this.graphics = g;
        super.paintComponent(g);
        if (this.playable) {
            this.drawPipe(g);
        }
        if (this.highlight){
            this.setBackground(Color.GRAY);
        }
        else{
            this.setBackground(Color.LIGHT_GRAY);
        }

    }

    public void drawPipe(Graphics g){

    }

    public void changeColor(){
        if (this.color == Color.BLACK && this.good){
            this.color = (Color.BLUE);
        }
        else if (this.color == (Color.BLUE) && !this.good)
            this.color = (Color.BLACK);
    }
}
