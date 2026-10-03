// Q12: Static functions and variable length arguments (varargs)
public class Q12_StaticVarargs {
    static int callCount = 0;                   // static variable: one copy shared by the whole class

    // static method: called with the class name, no object needed
    // int... nums means "any number of int arguments" (nums behaves like an int[])
    static int sum(int... nums) {
        callCount++;
        int total = 0;
        for (int n : nums) total += n;
        System.out.println("  sum() received " + nums.length + " argument(s)");
        return total;
    }

    // fixed parameter first, varargs must always be the LAST parameter
    static void printAll(String label, String... items) {
        System.out.print(label + ": ");
        for (String s : items) System.out.print(s + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("sum()          = " + sum());
        System.out.println("sum(5)         = " + sum(5));
        System.out.println("sum(1,2,3)     = " + sum(1, 2, 3));
        System.out.println("sum(array)     = " + sum(new int[] {10, 20, 30, 40}));

        printAll("Fruits", "apple", "mango", "banana");
        printAll("Empty");

        System.out.println("\nsum() was called " + Q12_StaticVarargs.callCount + " times (static counter)");
    }
}
