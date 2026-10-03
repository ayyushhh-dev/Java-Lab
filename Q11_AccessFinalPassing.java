// Q11: public vs private, pass by value (primitives) vs object references, and 'final'
class Account {
    public String owner;                        // public: accessible from anywhere
    private double balance;                     // private: accessible only inside this class
    public static final double MIN_BALANCE = 500;   // final: a constant, cannot be changed

    Account(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }
    public double getBalance() { return balance; }          // controlled access to the private field
    public void deposit(double amount) { balance += amount; }

    public final void showPolicy() {            // final method: subclasses cannot override it
        System.out.println("Minimum balance is " + MIN_BALANCE);
    }
}

public class Q11_AccessFinalPassing {
    // primitive: a COPY of the value is passed, the original is not affected
    static void changePrimitive(int x) {
        x = x + 100;
        System.out.println("  inside changePrimitive: x = " + x);
    }

    // object: the reference is passed, so the method works on the SAME object
    static void changeObject(Account a) {
        a.owner = "Changed Owner";
        a.deposit(1000);
    }

    // reassigning the parameter only changes the local copy of the reference
    static void reassign(Account a) {
        a = new Account("Someone Else", 1);
    }

    public static void main(String[] args) {
        Account acc = new Account("Ayush", 2000);

        System.out.println("--- public and private ---");
        System.out.println("Owner (public field): " + acc.owner);
        // System.out.println(acc.balance);     // ERROR: balance has private access in Account
        System.out.println("Balance via public getter: " + acc.getBalance());

        System.out.println("\n--- primitive passed by value ---");
        int number = 10;
        System.out.println("before: number = " + number);
        changePrimitive(number);
        System.out.println("after : number = " + number + "   (unchanged)");

        System.out.println("\n--- object passed by reference ---");
        System.out.println("before: " + acc.owner + ", balance " + acc.getBalance());
        changeObject(acc);
        System.out.println("after : " + acc.owner + ", balance " + acc.getBalance() + "   (changed)");
        reassign(acc);
        System.out.println("after reassign(): " + acc.owner + "   (still the same object)");

        System.out.println("\n--- final keyword ---");
        final int LIMIT = 50;
        System.out.println("LIMIT = " + LIMIT);
        // LIMIT = 60;                          // ERROR: cannot assign a value to a final variable
        acc.showPolicy();
        System.out.println("Account.MIN_BALANCE = " + Account.MIN_BALANCE);
    }
}
