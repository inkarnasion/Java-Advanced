package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Count_Substring_Occurrences {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String upperCase = reader.readLine().toUpperCase();
        String lowerCase = reader.readLine().toLowerCase();

        int counter = (int) IntStream.range(0, upperCase.length() - lowerCase.length() + 1)
                .filter(index -> upperCase
                        .substring(index, index + lowerCase.length())
                        .toLowerCase()
                        .equals(lowerCase)).count();

        System.out.println(counter);
    }
}