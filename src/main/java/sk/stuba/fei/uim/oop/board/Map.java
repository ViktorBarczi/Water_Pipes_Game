package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

import java.util.Random;

public class Map {

    @Getter
    private Type[][] map;
    private Coord begin;
    private Coord end;
    private Random rand;

    public Map(int dimension) {
        this.rand = new Random();
        this.begin = new Coord();
        this.end = new Coord();
        this.initializeEmptyMap(dimension);
        //System.out.println(" ");
    }
    private void initializeEmptyMap(int dimension){
        this.map = new Type[dimension][dimension];
        for (int i=0;i<dimension;i++){
            for(int j = 0;j<dimension;j++){
                this.map[i][j] = Type.EMPTY;
            }
        }
        this.begin.setX(rand.nextInt(dimension));
        this.begin.setY(rand.nextInt(dimension));
        this.map[this.begin.getX()][this.begin.getY()] = Type.BEGIN;
        this.map[this.begin.getX()][this.begin.getY()].setDirections(Direction.NORTH,Direction.NORTH);

        this.end.setX(rand.nextInt(dimension));
        this.end.setY(rand.nextInt(dimension));
        this.map[this.end.getX()][this.end.getY()] = Type.END;
        this.map[this.end.getX()][this.end.getY()].setDirections(Direction.NORTH,Direction.NORTH);
    }

    private void createMap(){

    }

}
