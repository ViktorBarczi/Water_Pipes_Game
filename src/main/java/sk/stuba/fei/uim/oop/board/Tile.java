package sk.stuba.fei.uim.oop.board;

import lombok.*;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Tile extends JPanel {
    @Setter
    private boolean highlight;
    @Getter @Setter
    private Direction in;
    @Getter @Setter
    private Direction out;
    @Getter
    private Direction[] directions;
    @Getter @Setter
    private Type type;
    @Getter @Setter
    private int numberOfCaptures;
    @Getter @Setter
    private boolean playable;
    @Getter @Setter
    private boolean straight;

    public Tile() {
        this.numberOfCaptures = 0;
        //this.state = State.EMPTY;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setBackground(Color.LIGHT_GRAY);
        this.directions = new Direction[2];
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.playable) {
            g.setColor(Color.RED);
            g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
            this.directions[0].draw(this,g);
            this.directions[1].draw(this,g);
            //this.in.draw(this,g);
            //this.out.draw(this,g);
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

    public void setColor(){
        if (this.getGraphics().getColor() == Color.RED){
            this.getGraphics().setColor(Color.BLUE);
        }
        else
            this.getGraphics().setColor(Color.RED);
    }

    public void setDirections(Direction x,Direction y){
        this.directions[0] = x;
        this.directions[1] = y;
    }




}

/*if (this.form == Type.STRAIGHT && (Objects.equals(this.form.getDirection(),Direction.NORTH) || Objects.equals(form.getDirection(),Direction.SOUTH))) {
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/2,this.getWidth()/3,this.getHeight());
            }
            else if (this.form == Type.STRAIGHT && (Objects.equals(this.form.getDirection(),Direction.EAST) || Objects.equals(form.getDirection(),Direction.WEST))) {
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
            }
            else if (this.form == Type.RIGHT && Objects.equals(this.form.getDirection(),Direction.NORTH)) {
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
            }
            else if (this.form == Type.RIGHT && Objects.equals(this.form.getDirection(),Direction.SOUTH)) {
                g.fillRect(this.getWidth()/3,this.getHeight()/2,this.getWidth()/3,this.getHeight());
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
            }
            else if (this.form == Type.RIGHT && Objects.equals(this.form.getDirection(),Direction.EAST)) {
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
            }
            else if (this.form == Type.RIGHT && Objects.equals(this.form.getDirection(),Direction.WEST)) {
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/2,this.getWidth()/3,this.getHeight());
            }
            else if (this.form == Type.LEFT && Objects.equals(this.form.getDirection(),Direction.NORTH)) {
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
            }
            else if (this.form == Type.LEFT && Objects.equals(this.form.getDirection(),Direction.SOUTH)) {
                g.fillRect(this.getWidth()/3,this.getHeight()/2,this.getWidth()/3,this.getHeight());
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
            }
            else if (this.form == Type.LEFT && Objects.equals(this.form.getDirection(),Direction.EAST)) {
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth(),this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/2,this.getWidth()/3,this.getHeight());
            }
            else if (this.form == Type.LEFT && Objects.equals(this.form.getDirection(),Direction.WEST)) {
                g.fillRect(0,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,this.getHeight()/3,this.getWidth()/3,this.getHeight()/3);
                g.fillRect(this.getWidth()/3,0,this.getWidth()/3,this.getHeight()/3);
            }*/