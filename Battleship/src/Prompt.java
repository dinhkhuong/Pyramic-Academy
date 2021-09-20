
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {
    private Scanner scan = new Scanner(System.in);
    public void askName(SeaShip first, SeaShip second){
        System.out.println("Enter Player 1 name:");
        String name = scan.nextLine();
        first.setPlayerName(name);
        System.out.println("Enter Player 2 name:");
        name = scan.nextLine();
        second.setPlayerName(name);
    }
    public void printBoard(Board bo){
        for(int i =0;i<bo.getLength();i++){
            for (int j=0; j<bo.getLength();j++){
                System.out.print(bo.getElement(i,j)+ " ");
            }
            System.out.println();
        }
    }
    public void printShip(Board bo){
        for(int i =0;i<bo.getLength();i++){
            for (int j=0; j<bo.getLength();j++){
                System.out.print(bo.getShip(i,j)+ " ");
            }
            System.out.println();
        }
    }
    //ask for ship coordition
    public void askCoor(Board bo, SeaShip ship) {
        while (!ship.getVerify()){
            System.out.println("Enter the coordinates for the battleship of "+ ship.getPlayerName());
            ship.setX(scan.nextInt());
            ship.setY(scan.nextInt());
            System.out.println("Place horizontally or vertically (h or v)? ");
            ship.setVertHor(scan.next());
            bo.setShip(ship);
            if (!ship.getVerify()){
                System.out.println("carrier is already located there, enter another location: ");

            }
        }
    }
    public void printGame(Board bo, SeaShip mine,SeaShip enemy){
        System.out.println(mine.getPlayerName()+" enter the coordinates for an attack: ");
        int x = scan.nextInt();
        int y = scan.nextInt();
        bo.fire(x,y);
        printBoard(bo);
        if(enemy.getHit(x,y)){
            System.out.println("got it");
        }
    }
}
