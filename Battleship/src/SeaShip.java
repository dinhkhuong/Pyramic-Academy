import java.util.ArrayList;

public class SeaShip extends Ship {
    private String playerName;
    private int x,y;
    private boolean vertHor;
    private ArrayList<Integer> noHit = new ArrayList<Integer>();
    public String getPlayerName(){
        return playerName;
    }
    public void setPlayerName(String nm){
        playerName = nm;
    }
    public int getX(){
        return x;
    }
    public void setX(int afd){
        x = afd;
    }
    public int gety(){
        return y;
    }
    public void setY(int afd){
        y = afd;
    }
    public boolean getVertHor(){
        return vertHor;
    }
    public void setVertHor(boolean ah){
        vertHor = ah;
    }

}
