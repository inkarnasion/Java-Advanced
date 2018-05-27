package Set_And_Maps;

import java.util.HashSet;
import java.util.Scanner;

public class Parking_Lot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); // правим стринг за вход който е за командите

        HashSet<String> cars = new HashSet<>(); // правим сет в който ще държим данните за колите

        Calculate(scanner, input, cars);

        PrintResult(cars);
    }

    private static void Calculate(Scanner scanner, String input, HashSet<String> cars) {
        while (!input.equals("END")) { // докато входа е различен
            String[] tokens = input.split(", "); // правим масив в който вкарваме данните от входа

            if (tokens[0].equals("IN")) { // ако масива с нулев индекс е равен на командата
                cars.add(tokens[1]); // добавяме кола в сета
            } else {
                cars.remove(tokens[1]); // в противен случай я премахваме
            }
            input = scanner.nextLine(); // след цялата логика четем следващата линия от входа, и така цикъла се завърта отново
        }
    }
    private static void PrintResult(HashSet<String> cars) {
        if (cars.isEmpty()) { // ако няма коли в сета
            System.out.println("Parking Lot is Empty"); // принтираме
        } else {
            for (String aList : cars) { // минаваме с форийч през сета
                System.out.println(aList); // принтираме
            }
        }
    }

}

