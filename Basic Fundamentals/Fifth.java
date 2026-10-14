public class Fifth{
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x++ + 5);// 15
        System.out.println(x);// 11
        System.out.println(++x * 2);// 24

        int marks1 = 80;
        String status1 = marks1 >= 75 ? "Distinction" : "Not Distinction";
        int marks2 = 60;
        String status2 = marks2 >= 75 ? "Distinction" : "Not Distinction";
        System.out.println(status1);
        System.out.println(status2);
    }
}