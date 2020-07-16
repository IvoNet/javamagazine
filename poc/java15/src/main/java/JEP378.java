public class JEP378 {
    public static void main(String[] args) {
        final String s = """
        	Deze regel heeft geen enter hier \
        	en een enkele spatie tussen de quotes: " "
        	groen \s
        	rood
        	blauw \s
        	""";
        System.out.println(s);
    }
}
