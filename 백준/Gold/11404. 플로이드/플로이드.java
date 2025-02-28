
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static class Edge {
        private int start;
        private int end;
        private int cost;

        public Edge(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(reader.readLine());

        int[][] edges = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(edges[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N; i++) {
            edges[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st1.nextToken()) - 1;
            int end = Integer.parseInt(st1.nextToken()) - 1;
            int cost = Integer.parseInt(st1.nextToken());
            edges[start][end] = Math.min(edges[start][end], cost);
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(edges[i][k] != Integer.MAX_VALUE && edges[k][j] != Integer.MAX_VALUE) {
                        edges[i][j] = Math.min(edges[i][j], edges[i][k] + edges[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(edges[i][j] == Integer.MAX_VALUE) {
                    System.out.print(0 + " ");
                    continue;
                }
                System.out.print(edges[i][j] + " ");
            }
            System.out.println();
        }

    }
}