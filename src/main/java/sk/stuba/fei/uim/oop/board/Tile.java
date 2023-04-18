package sk.stuba.fei.uim.oop.board;

import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Tile extends JPanel {
    @Setter
    private boolean highlight;
    @Getter @Setter
    private Type type;
    @Getter @Setter
    private int numberOfCaptures;
    @Getter @Setter
    private boolean playable;

    public Tile() {
        this.numberOfCaptures = 0;
        //this.state = State.EMPTY;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (type != Type.EMPTY) {
            this.playable = true;
            if (type == Type.STRAIGHT) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.RED);
                Line2D lin = new Line2D.Float(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
                g2.draw(lin);
            }
            if (this.highlight){
                this.setBackground(Color.GRAY);
                this.highlight = false;
            }
            else{
                this.setBackground(Color.LIGHT_GRAY);
            }
        }

    }


}
