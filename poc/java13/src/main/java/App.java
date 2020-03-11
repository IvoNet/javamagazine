public class App {
    public static void main(String[] args) {
        System.out.println(switch (args[0]) {
            case "NLJUG" -> "rockz";
            case "Foo" -> "Bar";
            default -> {
                int len = args[0].length();
                yield len;
            }
        });


        System.out.println(switch (args[0]) {
        	case "Ivo": yield "Woltring";
        	case "NLJUG": yield "Yeah";
        	default: {
        		yield "echoing: " + args[0];
        	}
        });
    }
}
