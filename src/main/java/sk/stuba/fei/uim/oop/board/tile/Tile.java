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


    public Tile() {
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY);
        this.type = Type.EMPTY;
    }
    public void paintComponent(Graphics g) {
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
        if (this.getGraphics().getColor() == Color.BLACK){
            this.getGraphics().setColor(Color.BLUE);
        }
        else
            this.getGraphics().setColor(Color.BLACK);
    }
}
