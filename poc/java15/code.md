
```java
public sealed class Fruit permits Orange {
}
public non-sealed class Orange extends Fruit {
}
public class Apple extends Fruit {
}
```

```bash
$ javac --enable-preview -source 15 Fruit.java Orange.java Apple.java
Apple.java:1: error: class is not allowed to extend sealed class: Fruit
public class Apple extends Fruit {
       ^
Note: Some input files use preview language features.
Note: Recompile with -Xlint:preview for details.
1 error
```


```bash
$ java --enable-preview JEP375
Het Werkt!!! <- heeft lengte :12
$ jshell --enable-preview
|  Welcome to JShell -- Version 15-ea
|  For an introduction type: /help intro

jshell> var s = "ivonet.nl"
s ==> "ivonet.nl"

jshell> if (s instanceof String bs && bs.length() > 5) System.out.println("Mooie string!")
Mooie string!

```

```java
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
```
```bash
$ javac JEP378.java
$ java JEP378
Deze regel heeft geen enter hier en een enkele spatie tussen de quotes: " "
groen
rood
blauw
```
