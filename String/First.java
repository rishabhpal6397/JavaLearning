public class First{
    public static void main(String[] args) {
        String input = "mad";
        System.out.println(isPalindrome(input));
    }

    public static boolean isPalindrome(String input){
        // int j =0;
        StringBuilder temp = new StringBuilder(input);
        
            // for(int j = input.length() -1; j <= input.length(); j--){
            //     if(input.charAt(i) == input.charAt(j)) return true;
            // } 1st Method
            // if(input.charAt(j)!=input.charAt(i)){
            //     return false;
            // } 2nd method
            // j+=1;
        temp.reverse();
        if(input.contentEquals(temp)){
            return true;// 3rd method
        }
        return false;
    }
}
