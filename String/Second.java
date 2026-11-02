public class Second{
    public static void main(String[] args) {
        String input = "Programming in Java";
        System.out.println("Number of vowels in given input: " + (vowelCounter(input)));
        
    }
    public static int vowelCounter(String input){

        if (input == null) {
            return 0; // Handle null input safely
        }

        String vowels = "aeiou";
        input = input.toLowerCase();
        int count = 0;
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(vowels.contains(String.valueOf(ch))){
                count++;
            }
        }
        return count;
    }
}