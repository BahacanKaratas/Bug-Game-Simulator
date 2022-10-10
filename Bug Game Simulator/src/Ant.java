public class Ant extends Organism{
    public Ant(){
        super();
        this.symbol="o";
        this.timeForBreeding=3;
    }
    public int move(){
        return rand.nextInt(20);
    }
}
