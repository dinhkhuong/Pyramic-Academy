import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

// We are going to create a Hangman Game with Java keywords :)
class HangmanGame {

    // Java Keywords
    public static final String[] WORDS = {
            "cat"
    };

    public static final Random RANDOM = new Random();
    // Max errors before user lose
    public static final int MAX_ERRORS = 8;
    // Word to find
    private String wordToFind;
    // Word found stored in a char array to show progression of user
    private char[] wordFound;
    private int dubErrors;
    // letters already entered by user
    private ArrayList < String > letters = new ArrayList < > ();
    private ArrayList < String > missed = new ArrayList < > ();



    // Method returning randomly next word to find
    private String nextWordToFind() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }

    // Method for starting a new game
    public void newGame() {
        dubErrors = 0;
        letters.clear();
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
        }
    }

    // Method returning the state of the word found by the user until by now
    private String wordFoundContent() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordFound.length; i++) {
            builder.append(wordFound[i]);

            if (i < wordFound.length - 1) {
                builder.append(" ");
            }
        }

        return builder.toString();
    }

    // Play method for our Hangman Game
    public void play() {
        try (Scanner input = new Scanner(System.in)) {
            // we play while dubErrors is lower than max errors or user has found the word
            while (dubErrors < MAX_ERRORS) {
                System.out.println("\nGuess a letter.\n");
                // get next input from user
                String str = input.next();

                // we keep just first letter
                if (str.length() > 1) {
                    str = str.substring(0, 1);
                }

                // update word found
                enter(str);

                // display current state
                System.out.println("\n" + wordFoundContent());
                System.out.println("\n Missed letters: " + missed);


                // check if word is found
                if (found()) {
                    System.out.println("\nYou win!");
                    break;
                } else {
                    // we display nb tries remaining for the user
                    System.out.println("\n=> Nb tries remaining : " + (MAX_ERRORS - dubErrors));
                }
            }

            if (dubErrors == MAX_ERRORS) {
                // user losed
                System.out.println("\nYou lose!");
                System.out.println("=> Word to find was : " + wordToFind);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("H A N G M A N");
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.newGame();
        hangmanGame.play();
    }

}