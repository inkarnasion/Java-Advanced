package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.IntStream;

public class Students_by_Enrollment_Year {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        LinkedHashMap<String, List<Integer>> students = new LinkedHashMap<>(); //речник който ще пази имената и оценките

        while (true) {
            String input = reader.readLine(); // променлива за вход
            if ("END".equals(input)) { // ако входа е това
                break; // прекъсваме операцията
            }
            String[] marks = input.split("\\s+"); // масив който взима от входа
            String facultyNumber = marks[0]; // променлива с първи елемент от масива
            students.put(facultyNumber, new ArrayList<>()); // вкарваме в речника имената и данните
            IntStream.range(1, marks.length)// почваме от първи елемент до дължината на масива
                    .forEachOrdered(i -> students.get(facultyNumber)
                            .add(Integer.parseInt(marks[i])));
        }
        students.entrySet()
                .stream()
                .filter(x -> x.getKey()
                        .endsWith("14")
                        || x.getKey()
                        .endsWith("15"))
                .forEach(x -> {
                    x.getValue()
                            .stream()
                            .map(integer -> integer + " ")
                            .forEachOrdered(System.out::print);
                    System.out.println();
                });
    }
}