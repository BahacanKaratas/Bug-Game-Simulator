import java.util.Random;
public class Organism{
    Random rand = new Random();
    int moved;
    int timeForBreeding; //At what point the Organism breeds
    int  lastBreed;
    int round;
    String symbol;
    public Organism(){
        lastBreed=0;
        moved=0;
        round=0;
    }
    public int move(){
        return rand.nextInt(20);
    }
}
