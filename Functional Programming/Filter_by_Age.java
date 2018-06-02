package Functional_Programming;

import com.sun.javafx.tools.packager.MakeAllParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Filter_by_Age {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Integer> people = new LinkedHashMap<>();

        int count = Integer.parseInt(reader.readLine());

        while (count -->0){
            String[] input = reader.readLine().split(", ");
            people.putIfAbsent(input[0],Integer.parseInt(input[1]));
        }
        String condition = reader.readLine();
        int ageCondition = Integer.parseInt(reader.readLine());
        String format = reader.readLine();

        Predicate<Integer> test = x-> x < ageCondition;

        BiFunction<String,Predicate<Integer>,Predicate<Integer>> func = (a,b)->{
            if ("younger".equals(a)){
                return b;
            }else {
                return b.negate();
            }
        };

        BiConsumer<String,Map.Entry<String,Integer>> printer=(a1, b1)->{
            switch (a1){
                case "name":
                    System.out.printf("%s%n",b1.getKey());
                    break;
                case "age":
                    System.out.printf("%s%n",b1.getValue());
                    break;
                case "name age":
                    System.out.printf("%s - %d%n",b1.getKey(), b1.getValue());
                    break;

            }
        };
        for (Map.Entry<String, Integer> entry : people.entrySet()) {
            if (func.apply(condition,test).test(entry.getValue())){
                printer.accept(format, entry);
            }
        }
    }
}
