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
