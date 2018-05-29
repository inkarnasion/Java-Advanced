package String_Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parse_Tags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = reader.readLine();

        while (input.contains("<upcase>")){
            int start = input.indexOf("<upcase>");
            int end = input.indexOf("</upcase>");
            String subs = input.substring(start + 8, end);
            input = input.replace("<upcase>" + subs + "</upcase>", subs.toUpperCase());
        }
        System.out.println(input);
    }
}