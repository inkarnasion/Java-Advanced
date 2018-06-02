package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Match_Phone_Number {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        Pattern pattern = Pattern.compile("^\\+359([ -])2\\1\\d{3}\\1\\d{4}$");

        while (! "end".equals(input)){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                System.out.println(matcher.group(0));
            }
            input=reader.readLine();
        }
    }
}
