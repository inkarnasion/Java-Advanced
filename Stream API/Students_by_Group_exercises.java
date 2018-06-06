package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Students_by_Group_exercises {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> students = new ArrayList<>();// пазим данните за студентите в лист

        while (true){ // докато е вярно
            String[] input = reader.readLine().split("\\s+"); // масив който ще подава информацията
            if("END".equals(input[0])){ //ако командата е това
                break; // прекъсваме
            }
            if("2".equals(input[2])){ // ако командата е това
                students.add(input[0] + " " + input[1]); // добавяме в листа имената
            }
        }
        students.stream().sorted(Comparator.comparing(a -> a.split("\\s+")[0])).forEach(System.out::println);

        // сортираме като а отива в а като го сплитваме и взимаме името от входа, и принтираме
    }
}