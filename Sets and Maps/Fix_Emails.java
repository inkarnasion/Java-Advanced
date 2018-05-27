package Set_and_Map_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Fix_Emails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> emails = new LinkedHashMap<>(); //речник в който ще държим данните


        FillEmails(reader, emails); // подаваме метода който изчислява
        emails.forEach((key, value) -> System.out.println(key + " -> " + value)); // принтираме по ключ и стойност
    }

    private static void FillEmails(BufferedReader reader, Map<String, String> emails) throws IOException {
        while (true) {  // докато е вярно следното условие
            String input = reader.readLine(); // променлива която пази входните имена
            if ("stop".equals(input)) { // ако входа е този
                break; // спираме цикъла
            }
            String email = reader.readLine(); // променлива която е за имейлите
            String[] domain = email.split("\\."); // масив който ще пази имейлите които ни трябват
            if ("bg".equals(domain[1])) { // ако завършва на този вход
                emails.put(input, email); // пълним речника със имената и имейлите
            }

        }
    }
}
