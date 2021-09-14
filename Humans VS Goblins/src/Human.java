public class Human {
    char human = '\u263A';
    public char getPlayer(){
        return human;
    }

    @Override
    public String toString(){
        return "Human{ "+human+"}";
    }
}
