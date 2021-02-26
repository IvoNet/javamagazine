public class JEP395 {
    static record Point(int x, int y) {};
    public static void main(String[] args) {
        final Point p1 = new Point(1, 2);
        final Point p2 = new Point(1, 2);
        if (p1.equals(p2)) {
            System.out.println(p1);
        }
    }
}
