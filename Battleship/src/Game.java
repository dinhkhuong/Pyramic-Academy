public class Game {
    String winner;
    Board sea = new Board();
    SeaShip one = new SeaShip();
    SeaShip two = new SeaShip();
    Prompt ask = new Prompt();
    public void play() {
        ask.askName(one,two);
        ask.printBoard(sea);
        ask.askCoor(sea,one);
        ask.askCoor(sea,two);
        ask.printShip(sea);
        while (winner!= one.getPlayerName()&&winner!=two.getPlayerName()){
            winner = ask.printGame(sea,one,two)? one.getPlayerName() : null;
            if (winner!= one.getPlayerName()&&winner!=two.getPlayerName()) {
                winner = ask.printGame(sea,two,one)? two.getPlayerName(): null;
            }else{ //if(winner== one.getPlayerName()||winner==two.getPlayerName()) {
                break;
            }
        }
        System.out.println("Winner: "+winner);
    }

}
