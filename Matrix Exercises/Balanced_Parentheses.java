package java_matrix_exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        char[] parenthesis = scanner.nextLine().toCharArray();

        Deque<Integer> roundParenthesis = new ArrayDeque<>();
        Deque<Integer> squareParenthesis = new ArrayDeque<>();
        Deque<Integer> curlyParenthesis = new ArrayDeque<>();

        if (FillDequeue(parenthesis, roundParenthesis, squareParenthesis, curlyParenthesis)) return;

        PrintDequeue(roundParenthesis, squareParenthesis, curlyParenthesis);
    }

    private static boolean FillDequeue(char[] parenthesis, Deque<Integer> roundParenthesis, Deque<Integer> squareParenthesis, Deque<Integer> curlyParenthesis) {
        int endIndex = 0;
        while (endIndex < parenthesis.length) {
            char parenthesi = parenthesis[endIndex];
            Integer startIndex = -1;
            if (parenthesi == '{') {
                curlyParenthesis.push(endIndex);
            } else if (parenthesi == '[') {
                squareParenthesis.push(endIndex);
            } else if (parenthesi == '(') {
                roundParenthesis.push(endIndex);
            } else if (parenthesi == '}') {
                startIndex = curlyParenthesis.poll();
                if (startIndex == null || (startIndex + endIndex) % 2 != 1) {
                    System.out.println("NO");
                    return true;
                }

            } else if (parenthesi == ']') {
                startIndex = squareParenthesis.poll();
                if (startIndex == null || (startIndex + endIndex) % 2 != 1) {
                    System.out.println("NO");
                    return true;
                }

            } else if (parenthesi == ')') {
                startIndex = roundParenthesis.poll();
                if (startIndex == null || (startIndex + endIndex) % 2 != 1) {
                    System.out.println("NO");
                    return true;
                }

            }
            endIndex++;
        }
        return false;
    }

    private static void PrintDequeue(Deque<Integer> roundParenthesis, Deque<Integer> squareParenthesis, Deque<Integer> curlyParenthesis) {
        System.out.println(roundParenthesis.isEmpty() && squareParenthesis.isEmpty() && curlyParenthesis.isEmpty() ? "YES" : "NO");
    }
}