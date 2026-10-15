public class Seventh{
    public static void change(String s) {
       s = "changed";
    }
    public static void main(String[] args) {
        // for (int i = 1; i <= 5; i++) {
        //     if (i % 2 == 0) continue;
        //     System.out.println(i);
        // }
        String text = "original";
        change(text);
        System.out.println(text);// original

        System.out.println(Test.isEven(7));
        System.out.println(Test.max(3, 7));
        System.out.println(Test.max(3, 7, 9));
        System.out.println(Test.sum());
        System.out.println(Test.sum(3, 7, 9, 6));

    }
    
}

class Test{
    public static boolean isEven(int n){
        return(n % 2 == 0);
    }

    public static int max(int a, int b){
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c){
        return Math.max(a, Math.max(b, c));
    }

    public static int sum(int... numbers){

        if (numbers.length == 0){
            System.out.println("No numbers are provided");
            return 0;
        }

        int result = 0;

        for (int n : numbers){
            result += n;
        }
        
        return result;
    }
}
