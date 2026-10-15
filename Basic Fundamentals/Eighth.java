public class Eighth{
    public static void appendText(StringBuilder sb) {
        sb.append(" changed");    // modifies the object both references point to
    }

    public static void replaceText(StringBuilder sb) {
        sb = new StringBuilder("new object");   // only the local copy is redirected
    }
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("original");
        appendText(text);
        System.out.println(text);// original changed

        replaceText(text);
        System.out.println(text);// original changed
    }
}