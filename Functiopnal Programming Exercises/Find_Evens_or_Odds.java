package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Find_Evens_or_Odds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        PrintOddOrEven(input, "even".equals(reader.readLine()) ? 0 : 1);
    }

    private static void PrintOddOrEven(int[] input, int rest) {

        Predicate<Integer> isEven = number -> Math.abs(number% 2) == rest;
        IntStream.rangeClosed(input[0], input[1]).filter(isEven::test).mapToObj(i -> i + " ").forEachOrdered(System.out::print);
    }
}