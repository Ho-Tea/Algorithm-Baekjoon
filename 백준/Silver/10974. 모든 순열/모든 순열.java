
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int[] input = Arrays.stream(reader.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();

        int i = Integer.parseInt(reader.readLine());

        int[] result = new int[i];
        boolean[] visited = new boolean[i];
        dfs(i, 0, result, visited);
    }

    public static void dfs(int N, int depth, int[] result, boolean[] visited) {
        if (depth == N) {
            for(int i =0; i<result.length; i++) {
                System.out.print(result[i]+1 + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(N, depth + 1, result, visited);
                visited[i] = false;
            }
        }
    }
}