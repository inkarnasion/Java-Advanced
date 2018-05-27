package java_matrix_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Fill_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");// въвеждаме входните данни

        int number = Integer.parseInt(input[0]);// обръщаме стринга в числа

        int matrix[][] = new int[number][number]; // правим матрица която взима входа


        int count = 1;
        if (input[1].equals("A")) {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    matrix[col][row] = count++;
                }
            }
            PrintMatrix(matrix);

        } else {
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix.length; col++) {
                    if (row % 2 == 0) {
                        matrix[col][row] = count++;
                    } else {
                        matrix[matrix.length - 1 - col][row] = count++;
                    }
                }
            }
            PrintMatrix(matrix);
        }
    }

    private static void PrintMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int mat : aMatrix) {
                System.out.print(mat + " ");
            }
            System.out.println();
        }
    }
}



