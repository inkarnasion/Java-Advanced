package Stack_and_Queues;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class simple_calculator_lab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens= scanner.nextLine().split(" "); // приемаме данните като масив

        ArrayDeque<String> stack = new ArrayDeque<>();
        Collections.addAll(stack,tokens); // правим колекция в която пъхаме входа и стека.

        while(stack.size()>1){ //въртим докато в стека има елементи

           Integer first= Integer.valueOf(stack.pop());// правим променлива която ще ползваме за пресмятане
            String operator = stack.pop(); // товва ще е следващият елемент в стека който ще ни служи за оператор
            Integer second = Integer.valueOf(stack.pop()); // това ще е третата променлива с която ще пресмятаме.

            if (operator.equals("+")){ // сравняваме дали оператора е равен на даден знак

                stack.push(String.valueOf(first+second)); // събираме променливите и ги пушваме нй отгоре.

            }else {
                stack.push(String.valueOf(first-second));// вадим променливите
            }

        }
        System.out.println(stack.pop()); // принтираме

    }
}
