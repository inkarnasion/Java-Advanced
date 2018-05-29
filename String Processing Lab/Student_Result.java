package String_Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Student_Result {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input= reader.readLine().split("[,\\s-]+"); //масив който ще пази информацията

        double avg =0; // променлива която ще пази крайният резултат
        for (int i = 1; i <input.length ; i++) { // въртим цикъл от първият елемент защото нулевият е името с което започва входа
            avg += Double.parseDouble(input[i]); // присвояваме стойност на входа и го парсваме към число защото е стринг
        if (i==input.length-1){ // ако е равно на входа минус 1 или по точно на последнат итерация
            avg /=3; // целият резултат го делим на три за да вземем средният резултат
        }
        }
        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average" );
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|%n",input[0],Double.valueOf( input[1]),Double.valueOf( input[2]),Double.valueOf( input[3]),avg);
    }
}
