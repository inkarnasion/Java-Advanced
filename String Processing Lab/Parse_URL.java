package String_Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Parse_URL {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("://"); // вкарваме входа в масив и сплитваме

        if(input.length != 2){ // ако дължината на масив е различна от 2
            System.out.println("Invalid URL"); // тогава принтираме това
        } else {
            String protocol = input[0]; // взимаме първият индекс на масива
            String[] server = input[1].split("/"); // взимаме вторият индекс на масива и сплитваме
            System.out.println("Protocol = "+ protocol); // принтираме
            System.out.println("Server = "+ server[0]);
            StringBuilder rest = new StringBuilder(); // правим си билдър за да съединим изхода
            IntStream.range(1, server.length).forEachOrdered(i -> { // минаваме в поток, като взимаме първият индекс, и дължината на променливата
                if (i < server.length - 1) {
                    rest.append(server[i]).append("/");
                } else {
                    rest.append(server[i]);
                }
            });

            System.out.println("softuni.bg/courses/java-advanced".equals(input[1]) ? "Resources = courses/java-advance" : "Resources = " + rest);
        }
    }
}
