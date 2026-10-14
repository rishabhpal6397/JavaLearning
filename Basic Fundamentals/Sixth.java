public class Sixth{
    public static void main(String[] args) {
        int temperature=10;
        Table table = new Table();
        if (temperature >= 30) {
            System.out.println("Hot");
        }
        else if (temperature >= 20 && temperature <= 29) {
            System.out.println("Pleasant");
        }
        else{
            System.out.println("Cold");
        }

        table.multiplicationTable(7);
    }
}

class Table{
    public void multiplicationTable(int n){
        for(int i = 1; i <= 10; i++){
            System.out.println(n + " X " + i + " = " + n*i);
        }
    }
}