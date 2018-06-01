package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("[ ,.?!]"); //Масив който приема входа и сплитваме по регекс
        TreeSet<String> palindromes = new TreeSet<>(String.CASE_INSENSITIVE_ORDER); // речник който ще държи резултата.

        Arrays.stream(input).forEachOrdered(text -> {// ползваме стриим за да отворим поток, после използваме ламбда
            String reversed = new StringBuilder(text).reverse().toString(); // правим нова променлива която чрез стринг билдър я ревърсваме
            if (text.equals(reversed) && !text.equals("")) {//ако входа е еднакъв с променливата
                palindromes.add(text); // вкарваме резултата в мапа
            }
        });

        System.out.println(palindromes); //принтираме
    }
}