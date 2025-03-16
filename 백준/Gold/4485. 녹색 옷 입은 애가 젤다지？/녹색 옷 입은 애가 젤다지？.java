
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Main {

    static int[][] moved = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        int index = 1;
        while (N != 0) {
            int[][] matrix = new int[N][N];
            for (int i = 0; i < N; i++) {
                matrix[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            boolean[][] visited = new boolean[N][N];

            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            // x, y, cost
            queue.offer(new int[]{0, 0, matrix[0][0]});
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int cost = cur[2];
                for (int[] move : moved) {
                    if (x + move[0] >= 0 && y + move[1] >= 0 && x + move[0] < N && y + move[1] < N) {
                        if (!visited[x + move[0]][y + move[1]]) {
                            visited[x + move[0]][y + move[1]] = true;
                            matrix[x + move[0]][y + move[1]] = cost + matrix[x + move[0]][y + move[1]];
                            queue.offer(new int[]{x + move[0], y + move[1], matrix[x + move[0]][y + move[1]]});
                        }
                    }
                }
            }
            System.out.println("Problem " + index + ": " + matrix[N - 1][N - 1]);
            N = Integer.parseInt(reader.readLine());
            index++;
        }
    }
}