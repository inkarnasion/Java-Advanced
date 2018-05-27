package Set_and_Map_exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Count_Symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char [] input = scanner.nextLine().toCharArray(); // правим масив орт чарове за вход

        Map<Character,Integer> symbol = new TreeMap<>(); // правим речник в който ще държим чаровете, както и колко пъти се срещат

        for (char line : input) { // въртим цикъл по входа
            if (! symbol.containsKey(line)){ // ако символа липсва в речника
                symbol.put(line,0); // то тогава го добавяме  със нулева начална стойност
            }
            symbol.put(line,symbol.get(line)+ 1); // след като сме взели вече началната стойност, отново му задаваме
            // стойност плюс всеки чар увеличен с едно на всяка итерация
        }
        for (Character character : symbol.keySet()) { // въртим цикъл по уникалните ключове в речника
            System.out.println(character + ": " + symbol.get(character)+ " time/s");
        }
    }
}
