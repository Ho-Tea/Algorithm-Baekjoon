
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        for (int i = 0; i < N; i++) {
            int parseInt = Integer.parseInt(reader.readLine());
            long count = 0;
            long sum = 0;
            for (int j = 5; j <= parseInt; j = j * 5) {
                count = parseInt / j;
                sum += count;
            }
            System.out.println(sum);
        }
    }
}