
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int n = array[0];
            int d = array[1];
            int start = array[2] - 1;
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                map.put(j, new ArrayList<>());
            }
            for (int j = 0; j < d; j++) {
                int[] array2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int startNode = array2[1] - 1;
                int endNode = array2[0] - 1;
                int cost = array2[2];
                map.get(startNode).add(new int[]{endNode, cost});
            }
            boolean[] visited = new boolean[n];
            int[] degree = new int[n];
            Arrays.fill(degree, Integer.MAX_VALUE);
            degree[start] = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            // 시작노드, 코스트, 몇개
            queue.offer(new int[]{start, 0, 1});
            while (!queue.isEmpty()) {
                int[] nodes = queue.poll();
                int node = nodes[0];
                int nodeCount = nodes[2];
                if (visited[node]) {
                    continue;
                }
                visited[node] = true;
                for (int[] nextNode : map.get(node)) {
                    if (visited[nextNode[0]]) {
                        continue;
                    }
                    if (degree[nextNode[0]] > degree[node] + nextNode[1]) {
                        degree[nextNode[0]] = degree[node] + nextNode[1];
                        queue.offer(new int[]{nextNode[0], degree[nextNode[0]], nodeCount + 1});
                    }
                }
            }
            int nodeCount = 0;
            int value = -1;
            for(int j = 0; j < degree.length; j++) {
                if (degree[j] == Integer.MAX_VALUE) {
                    continue;
                }
                nodeCount++;
                if(degree[j] > value){
                    value = degree[j];
                }
            }
            System.out.println(nodeCount + " " + value);
        }
    }

}