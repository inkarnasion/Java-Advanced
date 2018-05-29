package String_Processing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Series_of_Letters {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

       String input = reader.readLine();

       StringBuilder sb = new StringBuilder().append(input);

       int i =0;
       int state = 0;

       while (i < sb.length()-1){
           switch (state){
               case 0:
               if (sb.charAt(i)==sb.charAt(i+1)){
                   sb.deleteCharAt(i);
                   state=0;

               }else {
                   state=1;
               }
               break;
               case 1:
                   i++;
                   state=0;
                   break;

           }

       }
        System.out.println(sb.toString());
    }
}
