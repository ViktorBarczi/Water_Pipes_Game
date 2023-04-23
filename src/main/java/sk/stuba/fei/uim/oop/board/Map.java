package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

import java.util.Objects;
import java.util.Random;

public class Map {

    @Getter
    private Position[][] map;
    @Getter
    private Position begin;
    @Getter
    private Position end;
    private Random rand;

    public Map(int dimension) {
        this.rand = new Random();
        this.begin = new Position(0,0,Type.BEGIN);
        this.end = new Position(0,0,Type.END);
        this.map = new Position[dimension][dimension];
        this.initializeEmptyMap(dimension);
        this.createMap(dimension);
    }
    private void initializeEmptyMap(int dimension){
        for (int i=0;i<dimension;i++){
            for(int j = 0;j<dimension;j++){
                this.map[i][j] = new Position(i,j,Type.PIPE);
            }
        }
        if(rand.nextBoolean()) {
            if (rand.nextBoolean()) {
                this.begin.setX(0);
            }
            else{
                this.begin.setX(dimension-1);
            }
            this.begin.setY(rand.nextInt(dimension));
        }
        else{
            if (rand.nextBoolean()) {
                this.begin.setY(0);
            }
            else{
                this.begin.setY(dimension-1);
            }
            this.begin.setX(rand.nextInt(dimension));
        }
        this.map[this.begin.getX()][this.begin.getY()].setType(Type.BEGIN);
        this.map[this.begin.getX()][this.begin.getY()].setIn(null);
        this.map[this.begin.getX()][this.begin.getY()].setOut(null);
        this.map[this.begin.getX()][this.begin.getY()].setOccupied(true);

        calibrateEndPosition(dimension);


        this.map[this.end.getX()][this.end.getY()].setType(Type.END);
        this.map[this.end.getX()][this.end.getY()].setOut(null);
        this.map[this.end.getX()][this.end.getY()].setIn(null);
        this.map[this.end.getX()][this.end.getY()].setOccupied(true);
    }

    private void calibrateEndPosition(int dimension) {
        if (this.begin.getX() == 0){
            this.end.setX(dimension -1);
            this.end.setY(rand.nextInt(dimension));
        }
        else if (this.begin.getX() == dimension -1){
            this.end.setX(0);
            this.end.setY(rand.nextInt(dimension));
        }
        if (this.begin.getY() == 0){
            this.end.setY(dimension -1);
            this.end.setX(rand.nextInt(dimension));
        }
        else if (this.begin.getY() == dimension -1){
            this.end.setY(0);
            this.end.setX(rand.nextInt(dimension));
        }
    }

    private void createMap(int dimension){
        randomizedDFS(this.map[this.begin.getX()][this.begin.getY()],dimension,0);
    }

    private void randomizedDFS(Position current,int dimension, int count){
        if(count == 8){
            initializeEmptyMap(dimension);
            createMap(dimension);
            return;
        }
        current.setOccupied(true);
        Position next = findRandomNeighbour(current,dimension);
        next = this.map[next.getX()][next.getY()];
        if (!next.isOccupied()){
            count = 0;
            direction(current, next);

            randomizedDFS(next,dimension,count);
        }
        else{
            if (Objects.equals(next,this.map[this.end.getX()][this.end.getY()])){
                direction(current, next);
                return;
            }
            count++;
            randomizedDFS(current,dimension,count);
        }
    }

    private void direction(Position current, Position next) {
        if (current.getY() > next.getY()){
            current.setOut(Direction.WEST);
            next.setIn(Direction.EAST);
        }
        else if (current.getY() < next.getY()){
            current.setOut(Direction.EAST);
            next.setIn(Direction.WEST);
        }
        else if (current.getX() < next.getX()){
            current.setOut(Direction.SOUTH);
            next.setIn(Direction.NORTH);
        }
        else if (current.getX() > next.getX()){
            current.setOut(Direction.NORTH);
            next.setIn(Direction.SOUTH);
        }
    }

    private Position findRandomNeighbour(Position current,int dimension){
        Position result = new Position(current.getX(),current.getY(),Type.PIPE);
        while(true) {
            if (this.rand.nextBoolean()) {
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
