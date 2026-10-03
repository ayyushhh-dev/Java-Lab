// Q10: Function overloading with automatic type conversion
// If no method matches the argument type exactly, Java converts the argument from a
// lower to a higher data type (byte -> short -> int -> long -> float -> double)
// and uses the nearest matching method.
public class Q10_OverloadingConversion {
    static void show(int x)    { System.out.println("show(int) called with "    + x); }
    static void show(float x)  { System.out.println("show(float) called with "  + x); }
    static void show(double x) { System.out.println("show(double) called with " + x); }

    public static void main(String[] args) {
        byte b = 5;
        short s = 10;
        char c = 'A';
        int i = 100;
        long l = 5000L;
        float f = 2.5f;
        double d = 9.99;

        show(b);        // no show(byte): byte  -> int
        show(s);        // no show(short): short -> int
        show(c);        // no show(char): char  -> int (prints the character code 65)
        show(i);        // exact match: int
        show(l);        // no show(long): long  -> float
        show(f);        // exact match: float
        show(d);        // exact match: double

        // Conversion only goes UP. Going down (e.g. double -> int) is never done
        // automatically, so a call like show("text") or an int-only method called
        // with a double value gives a compile error.
    }
}
