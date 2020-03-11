
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

```bash

```
