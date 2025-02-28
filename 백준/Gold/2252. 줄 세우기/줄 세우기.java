
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> bridge = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            bridge.add(new ArrayList<>());
        }
        int[] indegree = new int[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            bridge.get(start).add(end);
            indegree[end]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> result  = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);
            for(int endNode : bridge.get(node)) {
                indegree[endNode]--;
                if(indegree[endNode] == 0) {
                    queue.offer(endNode);
                }
            }
        }

        for(int a : result){
            System.out.print(a + 1 + " ");
        }
    }

}