package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Sum_Big_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstInput = reader.readLine();
        String secondInput = reader.readLine();

        BigInteger sum = new BigInteger(firstInput).add(new BigInteger(secondInput));
        System.out.println(sum);
    }
}
