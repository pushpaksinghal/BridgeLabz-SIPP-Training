

import java.util.Random;
import java.util.Scanner;

public class MatrixOperations {

    // Generate random matrix with values from 0 to 9
    public static int[][] generateMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10);
        return matrix;
    }

    // Display integer matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + "\t");
            System.out.println();
        }
    }

    // Display double matrix
    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) System.out.printf("%.2f\t", val);
            System.out.println();
        }
    }

    // Transpose of a matrix
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                result[j][i] = matrix[i][j];
        return result;
    }

    // Determinant of a 2x2 matrix
    public static int determinant2x2(int[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    // Inverse of a 2x2 matrix
    public static double[][] inverse2x2(int[][] m) {
        int det = determinant2x2(m);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] =  m[1][1] / (double)det;
        inverse[0][1] = -m[0][1] / (double)det;
        inverse[1][0] = -m[1][0] / (double)det;
        inverse[1][1] =  m[0][0] / (double)det;

        return inverse;
    }

    // Determinant of a 3x3 matrix using cofactor expansion
    public static int determinant3x3(int[][] matrix) {
        int a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
        int d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
        int g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];

        return a * (e * i - f * h)
             - b * (d * i - f * g)
             + c * (d * h - e * g);
    }

    // Inverse of a 3x3 matrix using adjugate and determinant
    public static double[][] inverse3x3(int[][] matrix) {
        int det = determinant3x3(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[3][3];

        // Calculate cofactor matrix and adjugate (transposed cofactor)
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                // Create minor matrix (2x2)
                int[][] minor = new int[2][2];
                int r = 0;
                for (int i = 0; i < 3; i++) {
                    if (i == row) continue;
                    int c = 0;
                    for (int j = 0; j < 3; j++) {
                        if (j == col) continue;
                        minor[r][c++] = matrix[i][j];
                    }
                    r++;
                }

                // Cofactor sign alternates with position
                int sign = ((row + col) % 2 == 0) ? 1 : -1;

                // Determinant of 2x2 minor
                int minorDet = determinant2x2(minor);

                // Transpose while assigning to adjugate matrix
                inverse[col][row] = sign * minorDet / (double)det;
            }
        }

        return inverse;
    }

    // Main function to demonstrate both 2x2 and 3x3 operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Choose matrix size (2 or 3): ");
        int size = sc.nextInt();

        if (size == 2) {
            int[][] matrix = generateMatrix(2, 2);
            System.out.println("Generated 2x2 Matrix:");
            printMatrix(matrix);

            System.out.println("Transpose:");
            printMatrix(transpose(matrix));

            System.out.println("Determinant: " + determinant2x2(matrix));

            System.out.println("Inverse:");
            double[][] inv = inverse2x2(matrix);
            if (inv != null) printMatrix(inv);
            else System.out.println("Matrix is not invertible.");

        } else if (size == 3) {
            int[][] matrix = generateMatrix(3, 3);
            System.out.println("Generated 3x3 Matrix:");
            printMatrix(matrix);

            System.out.println("Transpose:");
            printMatrix(transpose(matrix));

            System.out.println("Determinant: " + determinant3x3(matrix));

            System.out.println("Inverse:");
            double[][] inv = inverse3x3(matrix);
            if (inv != null) printMatrix(inv);
            else System.out.println("Matrix is not invertible.");
        } else {
            System.out.println("Only 2x2 and 3x3 matrices are supported.");
        }

        sc.close();
    }
}
