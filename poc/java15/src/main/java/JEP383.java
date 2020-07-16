import jdk.incubator.foreign.MemoryAddress;
import jdk.incubator.foreign.MemorySegment;
public class JEP383 {
    public static void main(String[] args) {
        try (MemorySegment segment = MemorySegment.allocateNative(1024)) {
        	MemoryAddress base = segment.baseAddress();
        	System.out.println(base);
        }
    }
}
