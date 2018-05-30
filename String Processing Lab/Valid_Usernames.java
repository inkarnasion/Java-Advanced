package String_Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valid_Usernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); //вход за данните
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_-]{3,16}$"); // патерн с регекс по който да сплитваме

        List<String> list = new ArrayList<>(); // лист в който да държим данните след сплитването
        while (!"END".equals(input)){ // докато входа е различен
            Matcher matcher= pattern.matcher(input); // вкарваме данните от входа в патерна и ги сплитваме
            if (matcher.find()){ // ако имаме съвпадение
               list.add("valid");// вкарваме в листа следният изход
            }else {
                list.add("invalid"); // обратното
            }
            input=reader.readLine(); // чеетем отново реда за да завъри цикъла отново
        }
        if (list.contains("valid")){ // ако в листа се съдържа този изход
            for (String s : list) { // обикаляме с форийч
                System.out.println(s); // принтираме
            }
        }
       
    }
}
