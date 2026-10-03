// Q7: Sum of integers entered from the keyboard; how MANY integers is given as a command line argument
// Compile: javac Q07_InteractiveSum.java
// Run:     java Q07_InteractiveSum 5        (then type 5 numbers)
import java.util.Scanner;

public class Q07_InteractiveSum {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Q07_InteractiveSum <how many numbers>");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The command line argument must be an integer");
            return;
        }

        Scanner sc = new Scanner(System.in);
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter number " + i + ": ");
            sum += sc.nextInt();
        }
        System.out.println("Sum of " + n + " numbers = " + sum);
    }
}
