import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Game {
    static Human hu = new Human();
    static Goblin gob = new Goblin();
    public static char[][] drawGrid(){
        Random rand = new Random();
        char[][] gridGameWorld = new char[10][10];
        /*
        for(int i = 0; i<gridGameWorld.length;i++){
            for(int j = 0; j< gridGameWorld[i].length; j++){
                gridGameWorld[i][j]= '*';
            }
        }
        */
        for(int i = 0; i<gridGameWorld.length;i++){
            for(int j = 0; j< gridGameWorld[i].length; j++){
                //gridGameWorld[rand.nextInt(9)+1][rand.nextInt(9)+1]=new Land().getLand();
                gridGameWorld[i][j] = new Land().getLand();
            }
        }
        gridGameWorld[rand.nextInt(9)+1][rand.nextInt(9)+1]= hu.getPlayer();
        gridGameWorld[rand.nextInt(9)+1][rand.nextInt(9)+1]= gob.getPlayer();

        for(char[] row:gridGameWorld){
            for(char c:row){
                System.out.print(c+"  ");
            }
            System.out.println();
        }
        return gridGameWorld;
    }
    public static void dislayBoard(char[][] grid){
        for (int row=0; row<grid.length ;row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col]+"  ");
            }
            System.out.println();
        }

    }
    public static void waitTime()throws  InterruptedException {

    }

    public static void gmove(char[][] gr)throws InterruptedException{
        int rd = new Random().nextInt(4);
        switch (rd) {
            case 0:
                moveUp(gr,gob.getPlayer() );
                break;
            case 1:
                moveDown(gr,gob.getPlayer() );
                break;
            case 2:
                moveRight(gr,gob.getPlayer() );
                break;
            case 3:
                moveLeft(gr,gob.getPlayer() );
                break;
            case 4:
                break;
        }
    }



    public static void printMessage(String message) throws InterruptedException {
        System.out.println(message);
    }
    public static void intructions() throws InterruptedException, ClassNotFoundException {}
    public static void fill(){}
    public static void moveUp(char[][] grid, char player)throws InterruptedException{
        int row = 0;
        int col = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == player){
                    try{
                        row = i;
                        col = j;
                    }catch (Exception e){
                        printMessage("You must move within the bounds of the grid. Remember the Goblin is trying to find you.");
                    }
                }
            }
        }
        grid[row][col] = new Land().getLand();
        grid[--row][col] = player;
        dislayBoard(grid);
    }
    public static void moveDown(char[][] grid, char player)throws InterruptedException{
        int row = 0;
        int col = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == player){
                    try{
                        row = i;
                        col = j;
                    }catch (Exception e){
                        printMessage("You must move within the bounds of the grid. Remember the Goblin is trying to find you.");
                    }
                }
            }
        }
        grid[row][col] = new Land().getLand();
        grid[++row][col] = player;
        dislayBoard(grid);
    }

    public static void moveLeft(char[][] grid, char player)throws InterruptedException{
        int row = 0;
        int col = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == player){
                    try{
                        row = i;
                        col = j;
                    }catch (Exception e){
                        printMessage("You must move within the bounds of the grid. Remember the Goblin is trying to find you.");
                    }
                }
            }
        }
        grid[row][col] = new Land().getLand();
        grid[row][--col] = player;
        dislayBoard(grid);
    }
    public static void moveRight(char[][] grid, char player)throws InterruptedException{
        int row = 0;
        int col = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == player){
                    try{
                        row = i;
                        col = j;
                    }catch (Exception e){
                        printMessage("You must move within the bounds of the grid. Remember the Goblin is trying to find you.");
                    }
                }
            }
        }
        grid[row][col] = new Land().getLand();;
        grid[row][++col] = player;
        dislayBoard(grid);
    }
    public static void main(String[] args)throws InterruptedException, ClassNotFoundException{
        char[][] gridGameBoard = drawGrid();
        Scanner scan = new Scanner(System.in);
        while (true) {
        String move = scan.nextLine();

            switch (move) {
                case "U":
                case "u":
                    moveUp(gridGameBoard, hu.getPlayer());
                    break;
                case "D":
                case "d":
                    moveDown(gridGameBoard, hu.getPlayer());
                    break;
                case "L":
                case "l":
                    moveLeft(gridGameBoard, hu.getPlayer());
                    break;
                case "R":
                case "r":
                    moveRight(gridGameBoard, hu.getPlayer());
                    break;
                case "S":
                case "s":
                    break;
                default:
                    printMessage("Invalid moves cases you to lose that move");
            }
            gmove(gridGameBoard);
        }
    }
}
/*


public class Game {
    static public Land land;
    static HashMap<Integer,GameObject> board = new HashMap<>() {{
        put(0, land);
        put(1, land);
        put(2, land);
        put(3, land);
        put(4, land);
        put(5, land);
        put(6, land);
        put(7, land);
        put(8, land);
    }};
    static void printBoard()
    {
        System.out.println("|------------------------------|");
        //try {
            System.out.println("|  " + board.get(6) + "  |  " + board.get(7) + "  |  " + board.get(8) + "  |");
        //} catch (NullPointerException e){}
        System.out.println("|------------------------------|");
        System.out.println("|  " + board.get(3) + "  |  "+ board.get(4) + "  |  " + board.get(5)+ "  |");
        System.out.println("|------------------------------|");
        System.out.println("|  " + board.get(0) + "  |  "+ board.get(1) + "  |  " + board.get(2)+ "  |");
        System.out.println("|------------------------------|");
    }
    static void game(){
        printBoard();
    }
    public static void main(String[] args){
        game();
    }
}
*/