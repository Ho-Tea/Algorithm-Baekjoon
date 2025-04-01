
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
        int M = array[1];
        int[][] matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            int[] array1 = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = array1;
        }
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == N - 1 && poll[1] == M - 1) {
                System.out.println(poll[2]);
                return;
            }
            int x = poll[0];
            int y = poll[1];
            int cost = poll[2];
            for (int[] moved : move) {
                int newX = x + moved[0];
                int newY = y + moved[1];
                if (newX >= 0 && newY >= 0 && newX < matrix.length && newY < matrix[0].length && !visited[newX][newY] && matrix[newX][newY] == 1) {
                    queue.offer(new int[]{newX, newY, cost + 1});
                    visited[newX][newY] = true;
                }
            }
        }

    }
}