import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class HangManFP {
    public static final String[] WORDS = {
            "cat"
    };

    public static final Random RANDOM = new Random();

    // Hangman figure in array

    private static BufferedReader reader;

    static {
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream("src\\figure.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String[] figure;

    static {
        figure = reader.lines().collect(Collectors.joining()).split(",");
    }

    /*private static final String[] figure = {"+---+\n\n    |\n\n    |\n\n    |\n\n    ===",
            "+---+\n\no   |\n\n    |\n\n    |\n\n    ===",
            "+---+\n\no   |\n\n|   |\n\n    |\n\n    ===",
            "+---+\n\no   |\n\n|   |\n\n|   |\n\n    ===",
            "+---+\n\no   |\n\n|   |\n\n|   |\n\n|   ==="};
*/
    // Word to find
    private String wordToFind;
    // Word found stored in a char array to show progression of user
    private char[] wordFound;
    private int dubErrors;
    // letters already entered by user
    private ArrayList < String > letters = new ArrayList < > ();
    private ArrayList < String > missed = new ArrayList < > ();

    public HangManFP() {
    }

    // Method returning randomly next word to find
    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    // Method for starting a new game
    public void newGame() {
        dubErrors = 0;
        letters.clear();
        missed.clear();
        wordToFind = nextWordToFind();

        // word found initialization
        wordFound = new char[wordToFind.length()];

        for (int i = 0; i < wordFound.length; i++) {
            wordFound[i] = '_';
        }
    }

    // Method returning true if word is found by user
    public boolean found() {
        return wordToFind.contentEquals(new String(wordFound));
    }

    // Method updating the word found after user entered a character
    private void enter(String c) {
        // we update only if c has not already been entered
        if (!letters.contains(c)) {
            // we check if word to find contains c
            if (wordToFind.contains(c)) {
                // if so, we replace _ by the character c
                int index = wordToFind.indexOf(c);

                while (index >= 0) {
                    wordFound[index] = c.charAt(0);
                    index = wordToFind.indexOf(c, index + 1);
                }
            } else {

                // c not in the word => error
                missed.add(c);
                dubErrors++;
            }
            // c is now a letter entered
            letters.add(c);
        }else{
            System.out.println("You have already guessed that letter. Choose again.\n");
        }
    }



    // Play method for our Hangman Game
    public void play(Scanner scan) {
        //try (Scanner input = new Scanner(System.in)) {
        // we play while dubErrors is lower than max errors or user has found the word
        while (dubErrors < figure.length) {
            // display current state

            Arrays.stream(figure[dubErrors].split("/")).forEach(System.out::println);
            System.out.println("\nMissed letters: " + missed);
            //System.out.println(wordFoundContent());
            Stream.of(wordFound).forEach(System.out::println);
            System.out.println("Guess a letter.\n");
            // get next input from user
            String str = scan.next();

            // we keep just first letter
            if (str.length() > 1) {
                str = str.substring(0, 1);
            }

            // update word found
            enter(str);

            // check if word is found
            if (found()) {
                //System.out.println("\nYes! The secret word is "+wordFoundContent()+"! You have won!");
                System.out.println("\nYes! The secret word is "+String.valueOf(wordFound)+"! You have won!");
                break;
            }
        }

        if (dubErrors == figure.length) {
            // user lost
            System.out.println("\nYou lose!");
            System.out.println("=> Word to find was : " + wordToFind);
        }



    }

    public static void main(String[] args)  {
        System.out.println("H A N G M A N");
        HangManFP hangmanGame = new HangManFP();
        hangmanGame.newGame();

        try (Scanner input = new Scanner(System.in)){
            hangmanGame.play(input);
            while (true) {
                System.out.println("Do you want to play again?");
                String again = input.next();
                if (again.equals("yes")) {
                    hangmanGame.newGame();
                    hangmanGame.play(input);
                }else{
                    break;
                }
            }

        }



    }
}
