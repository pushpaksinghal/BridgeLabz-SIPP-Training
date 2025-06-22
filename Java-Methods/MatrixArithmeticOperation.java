
import java.util.Random;

public class MatrixArithmeticOperation {

    // Generate a random matrix
    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] mat = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = rand.nextInt(10);
        return mat;
    }

    // Print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Add two matrices
    public static int[][] add(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] + B[i][j];
        return result;
    }

    // Subtract two matrices
    public static int[][] subtract(int[][] A, int[][] B) {
        int[][] result = new int[A.length][A[0].length];
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A[0].length; j++)
                result[i][j] = A[i][j] - B[i][j];
        return result;
    }

    // Multiply two matrices
    public static int[][] multiply(int[][] A, int[][] B) {
        int rows = A.length, cols = B[0].length, sumDim = B.length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < sumDim; k++)
                    result[i][j] += A[i][k] * B[k][j];
        return result;
    }

    public static void main(String[] args) {
        int[][] A = generateMatrix(2, 2);
        int[][] B = generateMatrix(2, 2);
        int[][] C = generateMatrix(2, 3);

        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("A + B:");
        printMatrix(add(A, B));

        System.out.println("A - B:");
        printMatrix(subtract(A, B));

        System.out.println("A * C:");
        printMatrix(multiply(A, C));
    }
}
