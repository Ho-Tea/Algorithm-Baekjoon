import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        dfs(1, 0);
        System.out.print(sb);
    }
    
    // start: 선택 가능한 최소 값, depth: 현재까지 선택한 수의 개수
    static void dfs(int start, int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            // i를 다음 재귀 호출의 시작값으로 사용하여 비내림차순을 유지함
            dfs(i, depth + 1);
        }
    }
}
