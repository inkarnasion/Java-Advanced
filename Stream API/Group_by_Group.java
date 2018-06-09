package Stream_API_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Group_by_Group {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        LinkedHashMap<Integer, List<String>> persons = new LinkedHashMap<>();


        while (true) {
            String[] input = reader.readLine().split("\\s+");
            if ("END".equals(input[0])) {
                break;
            }
            String name = input[0] + " " + input[1];
            int group = Integer.valueOf(input[2]);
            if (persons.containsKey(group)) {
                persons.get(group).add(name);
            } else {
                List<String> groupName = new ArrayList<>();
                groupName.add(name);
                persons.put(group, groupName);
            }
        }
        SortAndPrintResult(persons);

    }

    private static void SortAndPrintResult(LinkedHashMap<Integer, List<String>> persons) {
        List<Map.Entry<Integer, List<String>>> sorted = new ArrayList<>();
        sorted.addAll(persons.entrySet());
        sorted.sort(Map.Entry.comparingByKey(Integer::compareTo));
        sorted.stream().map(entry -> new StringBuilder()
                .append(entry.getKey()).append(" - ")
                .append(Arrays.toString(entry.getValue().toArray())
                        .replace("[", "")
                        .replace("]", "")).toString())
                .forEach(System.out::println);
    }
}