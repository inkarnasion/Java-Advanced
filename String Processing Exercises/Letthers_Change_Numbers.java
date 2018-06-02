package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Letthers_Change_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("\\s+");
        Double sum = 0.0;
        Character[] alphabet = {' ','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

        for (int i = 0, inputLength = input.length; i < inputLength; i++) {
            String anInput = input[i];
            Character first = anInput.charAt(0);
            Character last = anInput.charAt(anInput.length() - 1);
            Double number = Double.parseDouble(anInput.substring(1, anInput.length() - 1));
            number = Character.isUpperCase(first) ? number / Arrays.asList(alphabet).indexOf(Character.toLowerCase(first)) : number * Arrays.asList(alphabet).indexOf(Character.toLowerCase(first));
            number = Character.isUpperCase(last) ? (number - Arrays.asList(alphabet).indexOf(Character.toLowerCase(last))) : (number + Arrays.asList(alphabet).indexOf(Character.toLowerCase(last)));
            sum += number;
        }

        System.out.printf("%.2f",sum);
    }
}