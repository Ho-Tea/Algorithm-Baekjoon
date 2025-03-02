
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // M 이 높이 -> 5
        // N 이 가로 -> 7
        int[][] matrix = new int[M][N];
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = array[0];
            int y1 = Math.abs(M - array[1] - 1); // 얘가 앞


            int x2 = array[2] - 1;
            int y2 = Math.abs(M - array[3]);

            for (int j = y1; j >= y2; j--) {
                for (int k = x1; k <= x2; k++) {
                    matrix[j][k] = 1;
                }
            }
        }

        int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> extentList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && matrix[i][j] == 0) {
                    int extent = 0;
                    extentList.add(bfs(visited, move, i, j, extent, matrix));
                }
            }
        }
        Collections.sort(extentList);
        System.out.println(extentList.size());
        for (int i : extentList) {
            System.out.print(i + " ");
        }

    }

    private static int bfs(boolean[][] visited, int[][] move, int m, int n, int extent, int[][] matrix) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{m, n});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y1 = poll[0];
            int x1 = poll[1];
            if (visited[y1][x1]) {
                continue;
            }
            visited[y1][x1] = true;
            extent++;
            for (int[] moving : move) {
                if ((y1 + moving[0] < matrix.length && x1 + moving[1] < matrix[0].length && y1 + moving[0] > -1 && x1 + moving[1] > -1)) {
                    if (matrix[y1 + moving[0]][x1 + moving[1]] == 0) {
                        int[] ints = {y1 + moving[0], x1 + moving[1]};
                        q.offer(ints);

                    }
                }
            }
        }
        return extent;
    }
}