# Java 13 code snippets

```bash
docker run -it --rm                \
      -v $(pwd)/src/main/java:/src \
      openjdk:13 /bin/bash                     


-XX:ArchiveClassesAtExit=<filename>


-XX:SharedArchiveFile=<filename>

# Eerst het creeren van een lijst van classes die in het archive moeten komen  
java -XX:+UseAppCDS
     -XX:DumpLoadedClassList=classes.lst
     -jar app.jar

# Dan het archive generereren
java -XX:+UseAppCDS -Xshare:dump 
     -XX:SharedClassListFile=classes.lst
     -XX:SharedArchiveFile=app-cds.jsa
     --class-path app.jar

# En dan het gebruik van het archive

java -XX:+UseAppCDS -Xshare:on 
     -XX:SharedArchiveFile=app-cds.jsa
     -jar app.jar

```





```bash
java --version
openjdk 13 2019-09-17
OpenJDK Runtime Environment (build 13+33)
OpenJDK 64-Bit Server VM (build 13+33, mixed mode, sharing)

```

```bash
javac -source 13 --enable-preview App.java && \
java --enable-preview App Ivo
```

```java
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

```


```java
public class MultiLineStrings {
    public static void main(String[] args) {
        String niet = "<html>\n" +
                      "    <body>\n" +
                      "        <p>Hello, world</p>\n" +
                      "    </body>\n" +
                      "</html>\n";

        String maar = """
                      <html>
                          <body>
                              <p>Hello, world</p>
                          </body>
                      </html>
                      """;
        System.out.println(maar);

        String query = """
                       SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
                       WHERE `CITY` = 'INDIANAPOLIS'
                       ORDER BY `EMP_ID`, `LAST_NAME`;
                       """;
        System.out.println(query);
    }
}/**/
```

```bash
javac -source 13 --enable-preview MultiLineStrings.java && \
java --enable-preview MultiLineStrings

Note: MultiLineStrings.java uses preview language features.
Note: Recompile with -Xlint:preview for details.
<html>
    <body>
        <p>Hello, world</p>
    </body>
</html>

SELECT `EMP_ID`, `LAST_NAME` FROM `EMPLOYEE_TB`
WHERE `CITY` = 'INDIANAPOLIS'
ORDER BY `EMP_ID`, `LAST_NAME`;
```
