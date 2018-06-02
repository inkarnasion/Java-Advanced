package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Find_The_Smallest_Element {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int min = numbers[0];
        int smallest = 0;
        int index = 0;
        while (index < numbers.length) {
            if (numbers[index] <= min) {
                min = numbers[index];
                smallest = index;
            }
            index++;
        }
        System.out.println(smallest);
    }
}