
import java.util.InputMismatchException;
import java.util.Scanner;

public class Prompt {
    private Scanner scan = new Scanner(System.in);
    public void askName(SeaShip wa){
        System.out.println("Enter Player 1 name:");
        String name = scan.nextLine();
        wa.setPlayerName(name);
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
    public void setCoor(Board bo, SeaShip ship)throws InputMismatchException {
        System.out.println("Enter the coordinates for the battleship of "+ ship.getPlayerName());

        ship.setX(scan.nextInt());
        //System.out.println(ship.getX());
        ship.setY(scan.nextInt());
        //System.out.println(ship.getY());
        //System.out.println("Place horizontally or vertically (h or v)? ");
        //ship.setVertHor(scan.next());
        //System.out.println(ship.getVertHor());
        while (!ship.getVerify()){
            System.out.println("carrier is already located there, enter another location: ");
            System.out.println("Place horizontally or vertically (h or v)? ");
            ship.setVertHor(scan.next());
            bo.setShip(ship);
        }
    }

}
