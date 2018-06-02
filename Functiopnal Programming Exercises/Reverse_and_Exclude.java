package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Reverse_and_Exclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int divisible = Integer.parseInt(reader.readLine());
        int[] result = Arrays.stream(numbers).filter(a ->  Math.abs(a % divisible) > 0).toArray();
        IntStream.iterate(result.length - 1, i -> i >= 0, i -> i - 1).mapToObj(i -> result[i] + " ").forEachOrdered(System.out::print);
    }
}