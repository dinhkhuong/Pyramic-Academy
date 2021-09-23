// A simple program to demonstrate
// Tic-Tac-Toe Game.
import java.util.*;

class TicTacToe {

    static String[] board;
    static String turn;
    static ArrayList<Integer> left = new ArrayList<Integer>();
    static HashMap<String,String>choice = new HashMap<String,String>();

    // CheckWinner method will
    // decide the combination
    // of three box given below.
    static String checkWinner()
    {
        for (int a = 0; a < 8; a++) {
            String line = null;

            switch (a) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }

            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            else if (a == 8) {
                return "draw";
            }
        }

        // To enter the X Or O at the exact place on board.


        return null;
    }

    static void printBoard()
    {
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println("-----------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
    }
    /*aiPlay will scan which move is available
    and play pick one of them*/
    static int aiPlay(){
        left.clear();
        for (int b = 0;b<9;b++){
            try {
                if ((b+1) == (Integer.parseInt(board[b]))) {
                    left.add(b);
                }
            } catch (NumberFormatException e) {
            }
        }
        //ai move is set to random
        Collections.shuffle(left);
        return left.get(0);
    }
    public static void game(){
        Scanner in = new Scanner(System.in);
        board = new String[9];

        String winner = null;

        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }

        System.out.println("Welcome to 3x3 Tic Tac Toe.");
        printBoard();
        while (true) {
            System.out.println("Do you want to be X or O?");
            String input = in.nextLine();
            //System.out.println(input);
            if (input.equals("X")) {
                choice.put("player", input);
                choice.put("ai", "O");
                break;
            } else if (input.equals("O")) {
                choice.put("player", input);
                choice.put("ai", "X");
                break;
            }
        }
        System.out.println("The computer will go first.");
        turn = choice.get("ai");
        //System.out.println(choice.get("player")+choice.get("ai"));
        while (winner == null) {
            System.out.println();
            int numInput;
            if (turn.equals(choice.get("ai"))){

                board[aiPlay()]=turn;
                printBoard();
                winner = checkWinner();

                turn =choice.get("player");
            }else {
                System.out.println("What is your next move? (1-9)");
                // Exception handling.
                // numInput will take input from user like from 1 to 9.
                // If it is not in range from 1 to 9.
                // then it will show you an error "Invalid input."
                try {
                    numInput = in.nextInt();
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println(
                                "Invalid input; re-enter slot number:");
                        continue;
                    }
                } catch (InputMismatchException e) {
                    System.out.println(
                            "Invalid input; re-enter slot number:");
                    continue;
                }

                // This game has two player x and O.
                // Here is the logic to decide the turn.
                if (board[numInput - 1].equals(
                        String.valueOf(numInput))) {
                    board[numInput - 1] = turn;

                    if (turn.equals(choice.get("player"))) {
                        turn = choice.get("ai");

                    } else {
                        turn = choice.get("player");
                    }

                    printBoard();
                    winner = checkWinner();
                } else {
                    System.out.println(
                            "Slot already taken; re-enter slot number:");
                }
            }
        }

        // If no one win or lose from both player x and O.
        // then here is the logic to print "draw".
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println(
                    "It's a draw! Thanks for playing.");
        }else if (winner.equals( choice.get("ai"))){
            System.out.println("The computer has beaten you! You lose.");
        }

        // For winner -to display Congratulations! message.
        else {
            System.out.println(
                    "Congratulations! You have won! Thanks for playing.");
        }
    }
    public static void main(String[] args)
    {
        try (Scanner x = new Scanner(System.in)){
            game();
            while (true) {
                System.out.println("Do you want to play again? (yes or no)");
                String again = x.next();
                if (again.equals("yes")) {
                    game();
                }else{
                    break;
                }
            }

        }
    }
}
