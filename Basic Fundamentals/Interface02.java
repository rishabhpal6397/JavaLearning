interface Flyable{
    void fly();
}

interface Swimmable{
    void swim();

    default void rest(){
        System.out.println("Resting....");
    }
}

class Robot implements Flyable, Swimmable{
    @Override 
    public void fly(){
        System.out.println("Robo is Flying....");
    }

    @Override 
    public void swim(){
        System.out.println("Robo is Swimming....");
    }
}

public class Interface02{
    public static void main(String[] args) {
        Robot robo = new Robot();
        robo.fly();
        robo.swim();
    }
}