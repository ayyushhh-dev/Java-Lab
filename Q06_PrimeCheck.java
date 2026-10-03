// Q6: Check whether a number is prime (number taken from the keyboard)
import java.util.Scanner;

public class Q06_PrimeCheck {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        if (isPrime(n)) System.out.println(n + " is a prime number");
        else System.out.println(n + " is not a prime number");
    }
}
