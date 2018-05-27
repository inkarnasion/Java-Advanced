package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Dragon_Army {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, TreeMap<String, long[]>> dictionary = new LinkedHashMap<>(); //речник който ще пази данните


        Calculating(reader, dictionary);

        SortAndPrintResult(dictionary);
    }

    private static void Calculating(BufferedReader reader, Map<String, TreeMap<String, long[]>> dictionary) throws IOException {
        int n = Integer.parseInt(reader.readLine()); // променлива която ще дава бройката на играчите
        for (int i = 0; i < n; i++) { // въртим до бройката зададена от входа
            String[] commandArgs = reader.readLine().split("\\s+"); // масив който ще държи данните за играчите

            String type = commandArgs[0]; // променлива за типа която взима от първият елемент на входа
            String name = commandArgs[1]; // променлива за името която взима от вторият елемент на входа


            if (commandArgs[2].equals("null")) { // ако damage е равен на този вход
                commandArgs[2] = "45"; // сменяме стойноста
            }

            if (commandArgs[3].equals("null")) { // ако health  е равен на този вход
                commandArgs[3] = "250"; // сменяме стойноста
            }

            if (commandArgs[4].equals("null")) { // ако armor  е равен на този вход
                commandArgs[4] = "10"; // сменяме стойноста
            }

            long damage = Long.parseLong(commandArgs[2]); // задаваме име на командите които получаваме от входа
            long health = Long.parseLong(commandArgs[3]);
            long armor = Long.parseLong(commandArgs[4]);

            if (!dictionary.containsKey(type)) { // ако в речника нямаме от този тип
                dictionary.put(type, new TreeMap<>()); //добавяме го в речника
            }
            dictionary.get(type).put(name, new long[3]); // в противен случай сменяме стойностоите

            dictionary.get(type).get(name)[0] = damage;
            dictionary.get(type).get(name)[1] = health;
            dictionary.get(type).get(name)[2] = armor;
        }
    }

    private static void SortAndPrintResult(Map<String, TreeMap<String, long[]>> dictionary) {
        dictionary.entrySet().forEach(type -> {
            String typeName = type.getKey();
            final double[] averageDamage = {0.0};
            final double[] averageHealth = {0.0};
            final double[] averageArmor = {0.0};
            dictionary.get(typeName).forEach((key, value) -> {
                averageDamage[0] += value[0];
                averageHealth[0] += value[1];
                averageArmor[0] += value[2];


            });
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", typeName, averageDamage[0] / type.getValue().size(),
                    averageHealth[0] / type.getValue().size(), averageArmor[0] / type.getValue().size());
            for (Map.Entry<String, long[]> dragon : type.getValue().entrySet()) {
                String dragonName = dragon.getKey();

                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n", dragonName, dragon.getValue()[0],
                        dragon.getValue()[1], dragon.getValue()[2]);
            }
        });
    }
}