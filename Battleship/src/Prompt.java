
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
}
