
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
    static int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int S = array[1];

        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long minCount = Integer.MAX_VALUE;
        long count = 0;
        long sum = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            sum += numbers[i];
            queue.offer(numbers[i]);
            count++;
            while (sum >= S && !queue.isEmpty()) {
                minCount = Math.min(minCount, count);
                sum -= queue.poll();
                count--;
            }

        }
        if (minCount == Integer.MAX_VALUE) {
            System.out.println(0);
            return;
        }
        System.out.println(minCount);
    }
}