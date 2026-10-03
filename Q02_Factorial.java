// Q2: Factorial of a given number
import java.util.Scanner;

public class Q02_Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative number (max 20): ");
        int n = sc.nextInt();

        if (n < 0 || n > 20) {
            System.out.println("Number must be between 0 and 20 (21! does not fit in a long)");
            return;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) fact *= i;
        System.out.println(n + "! = " + fact);
    }
}
