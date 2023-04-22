package sk.stuba.fei.uim.oop.board.tile;

import sk.stuba.fei.uim.oop.board.Direction;
import sk.stuba.fei.uim.oop.board.Type;
import sk.stuba.fei.uim.oop.board.tile.Tile;

import java.awt.*;

public class Pipe extends Tile {
    public Pipe(int a,int b){
        super(a,b);
        this.color = Color.BLACK;
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
        if (this.occupied)
            g.fillRect(this.getWidth() / 3, this.getHeight() / 3, this.getWidth() / 3, this.getHeight() / 3);

        if (this.in != null){
            this.in.drawPipe(this,g);
        }
        if (this.out != null){
            this.out.drawPipe(this,g);
        }
    }

}
