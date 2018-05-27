package Set_And_Maps;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUni_Party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guest = new TreeSet<>();// правим сет с хората

        String line = scanner.nextLine(); // правим вход за командите

        while (!"PARTY".equals(line)) { // ако командата е различна от това

            guest.add(line); // добавяме в сета
            line=scanner.nextLine(); //четем новият ред след предишният цикъл
        }
        line=scanner.nextLine(); // завъртаме нов цикъл

        while (!"END".equals(line)){ // докато е различно от командата
            guest.remove(line); // премахваме хора от сета
            line=scanner.nextLine(); // завъртаме цикъла отново
        }
        System.out.println(guest.size()); // принтираме бройката на хората в сета
       // System.out.println((guest + "").replaceAll("[\\[\\]]", " ")); // принтираме хората в сета
        for (String people : guest) { //обикаляме сета с форийч
            System.out.println(people); // принтираме номерата в сета
        }
    }
}
