
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = array;
        }
        long[] minCost = new long[]{Integer.MAX_VALUE};
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            int startNode = i;
            visited[startNode] = true;
            int depth = 1;
            dfs(i, visited, matrix, startNode, depth, minCost, 0);
        }
        System.out.println(minCost[0]);
    }


    public static void dfs(int startNode, boolean[] visited, int[][] matrix, int node, int depth, long[] minCost, long cost) {
        if (depth == matrix.length) {
            if (matrix[node][startNode] != 0 && minCost[0] > cost + matrix[node][startNode]) {
                minCost[0] = cost + matrix[node][startNode];
            }
            return;
        }

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 0) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                dfs(startNode, visited, matrix, i, depth + 1, minCost, cost + matrix[node][i]);
                visited[i] = false;
            }
        }

    }
}