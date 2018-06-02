package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class List_Of_Predicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split("\\s+");
        Set<Integer> divisible = Arrays.stream(numbers).map(Integer::parseInt).collect(Collectors.toSet());

        Predicate<Integer> predicate = (number) -> divisible.stream().noneMatch(divisor -> number % divisor != 0);

        String sb = IntStream.rangeClosed(1, n).filter(predicate::test).mapToObj(i -> i + " ").collect(Collectors.joining());

        System.out.println(sb.trim());
    }
}