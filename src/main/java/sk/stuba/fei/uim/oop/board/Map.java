package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

import java.util.Objects;
import java.util.Random;

public class Map {

    @Getter
    private Type[][] map;
    private Position begin;
    private Position end;
    private Random rand;

    public Map(int dimension) {
        this.rand = new Random();
        this.begin = new Position();
        this.end = new Position();
        this.initializeEmptyMap(dimension);
        //this.createMap(dimension);
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
        this.map[this.begin.getX()][this.begin.getY()].setPos(this.begin);

        this.end.setX(rand.nextInt(dimension));
        this.end.setY(rand.nextInt(dimension));
        this.map[this.end.getX()][this.end.getY()] = Type.END;
        this.map[this.end.getX()][this.end.getY()].setDirections(Direction.NORTH,Direction.NORTH);
        this.map[this.end.getX()][this.end.getY()].setPos(this.end);
    }

    private void createMap(int dimension){
        randomizedDFS(this.map[this.begin.getX()][this.begin.getY()],dimension);
    }

    private void randomizedDFS(Type current,int dimension){
        current.setOccupied(true);
        Position randPos = findRandomNeighbour(current.getPos().getX(),current.getPos().getY(),dimension);
        Type next = this.map[randPos.getX()][randPos.getY()];
        if (!next.isOccupied()){

            randomizedDFS(next,dimension);
        }
        else{
            if (Objects.equals(next,this.map[this.end.getX()][this.end.getY()])){
                return;
            }
            randomizedDFS(next,dimension);
        }

        //return;
    }

    private Position findRandomNeighbour(int x,int y,int dimension){
        Position result = new Position();
        result.setY(y);
        result.setX(x);
        while(true) {
            if (rand.nextBoolean()) {
                if (result.getX() == 0) {
                    if (rand.nextBoolean()) {
                        result.setX(result.getX() + 1);
                        break;
                    }

                } else if (result.getX() == dimension - 1) {
                    if (rand.nextBoolean()) {
                        result.setX(result.getX() - 1);
                        break;
                    }

                } else {
                    if (rand.nextBoolean()) {
                        result.setX(result.getX() + 1);
                    }
                    else {
                        result.setX(result.getX() - 1);
                    }
                    break;
                }
            } else {
                if (result.getY() == 0) {
                    if (rand.nextBoolean()) {
                        result.setY(result.getY() + 1);
                        break;
                    }

                } else if (result.getY() == dimension - 1) {
                    if (rand.nextBoolean()) {
                        result.setY(result.getY() - 1);
                        break;
                    }

                } else {
                    if (rand.nextBoolean()) {
                        result.setY(result.getY() + 1);
                    }
                    else {
                        result.setY(result.getY() - 1);
                    }
                    break;
                }
            }
        }

        return result;
    }

}
