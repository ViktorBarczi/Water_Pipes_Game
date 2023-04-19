package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;

public enum Type {
    BEGIN,
    END,
    PIPE,
    EMPTY;

    @Setter @Getter
    private boolean occupied;
    @Setter @Getter
    private Position pos;

    private Direction[] directions;

    Type(){
        this.directions = new Direction[2];
    }

    public void setDirections(Direction x,Direction y){
        this.directions[0] = x;
        this.directions[1] = y;
    }

    public Direction[] getDirections(){
        return this.directions;
    }
}
