
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        String[] numbers = reader.readLine().split("");
        int sum = 0;
        for(int i = 0; i < count; i++) {
            sum += Integer.parseInt(numbers[i]);
        }
        System.out.println(sum);
    }
}