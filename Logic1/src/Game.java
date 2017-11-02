import java.util.*;

public class Game {

    private List<Integer> board = new ArrayList<>();
    int adjacent;
    int nettle;

    public Game(){};

    public Game(int nettle, int[][] map, int size){
        nettle = nettle;
        for(int i = 0; i<size;i++){
            for(int j = 0;j<size;j++){
                board.add(map[i][j]);
            }
        }
    }

    public int getAdjacent(int location){
        adjacent = board.get(location);
        return adjacent;
    }

    public boolean won(int uncovered){
        if(uncovered == nettle){
            return true;
        }
        else{
            return false;
        }
    }
}
