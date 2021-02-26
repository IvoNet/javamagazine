import jdk.incubator.foreign.CLinker;
import jdk.incubator.foreign.FunctionDescriptor;
import jdk.incubator.foreign.LibraryLookup;

import java.lang.invoke.MethodType;
import java.nio.file.Path;

public class JEP389 {
  public static void main(final String[] args) throws Throwable {
    var lib = LibraryLookup.ofPath(Path.of("/src/helloworld.so"));
    var sym = lib.lookup("helloworld").get();
    var fd = FunctionDescriptor.ofVoid();
    var mt = MethodType.methodType(Void.TYPE);
    var mh = CLinker.getInstance().downcallHandle(sym.address(), mt, fd);
    mh.invokeExact();
  }
}
