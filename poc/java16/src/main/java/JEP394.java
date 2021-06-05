public class JEP394 {

    public void print(Object o) {
        if (o instanceof String bs &&
              bs.length() > 5){
            System.out.println(bs);
        } else {
            System.out.println("Shorter");
        }
    }

  public static void main(String[] args) {
    JEP394 jep394 = new JEP394();
    var site = "IvoNet.nl";
    jep394.print(site);

  }
}
