package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence_Extractor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = reader.readLine(); // взимаме първият вход
        String secondInput = reader.readLine();// взимаме вторият вход

        Pattern pattern = Pattern.compile("(^| )[^!.?]*\\b" + firstInput + "\\b.*?[.!?]");// правим патерн с регекс и слагаме в него първият вход

        Matcher matcher = pattern.matcher(secondInput);// мачваме вторият вход с регекса

        while (matcher.find()){ // ако имамме съвпадение
            System.out.println(matcher.group(0).trim()); // принтираме
        }
    }
}
