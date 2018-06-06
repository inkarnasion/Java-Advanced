package Stream_API_exercises;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Students_by_First_and_Last_Name_exercises {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<Pair<String, String>> students = new ArrayList<>();

        String line;
        while (true) {
            if ("END".equals(line = reader.readLine())) {
                break;
            }

            String[] tokens = line.split("\\s+");//пазим входните данни

            String firstName = tokens[0];//взимаме първото име
            String lastName = tokens[1]; // взимаме фамилията

            Pair<String, String> student = new Pair<>(firstName, lastName); // лист който взима данните от входа

            students.add(student); // добавяме в листа който пази всичките данни
        }

        students.stream() // сравняваме и принтираме
                .filter(s -> s.getValue().compareTo(s.getKey()) > 0)
                .forEach(s -> System.out.println(String.format("%s %s", s.getKey(), s.getValue())));
    }
}