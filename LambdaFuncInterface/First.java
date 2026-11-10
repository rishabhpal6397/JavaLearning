package LambdaFuncInterface;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.List;

public class First{
    public static void main(String[] args) {
        Predicate<String> beginWithR = str -> str.startsWith("R");
        System.out.println(beginWithR.test("Rishabh"));
        System.out.println(beginWithR.test("Varun"));

        List<Integer> num = List.of(1,2,3,4,5,6,7,8,9,10);
        num.forEach(n->{
            if(n % 2 ==0){
                System.out.println(n);
            }
        });

        Function<Integer,Integer> squareFunc = n -> {
            return n * n;
        };
        Supplier<String> greeting = () -> "hello Greeting, Welcome to the Supplier Functional Interface";
        System.out.println(squareFunc.apply(5));
        System.out.println(greeting.get());

        List<String> names = new ArrayList<>(List.of("Rishabh","Om", "Disha", "Varun", "Goku"));
        names.removeIf( n -> n.length() < 4);
        names.forEach(System.out::println);// Om removed

    }
}