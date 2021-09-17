public class Game {
    Board babo = new Board();
    SeaShip one = new SeaShip();
    SeaShip two = new SeaShip();
    Prompt ask = new Prompt();
    public void play() {
        ask.askName(one);
        ask.askName(two);
        ask.printBoard(babo);
    }

}
