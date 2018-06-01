package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Magic_Exchangeable_Words {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] input = reader.readLine().split("\\s+");
        if(input[0].length() > input[1].length()){
            System.out.println(ExchangableWords(input[1], input[0]));
        } else {
            System.out.println(ExchangableWords(input[0], input[1]));
        }
    }

    private static boolean ExchangableWords(String s, String s1) {

        HashMap<Character, Character> store = new HashMap<>();
        String word1 = "";
        String word2 = "";

        int i = 0;
        while (i < s.length()) {
            if(!word1.contains(s.charAt(i) + "")){
                word1 += s.charAt(i);
            }
            if (store.containsKey(s.charAt(i))) {
                if (store.get(s.charAt(i)) != s1.charAt(i)) {
                    return false;
                }
            } else {
                store.put(s.charAt(i), s1.charAt(i));
            }
            i++;
        }

        int j = 0;
        while (j < s1.length()) {
            if(!word2.contains(s1.charAt(j) + "")){
                word2 += s1.charAt(j);
            }
            j++;
        }

        return word1.length() == word2.length();
    }
}