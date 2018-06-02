package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.function.Function;

public class Custom_Min_Function {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("\\s+");// взимаме входа като масив
        Integer[] number = Arrays.stream(input).map(Integer::parseInt).toArray(Integer[]::new);// правим масив от интове,
        //като ползваме стриим и взимаме входа, мапваме го за да го обърнем в Интиджер,след това го правим на масив
        Function<Integer[], Integer> minNumber = numbers -> Collections.min(Arrays.asList(numbers));//ползваме функция
        System.out.println(minNumber.apply(number));
    }
}