package sk.stuba.fei.uim.oop.board;

import lombok.*;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    //@Getter @Setter
    //private State state;
    @Setter
    private boolean highlight;
    @Getter
    @Setter
    private boolean playable;
    @Getter @Setter
    private int numberOfCaptures;

    public Tile() {
        this.numberOfCaptures = 0;
        //this.state = State.EMPTY;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.LIGHT_GRAY);
    }

}
