
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    static int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxValue = 0;


        for (int j = 0; j < array.length; j++) {
            int beforeNumber = array[j];
            for (int k = array.length - 1; k > j; k--) {
                maxValue = Math.max(maxValue, (k - j - 1) * Math.min(array[j], array[k]));
            }
            while (j + 1 < array.length - 1 && beforeNumber > array[j + 1]) {
                j++;
            }
        }
        System.out.println(maxValue);
    }
}