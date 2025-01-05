
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N];
        int[] results = new int[M];
        backtracking(N, M, visited, results, 0, 0);
    }

    private static void backtracking(int N, int M, boolean[] visited, int[] results, int depth, int at) {
        if (depth == M) {
            for (int result : results) {
                System.out.print(result + 1 + " ");
            }
            System.out.println();
            return;
        }

        for (int i = at; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results[depth] = i;
                backtracking(N, M, visited, results, depth + 1, i);
                visited[i] = false;
            }
        }
    }
}
