
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int index = Math.min(N, M) / 2;
        for (int i = 0; i < R; i++) {
            for (int k = 0; k < index; k++) {
                int savePoint = arr[k][k];
                for (int j = k + 1; j < M - k; j++) {
                    arr[k][j - 1] = arr[k][j];
                }
                for (int j = k + 1; j < N - k; j++) {
                    arr[j - 1][M - 1 - k] = arr[j][M - 1 - k];
                }
                for (int j = M - k - 1; j > k; j--) {
                    arr[N - k - 1][j] = arr[N - k - 1][j - 1];
                }
                for (int j = N - k - 1; j > k + 1; j--) {
                    arr[j][k] = arr[j - 1][k];
                }
                arr[k + 1][k] = savePoint;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}