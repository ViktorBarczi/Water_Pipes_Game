package sk.stuba.fei.uim.oop.board.tile;

import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.Type;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import java.awt.*;

public class Pipe extends Tile {
    public Pipe(){
        super();
        this.type = Type.PIPE;
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
        g.setColor(Color.BLACK);
        g.fillRect(this.getWidth() / 3, this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 3);

        this.type.getDirections()[0].drawPipe(this, g);
        this.type.getDirections()[1].drawPipe(this, g);
    }

}
