// Q8: "Distance" class (feet and inches): creating objects and the use of 'this'
class Distance {
    int feet;
    int inches;

    // parameter names are the same as the fields, so 'this' tells them apart
    void setDistance(int feet, int inches) {
        this.feet = feet;                       // this.feet = the object's field, feet = the parameter
        this.inches = inches;
        normalize();
    }

    private void normalize() {                  // 12 inches = 1 foot
        feet += inches / 12;
        inches = inches % 12;
    }

    // adds the distance d to the current object (this) and returns a new Distance
    Distance add(Distance d) {
        Distance result = new Distance();
        result.setDistance(this.feet + d.feet, this.inches + d.inches);
        return result;
    }

    // returning 'this' allows method chaining: d.addFeet(1).addFeet(2)
    Distance addFeet(int f) {
        this.feet += f;
        return this;
    }

    // 'this' is a reference to the object on which the method was called
    Distance getThis() {
        return this;
    }

    void display() {
        System.out.println(feet + " feet " + inches + " inches");
    }
}

public class Q08_DistanceClass {
    public static void main(String[] args) {
        Distance d1 = new Distance();           // creating objects
        Distance d2 = new Distance();
        d1.setDistance(5, 8);
        d2.setDistance(3, 10);

        System.out.print("d1 = "); d1.display();
        System.out.print("d2 = "); d2.display();

        Distance d3 = d1.add(d2);
        System.out.print("d1 + d2 = "); d3.display();

        d1.addFeet(1).addFeet(2);               // chaining works because the method returns 'this'
        System.out.print("d1 after addFeet(1).addFeet(2) = "); d1.display();

        System.out.println("d1.getThis() == d1 ? " + (d1.getThis() == d1));
        System.out.println("d1.getThis() == d2 ? " + (d1.getThis() == d2));
    }
}
