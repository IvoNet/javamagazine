
```java
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
```


```bash
$ javac -source 14 --enable-preview -Xlint:preview App.java 
$ java --enable-preview App
```

```
App.java:7: warning: [preview] pattern matching in instanceof is a preview feature and may be removed in a future release.
        if(obj instanceof String s){
                                 ^
1 warning
ivonet.nl
9
```


```bash
# Compile the example code
$ javac -source 14 --enable-preview -Xlint:preview App.java
# Created a manifest for the jar
$ cat App.mf
Manifest-Version: 1.0
Main-Class: App
# Create the jar
$ jar cmf App.mf app.jar App.class App.java 
$ jpackage --name app --input . --main-jar app.jar \
  --type app-image --java-options "--enable-preview"
# Lets see working
$ ./app/bin/app
ivonet.nl
9
```




```text
.
└── app
    ├── bin
    └── lib
        ├── app
        └── runtime
            ├── conf
            │   ├── management
            │   ├── sdp
            │   └── security
            │       └── policy
            │           ├── limited
            │           └── unlimited
            ├── legal
            │   ├── java.base
            │   ├── [lots more items here ...]
            │   └── jdk.zipfs
            └── lib
                ├── jfr
                ├── security
                └── server

```


```java
import java.time.Duration;
import jdk.jfr.consumer.RecordingStream;
public class JFRApp {
    public static void main(String[] args) {
        try (var rs = new RecordingStream()) {
          rs.enable("jdk.CPULoad").withPeriod(Duration.ofSeconds(1));
          rs.enable("jdk.JavaMonitorEnter").withThreshold(Duration.ofMillis(10));
          rs.onEvent("jdk.CPULoad", event -> {
            System.out.println(event.getFloat("machineTotal"));
          });
          rs.onEvent("jdk.JavaMonitorEnter", event -> {
            System.out.println(event.getClass("monitorClass"));
          });
          rs.start();
        }
    }
}
```

```java
public class NPEApp {
    public static void main(String[] args) {
        final String[] s = new String[2];
        s[1].length();
    }
}
```


```bash
$ javac NPEApp.java && java NPEApp
Exception in thread "main" java.lang.NullPointerException
	at NPEApp.main(NPEApp.java:4)
$ javac NPEApp.java && java -XX:+ShowCodeDetailsInExceptionMessages NPEApp
Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "<local1>[1]" is null
	at NPEApp.main(NPEApp.java:4)
```


```java
public class JEP359 {
    public static void main(String[] args) {
        record Point(int x, int y) {};

        final Point p1 = new Point(1, 2);
        final Point p2 = new Point(1, 2);

        if (p1.equals(p2)) {
        	System.out.println(p1);
        }
    }
}
```

```bash
$ javac -source 14 --enable-preview -Xlint:preview JEP359.java
$ java --enable-preview JEP359
JEP359.java:3: warning: [preview] records are a preview feature and may be removed in a future release.
        record Point(int x, int y) {};
        ^
1 warning
Point[x=1, y=2]
```



```java
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
```


```bash
$ javac -source 14 --enable-preview JEP368.java && java --enable-preview JEP368
Note: JEP368.java uses preview language features.
Note: Recompile with -Xlint:preview for details.
Deze regel heeft geen enter hier en een enkele spatie tussen de quotes: " "
groen
rood
blauw
```

```bash
$ javac -source 14 --enable-preview -Xlint:preview JEP368.java && java --enable-preview JEP368
JEP368.java:3: warning: [preview] text blocks are a preview feature and may be removed in a future release.
        final String s = """
                         ^
JEP368.java:4: warning: [preview] text blocks are a preview feature and may be removed in a future release.
        	Deze regel heeft geen enter hier \
        	                                  ^
JEP368.java:5: warning: [preview] text blocks are a preview feature and may be removed in a future release.
        	en een enkele spatie tussen de quotes: "\s"
        	                                         ^
JEP368.java:6: warning: [preview] text blocks are a preview feature and may be removed in a future release.
        	groen \s
        	       ^
JEP368.java:7: warning: [preview] text blocks are a preview feature and may be removed in a future release.
        	rood  \s
        	       ^
JEP368.java:8: warning: [preview] text blocks are a preview feature and may be removed in a future release.
        	blauw \s
        	       ^
6 warnings
Deze regel heeft geen enter hier en een enkele spatie tussen de quotes: " "
groen  
rood  
blauw  
```



```java
import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
public class JEP370 {
    public static void main(String[] args) {
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {
        	MemoryAddress base = segment.baseAddress();
        	System.out.println(base);
        }
    }
}
```

```bash
$ javac -source 14 --enable-preview --add-modules jdk.incubator.foreign JEP370.java && java --enable-preview --add-modules jdk.incubator.foreign JEP370
warning: using incubating module(s): jdk.incubator.foreign
1 warning
WARNING: Using incubator modules: jdk.incubator.foreign
MemoryAddress{ region: MemorySegment{ id=0x683ceb2a limit: 1024 } offset=0x0 }
```
