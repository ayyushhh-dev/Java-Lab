// Q18: Nested try statements - the order in which catch handlers are checked
// Rule: the inner try's catch blocks are checked first. If none matches, the exception
// goes to the outer try's catch blocks. 'finally' always runs.
public class Q18_NestedTry {
    static void run(int scenario) {
        System.out.println("\n=== Scenario " + scenario + " ===");
        try {                                                   // outer try
            System.out.println("Outer try started");
            try {                                               // inner try
                System.out.println("  Inner try started");
                int zero = 0;
                if (scenario == 1) {
                    int x = 10 / zero;                          // ArithmeticException
                } else if (scenario == 2) {
                    int[] arr = new int[3];
                    arr[5] = 1;                                 // ArrayIndexOutOfBoundsException
                } else if (scenario == 3) {
                    String s = null;
                    s.length();                                 // NullPointerException
                }
                System.out.println("  Inner try finished without exception");
            } catch (ArithmeticException e) {
                System.out.println("  Inner catch: ArithmeticException handled here");
            } finally {
                System.out.println("  Inner finally");
            }
            System.out.println("Outer try continues after inner try");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Outer catch: ArrayIndexOutOfBoundsException (inner try had no handler for it)");
        } catch (Exception e) {
            // general handler is written LAST: a superclass catch before a subclass catch is a compile error
            System.out.println("Outer catch (general Exception): " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Outer finally");
        }
    }

    public static void main(String[] args) {
        run(0);     // no exception
        run(1);     // handled by the inner catch
        run(2);     // inner has no match, handled by the outer specific catch
        run(3);     // inner has no match, handled by the outer general catch
    }
}
