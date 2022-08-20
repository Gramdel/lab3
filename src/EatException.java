public class EatException extends RuntimeException {
    public EatException(){
        super("Невозможно съесть пустое место!");
    }
    public EatException(String s){
        super(s);
    }
}
