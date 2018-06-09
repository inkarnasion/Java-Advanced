package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Excellent_Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,List<Integer>> students=new LinkedHashMap<>();

        while (true){
            String input = reader.readLine();
            if ("END".equals(input)){
                break;
            }
            String[] inputName = input.split("\\s+");
            String name = inputName[0] + " " + inputName[1];
            students.put(name,new ArrayList<>());
            IntStream.range(2, inputName.length)
                    .forEachOrdered(i -> students.get(name)
                            .add(Integer.parseInt(inputName[i])));
        }
        students.entrySet()
                .stream()
                .filter(x->x.getValue()
                        .contains(6))
                .forEach(x-> System.out.println(x.getKey()));

    }
}
