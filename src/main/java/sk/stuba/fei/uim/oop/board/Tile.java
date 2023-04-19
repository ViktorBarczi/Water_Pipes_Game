package sk.stuba.fei.uim.oop.board;

import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Tile extends JPanel {
    @Setter
    private boolean highlight;
    @Getter @Setter
    private Type type;
    @Getter @Setter
    private boolean playable;

    public Tile() {
        //this.state = State.EMPTY;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.playable) {
            if (Objects.equals(this.type,Type.PIPE)) {
                g.setColor(Color.BLACK);
                g.fillRect(this.getWidth() / 3, this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 3);
                this.type.getDirections()[0].drawPipe(this, g);
                this.type.getDirections()[1].drawPipe(this, g);
            }
            if (Objects.equals(this.type,Type.BEGIN)){
                g.setColor(Color.GREEN);
                g.fillOval(this.getWidth()/4,this.getWidth()/4,this.getWidth()/2,this.getHeight()/2);
                this.type.getDirections()[0].drawPipe(this, g);
                this.type.getDirections()[1].drawPipe(this, g);
            }
            if (Objects.equals(this.type,Type.END)){
                g.setColor(Color.RED);
                g.fillOval(this.getWidth()/4,this.getWidth()/4,this.getWidth()/2,this.getHeight()/2);
                this.type.getDirections()[0].drawPipe(this, g);
                this.type.getDirections()[1].drawPipe(this, g);
            }
        }
        if (this.highlight){
            this.setBackground(Color.GRAY);
        }
        else{
            this.setBackground(Color.LIGHT_GRAY);
        }

    }

    public void changeColor(){
        if (this.getGraphics().getColor() == Color.BLACK){
            this.getGraphics().setColor(Color.BLUE);
        }
        else
            this.getGraphics().setColor(Color.BLACK);
    }
}
