public class JEP406 {

    static String formatterPatternSwitch(Object o) {
        return switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> o.toString();
        };
    }

    static void testPatternWithNull(String s) {
        switch (s) {
            case null -> System.out.println("Oops");
            case "Java Magazine",
                  "ivonet.nl" -> System.out.println("Great");
            default -> System.out.println("Ok");
        }
    }

    public static void main(String[] args) {
        System.out.println(formatterPatternSwitch(42));
        System.out.println(formatterPatternSwitch(42L));
        System.out.println(formatterPatternSwitch(42D));
        System.out.println(formatterPatternSwitch("42"));
        System.out.println(formatterPatternSwitch(false));

        testPatternWithNull(null);
        testPatternWithNull("Java Magazine");
        testPatternWithNull("ivonet.nl");
        testPatternWithNull("other");
    }
}
