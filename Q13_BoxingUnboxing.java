// Q13: Boxing and unboxing
// Boxing   = primitive -> wrapper object (int -> Integer)
// Unboxing = wrapper object -> primitive (Integer -> int)
import java.util.ArrayList;

public class Q13_BoxingUnboxing {
    public static void main(String[] args) {
        // Manual boxing and unboxing
        int p = 25;
        Integer boxed = Integer.valueOf(p);     // boxing
        int back = boxed.intValue();            // unboxing
        System.out.println("Manual: boxed = " + boxed + ", unboxed = " + back);

        // Autoboxing and auto-unboxing (the compiler does it for us)
        Integer a = 10;                         // autoboxing: int -> Integer
        int b = a;                              // auto-unboxing: Integer -> int
        Integer sum = a + b;                    // unboxed, added, then boxed again
        System.out.println("Auto: a = " + a + ", b = " + b + ", a + b = " + sum);

        // Other wrapper classes
        Double d = 3.14;
        double dd = d;
        Character c = 'Z';
        char cc = c;
        Boolean flag = true;
        boolean ff = flag;
        System.out.println("Double " + dd + ", Character " + cc + ", Boolean " + ff);

        // Collections hold objects only, so primitives are boxed automatically
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);                            // boxing
        list.add(15);
        list.add(25);
        int total = 0;
        for (int v : list) total += v;          // unboxing
        System.out.println("List = " + list + ", total = " + total);

        // Comparing wrapper objects: use equals(), not ==
        Integer x1 = 127, x2 = 127;
        Integer y1 = 1000, y2 = 1000;
        System.out.println("127 == 127   : " + (x1 == x2) + "   (small values are cached)");
        System.out.println("1000 == 1000 : " + (y1 == y2) + "  (different objects)");
        System.out.println("1000.equals(1000): " + y1.equals(y2));
    }
}
