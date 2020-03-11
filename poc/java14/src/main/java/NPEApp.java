public class NPEApp {
    public static void main(String[] args) {
        final String[] s = new String[2];
        s[1].length();
    }
}
