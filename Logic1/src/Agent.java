import java.util.*;

public class Agent extends Game {
    private List<Integer> agentBoard = new ArrayList<>();
    private List<Integer> explored = new ArrayList<>();
    private List<Integer> frontier = new ArrayList<>();
    int boxValue;
    private int uncovered;
    private int currentLocation;
    boolean over;

    public Agent(){};

    public Agent(int size){
        uncovered = 0;
        agentBoard.add(0);
        for(int i = 1; i<size*size;i++){
            agentBoard.add(-2);
        }
        currentLocation = 0;
        over = false;
        explored.add(0);

    }

    public void getMap(int location){

    }

    public void flag(int location){
        agentBoard.add(location,-5);
    }

    public void play(){
        while(!over){
            boxValue = super.getAdjacent(currentLocation);
            if(boxValue == 0){
                //Make all adjacent 0 and update uncovered and add all of them as explored
            }
            else if(boxValue == -1){
                System.out.println("Game over");
                over = true;
            }
            else{
                agentBoard.add(currentLocation,boxValue);
                uncovered += 1;
            }
            over = super.won(uncovered);
        }

    }

    public void update(int location){
        //Pick a position from the frontier and search if it has 0
        currentLocation = location;
    }
}
