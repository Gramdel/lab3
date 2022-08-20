public abstract class Human implements CanEat, CanPossessTreats {
    private Treat treat;
    private Mood mood = (Math.random() <= 0.5) ? Mood.GOOD : Mood.BAD;
    private double curTemp;
    private double prevTemp;

    public void setCurTemp(double curTemp) {
        this.curTemp = curTemp;
    }
    public void setPrevTemp(double prevTemp) {
        this.prevTemp = prevTemp;
    }
    public double getCurTemp() {
        return curTemp;
    }
    public double getPrevTemp() {
        return prevTemp;
    }
    public void setMood(Mood mood) {
        this.mood = mood;
    }
    public Mood getMood() {
        return mood;
    }
    @Override
    public void eat() {
        if (treat == null) throw new EatException();
        treat.beEaten();
    }
    @Override
    public void hasTreat(Treat treat) {
        if(getTreat().equals(treat)){
            System.out.println("У человека на ладони лежит сладость "+treat.getName()+".");
        } else {
            System.out.println("У человека на ладони нет сладости "+treat.getName()+".");
        }
    }
    @Override
    public void setTreat(Treat treat){
        this.treat = treat;
    }
    @Override
    public Treat getTreat() {
        return treat;
    }
    @Override
    public void transferTreat(Human human) {
        human.setTreat(treat);
        treat = null;
    }
    public void longSulk() {
        System.out.println("Человек долго дуется.");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Human human = (Human) obj;
        return getTreat().equals(human.getTreat()) &&
                getMood() == human.getMood() &&
                getPrevTemp() == human.getPrevTemp() && getCurTemp() == human.getCurTemp();
    }

    @Override
    public String toString() {
        return "[ treat = "+getTreat()+", mood = "+getMood()+", curTemp = "+getCurTemp()+", prevTemp = "+getPrevTemp()+" ]";
    }

    @Override
    public int hashCode() {
        return getTreat().hashCode()+getMood().hashCode()+((Double)getCurTemp()).hashCode()+((Double)getPrevTemp()).hashCode();
    }
}
