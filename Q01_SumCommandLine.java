public class Q01_SumCommandLine {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No arguments given. Usage: java Q01_SumCommandLine 10 20 30");
            return;
        }
        long sum = 0;
        for (int i = 0; i < args.length; i++) {
            try {
                sum += Integer.parseInt(args[i]);       // args are Strings, convert to int
            } catch (NumberFormatException e) {
                System.out.println("Skipping \"" + args[i] + "\" (not an integer)");
            }
        }
        System.out.println("Number of arguments: " + args.length);
        System.out.println("Sum = " + sum);
    }
}
