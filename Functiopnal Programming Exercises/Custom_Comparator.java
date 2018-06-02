package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Custom_Comparator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Integer[] numbers = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        Comparator<Integer> custom = Custom_Comparator::compare;

        Arrays.sort(numbers, custom);

        Arrays.stream(numbers).map(number -> number + " ").forEachOrdered(System.out::print);
    }

    private static int compare(Integer o1, Integer o2) {
        int o1Abs = Math.abs(o1);
        int o2Abs = Math.abs(o2);

        if (o1Abs % 2 == 0 && o2Abs % 2 == 1) {
            return -1;
        } else if (o1Abs % 2 == 1 && o2Abs % 2 == 0) {
            return 1;
        } else if (o1 < o2) {
            return -1;
        } else if (o2 < o1) {
            return 1;
        }
        return 0;
    }
}