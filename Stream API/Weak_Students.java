package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Weak_Students {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        Set<String> students = new LinkedHashSet<>();

        while (true){
            String input = reader.readLine();
            if("END".equals(input)){
                break;
            }
            students.add(input);
        }
        for (String a : students) {
            if (Arrays.stream(a.split("\\s+"))
                    .filter(b -> b.equals("3") || b.equals("2"))
                    .toArray().length > 1) {
                System.out.println(a.split("\\s+")[0] + " " + a.split("\\s+")[1]);
            }
        }
    }
}