package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Miner_Task {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> resources = new LinkedHashMap<>(); // правим речник койт ще държи продуктите и стойностите им


        Resoursed(reader, resources);  /* извикваме метода който прави изчисленията */
        PrintResourced(resources); /* извикваме метода който принтира */

    }

    private static void Resoursed(BufferedReader reader, Map<String, Integer> resources) throws IOException { // метод който прави изчисленията
        while (true) { // докато отговаря следното условие
            String resource = reader.readLine(); // правим променлива която ще вкарва командите за вход, като продукти и команди
            if ("stop".equals(resource)) { // ако командата е тази
                break; // спираме
            }
            int quantity = Integer.parseInt(reader.readLine()); // променлива която ще държи стойностите на продуктите
            if (!resources.containsKey(resource)) { // ако в речника не се съдържа този продукт
                resources.put(resource, 0); // добавяме в речника, на нулева позиция и цикъла се завърта отново
            }
            resources.put(resource, resources.get(resource) + quantity); // добавяме в речника продуктите плюс цифрите
        }
    }

    private static void PrintResourced(Map<String, Integer> resources) { // метод който принтира резултата
        for (Map.Entry<String, Integer> entry : resources.entrySet()) { // обикаляме речника
            System.out.println(entry.getKey() + " -> " + entry.getValue()); // принтираме имената и стойностите
        }
    }
}
