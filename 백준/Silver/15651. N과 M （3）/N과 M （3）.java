
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];
        int[] results = new int[M];
        backtracking(N, M, visited, results, 0, 0);
        System.out.println(stringBuilder);
    }

    private static void backtracking(int N, int M, boolean[] visited, int[] results, int depth, int at) {
        if (depth == M) {
            for (int result : results) {
                stringBuilder.append(result).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
            return;
        }

        for (int i = 1; i < N + 1; i++) {

            results[depth] = i;
            backtracking(N, M, visited, results, depth + 1, i);
        }
    }
}
