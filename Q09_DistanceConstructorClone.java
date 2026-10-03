// Q9: "Distance" class with constructors; reference assignment; clone()
class Distance implements Cloneable {
    int feet;
    int inches;

    Distance() {                                // default constructor
        this(0, 0);
    }

    Distance(int feet, int inches) {            // parameterised constructor
        this.feet = feet + inches / 12;
        this.inches = inches % 12;
    }

    void display(String label) {
        System.out.println(label + " = " + feet + " feet " + inches + " inches");
    }

    // clone() creates a separate copy with the same values
    public Distance clone() {
        try {
            return (Distance) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}

public class Q09_DistanceConstructorClone {
    public static void main(String[] args) {
        Distance d1 = new Distance(5, 8);
        Distance d2 = new Distance(3, 10);       // another object
        System.out.println("--- two separate objects ---");
        d1.display("d1");
        d2.display("d2");

        d2 = d1;                                 // reference assignment: d2 now points to the SAME object as d1
        Distance d3 = d1.clone();                // d3 is a new object, a copy of d1

        d1.feet = 99;                            // change the object d1 refers to

        System.out.println("\n--- after d2 = d1, d3 = d1.clone(), then d1.feet = 99 ---");
        d1.display("d1");
        d2.display("d2 (same object as d1, so it changed too)");
        d3.display("d3 (clone, independent copy, unchanged)");

        System.out.println("\nd1 == d2 ? " + (d1 == d2));
        System.out.println("d1 == d3 ? " + (d1 == d3));
    }
}
