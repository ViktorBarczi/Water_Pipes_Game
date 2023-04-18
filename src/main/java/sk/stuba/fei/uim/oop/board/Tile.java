package sk.stuba.fei.uim.oop.board;

import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Tile extends JPanel {
    @Setter
    private boolean highlight;
    @Getter @Setter
    private Type form;
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
        if (form != Type.EMPTY) {
            this.playable = true;
            g.setColor(Color.RED);
            if (this.form == Type.STRAIGHT && Objects.equals(form.getDirection(),Direction.NORTH) || Objects.equals(form.getDirection(),Direction.SOUTH)) {
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/2);
                g.fillRect(this.getWidth()/3,this.getHeight()/2,this.getWidth()/3,this.getHeight());
            }
            else if (this.form == Type.RIGHT && Objects.equals(form.getDirection(),Direction.NORTH)) {
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
            }
            else if (this.form == Type.RIGHT && Objects.equals(form.getDirection(),Direction.SOUTH)) {
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
            }
           // else if ()
            if (this.highlight){
                this.setBackground(Color.GRAY);
                //this.highlight = false;
            }
            else{
                this.setBackground(Color.LIGHT_GRAY);
            }
        }

    }


}
