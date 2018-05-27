package Set_And_Maps;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Academy_Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        Map<String, double[]> students = new TreeMap<>(); // речник в който ще държим данните за студентите
        int studentCount = Integer.parseInt(scanner.nextLine()); // променлива която определя бройките в конзолата на студентите

        StudentCountCalculate(scanner, students, studentCount); // метод който извършва изчисленията
        PrintingResult(students); // извикваме метода който принтира
    }


    private static void StudentCountCalculate(Scanner scanner, Map<String, double[]> students, int studentCount) {
        while (studentCount-- > 0) { //това е намаляващ цикъл, числото намаляво докато е по голямо то 0;
            String studentName = scanner.nextLine(); //запзваме имената
            double[] grades = Arrays.stream(scanner.nextLine()
                    .split(" "))
                    .mapToDouble(Double::parseDouble).toArray();// правим масивв за оценките, който запазваме със stream
            //и го парсваме към double със map.

            students.put(studentName, grades); //добавяме в речника имената на студентите и оценките им.

        }
    }
    private static void PrintingResult(Map<String, double[]> students) {
        students.forEach((key, value) -> { // въртим цикъл по речника за да изведем стойностите

            double avg = 0; // нова променллива която ще пази средният успех
            for (double v : value) { // намираме стойноста на речника който подава числата
                avg += v; //присвояваме стойноста от цикъла

            }
            avg /= value.length; // делим стойноста на две за да вземем средният успех

            System.out.printf("%s is graduated with %s%n", key, avg);

        });
    }

}
