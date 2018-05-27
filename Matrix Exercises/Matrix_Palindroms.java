package java_matrix_exercises;

import java.util.Scanner;

public class Matrix_Palindroms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");// взимаме входа като масив

        int row = Integer.parseInt(input[0]); // правим колоните от входа
        int col = Integer.parseInt(input[1]); // правим редовете от входа

        String[][] matrixResult = generateMatrixPalindromes(row, col); // извикваме алгоритъма
        printMatrix(matrixResult);// принтираме резултата
    }

    public static String[][] generateMatrixPalindromes(int row, int col) { //правим метод за алгоритъм
        String[][] matrix = new String[row][col]; // правим матрица с данните от входа
        char one = 'a';
        char two = 'a';
        char tree = 'a';

        for (int i = 0; i < matrix.length; i++) { // обикаляме редовете
            for (int j = 0; j < matrix[i].length; j++) { // обикаляме колоните
                matrix[i][j] = one + "" + two + "" + tree; //пълним камтрицата с данните
                two++;
            }
            one++; // обръщаме чаровете
            two = one;
            tree = one;
        }
        return matrix; // връщаме резултата
    }

    public static void printMatrix(String[][] matrix) { // принтираме резултата
        for (int i = 0; i < matrix.length; i++) { // обикаляме редовете
            for (int j = 0; j < matrix[i].length; j++) { // обикаляме колоните
                System.out.print(matrix[i][j] + " "); // принтираме резултата
            }
            System.out.println();// празен нов ред
        }
    }
}
