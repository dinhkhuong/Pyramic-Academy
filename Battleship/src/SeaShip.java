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
    public int getY(){
        return y;
    }
    public void setY(int afd){
        y = afd;
    }
    public boolean getVertHor(){
        return vertHor;
    }
    public void setVertHor(String yn){
        switch (yn){
            case "yes":
            case "y":
            case "YES":
            case "v":
            case "V":
                vertHor = true;
                break;
            case "no":
            case "n":
            case "NO":
            case "h":
            case "H":
                vertHor = false;
                break;
        }

    }

    private boolean verify=false;
    public boolean getVerify(){
        return verify;
    }
    public void setVerify(boolean b){
        verify = b;
    }


}
