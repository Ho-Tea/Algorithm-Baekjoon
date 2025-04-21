
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = array[0];
        int M = array[1];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String input = reader.readLine();
            set.add(input);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String input = reader.readLine();
            if (set.contains(input)) {
                count++;
            }
        }

        System.out.println(count);

    }
}
