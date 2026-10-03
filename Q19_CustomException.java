// Q19: User defined exceptions
// Exception is a subclass of Throwable, so our own exceptions extend Exception.
import java.util.Scanner;

class InvalidAmountException extends Exception {
    private static final long serialVersionUID = 1L;
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    private static final long serialVersionUID = 1L;
    private final double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }
    public double getShortfall() { return shortfall; }
}

class BankAccount {
    private double balance;

    BankAccount(double balance) { this.balance = balance; }

    void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0)
            throw new InvalidAmountException("Amount must be greater than zero");
        if (amount > balance)
            throw new InsufficientFundsException("Insufficient balance", amount - balance);
        balance -= amount;
    }
    double getBalance() { return balance; }
}

public class Q19_CustomException {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Opening balance: ");
        BankAccount acc = new BankAccount(sc.nextDouble());

        System.out.print("Amount to withdraw: ");
        double amount = sc.nextDouble();
        try {
            acc.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: " + acc.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println("Invalid amount: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage() + ". You are short by " + e.getShortfall());
        }
    }
}
