package Functional_Programming_exercises;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.function.Consumer;

public class Consumer_Print {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split("\\s+");
        Consumer<String> namePrint = System.out::println;
        for (String s : input) {
            namePrint.accept(s);
        }
    }
}
