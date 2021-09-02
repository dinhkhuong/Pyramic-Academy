import java.util.Scanner;
import java.util.InputMismatchException;
class GuessTheNumber
{
    
    public static void main(String args[])
    {
		String name = null;
		int guess = 0;
		int num = 1 + (int)(Math.random() * 10);
		int numOfG= 0;
		String more = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello! What is your name?");
		
		name = sc.nextLine();
		
		System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20. Take a guess.");
		while ( guess != num){
			try {
				guess = sc.nextInt();
			} catch (InputMismatchException e) {
                sc.next();
            }
			numOfG++;
			if (guess > num){
				System.out.println("Your guess is too high. Take a guess.");
				
			}if (guess < num){
				System.out.println("Your guess is too low. Take a guess.");
					
			}if (guess == num) {
				System.out.println("Good job, " +name +"! You guessed my number in "+numOfG+" guesses! Would you like to play again? (y or n)");
				more = sc.nextLine();
				//sc.next();
				sc.reset();
				if (more == "n"){
					break;
				}if (more == "y"){
					
					guess = 0;
					numOfG = 0;
					num = 1 + (int)(Math.random() * 10);
				}
				
			}	
		}	
		sc.close();
        	
	}
}