public class Goblin {
    char goblin = '\u2649';
    public char getPlayer(){
        return goblin;
    }
    @Override
    public String toString(){
        return "Goblin{ "+goblin+"}";
    }
}
