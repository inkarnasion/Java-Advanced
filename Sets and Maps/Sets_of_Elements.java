package Set_and_Map_exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Sets_of_Elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+"); //правим масив за водхните данни

        Set<String> firstSet = SetElementCalculation(scanner, input); // извикваме метода който прави изчисленията

        PrintCalculation(firstSet); // извикваме метода който принтира
    }

    private static Set<String> SetElementCalculation(Scanner scanner, String[] input) { // метод който изчислява
        
        int n = Integer.parseInt(input[0]); // нова променлива за сравняване която взима нулевият елемент от масива
        int m = Integer.parseInt(input[1]); // променлива която взима първият елемент от масива

        Set<String> firstSet = new LinkedHashSet<>(); //взимаме стойности за първият сет
        Set<String> secondSet = new LinkedHashSet<>(); // вторият сет

        for (int i = 0; i < n + m; i++) { // въртим цикъл докато стигне сбора от входните данни
            if (i < n) { // ако цикъла е по малък от числото
                firstSet.add(scanner.nextLine()); // добавяме нов ред
            } else {
                secondSet.add(scanner.nextLine());
            }
        }
        firstSet.retainAll(secondSet); // обединява числата от входа и оставя само тези които са еднакви
        return firstSet; //връща резултата от метода
    }

    private static void PrintCalculation(Set<String> firstSet) { // метод който принтира резултата
        for (String names : firstSet) {
            System.out.print(names + " ");
        }
    }
}
