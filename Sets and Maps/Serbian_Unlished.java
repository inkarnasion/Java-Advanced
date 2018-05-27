package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Serbian_Unlished {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String line = reader.readLine(); // променлива за вход

        LinkedHashMap<String, HashMap<String, Long>> userData = new LinkedHashMap<>(); // речник който ще държи данните

        Pattern pattern = Pattern.compile("^(\\D+)\\s@(\\D+)\\s(\\d+)\\s(\\d+)$"); // регекс по който ще сплитваме
        Matcher matcher = pattern.matcher(line); // обеденивяме регекса със входа

        CalculateResult(reader, line, userData, pattern, matcher);  // извикваме метода който прави изчисленията

        PrintResult(userData); // извикваме метода който принтира резултата
    }

    private static void CalculateResult(BufferedReader reader, String line, LinkedHashMap<String, HashMap<String, Long>> userData, Pattern pattern, Matcher matcher) throws IOException {
        while (!line.equals("End")) { // докато входа е различен от тази команда
            //Matcher matcher = pattern.matcher(line); // обеденивяме регекса със входа
            if (matcher.find()) { // ако намери този вход
                String town = matcher.group(2); // придаваме му стойности
                String singer = matcher.group(1);
                long ticketPrice = Long.parseLong(matcher.group(3));// задаваме стойности от входа като го парсваме към число
                long ticketCount = Long.parseLong(matcher.group(4));

                long totalsum = ticketPrice * ticketCount; // променлива за крайната стойност от билетите и продадените такива

                if (!userData.containsKey(town)) { // ако в речника не се съдържа този град
                    userData.put(town, new LinkedHashMap<>()); // добавяме го в речника
                }

                if (!userData.get(town).containsKey(singer)) { // ако в речника има този град
                    userData.get(town).put(singer, 0L); // добавяме певицата и сумата
                    //userData.get(town).get(singer) + totalsum
                }

                Long sum = userData.get(town).get(singer) + totalsum;
                userData.get(town).put(singer, sum); // ги добавяме

                line = reader.readLine(); // четем отново входа
            }
        }
    }

    private static void PrintResult(LinkedHashMap<String, HashMap<String, Long>> userData) {
        userData.forEach((key, value) -> { // обикаляме речника и принтираме
            System.out.println(key); // принтираме града
            value.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // сортираме
                    .forEach(innerPair -> {
                        System.out.printf("#  %s -> %d%n", innerPair.getKey(), innerPair.getValue());
                    });
        });
    }
}