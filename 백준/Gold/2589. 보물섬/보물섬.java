
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {

    static int[][] moved = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int row = array[0];
        int col = array[1];

        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split("")).mapToInt(a -> {
                if (a.equals("W")) {
                    return 0;
                }
                return 1;
            }).toArray();
        }

        int max = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1) {
                    boolean[][] visited = new boolean[row][col];
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        int cost = poll[2];
                        for (int k = 0; k < moved.length; k++) {
                            int nextRow = x + moved[k][0];
                            int nextCol = y + moved[k][1];
                            if (nextRow >= 0 && nextCol >= 0 && nextRow < matrix.length && nextCol < matrix[0].length) {
                                if (visited[nextRow][nextCol]) {
                                    continue;
                                }
                                if (matrix[nextRow][nextCol] == 1) {
                                    visited[nextRow][nextCol] = true;
                                    queue.offer(new int[]{nextRow, nextCol, cost + 1});
                                }

                            }
                        }
                        max = Math.max(max, cost);
                    }
                }
            }
        }
        System.out.println(max);
    }
}