public class Third{
    public static void main(String[] args) {
        String x = "Java";
        String part = "Ja";
        String p = part + "va";
        System.out.println(x == p);
        System.out.println(p.intern());
    }
}