import java.util.Scanner;
import java.util.InputMismatchException;
class DragonCave
{
    
    public static void main(String args[])
    {
        
        System.out.println("You are in a land full of dragons. In front of you, you see two caves. In one cave, the dragon is friendly and will share his treasure with you. The other dragonis greedy and hungry and will eat you on sight.");
		Scanner sc = new Scanner(System.in);
		int cave=0;
		
		while (cave !=1 && cave!=2){
			System.out.println("Which cave will you go into? (1 or 2)");
			
            try{    
				cave = sc.nextInt();
				
            } catch (InputMismatchException e) {
                sc.next();
            }
			
		}
			
		sc.close();
        if (cave == 1){
			System.out.println("You approach the cave...It is dark and spooky...A large dragon jumps out in front of you! He opens his jaws and...Gobbles you down in one bite!");
		}
		 
			
	}
}