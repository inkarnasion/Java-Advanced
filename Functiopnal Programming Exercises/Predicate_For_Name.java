package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;

public class Predicate_For_Name {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int number = Integer.parseInt(reader.readLine()); //вкарваме входа от числа
        String[] input = reader.readLine().split("\\s+");// масив с думите
        Predicate<String> predicate = a -> a.length() <= number; //ако дължината на думете е по малка или равна на числото от входа
        Arrays.stream(input).filter(predicate).forEachOrdered(System.out::println);// ползваме стрийм, филтрираме всички думи от Предикейда,
        //правим им форийч подреден азбучно, и принтираме
    }
}