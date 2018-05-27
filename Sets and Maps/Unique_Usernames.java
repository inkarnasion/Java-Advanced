package Set_and_Map_exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Unique_Usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());// взимаме числа за вход
        Set<String> names = new LinkedHashSet<>(); // получаваме имена

        for (int i = 0; i <number ; i++) { // въртим до числата
            String input = scanner.nextLine(); // нова променлива която да взима нов ред след всяко завъртане
            names.add(input); // добавяме имената
        }
            for (String name : names) { // въртим цикъл през сета
                System.out.println(name);


        }
    }
}
