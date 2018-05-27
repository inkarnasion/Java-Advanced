package java_matrix_exercises;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Maximum_elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> commands = new ArrayDeque<>();
        ArrayDeque<Integer> typeOfElements = new ArrayDeque<>();

        CalculateElements(scanner, number, commands, typeOfElements);
    }

    private static void CalculateElements(Scanner scanner, int number, ArrayDeque<Integer> commands, ArrayDeque<Integer> typeOfElements) {
        IntStream.range(0, number).mapToObj(i -> scanner.nextLine()).forEach(input -> {
            if (input.length() == 1) {
                if (input.equals("2")) {
                    if (!commands.isEmpty()) {
                        typeOfElements.remove(commands.peek());
                        commands.pop();
                    }
                } else if (input.equals("3")) {
                    System.out.println(typeOfElements.peek());
                }
            } else {
                if (input.split(" ")[0].equals("1")) {
                    int num = Integer.parseInt(input.split(" ")[1]);
                    commands.push(num);
                    if (typeOfElements.isEmpty() || typeOfElements.peek() <= num) {
                        typeOfElements.push(num);
                    } else {
                        typeOfElements.addLast(num);
                    }
                }
            }
        });
    }
}
