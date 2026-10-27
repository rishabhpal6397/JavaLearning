import java.util.List;
import java.util.Arrays;

public class ObjCls3{
    public static void main(String[] args) {
        List<Animal> animals = Arrays.asList(
            new Dog(),
            new Cat()
        );

        for (Animal anim : animals){
            System.out.println(anim.sound());
        }
    }
}

abstract class Animal{
    abstract String sound();
}

class Dog extends  Animal{
    @Override 
    String sound(){ return "Woof"; }
}

class Cat extends Animal{
    @Override 
    String sound(){ return "Meow"; }
}