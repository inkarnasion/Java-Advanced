package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Students_by_Age_exercises {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        LinkedHashMap<String, Integer> students = new LinkedHashMap<>();

        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("END".equals(input[0])) {
                break;
            }
            students.put(input[0] + " " + input[1], Integer.valueOf(input[2]));
        }
        for (Map.Entry<String, Integer> a : students.entrySet()) {
            if (a.getValue() >= 18 && a.getValue() <= 24) {
                System.out.println(a.getKey() + " " + a.getValue());
            }
        }
    }
}