package Stack_and_Queues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class reverse_string_lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // взимаме входа

        ArrayDeque<Character> reversed = new ArrayDeque<>(); // правим го на стек

        for (Character character : input.toCharArray()) { // обикаляме с форийч, но не може да се форйчва чар, за това се ползва инпута

            reversed.push(character); // пъаме всеки чар във масива.

        }
        while (! reversed.isEmpty()){ //докато стека не се окаже празен
            System.out.print(reversed.pop()); //тогава принтираме
        }


    }
}
