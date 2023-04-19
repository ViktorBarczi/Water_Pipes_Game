package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

public class Map {

    @Getter
    private Type[][] map;

    public Map(int dimension) {
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
    }

}
