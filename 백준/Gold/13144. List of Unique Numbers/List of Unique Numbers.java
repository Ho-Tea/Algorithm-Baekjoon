
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
        int N = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long count = 0;
        boolean[] matrix = new boolean[100001];
        int right = 0;
        int left = 0;
        while (right < N) {
            if (!matrix[array[right]]) {
                matrix[array[right]] = true;
                right++;
                count += right - left;
            } else {
                matrix[array[left]] = false;
                left++;
            }
        }
        System.out.println(count);
    }
}