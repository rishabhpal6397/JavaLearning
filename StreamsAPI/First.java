package StreamsAPI;

import java.util.List;
import java.util.stream.*;

public class First {
    public static void main(String[] args) {
        // Excercise: 1
        List<Integer> nums = List.of(3, 8, 1, 9, 4, 7);
        List<Integer> oddNum = nums.stream()
            .sorted()
            .filter(n -> n % 2 != 0)
            .toList();
        System.out.println(oddNum);

        // Excercise: 2
        int sumOfSquares = IntStream.rangeClosed(1, 10)
            .map(n -> n * n)
            .sum();
        System.out.println(sumOfSquares);

        // Excercise: 3
        List<String> names = List.of("Rishabh", "Om", "Disha", "Varun", "Goku");
        long countOfAa = names.stream()
            .filter( n -> n.toLowerCase().contains("a"))
            .count();
        System.out.println(countOfAa);// 3

        // Excercise: 4
        // well the statement won't run until a terminal operation is used and as you asked what happens if I write names.stream().filter.map(), well nothing because we haven't specified what should happen 
        names.stream()
            .filter(n -> {
                System.out.println("checking " + n);
                return n.length() > 3;
            });

    }   
}
