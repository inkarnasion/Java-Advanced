package java_matrix_exercises;

import java.util.Scanner;

public class Matrix_Shuffing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+"); //получаваме данните и ги запазваме като масив

        int row = Integer.parseInt(input[0]);  // пълним редовете с входните данни
        int col = Integer.parseInt(input[1]); // пълним колоните с входните данни

        String[][] result = fillMatrix(row, col, scanner); // правим матрица която е отделена в метод и се пълни с редовете и колоните


        String command = scanner.nextLine(); // получаваме команда като стринг

        CalculateMatrix(scanner, row, col, result, command);
    }

    private static void CalculateMatrix(Scanner scanner, int row, int col, String[][] result, String command) {
        while (!command.equalsIgnoreCase("end")) {  // докато командата е различна от този вход и ползваме методд който игнорира независимо дали е с главни или малки букви

            String[] commandParts = command.split("\\s+"); // правим масив който ще държи командите и взима данните от стринга

             if (commandParts[0].equalsIgnoreCase("swap") && commandParts.length ==5){ // ако първата команда е тази и дължината на командата е равна на 5
                 int row1 = Integer.parseInt(commandParts[1]); // правим променливи на които присвояваме дължината на масива от 1 до 4
                 int col1 = Integer.parseInt(commandParts[2]);
                 int row2 = Integer.parseInt(commandParts[3]);
                 int col2 = Integer.parseInt(commandParts[4]);

                 if (row1>=row || row2 >=row || col1 >=col || col2>= col){ // ако данните от командата са по големи от входните данни
                     System.out.println("Invalid input!"); // принтираме
                 }else { // в противен случай правим променлива която разменя местата на данните
                     String temp = result[row1][col1];
                     result[row1][col1]=result[row2][col2];
                     result[row2][col2]=temp;

                     printMatrix(result); // извикваме метода който принтира резултата

                 }
             }else {
                 System.out.println("Invalid input!"); // в противен случай принтираме
             }
            command=scanner.nextLine(); // извикваме първоначалната команда иначе няма да се отпечата

        }
    }

    private static String[][] fillMatrix(int row, int col, Scanner scanner) { //пълним матрицата
        String[][] matrix = new String[row][col]; // задаваме стойност на матрицата от входовете
        for (int i = 0; i < matrix.length; i++) { //обикаляме редовете
            String[] result = scanner.nextLine().split("\\s+"); // запазваме резултата в масив
            for (int j = 0; j < matrix[i].length; j++) { // обикаляме колоните
                matrix[i][j] = (result[j]); // запазваме резултата

            }

        }
        return matrix;  // връщаме резултата в главният метод
    }

    private static void printMatrix(String[][] matrix) { // принтираме резултата
        for (int i = 0; i < matrix.length; i++) { // обикаляме редовете
            for (int j = 0; j < matrix[i].length; j++) { // обикаляме колоните
                System.out.print(matrix[i][j] + " "); // принтираме резултата
            }
            System.out.println();// празен нов ред
        }

    }
}

