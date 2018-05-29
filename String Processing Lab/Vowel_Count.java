package String_Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowel_Count {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); // променлива за входа

        Pattern pattern = Pattern.compile("[AEIOUYaeiouy]"); // метод който пази регекса по който ще сплитваме
        Matcher matcher = pattern.matcher(input); // мертод който вкарва текста в метода патерн и така текста е сплитнат по регекса

        int count = 0; // променлива за бройките букви
        while (matcher.find()){ // докато има съвпадения в буквите
            count++; // уввеличаваме ги с една бройка
        }
        System.out.println("Vowels: " + count); // принтираме
    }
}
