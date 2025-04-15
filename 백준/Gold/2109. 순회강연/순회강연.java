
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int result = b[0] - a[0];
            if (result == 0) {
                return a[1] - b[1];
            }
            return result;
        });

        for (int i = 0; i < num; i++) {
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            q.offer(array);
        }

        boolean[] visited = new boolean[10000];
        long sum = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int d = poll[1] - 1; d >= 0; d--) {
                if (!visited[d]) {
                    visited[d] = true;
                    sum += poll[0];
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
