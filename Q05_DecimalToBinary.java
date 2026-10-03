// Q5: Convert a decimal number to binary
import java.util.Scanner;

public class Q05_DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a non-negative decimal number: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("Please enter a non-negative number");
            return;
        }

        // Method 1: repeated division by 2, remainders read in reverse
        StringBuilder binary = new StringBuilder();
        int temp = n;
        if (temp == 0) binary.append(0);
        while (temp > 0) {
            binary.insert(0, temp % 2);         // put each remainder in front
            temp /= 2;
        }
        System.out.println("Binary (division method)   : " + binary);

        // Method 2: built-in, to cross-check
        System.out.println("Binary (Integer.toBinaryString): " + Integer.toBinaryString(n));
    }
}
