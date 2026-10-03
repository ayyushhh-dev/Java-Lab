// Q7b: Working of String and StringBuffer methods:
//      setCharAt(), setLength(), append(), insert(), concat() and equals()
// (This question had no number in the list, so it is called 7b here.)
public class Q07b_StringStringBuffer {
    public static void main(String[] args) {
        // ---------- StringBuffer (mutable: changes the same object) ----------
        StringBuffer sb = new StringBuffer("Hello World");
        System.out.println("Original          : " + sb);

        sb.setCharAt(0, 'J');                   // replace character at index 0
        System.out.println("setCharAt(0,'J')  : " + sb);

        sb.append("!!");                        // add at the end
        System.out.println("append(\"!!\")      : " + sb);

        sb.insert(5, ",");                      // insert at index 5
        System.out.println("insert(5, \",\")    : " + sb);

        sb.setLength(5);                        // cut the buffer to 5 characters
        System.out.println("setLength(5)      : " + sb + "   (length now " + sb.length() + ")");

        // ---------- String (immutable: methods return a NEW string) ----------
        String s1 = "Java";
        String s2 = s1.concat(" Lab");
        System.out.println("\ns1 = " + s1);
        System.out.println("s1.concat(\" Lab\") = " + s2 + "   (s1 is unchanged: " + s1 + ")");

        // ---------- equals() ----------
        String a = new String("hello");
        String b = new String("hello");
        System.out.println("\na == b                : " + (a == b) + "   (different objects)");
        System.out.println("a.equals(b)           : " + a.equals(b) + "   (same content)");
        System.out.println("\"HELLO\".equals(a)     : " + "HELLO".equals(a));
        System.out.println("\"HELLO\".equalsIgnoreCase(a): " + "HELLO".equalsIgnoreCase(a));

        // StringBuffer does NOT override equals(): it compares references, not content
        StringBuffer x = new StringBuffer("same");
        StringBuffer y = new StringBuffer("same");
        System.out.println("\nStringBuffer x.equals(y)                : " + x.equals(y));
        System.out.println("x.toString().equals(y.toString())       : " + x.toString().equals(y.toString()));
    }
}
