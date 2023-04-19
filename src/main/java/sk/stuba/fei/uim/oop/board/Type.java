package sk.stuba.fei.uim.oop.board;


import sk.stuba.fei.uim.oop.board.tile.Tile;

public enum Type {
    BEGIN,
    END,
    PIPE,
    EMPTY;

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
