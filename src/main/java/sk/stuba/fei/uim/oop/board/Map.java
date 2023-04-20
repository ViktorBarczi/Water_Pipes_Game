package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

import java.util.Objects;
import java.util.Random;

public class Map {

    @Getter
    private Position[][] map;
    private Position begin;
    private Position end;
    private Random rand;

    public Map(int dimension) {
        this.rand = new Random();
        this.begin = new Position();
        this.end = new Position();
        this.initializeEmptyMap(dimension);
        this.createMap(dimension);
    }
    private void initializeEmptyMap(int dimension){
        this.map = new Position[dimension][dimension];
        for (int i=0;i<dimension;i++){
            for(int j = 0;j<dimension;j++){
                this.map[i][j] = new Position();
                this.map[i][j].setType(Type.PIPE);
                this.map[i][j].setX(i);
                this.map[i][j].setY(j);
            }
        }
        this.begin.setX(rand.nextInt(dimension));
        this.begin.setY(rand.nextInt(dimension));
        this.map[this.begin.getX()][this.begin.getY()].setType(Type.BEGIN);
        this.map[this.begin.getX()][this.begin.getY()].setIn(null);
        this.map[this.begin.getX()][this.begin.getY()].setOut(null);
        //this.map[this.begin.getX()][this.begin.getY()].setPos(this.begin);
        this.map[this.begin.getX()][this.begin.getY()].setOccupied(true);

        this.end.setX(rand.nextInt(dimension));
        this.end.setY(rand.nextInt(dimension));
        this.map[this.end.getX()][this.end.getY()].setType(Type.END);
        this.map[this.end.getX()][this.end.getY()].setOut(null);
        this.map[this.end.getX()][this.end.getY()].setIn(null);
        //this.map[this.end.getX()][this.end.getY()].setPos(this.end);
        this.map[this.end.getX()][this.end.getY()].setOccupied(true);
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

            randomizedDFS(next,dimension,count);
        }
        else{
            if (Objects.equals(next,this.map[this.end.getX()][this.end.getY()])){
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
                return;
            }
            count++;
            randomizedDFS(current,dimension,count);
        }

        //return;
    }//Kedvenc baratnom a Kitti

    private Position findRandomNeighbour(Position current,int dimension){
        Position result = new Position();
        result.setY(current.getY());
        result.setX(current.getX());
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
