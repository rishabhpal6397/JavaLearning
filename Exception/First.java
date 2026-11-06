public class First{
    public static void main(String[] args) {
        System.out.println(safeDivide(4,0));// 1st

        try {// 2nd
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught it");
        } finally {
            System.out.println("Finally runs");
        }
        System.out.println("End");// every print statement runs

        try {// 3rd
            withdraw(1243, 210);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int safeDivide(int a, int b) throws ArithmeticException{
        int result = 0;
        try {
            result = a / b;
        } catch (ArithmeticException e) {
            result = 0;
            System.out.println("Cannot divide by zero!");
        }
        return result;
    }

    public static void withdraw(double amount, double balance) throws InsufficientBalanceException{
        if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance: tried to withdraw " + amount + " but only " + balance + " is available.");
        }
        System.out.println("Withdrawal of " + amount + " successful!");
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}