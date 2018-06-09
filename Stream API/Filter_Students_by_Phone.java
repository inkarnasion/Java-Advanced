package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Filter_Students_by_Phone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> dict = new LinkedHashMap<>();

        while (true) {
            String line = reader.readLine();
            if (line.equals("END")) {
                break;
            }
            String[] vhod = line.split(" ");
            String name = vhod[0] + " " + vhod[1];
            String telephone = vhod[2];
            dict.put(name, telephone);
        }
        dict.entrySet().stream().filter(x -> x.getValue().startsWith("02")
                || x.getValue().startsWith("+3592"))

                .forEach(x -> System.out.println(x.getKey()));
    }
}