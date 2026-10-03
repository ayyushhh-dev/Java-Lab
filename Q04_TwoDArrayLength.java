// Q4: Use of .length with a two dimensional array
public class Q04_TwoDArrayLength {
    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12} };

        System.out.println("matrix.length (number of rows)       = " + matrix.length);
        System.out.println("matrix[0].length (number of columns) = " + matrix[0].length);

        System.out.println("\nPrinting the matrix using .length in the loops:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++)
                System.out.print(matrix[i][j] + "\t");
            System.out.println();
        }

        // In Java a 2D array is an array of arrays, so every row can have a different length
        int[][] jagged = new int[3][];
        jagged[0] = new int[2];
        jagged[1] = new int[4];
        jagged[2] = new int[1];
        System.out.println("\nJagged array:");
        for (int i = 0; i < jagged.length; i++)
            System.out.println("Row " + i + " has length " + jagged[i].length);
    }
}
