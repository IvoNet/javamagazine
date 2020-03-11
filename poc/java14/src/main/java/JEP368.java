public class JEP368 {
    public static void main(String[] args) {
        final String s = """
        	Deze regel heeft geen enter hier \
        	en een enkele spatie tussen de quotes: "\s"
        	groen \s
        	rood  \s
        	blauw \s
        	""";
        System.out.println(s);
    }
}
