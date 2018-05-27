package Set_And_Maps;

import java.util.*;

public class Count_Same_Values_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       String[]arr = scanner.nextLine().split("\\s+");
        // правим масив, сплитваме го по празен спейс

        Map<String,Integer> numbers=new HashMap<>(); //правим речник

        for (String num : arr) { //въртим цикъкл през входният масив
            if (! numbers.containsKey(num + "")){ // ако няма такова число в масива
                numbers.put(num + "",0); //добавяме го в речника от входния масив като първа стойност, и с нулев елемент за начало
                // така валидираме че със сигурност имаме ключа numbers
            }

            numbers.put(num + "",numbers.get(num + "")+1);// взимаме отново ключа, само че добавяме отново ключа и добавяме към него една еденица
        }
        for (Map.Entry<String, Integer> entry : numbers.entrySet()) { //минаваме през входните данни в речника
            System.out.printf("%s - %d times%n",entry.getKey(),entry.getValue()); // принтираме ключа и стойностите
        }
    }
}
