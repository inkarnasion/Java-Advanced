package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Sort_Students {
     public static void main(String[] args) throws IOException {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

         HashSet<String> students = new HashSet<>();

         while (true){
             String input = reader.readLine();
             if("END".equals(input)){
                 break;
             }
             students.add(input);
         }
         students.stream().sorted(Sort_Students::compare).forEach(System.out::println);
     }

    private static int compare(String a, String b) {
        return a.split(" ")[1]
                .compareTo(b.split(" ")[1]) == 0 ? b.split(" ")[0]
                .compareTo(a.split(" ")[0]) : a.split(" ")[1]
                .compareTo(b.split(" ")[1]);
    }
}
