
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static class Edge{
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
        int M = Integer.parseInt(st.nextToken());
        List<Edge> edges = new LinkedList<>();
        long[] dist = new long[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int startNode = 0;
        dist[startNode] = 0;

        for(int i = 0; i < M; i++){
            StringTokenizer st1 = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st1.nextToken()) - 1;
            int end = Integer.parseInt(st1.nextToken()) - 1;
            int cost = Integer.parseInt(st1.nextToken());
            Edge edge = new Edge(start, end, cost);
            edges.add(edge);
        }

        for(int i = 0; i < N; i++){
            for(Edge edge : edges){
                if(dist[edge.start] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.cost){
                    dist[edge.end] = dist[edge.start] + edge.cost;
                }
            }
        }

        for(Edge edge : edges){
            if(dist[edge.end] != Integer.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.cost){
                System.out.println(-1);
                return;
            }
        }

        int index = 0;
        for(long cost : dist){
            if(index == 0){
                index++;
                continue;
            }
            if(cost == Integer.MAX_VALUE){
                writer.write(String.valueOf(-1));
                writer.newLine();
                continue;
            }
            writer.write(String.valueOf(cost));
            writer.newLine();
        }

        writer.flush();


    }

}