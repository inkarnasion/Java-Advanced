package java_matrix_exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Reverce_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] numbers=scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> reversed = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            reversed.push(Integer.parseInt(numbers[i]));

        }
        while (reversed.size()> 0){
            System.out.print(reversed.pop()+ " ");
        }
    }
}
