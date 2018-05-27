package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> phonebook = new HashMap<>(); // правим речник от стрингове който ще пази телефонните номера и номерата

        PhonebookCalculation(reader, phonebook);

    }

    private static void PhonebookCalculation(BufferedReader reader, Map<String, String> phonebook) throws IOException {
        while (true){ // докато е вярно
            String commandsArg= reader.readLine(); // променлива която ще държи командите
            if ("search".equals(commandsArg)){ // ако е вярно условието
                break; // прекъсни
            }
            String[] line=commandsArg.split("-"); // правим масив който взима входа от стринга
            phonebook.put(line[0],line[1]); // добавяме в речника името и телефонният номер
        }
        while (true){
            String commandsArg = reader.readLine();// заради новият цикъл правим отново променли която да чете на нов ред
            if ("stop".equals(commandsArg)){ // ако това е командата
                break; // спираме
            }
            if (phonebook.containsKey(commandsArg)){// ако в речника се съдържа името
                System.out.println(commandsArg + " -> " +  phonebook.get(commandsArg)); // принтираме името и телефонният номер
            }else {
                System.out.println("Contact " + commandsArg + " does not exist.");
            }
        }
    }
}
