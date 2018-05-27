package Set_and_Map_exercises;

        import java.util.*;

public class Periodic_Table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine()); // приемаме число за вход от конзолата
        Set<String> input = new TreeSet<>(); // задаваме сет който ще държи буквите

        for (int i = 0; i < number; i++) { // въртим цикъл до дължимната на числата
            Collections.addAll(input, scanner.nextLine().split("\\s+")); // правим колекция в която вкарваме
            // Сета и скенер за да получава нов ред на всяка итерация на цикъла като го сплитваме по празен спейс
        }

        for (String ordered : input) { // въртим по колекцията от букви
            System.out.print(ordered + " "); // принтираме на един ред
        }
    }
}
