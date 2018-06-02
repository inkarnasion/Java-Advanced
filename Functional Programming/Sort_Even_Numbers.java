package Functional_Programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

import java.util.List;

import java.util.stream.Collectors;

public class Sort_Even_Numbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> numbers = Arrays.stream(reader.readLine()
                .split(", "))
                .map(Integer::parseInt).collect(Collectors.toList());

        numbers.removeIf(e->e % 2 !=0);

        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));

        numbers.sort(Integer::compareTo); // и трите метода правят едно и също
        // numbers.sort((a,b)->a.compareTo(b));
        //numbers.sort(Comparator.naturalOrder());


        StringBuilder sb = new StringBuilder();

        numbers.forEach(num->sb.append(", "));
        System.out.println(numbers.toString().replaceAll("[\\[\\]]", ""));
    }
}
