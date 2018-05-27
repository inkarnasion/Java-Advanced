package java_matrix_exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Basic_Stack_Operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] firstInput=scanner.nextLine().split("\\s+");
        String [] secondInput = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        int numberOfElements = Integer.parseInt(firstInput[0]);
        int pops = Integer.parseInt(firstInput[1]);
        int target = Integer.parseInt(firstInput[2]);
        for (int i = 0; i < numberOfElements; i++) {
            stack.push(secondInput[i]);
        }
        for (int i = 0; i < pops; i++) {
            stack.pop();
        }

        PrintStack(stack, target);
    }

    private static void PrintStack(ArrayDeque<String> stack, int target) {
        if(stack.contains(Integer.toString(target))) {
            System.out.println(stack.contains(Integer.toString(target)));
        } else if(stack.isEmpty()){
            System.out.println("0");
        } else {
            int minNumber = Integer.MAX_VALUE;
            for (String element: stack) {
                if(Integer.parseInt(element) < minNumber){
                    minNumber = Integer.parseInt(element);
                }
            }
            System.out.println(minNumber);
        }
    }
}
