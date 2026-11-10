import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Second{
    public static void main(String[] args) {
        Pair<String,Integer> pair1 = new Pair<>();
        pair1.setFirst("Rishabh");
        pair1.setSecond(24);
        System.out.println(pair1.getFirst() + ": " + pair1.getSecond());

        String[] names = {"Rishi","Varun","Om","Disha"};
        swap(names, 1, 3);
        System.out.println(Arrays.toString(names));

        List<Integer> num = Arrays.asList(10,20,30);
        List<Double> num2 = Arrays.asList(10.5, 20.5, 30.5);

        System.out.println(sum(num));
        System.out.println(sum(num2));
        

    }

    public static <T> void swap(T[] arr, int i, int j){
        T temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static double sum(List<? extends Number> list){
        double total = 0;
        for(Number n : list){
            total += n.doubleValue();
        }

        return total;
    }
}

class Pair<A, B>{
    private A first;
    private B second;

    public void setFirst(A first){this.first = first; }
    public void setSecond(B second){this.second = second; }
    public A getFirst() {return first;}
    public B getSecond() {return second;}
}