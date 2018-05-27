package java_matrix_exercises;

import java.util.Scanner;

public class Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+"); //взимаме входа като масив

        int rows = Integer.parseInt(input[0]); // правим редове от входа
        int cols = Integer.parseInt(input[1]); // правим колони от входа


        int[][] matrixResult = fillMatrix(rows, cols, scanner); // правим матрица с с редове и колони и която е в отделен метод за напълване


        int maxSum = Integer.MIN_VALUE; // допълнителна променлива която да пази краен резултат
        int firstRow = 0;
        int secondCol = 0;


        for (int row = 0; row < matrixResult.length - 2; row++) {
            for (int col = 0; col < matrixResult[row].length - 2; col++) {
                int result = (matrixResult[row][col]) + (matrixResult[row][col + 1]) + (matrixResult[row][col + 2]) +
                        (matrixResult[row + 1][col]) + (matrixResult[row + 1][col + 1]) + (matrixResult[row + 1][col + 2]) +
                        (matrixResult[row + 2][col]) + (matrixResult[row + 2][col + 1]) + (matrixResult[row + 2][col + 2]);

                if (result > maxSum) {
                    firstRow = row;
                    secondCol = col;
                    maxSum = result;
                }

            }

        }

        PrintMatrix(matrixResult, maxSum, firstRow, secondCol);

    }

    private static void PrintMatrix(int[][] matrixResult, int maxSum, int firstRow, int secondCol) {
        System.out.println("Sum = " + maxSum); // принтираме
        for (int i = firstRow; i < firstRow + 3; i++) {
            for (int j = secondCol; j < secondCol + 3; j++) {
                System.out.print(matrixResult[i][j] + " ");
            }
            System.out.println();

        }
    }

    private static int[][] fillMatrix(int rows, int cols, Scanner scanner) {// метод с който пълним матрицата
        int[][] matrix = new int[rows][cols]; // взимаме входните данни
        for (int i = 0; i < matrix.length; i++) { // обикаляме по редовете
            String[] result = scanner.nextLine().split("\\s+"); // запазваме данните в масив
            for (int j = 0; j < matrix[i].length; j++) { // обикаляме колоните
                matrix[i][j] = Integer.parseInt(result[j]); // запазваме общият резултат

            }

        }
        return matrix; // връщаме резултата
    }

}
