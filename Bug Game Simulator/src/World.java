import java.util.Random;
public class World {
    Organism[][] theBoard=new Organism[20][20];
    Random rand = new Random();
    public World(){
        //5 doodle bugs randomly placed
        for(int i=0;i<5;i++){
            int row=rand.nextInt(20);
            int column=rand.nextInt(20);
            while(theBoard[row][column]!=null){
                row=rand.nextInt(20);
                column=rand.nextInt(20);
            }
            DoodleBug doodleBugObj=new DoodleBug();
            theBoard[row][column]=doodleBugObj;
        }
        //100 ants are placed
        for(int i=0;i<100;i++){
            int row=rand.nextInt(20);
            int column=rand.nextInt(20);
            while(theBoard[row][column]!=null){
                row=rand.nextInt(20);
                column=rand.nextInt(20);
            }
            Ant antObj=new Ant();
            theBoard[row][column]=antObj;
        }
    }
    public void moveAllOrganisms(){
        for(int i=0;i<theBoard.length;i++){
            for(int y=0;y<theBoard[0].length;y++){
                if(theBoard[i][y]!=null && theBoard[i][y].moved==0){
                   if(theBoard[i][y].symbol.equals("o")){
                       theBoard[i][y].lastBreed++;
                       //first move ants
                       int endAlready=0;
                       while(true){
                           if(endAlready==4){
                               break;
                           }
                           endAlready++;
                           int coordinate=theBoard[i][y].move();
                           if(coordinate>=0 && coordinate<=5){
                               //up
                               if(i!=0){
                                   if(theBoard[i-1][y]==null){
                                       theBoard[i][y].moved=1;
                                       theBoard[i-1][y]=theBoard[i][y];
                                       theBoard[i][y]=null;
                                       break;
                                   }
                               }
                               continue;
                           }
                           if(coordinate>5 && coordinate<=10){
                               //down
                               if(i!=19){
                                   if(theBoard[i+1][y]==null){
                                       theBoard[i][y].moved=1;
                                       theBoard[i+1][y]=theBoard[i][y];
                                       theBoard[i][y]=null;
                                       break;
                                   }
                                   continue;
                               }
                           }
                           if(coordinate>10 && coordinate<=15){
                               //left
                               if(y!=0){
                                   if(theBoard[i][y-1]==null){
                                       theBoard[i][y].moved=1;
                                       theBoard[i][y-1]=theBoard[i][y];
                                       theBoard[i][y]=null;
                                       break;
                                   }
                                   continue;
                               }
                           }
                           if(coordinate>15 && coordinate<20){
                               //right
                               if(y!=19){
                                   if(theBoard[i][y+1]==null){
                                       theBoard[i][y].moved=1;
                                       theBoard[i][y+1]=theBoard[i][y];
                                       theBoard[i][y]=null;
                                       break;
                                   }
                                   continue;
                               }
                           }
                       }
                   }
                }
            }
        }
        int ateAlready=0;
        for(int i=0;i<theBoard.length;i++) {
            for (int y = 0; y < theBoard[0].length; y++) {
                if (theBoard[i][y] != null && theBoard[i][y].moved == 0) {
                    if (theBoard[i][y].symbol.equals("X")){
                        theBoard[i][y].lastBreed++;
                        theBoard[i][y].round++;
                        if (i != 0 && theBoard[i - 1][y] != null && theBoard[i - 1][y].symbol.equals("o")) {
                            //up has ant
                            ateAlready++;
                            theBoard[i][y].moved = 1;
                            theBoard[i][y].round = 0;
                            theBoard[i - 1][y] = theBoard[i][y];
                            theBoard[i][y] = null;
                            continue;
                        } else {
                            //down has ant
                            if (i != 19 && theBoard[i + 1][y] != null && theBoard[i + 1][y].symbol.equals("o")) {
                                ateAlready++;
                                theBoard[i][y].moved = 1;
                                theBoard[i][y].round = 0;
                                theBoard[i + 1][y] = theBoard[i][y];
                                theBoard[i][y] = null;
                                continue;
                            } else {
                                if (y != 0 && theBoard[i][y - 1] != null && theBoard[i][y - 1].symbol.equals("o")) {
                                    ateAlready++;
                                    theBoard[i][y].moved = 1;
                                    theBoard[i][y].round = 0;
                                    theBoard[i][y - 1] = theBoard[i][y];
                                    theBoard[i][y] = null;
                                    continue;
                                } else {
                                    if (y != 19 && theBoard[i][y + 1] != null && theBoard[i][y + 1].symbol.equals("o")) {
                                        ateAlready++;
                                        theBoard[i][y].moved = 1;
                                        theBoard[i][y].round = 0;
                                        theBoard[i][y + 1] = theBoard[i][y];
                                        theBoard[i][y] = null;
                                        continue;
                                    }
                                }
                            }
                        }
                        if(ateAlready==0){
                            //if no adjent has ant , normal process occur
                            int endAlready=1;
                            while (true) {
                                if(endAlready==4){
                                    break;
                                }
                                endAlready++;
                                int coordinate = theBoard[i][y].move();
                                if (coordinate >= 0 && coordinate <= 5) {
                                    //up
                                    if (i != 0) {
                                        if (theBoard[i - 1][y] == null) {
                                            theBoard[i][y].moved = 1;
                                            theBoard[i - 1][y] = theBoard[i][y];
                                            theBoard[i][y] = null;
                                            break;
                                        }
                                    }
                                    continue;
                                }
                                if (coordinate > 5 && coordinate <= 10) {
                                    //down
                                    if (i != 19) {
                                        if (theBoard[i + 1][y] == null) {
                                            theBoard[i][y].moved = 1;
                                            theBoard[i + 1][y] = theBoard[i][y];
                                            theBoard[i][y] = null;
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                if (coordinate > 10 && coordinate <= 15) {
                                    //left
                                    if (y != 0) {
                                        if (theBoard[i][y - 1] == null) {
                                            theBoard[i][y].moved = 1;
                                            theBoard[i][y - 1] = theBoard[i][y];
                                            theBoard[i][y] = null;
                                            break;
                                        }
                                        continue;
                                    }
                                }
                                if (coordinate > 15 && coordinate < 20) {
                                    //right
                                    if (y != 19) {
                                        if (theBoard[i][y + 1] == null) {
                                            theBoard[i][y].moved = 1;
                                            theBoard[i][y + 1] = theBoard[i][y];
                                            theBoard[i][y] = null;
                                            break;
                                        }
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<theBoard.length;i++) {
            for (int y = 0; y < theBoard[0].length; y++) {
                if(theBoard[i][y]!=null){
                    theBoard[i][y].moved=0;
                }
            }
        }
    }
    public void breedAll(){
        for(int i=0;i<theBoard.length;i++){
            for(int y=0;y<theBoard[0].length;y++){
                if(theBoard[i][y]!=null){
                    if(theBoard[i][y].lastBreed==theBoard[i][y].timeForBreeding){
                        theBoard[i][y].lastBreed=0;
                        Organism obj;
                        if(theBoard[i][y].symbol.equals("o")){
                            obj=new Ant();
                        }
                        else{
                            obj=new DoodleBug();
                        }
                        int endAlready=1;
                        while(true){
                            if(endAlready==4){
                                break;
                            }
                            endAlready++;
                            int coordinate=theBoard[i][y].move();
                            if(coordinate>=0 && coordinate<=5){
                                //up
                                if(i!=0){
                                    if(theBoard[i-1][y]==null){
                                        theBoard[i-1][y]=obj;
                                        break;
                                    }
                                }
                                continue;
                            }
                            if(coordinate>5 && coordinate<=10){
                                //down
                                if(i!=19){
                                    if(theBoard[i+1][y]==null){
                                        theBoard[i+1][y]=obj;
                                        break;
                                    }
                                    continue;
                                }
                            }
                            if(coordinate>10 && coordinate<=15){
                                //left
                                if(y!=0){
                                    if(theBoard[i][y-1]==null){
                                        theBoard[i][y-1]=obj;
                                        break;
                                    }
                                    continue;
                                }
                            }
                            if(coordinate>15 && coordinate<20){
                                //right
                                if(y!=19){
                                    if(theBoard[i][y+1]==null){
                                        theBoard[i][y+1]=obj;
                                        break;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void starveAll(){
        for(int i=0;i<theBoard.length;i++){
            for(int y=0;y<theBoard.length;y++){
                if(theBoard[i][y]!=null){
                    if(theBoard[i][y].symbol.equals("X")){
                        if(theBoard[i][y].round==3){
                            theBoard[i][y]=null;
                        }
                    }
                }
            }
        }
    }
    public void printBoard(){
        int ant=0;
        int dod=0;
        for(int i=0;i<theBoard.length;i++){
            for(int y=0;y<theBoard.length;y++){
                if(theBoard[i][y]!=null){
                    System.out.print(theBoard[i][y].symbol+" ");
                    if(theBoard[i][y].symbol.equals("o")){
                        ant++;
                    }
                    else{
                        dod++;
                    }
                }
                else{
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
