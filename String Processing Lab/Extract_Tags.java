package String_Processing;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Extract_Tags {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine(); // променлива за вход
        Pattern pattern = Pattern.compile("<.+?>"); // променлива която пази регекса по който ще се сплитва

        while(!"END".equals(input)){ // докато входа е различен от командата
            Matcher matcher = pattern.matcher(input); // метод който присъединява входа към регекса и го сплитва по него
            while (matcher.find()){ // ако намери такъв вход
                System.out.println(matcher.group()); // принтира групата
            }
            input=reader.readLine();// четем отново реда за да може да върти цикъла отново
        }
    }
}
