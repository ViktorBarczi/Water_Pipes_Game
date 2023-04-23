package sk.stuba.fei.uim.oop.board;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Position {
    private int x;
    private int y;

    @Setter
    @Getter
    private boolean occupied;
    @Setter @Getter
    private Type type;
    @Setter @Getter
    private Direction in;
    @Setter @Getter
    private Direction out;

    public Position(int a,int b, Type t){
        this.x = a;
        this.y = b;
        this.occupied = false;
        this.type = t;
    }
}
