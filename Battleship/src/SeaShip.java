import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class SeaShip extends Ship {
    private String playerName;
    private int x,y;
    private boolean vertHor;
    private boolean sink=false;
    private int noOfHit=0;
    public boolean getSink(){
        return sink;
    }
    //private HashSet<Integer[]> hit = new HashSet<Integer[]>();
    private Point[] hitPoint = new Point[5];
    public void setHit(int a, int b, boolean verHor){
        if(verHor) {
            for (int i = 0; i < hitPoint.length; i++) {
                hitPoint[i] = new Point(a + i, b);
            }
        }else {
            for (int i = 0; i < hitPoint.length; i++) {
                hitPoint[i] = new Point(a, b+i);
            }
        }
    }
    public boolean getHit(int a, int b){
        for(int i=0;i<hitPoint.length;i++){
            //if((int)hitPoint[i].getX()==a && (int)hitPoint[i].getY()==b){
            if (hitPoint[i].equals(new Point(a,b))){
                hitPoint[i].setLocation(0,0);
                noOfHit++;
                if(noOfHit==hitPoint.length)sink=true;
                return true;
            }

        }

        return false;
    }
    //private ArrayList<Integer> noHit = new ArrayList<Integer>();
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
