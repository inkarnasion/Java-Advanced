package String_Processing_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Text_Filter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        String[] bannedWords = reader.readLine().split(", ");
        String text = reader.readLine();

        for (int i = 0; i < bannedWords.length; i++) {
            String bannedWord = bannedWords[i];
            while (true) {
                if (!text.contains(bannedWord))
                    break;
                text = text.replace(bannedWord, new String(new char[bannedWord.length()]).replace("\0", "*"));
            }
        }

        System.out.println(text);
    }
}