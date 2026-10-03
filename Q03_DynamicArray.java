// Q3: Single dimensional array defined dynamically (size decided at run time)
import java.util.Scanner;

public class Q03_DynamicArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many elements? ");
        int n = sc.nextInt();

        int[] arr = new int[n];                 // array created at run time with the size the user gave
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int sum = 0, max = arr[0], min = arr[0];
        System.out.print("Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            sum += arr[i];
            if (arr[i] > max) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("\nSum = " + sum);
        System.out.println("Maximum = " + max + ", Minimum = " + min);
    }
}
