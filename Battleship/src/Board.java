public class Board {
    private int length = 10;
    public int getLength(){
        return length;
    }
    private char grid[][] = new char[length][length];

    public Board(){

        for (int i = 0; i<10;i++){
            grid[0][i] = Character.forDigit(i,10);
        }
        for (int j = 0; j<10; j++){
            grid[j][0] = Character.forDigit(j,10);
        }
        for (int i = 1; i<10;i++){
            for (int j = 1; j<10; j++){
                grid[i][j]='~';
            }
        }
        grid [0][0]= ' ';
    }
    public void setElement(int a, int b,boolean ch){
        grid[a][b] = ch ? 'x':'m';
    }
    public char getElement(int a, int b){
        return grid[a][b];
    }
}
