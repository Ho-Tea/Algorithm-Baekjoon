
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
        int[][] matrix = new int[N][M];

        for(int i =0; i<N; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j =0; j<M; j++) {
                String s = st.nextToken();
                matrix[i][j] = Integer.parseInt(s);
            }
        }
        StringTokenizer st1 = new StringTokenizer(reader.readLine());
        int M2 = Integer.parseInt(st1.nextToken());
        int K = Integer.parseInt(st1.nextToken());
        int[][] matrix2 = new int[M2][K];

        for(int i =0; i<M2; i++) {
            st = new StringTokenizer(reader.readLine());
            for(int j =0; j<K; j++) {
                String s = st.nextToken();
                matrix2[i][j] = Integer.parseInt(s);
            }
        }

        int[][] result = new int[N][K];

        for(int i =0; i<N; i++) {
            for(int j =0; j<K; j++) {
                for(int k =0; k<M; k++) {
                    result[i][j] += matrix[i][k] * matrix2[k][j];
                }
            }
        }

        for(int i =0; i<N; i++) {
            for(int j =0; j<K; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

}
