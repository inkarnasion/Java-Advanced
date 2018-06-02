package Functional_Programming_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicate_Party {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<String> guestList = Arrays.stream(reader.readLine().split(" ")).collect(Collectors.toList());

        String[] commandLine = reader.readLine().split(" ");

        while (!"Party!".equals(commandLine[0])) {
            String command = commandLine[0];
            Predicate<String> validate = getPredicate(commandLine);

            if ("Remove".equals(command)) {
                guestList.removeIf(validate);

            } else if ("Double".equals(command)) {
                List<String> temp = new ArrayList<>();
                guestList.forEach(guest -> {
                    if (validate.test(guest)) {
                        temp.add(guest);
                    }
                    temp.add(guest);
                });
                guestList = temp;

            }

            commandLine = reader.readLine().split(" ");
        }

        if (guestList.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }
        System.out.println(String.join(", ", guestList) + " are going to the party!");
    }

    public static Predicate<String> getPredicate(String[] commandLine) {
        String command = commandLine[1];
        if ("StartsWith".equals(command)) {
            return x -> x.indexOf(commandLine[2]) == 0;
        } else if ("EndsWith".equals(command)) {
            return x -> x.lastIndexOf(commandLine[2]) == x.length() - commandLine[2].length();
        } else if ("Length".equals(command)) {
            return x -> x.length() == Integer.parseInt(commandLine[2]);
        } else {
            return null;
        }
    }

}