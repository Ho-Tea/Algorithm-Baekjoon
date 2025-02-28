
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
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Map<Integer, List<int[]>> map = new HashMap<>();
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(reader.readLine()) - 1;
        boolean[] visited = new boolean[V];
        int[] digest = new int[V];
        Arrays.fill(digest, Integer.MAX_VALUE);

        for (int i = 0; i < V; i++) {
            List<int[]> list = new LinkedList<>();
            map.put(i, list);
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st1 = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st1.nextToken()) - 1;
            int end = Integer.parseInt(st1.nextToken()) - 1;
            int weight = Integer.parseInt(st1.nextToken());
            map.get(start).add(new int[]{end, weight});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.offer(new int[]{startNode, 0});
        digest[startNode] = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int node = poll[0];
            if (visited[node])
                continue;
            visited[node] = true;
            List<int[]> ints = map.get(node);
            for (int[] i : ints) {
                if (digest[i[0]] > digest[node] + i[1]) {
                    digest[i[0]] = digest[node] + i[1];
                    pq.offer(new int[]{i[0], digest[i[0]]});
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (digest[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(digest[i]);
        }
    }

}