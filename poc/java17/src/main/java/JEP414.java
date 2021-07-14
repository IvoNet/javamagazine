import jdk.incubator.vector.*;

/*
$ javac --add-modules jdk.incubator.vector JEP414.java
$ java --add-modules jdk.incubator.vector -XX:+PrintCompilation -Xbatch -XX:-TieredCompilation -XX:CompileThreshold=1 -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly JEP414 > jep414.out
*/

public class JEP414 {

  public static void jep414() {
    int a[] = {1, 2, 3, 4};
    int b[] = {1, 2, 3, 4};
    int c[] = new int[a.length];

    // preferred length of vectors
    // (i.e. max supported by the platform)
    VectorSpecies<Integer> SPECIES = IntVector.SPECIES_PREFERRED;

    for (int i = 0; i < a.length; i += SPECIES.length()) {

      // the vector mask is for the end-boundary
      // in case a.length is not a multiple of SPECIES.length
      VectorMask<Integer> m = SPECIES.indexInRange(i, a.length);
      IntVector va = IntVector.fromArray(SPECIES, a, i, m);
      IntVector vb = IntVector.fromArray(SPECIES, b, i, m);
      IntVector vc = va.mul(vb);
      vc.intoArray(c, i, m);
    }
  }

  public static void main(String[] args) {
    jep414();
    jep414();
  }
}
