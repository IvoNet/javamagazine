
```java
public String klasiekeSwitch(int dag) {
    final String waarde;
    switch (dag) {
        case 1:     // geen break gebruikt dus valt hij door naar de volgende case als niet true
        case 2:
        case 3:
        case 4:
        case 5:
            waarde = "weekdag";
            break;
        case 6:
        case 7:
            waarde = "weekend";
            break;
        default:
            waarde = "onbekend";
    }
    return waarde;
}
```
listing 1


```java
public String dag(int day) {
    return switch (day) {
        case 1, 2, 3, 4, 5  -> "weekdag";
        case 6,7 -> "weekend";
        default -> "onbekend";
    } ;
}
```
listing 2


```java
public boolean isWeekend(String day) {
    return switch (day) {
        case "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag" -> false;
        case "zaterdag","zondag" -> true;
        default -> {
            if (day.startsWith("z")) {
                System.out.println("Lijkt op weekend");
                break true;
            }

            System.out.printf("Onbekende dag: %s%n", day);
            break false;
        }
    } ;
}
```
listing 3



```bash
docker run \
       -it \
       --rm \
       --name jdk12 \
       -e JAVA_OPTS="-XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC" \
       openjdk:12-oracle \
       jshell --enable-preview
```
listing 4


```java

public class SwitchVoorbeeld {

    public String klasiekeSwitch(int dag) {
        final String waarde;
        switch (dag) {
            case 1:     // geen break gebruikt dus valt hij door naar de volgende case als niet true
            case 2:
            case 3:
            case 4:
            case 5:
                waarde = "weekdag";
                break;
            case 6:
            case 7:
                waarde = "weekend";
                break;
            default:
                waarde = "onbekend";
        }
        return waarde;
    }

    public String dag(int day) {
        return switch (day) {
            case 1, 2, 3, 4, 5  -> "weekdag";
            case 6,7 -> "weekend";
            default -> "invalid";
        } ;
    }

    public boolean isWeekend(String day) {
        return switch (day) {
            case "maandag", "dinsdag", "woensdag", "donderdag", "vrijdag" -> false;
            case "zaterdag","zondag" -> true;
            default -> {
                if (day.startsWith("z")) {
                    System.out.println("Lijkt op weekend");
                    break true;
                }

                System.out.printf("Onbekende dag: %s%n", day);
                break false;
            }
        } ;
    }
}


```