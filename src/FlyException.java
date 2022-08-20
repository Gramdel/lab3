public class FlyException extends Exception {
    public FlyException(){
        super("Карлсон не может летать без настроения.");
    }
    public FlyException(String s){
        super(s);
    }
}
