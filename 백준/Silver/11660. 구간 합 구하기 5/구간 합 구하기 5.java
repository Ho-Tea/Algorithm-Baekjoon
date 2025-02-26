
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        List<int[]> array = new ArrayList<>();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < M; i++) {
            int[] strings = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            array.add(strings);
        }


        int[][] dp = new int[N][N];
        dp[0][0] = matrix[0][0];
        dp[0][1] = matrix[0][1] + dp[0][0];
        dp[1][0] = matrix[1][0] + dp[0][0];
        for (int j = 0; j < N - 1; j++) {
            dp[0][j + 1] = dp[0][j] + matrix[0][j + 1];
        }
        for (int j = 0; j < N - 1; j++) {
            dp[j + 1][0] = dp[j][0] + matrix[j + 1][0];
        }
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + matrix[i + 1][j + 1];
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int[] r : array) {
            int y1 = r[0] - 1;
            int x1 = r[1] - 1;
            int y2 = r[2] - 1;
            int x2 = r[3] - 1;
            long sum = 0;
            if (x1 - 1 < 0 && y1 - 1 < 0) {
                sum = dp[y2][x2];
            } else if (x1 - 1 < 0) {
                sum = dp[y2][x2] - dp[y1 - 1][x2];
            } else if (y1 - 1 < 0) {
                sum = dp[y2][x2] - dp[y2][x1 - 1];
            } else {
                sum = dp[y2][x2] - dp[y1 - 1][x2] - dp[y2][x1 - 1] + dp[y1 - 1][x1 - 1];
            }
            System.out.println(sum);
        }

    }
}