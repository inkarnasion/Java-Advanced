package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Unicode_Characters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String input = reader.readLine();
        StringBuilder result = new StringBuilder("");

        IntStream.range(0, input.length())
                .forEachOrdered(i -> result.append("\\u")
                        .append(Integer.toHexString(input.charAt(i) | 0x10000)
                                .substring(1)));

        System.out.println(result);
    }
}