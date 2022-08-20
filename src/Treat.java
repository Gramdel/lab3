import java.util.Arrays;

public abstract class Treat implements Eatable {
    private boolean exist;
    private Trait[] description;
    private String name;
    public void setDescription(Trait[] description){
        this.description = description;
    }
    public Trait[] getDescription(){
        return description;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setExist(boolean exist){
        this.exist = exist;
    }
    public boolean getExist(){
        return exist;
    }

    @Override
    public void beEaten() {
        if (getExist()) {
            setExist(false);
            System.out.println("Стоит положить в рот сладость, как её уже нет!");
        } else {
            System.out.println("Сладость уже съедена!");
        }
    }

    @Override
    public boolean isEaten() {
        return !getExist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Treat treat = (Treat) obj;
        return getExist() == treat.getExist() &&
                Arrays.equals(getDescription(), treat.getDescription()) &&
                getName().equals(treat.getName());
    }

    @Override
    public String toString() {
        return "[ exist = "+getExist()+", description = "+Arrays.toString(getDescription())+", name = "+getName()+" ]";
    }

    @Override
    public int hashCode() {
        return getDescription().hashCode()+getName().hashCode()+((Boolean)getExist()).hashCode();
    }

    public static class Nut extends Treat {
        public Nut() {
            setExist(true);
            setName("орех");
        }

        @Override
        public void beEaten() {
            if (getExist()) {
                setExist(false);
                System.out.println("Стоит положить в рот орех, как его уже нет!");
            } else {
                System.out.println("Орех уже съеден!");
            }
        }
    }
}
