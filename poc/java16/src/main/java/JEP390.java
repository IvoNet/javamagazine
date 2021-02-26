public class JEP390 {
    public static void main(String[] args) {
        Double d = 20.0;
        synchronized (d) { /* do stuff */ } // javac warning & HotSpot warning
        Object o = d;
        synchronized (o) { /* do stuff */ } // HotSpot warning
    }
}
