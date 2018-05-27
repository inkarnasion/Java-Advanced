package Set_And_Maps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>(); //задаваме сет за първия играч
        Set<Integer> secondPlayer = new LinkedHashSet<>(); // задаваме сет за вторият играч

        fillNumber(scanner, firstPlayer, secondPlayer);

        if (war(firstPlayer, secondPlayer)) {
            return;
        }
        printResult(firstPlayer, secondPlayer); // принтираме резултата

    }

    private static boolean war(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        for (int i = 0; i < 50; i++) { // въртим цикъл до стойноста която ни трябва
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) { // ако в първият сет няма вече нищо
                System.out.println(firstPlayer.isEmpty() ? "Second player win!" : "First payer win!"); // принтираме
                return true;
            }
            int firstNum = firstPlayer.iterator().next(); // връща стойностите в сета
            firstPlayer.remove(firstNum); // ако има повтарящи се, тогава ги премахваме
            int secondNum = secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);

            if (firstNum > secondNum) { // ако единият е по голям от другият
                firstPlayer.add(firstNum); // добавяме първото число в сета
                firstPlayer.add(secondNum);
            } else if (secondNum > firstNum) {
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }
        }
        return false;
    }


    private static void fillNumber(Scanner scanner, Set<Integer> firstPlayer, Set<Integer> secondPlayer) { // правим изчисленията в отделен метод
        String[] firstPlayerNumbers = scanner.nextLine().split("\\s+"); // правим масиви на които присвояваме стойност от входа
        String[] secondPlayerNumbers = scanner.nextLine().split("\\s+");

        for (String firstPlayerNumber : firstPlayerNumbers) { // обикаляме масива
            firstPlayer.add(Integer.parseInt(firstPlayerNumber)); // добавяме числа в сета
        }
        for (String secondPlayerNumber : secondPlayerNumbers) {
            secondPlayer.add(Integer.parseInt(secondPlayerNumber));
        }
    }

    private static void printResult(Set<Integer> firstPlayer, Set<Integer> secondPlayer) {
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (firstPlayer.size() < secondPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
