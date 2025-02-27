
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N];
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);

        int[] results = new int[M];
        backtracking(array, 0, M, results, visited);


    }

    public static void backtracking(int[] array, int depth, int EndDepth, int[] results, boolean[] visited) {
        if (depth == EndDepth) {
            for (int result : results) {
                System.out.print(result + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i <array.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                results[depth] = array[i];
                backtracking(array, depth + 1, EndDepth, results, visited);
                visited[i] = false;
            }
        }
    }
}