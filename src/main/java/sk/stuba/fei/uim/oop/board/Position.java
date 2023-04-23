package sk.stuba.fei.uim.oop.board;

import lombok.Data;


@Data
public class Position {
    private int x;
    private int y;
    private boolean occupied;
    private Type type;
    private Direction in;
    private Direction out;

    public Position(int a,int b, Type t){
        this.x = a;
        this.y = b;
        this.occupied = false;
        this.type = t;
    }
}
