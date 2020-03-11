public class JEP359 {
    public static void main(String[] args) {
        record Point(int x, int y) {};

        final Point p1 = new Point(1, 2);
        final Point p2 = new Point(1, 2);

        if (p1.equals(p2)) {
        	System.out.println(p1);
        }
    }
}
