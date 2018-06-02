package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extract_Emails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); //взимаме входа
        Pattern pattern = Pattern.compile("(^| )([a-zA-Z0-9]+([-_.]*[a-zA-Z0-9]+)*@[a-zA-Z]+(-[a-zA-Z]+)*(\\.[a-zA-Z]+(-[a-zA-Z]+)*)+)(| |$)");
        // патерн който дърржи регекса
        Matcher matcher = pattern.matcher(input);// метод който обединява входа с регвкса

        while (matcher.find()) { // ако имаме съвпадение
            System.out.println(matcher.group(0)); // принтираме резултата в група с нулев индекс
        }
    }
}