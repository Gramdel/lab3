import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Karlsson karlsson = new Karlsson() {
            @Override
            public void hasTreat(Treat treat) {
                if(getTreat().equals(treat)){
                    System.out.println("У Карлсона на ладони лежит сладость "+treat.getName()+".");
                } else {
                    System.out.println("У Карлсона на ладони нет сладости "+treat.getName()+".");
                }
            }
            @Override
            public void longSulk() {
                System.out.println("Карлсон не умеет долго дуться.");
            }
            @Override
            public void remember() {
                if (getCurTemp() < getPrevTemp()) {
                    System.out.println("Карлсон вспомнил о том, что у него упала температура.");
                }
            }
        };

        Kid kid = new Kid() {
            @Override
            public void longSulk() {
                System.out.println("Малыш не умеет долго дуться.");
            }
            @Override
            public void changeMood(Human human) {
                class Thermometr{
                    private double temp1,temp2;
                    public Thermometr(){
                        temp1 = human.getPrevTemp();
                        temp2 = human.getCurTemp();
                    }
                }
                Thermometr thermometr = new Thermometr();

                if (getMood() == Mood.BAD && thermometr.temp2 < thermometr.temp1) {
                    setMood(Mood.GOOD);
                    System.out.println("Малыш рад тому, что у Карлсона упала температура.");
                }
            }
            @Override
            public void admire() {
                Trait description[] = { Trait.CANDIED, Trait.TEMPTING, Trait.APPETIZING, Trait.AMAZING };
                if (Arrays.equals(description, getTreat().getDescription())) {
                    System.out.println("Малыш любуется сладостью " + getTreat().getName() + ".");
                }
            }
            @Override
            public void hasTreat(Treat treat) {
                if(getTreat().equals(treat)){
                    System.out.println("У Малыша на ладони лежит сладость "+treat.getName()+".");
                } else {
                    System.out.println("У Малыша на ладони нет сладости "+treat.getName()+".");
                }
            }
        };

        kid.longSulk();

        karlsson.setCurTemp(36.6);
        karlsson.setPrevTemp(37.0);
        kid.setMood(Mood.BAD);
        kid.changeMood(karlsson);
        karlsson.remember();

        Treat.Nut nut = new Treat.Nut();
        Trait description[] = { Trait.CANDIED, Trait.TEMPTING, Trait.APPETIZING, Trait.AMAZING };
        nut.setDescription(description);
        kid.setTreat(nut);
        if (nut.isEaten()){
            System.out.println("Малыш съел "+nut.getName()+".");
        } else {
            System.out.println("Малыш ещё не съел "+nut.getName()+".");
        }

        kid.hasTreat(nut);
        kid.admire();
        kid.eat();

        try {
            karlsson.fly();
        } catch(FlyException e) {
            e.printStackTrace();
        }
        kid.setTreat(null);
        kid.eat();
    }
}
