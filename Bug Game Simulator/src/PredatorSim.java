import java.util.Scanner;

public class PredatorSim{
    public static void main(String[] args){
        World world=new World();
        System.out.println("First Board");
        world.printBoard();
        Scanner k=new Scanner(System.in);
        System.out.println("Press Enter");
        String word=k.nextLine();
        int count=1;
        while(word!=null){
            System.out.println("Round:"+count);
            world.moveAllOrganisms();
            world.starveAll();
            world.breedAll();
            world.printBoard();
            System.out.println();
            System.out.println("Press Enter");
            word=k.nextLine();
            count++;
            System.out.println();
        }
    }
}