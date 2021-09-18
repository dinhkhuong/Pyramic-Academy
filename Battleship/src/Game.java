public class Game {
    Board sea = new Board();
    SeaShip one = new SeaShip();
    SeaShip two = new SeaShip();
    Prompt ask = new Prompt();
    public void play() {
        ask.askName(one);
        ask.askName(two);
        ask.printBoard(sea);
        ask.setCoor(sea,one);
        ask.setCoor(sea,two);
        ask.printShip(sea);
    }

}
