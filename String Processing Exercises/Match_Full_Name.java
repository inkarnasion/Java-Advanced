package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match_Full_Name {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine(); // стринг вход
        Pattern pattern = Pattern.compile("^[A-Z][a-z]+ [A-Z][a-z]+$"); // патерн който да държи регекса

        while (!"end".equals(text)){ //докато е различно от този вход
            Matcher matcher =pattern.matcher(text); // обединяваме входа с регекса
           if (matcher.find()){ // ако открием този вход
               System.out.println(matcher.group(0)); // принтираме
           }
           text=reader.readLine(); // четем отново входа за следващо завъртане на цикъла

        }

    }
}
