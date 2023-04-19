package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

public enum Type {
    BEGIN,
    END,
    PIPE,
    EMPTY;

    @Getter
    private Direction[] directions;

    Type(){
        this.directions = new Direction[2];
    }

    public void setDirections(Direction x,Direction y){
        this.directions[0] = x;
        this.directions[1] = y;
    }
}
