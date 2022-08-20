public abstract class Karlsson extends Human{
    public abstract void remember();
    private Propeller propeller = new Propeller();

    private class Propeller{
        private boolean isSpinning = false;
        public void spin(){
            if (isSpinning){
                System.out.println("Пропеллер перестаёт крутиться.");
                isSpinning = false;
            } else {
                System.out.println("Пропеллер начинает крутиться!");
                isSpinning = true;
            }
        }
    }

    public void fly() throws FlyException{
        if (propeller.isSpinning){
            propeller.spin();
            System.out.println("Карлсон заканчивает полёт.");
        } else if (getMood()==Mood.GOOD){
            propeller.spin();
            System.out.println("Карлсон начинает полёт!");
        } else {
            throw new FlyException();
        }
    }
}
