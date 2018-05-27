package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hands_of_cards {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        CardFill cardFill = new CardFill().invoke(); // метод който извиква типовете карти
        Map<String, Integer> types = cardFill.getTypes();
        Map<String, Integer> powers = cardFill.getPowers();

        Map<String, Set<String>> players = new LinkedHashMap<>(); // речник който ще пази играчите


        while (true) { // докато е вярно следното условие
            String line = reader.readLine(); // променлива която ще въвежда входовете
            if ("JOKER".equals(line)) { // ако входа е този
                break; // тогава прекъсваме цикъла
            }

            String[] tokens = line.split(":\\s"); // масив който ще държи входовете
            String name = tokens[0]; // променлива за имената която взима първият вход
            String[] cardTokens = tokens[1].split(",\\s"); // масив за данните на картите от вторият вход

            Set<String> cards = new HashSet<>();// сет за картите

            Collections.addAll(cards, cardTokens);// вкарваме в сета командите

            if (players.containsKey(name)) { // ако в речника има такова име
                Set<String> previousCards = players.get(name); // го слагаме в нов сет
                previousCards.addAll(cards);// след което го добавяме в сета с карти
            } else { //ако името го няма в реччника
                players.put(name, cards); // добавяме го в сета
            }
        }

        players.forEach((key, value) -> { //обикаляме цялата колекция и принтираме
            int totalCardsStrength = 0;
            for (String card : value) {
                String power = card.substring(0, card.length() - 1);
                String type = String.valueOf(card.charAt(card.length() - 1));
                totalCardsStrength += computeCardStrength(power, type, types, powers);
            }
            System.out.printf("%s: %d%n", key, totalCardsStrength);
        });
    }

    private static int computeCardStrength(String power, String type, Map<String, Integer> types, Map<String, Integer> powers) {
        int resultPower;
        try {
            resultPower = Integer.parseInt(power);
        } catch (NumberFormatException nfe) {
            resultPower = powers.get(power);
        }
        return types.get(type) * resultPower;
    }

    private static class CardFill {
        private Map<String, Integer> types;
        private Map<String, Integer> powers;

        public Map<String, Integer> getTypes() {
            return types;
        }

        public Map<String, Integer> getPowers() {
            return powers;
        }

        public CardFill invoke() {
            types = new HashMap<>() {{
                put("S", 4);
                put("H", 3);
                put("D", 2);
                put("C", 1);
            }};

            powers = new HashMap<>() {{
                put("J", 11);
                put("Q", 12);
                put("K", 13);
                put("A", 14);
            }};
            return this;
        }
    }
}