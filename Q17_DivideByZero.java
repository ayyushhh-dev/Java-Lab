// Q17: Divide By Zero - ArithmeticException when the denominator is zero
import java.util.InputMismatchException;
import java.util.Scanner;

public class Q17_DivideByZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a (numerator): ");
            int a = sc.nextInt();
            System.out.print("Enter b (denominator): ");
            int b = sc.nextInt();

            int result = a / b;                 // throws ArithmeticException if b == 0
            System.out.println(a + " / " + b + " = " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: denominator is zero, division is not possible. (" + e.getMessage() + ")");
        } catch (InputMismatchException e) {
            System.out.println("Error: please enter whole numbers only");
        } finally {
            System.out.println("Program finished");
        }
    }
}
