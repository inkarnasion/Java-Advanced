package Functional_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Count_Uppercase_Words {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        Predicate<String> testUpperCase = word->{
          return   word.charAt(0)==word.toUpperCase().charAt(0);

        };
        List<String> upperCaseWord = new ArrayList<>();
        for (String word : input) {
            if (testUpperCase.test(word)){
                upperCaseWord.add(word);
            }
        }
        System.out.println(upperCaseWord.size());
        upperCaseWord.forEach(word-> System.out.println(word));
    }
}
