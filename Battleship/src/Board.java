public class Board {
    private int length = 10;
    public int getLength(){
        return length;
    }

    //the board grid to show when the game is on going
    private char grid[][] = new char[length][length];
    //the board shipGrid to show to user and keep track of ship position
    private char shipGrid[][]= new char[length][length];

    public Board(){
        for (int i = 0; i<length;i++){
            grid[0][i] = Character.forDigit(i,10);
        }
        for (int j = 0; j<length; j++){
            grid[j][0] = Character.forDigit(j,10);
        }
        for (int i = 1; i<length;i++){
            for (int j = 1; j<length; j++){
                grid[i][j]='~';
            }
        }
        grid [0][0]= ' ';
        // fill the shipGrid the same as grid at the begining
        for (int i = 0; i<length;i++){
            shipGrid[0][i] = Character.forDigit(i,10);
        }
        for (int j = 0; j<length; j++){
            shipGrid[j][0] = Character.forDigit(j,10);
        }
        for (int i = 1; i<length;i++){
            for (int j = 1; j<10; j++){
                shipGrid[i][j]='~';
            }
        }
        shipGrid [0][0]= ' ';
    }
    public void fire(int a, int b)throws ArrayIndexOutOfBoundsException{
        grid[a][b] = (shipGrid[a][b] == 'c') ? 'x':'m';
    }
    public char getElement(int a, int b){
        return grid[a][b];
    }
    public char getShip(int a, int b){ return shipGrid[a][b];}
    public void setShip(SeaShip ship){
       if (ship.getVertHor()){
           for (int i=0; i<5;i++){
               if(ship.getX()+i<10) {
                   if(shipGrid[ship.getX() + i][ship.getY()] != 'c') {
                       ship.setVerify(true);
                   }else if (shipGrid[ship.getX() + i][ship.getY()] == 'c'){
                       ship.setVerify(false);
                       break;
                   }
               }
           }
           if (ship.getVerify()) {
               for (int i = 0; i < 5; i++) {
                   if (ship.getX() + i < 10) {
                       shipGrid[ship.getX() + i][ship.getY()] = 'c';
                   }
               }

           }
       }else if(!ship.getVertHor()) {
           for(int i=0; i<5; i++){
               if(ship.getY()+i<10) {
                   if(shipGrid[ship.getX()][ship.getY() + i] != 'c') {
                       ship.setVerify(true);
                   }else if (shipGrid[ship.getX()][ship.getY() + i] == 'c'){
                       ship.setVerify(false);
                       break;
                   }
               }
           }
           if(ship.getVerify()) {
               for (int i = 0; i < 5; i++) {
                   if (ship.getY() + i < 10) {
                       shipGrid[ship.getX()][ship.getY() + i] = 'c';
                   }
               }

           }
       }
       if(ship.getVerify()){
           ship.setHit(ship.getX(),ship.getY(),ship.getVertHor());
       }
    }

}
