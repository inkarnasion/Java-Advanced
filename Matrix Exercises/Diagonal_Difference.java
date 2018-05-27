package java_matrix_exercises;

import java.util.Scanner;

public class Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine()); //въвеждаме входни числа

        int[][] matrix = new int[input][input]; //правим матрица в която ще държим входните данни

        FillMattrix(scanner, input, matrix);
        int firstDiagonal = 0; // променливи за диагоналите
        int secondDiagonal = 0;

        firstDiagonal = DownDiagonal(matrix, firstDiagonal);
        secondDiagonal = UpDiagonal(matrix, secondDiagonal);

        int sum = Math.abs(firstDiagonal-secondDiagonal);// сумираме като използваме метод за абсолютна стойност
        System.out.println(sum); // принтираме
    }

    private static int UpDiagonal(int[][] matrix, int secondDiagonal) {
        for (int up = matrix.length-1; up >=0; up--) {// въртим по другият диагонал нагоре със намаляващ цикъл
            secondDiagonal += matrix[up][matrix.length-1 - up]; //въртим до -1 защото иначе ще излезе извън границите
        }
        return secondDiagonal;
    }

    private static int DownDiagonal(int[][] matrix, int firstDiagonal) {
        for (int down = 0; down <matrix.length ; down++) {// въртим по диагоналите надолу
            firstDiagonal += matrix[down][down]; // попълваме данните в променлива

        }
        return firstDiagonal;
    }

    private static void FillMattrix(Scanner scanner, int input, int[][] matrix) {
        for (int row = 0; row < input; row++) { //обикаляме редовете
            String[] line = scanner.nextLine().split("\\s+"); //запазваме данните в масив
            for (int col = 0; col < input; col++) { //обикаляме колоните
                matrix[row][col] = Integer.parseInt(line[col]); // въвеждаме вече попълнените редове и колони
            }

        }
    }
}


