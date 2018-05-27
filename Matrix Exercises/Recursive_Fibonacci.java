package java_matrix_exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Recursive_Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int fibonacciIndex = Integer.parseInt(scanner.nextLine()) + 1;

        Deque<Long> fibonacciNumbers = getFibonacciQueue(fibonacciIndex);

        Long fibonacciAtIndexGiven = fibonacciNumbers.pop();

        System.out.println(fibonacciAtIndexGiven);
    }

    private static Deque<Long> getFibonacciQueue(int fibonacciIndex) {
        if (fibonacciIndex == 1) {
            Deque<Long> fibonacciNumbers = new ArrayDeque<>();
            fibonacciNumbers.push(1L);
            return fibonacciNumbers;
        } else {
            Deque<Long> fibonacciNumbers = getFibonacciQueue(fibonacciIndex - 1);
            Long number = fibonacciNumbers.poll();
            Long previousNumber = fibonacciNumbers.poll();
            if (previousNumber == null) {
                previousNumber = 0L;
            }
            Long nextNumber = number + previousNumber;
            fibonacciNumbers.push(number);
            fibonacciNumbers.push(nextNumber);

            return fibonacciNumbers;
        }
    }
}