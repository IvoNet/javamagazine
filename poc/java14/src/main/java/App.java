public class App {

    public static void main(String[] args) {
        final Object obj = "ivonet.nl";
        //        final Object obj = 42;

        if(obj instanceof String s){
            // s is direct te gebruiken als: s = (String) obj;
            System.out.println(s);
            System.out.println(s.length());
        } else{
            // s is hier niet beschikbaar
            System.out.println("Niet een string");
        }
    }
}
