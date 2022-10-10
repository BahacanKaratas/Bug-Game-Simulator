public class DoodleBug extends  Organism{
    public DoodleBug(){
        super();
        this.symbol="X";
        this.timeForBreeding=8;
    }
    public int move(){
        return rand.nextInt(20);
    }
}
