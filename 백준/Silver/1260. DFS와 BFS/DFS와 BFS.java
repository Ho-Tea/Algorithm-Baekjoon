
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][n];
        List<Integer> dfsResult = new ArrayList<>();
        boolean[] dfsVisited = new boolean[n];
        for (int i = 0; i < m; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int node1 = Integer.parseInt(stringTokenizer.nextToken());
            int node2 = Integer.parseInt(stringTokenizer.nextToken());

            matrix[node1 - 1][node2 - 1] = 1;
            matrix[node2 - 1][node1 - 1] = 1;
        }

        dfs(dfsResult, matrix, v-1, dfsVisited);
        for (int i = 0; i < dfsResult.size(); i++) {
            System.out.print(dfsResult.get(i) + 1 + " ");
        }

        System.out.println();
        List<Integer> bfsResult = new ArrayList<>();
        boolean[] bfsVisited = new boolean[n];
        bfs(bfsResult, matrix, v-1, bfsVisited);
        for (int i = 0; i < bfsResult.size(); i++) {
            System.out.print(bfsResult.get(i) + 1 + " ");
        }
    }

    public static void dfs(List<Integer> result, int[][] matrix, int node, boolean[] visited) {
        result.add(node);
        visited[node] = true;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[node][i] == 1 && !visited[i]) {
                dfs(result, matrix, i, visited);
            }
        }
    }

    public static void bfs(List<Integer> result, int[][] matrix, int node, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            result.add(curNode);
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[curNode][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
