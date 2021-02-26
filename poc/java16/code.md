
```java
public class JEP390 {
    public static void main(String[] args) {
        Double d = 20.0;
        synchronized (d) { /* do stuff */ } // javac warning & HotSpot warning
        Object o = d;
        synchronized (o) { /* do stuff */ } // HotSpot warning
    }
}
```

```c
#include <stdio.h>
void helloworld() {
	printf("Hello world!\n");
}
```

```java
import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.LibraryLookup;
import java.lang.invoke.MethodType;
import java.nio.file.Path;
public class JEP389 {
  public static void main(String[] args) throws Throwable {
    var lib = LibraryLookup.ofPath(Path.of("/src/helloworld.so"));
    var sym = lib.lookup("helloworld").get();
    var fd = FunctionDescriptor.ofVoid();
    var mt = MethodType.methodType(Void.TYPE);
    var mh = CLinker.getInstance().downcallHandle(sym.address(), mt, fd);
    mh.invokeExact();
  }
}
```


jar cmf Hello.mf app.jar Hello.class Hello.java

jpackage --name app --input ./build --main-jar app.jar --type app-image --java-options "--enable-preview"


```java
public class JEP394 {
    
    public void print(Object o) {
        if (o instanceof String bs && bs.length() > 5){
            System.out.println(bs);
        } else {
            System.out.println("Shorter");
        }
    }

  public static void main(String[] args) {
    JEP394 jep394 = new JEP394();
    var site = "IvoNet.nl";
    jep394.print(site);

  }
}
```


```java
public class JEP395 {
    static record Point(int x, int y) {};
    public static void main(String[] args) {
        final Point p1 = new Point(1, 2);
        final Point p2 = new Point(1, 2);
        if (p1.equals(p2)) {
            System.out.println(p1);
        }
    }
}
```
