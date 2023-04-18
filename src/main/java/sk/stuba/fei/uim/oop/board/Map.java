package sk.stuba.fei.uim.oop.board;

public class Map {

    private Type[][] map;

    public Map(int dimension) {
        this.map = new Type[dimension][dimension];
        for (int i=0;i<dimension;i++){
            for(int j = 0;j<dimension;j++){
                this.map[i][j] = Type.EMPTY;
            }
        }
        System.out.println(" ");
    }


}
