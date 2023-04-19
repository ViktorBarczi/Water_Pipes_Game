package sk.stuba.fei.uim.oop.board;

import javax.swing.*;
import java.awt.*;

public enum Direction {
    SOUTH,
    WEST,
    NORTH,
    EAST;

    public Graphics draw(Tile f, Graphics g){
        if (this == SOUTH){
            g.fillRect(f.getWidth()/3,f.getHeight()/2,f.getWidth()/3,f.getHeight());
        }
        else if (this == WEST){
            g.fillRect(0,f.getHeight()/3,f.getWidth()/3,f.getHeight()/3);
        }
        else if (this == NORTH){
            g.fillRect(f.getWidth()/3,0,f.getWidth()/3,f.getHeight()/3);
        }
        else if (this == EAST){
            g.fillRect(f.getWidth()/3,f.getHeight()/3,f.getWidth(),f.getHeight()/3);
        }
        return g;
    }

}
