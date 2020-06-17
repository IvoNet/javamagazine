public class App {
    public static void main(String[] args) {
        //Flip comment op de volgende twee regels om de else tak in te gaan
        final Object obj = "Het Werkt!!!";
        // final Object obj = 42;
        if(obj instanceof String s){
            // s is direct te gebruiken als: s = (String) obj;
            System.out.println(s + " <- heeft lengte :" + s.length());
        } else{
            // s is hier niet beschikbaar
            System.out.println("Niet een string");
        }
    }
}
