package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class User_log {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        TreeMap<String, LinkedHashMap<String, Integer>> userLogs = new TreeMap<>();//речник който ще държи данните за потребителя

        UserLogLogik(reader, userLogs); //извикваме метода който прави изчисленията
        PrintResult(userLogs); // извикваме метода който принтира

    }

    private static void UserLogLogik(BufferedReader reader, TreeMap<String, LinkedHashMap<String, Integer>> userLogs) throws IOException {
        while (true) { // докато е вярно условието
            String input = reader.readLine(); // променлива за входа
            if ("end".equals(input)) { // ако входа отговаря на това
                break; // прекъсваме цикъла
            }

            String[] tokens = input.split("\\s+"); // масив който ще държи данните от входа
            String name = tokens[2].split("=")[1]; // променлива за имената която взима индекса за  името и го сплитва по знака
            String ip = tokens[0].split("=")[1];// променлива за айпи адресите която взима индекса за айпи то и го сплитва по знака

            LinkedHashMap<String, Integer> user = new LinkedHashMap<>(); // правим нов речник който ще държи данните

            if (!userLogs.containsKey(name)) { // ако в масива не съществува такова име
                user.put(ip, 1); // слагаме в него данните за айпи тата, като почваме от първо завъртане защото вече сме имали едно
                userLogs.put(name, user); // накрая добавяме данните за имената и айпитата в общият речник
            } else { // в противен случай
                if (!userLogs.get(name).containsKey(ip)) {// ако в речника няма това име със това айпи
                    userLogs.get(name).put(ip, 1); // добавяме ги в речника на първо завъртане на цикъла
                } else {
                    userLogs.get(name).replace(ip, userLogs.get(name).get(ip) + 1); // ако имената и данните съществуват тогава ги заместваме с новите
                }
            }
        }
    }

    private static void PrintResult(TreeMap<String, LinkedHashMap<String, Integer>> userLogs) {
        for (String s : userLogs.keySet()) { // обикаляме речника
            System.out.println(s + ":"); // принтираме името
            StringBuilder output = new StringBuilder(); // правим си променлива от тип
            for (String s1 : userLogs.get(s).keySet()) { // обикаляме речника и взимаме стойностите
                output.append(s1).append(" => ").append(userLogs.get(s).get(s1)).append(", "); // долепяме двете стойности
            }
            System.out.println(output.substring(0, output.length() - 2) + "."); // принтираме, като изрязваме от нулевият елемент, до предпоследните два знака
        }
    }
}