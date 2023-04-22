package sk.stuba.fei.uim.oop.board.tile;

import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.Type;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import java.awt.*;

public class End extends Tile {
    public End(int a,int b){
        super(a,b);
        this.color = Color.RED;
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
        g.setColor(this.color);
        g.fillOval(this.getWidth()/4,this.getWidth()/4,this.getWidth()/2,this.getHeight()/2);
        if (this.in != null){
            this.in.drawPipe(this,g);
        }
        if (this.out != null){
            this.out.drawPipe(this,g);
        }
    }

}
