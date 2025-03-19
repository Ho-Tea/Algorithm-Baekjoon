
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (array[0] != 0 && array[1] != 0) {

            int N = array[0];
            int M = array[1];

            int[] array2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = array2[0]; // 시작점
            int end = array2[1]; // 도착점
            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int[] array3 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int startNode = array3[0];
                int endNode = array3[1];
                int cost = array3[2];
                map.get(startNode).add(new int[]{endNode, cost});
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            int[] degree = new int[N];
            Arrays.fill(degree, Integer.MAX_VALUE);
            degree[start] = 0;
            boolean[] visited = new boolean[N];

            Map<Integer, List<Integer>> route = new HashMap<>();
            for (int i = 0; i < N; i++) {
                route.put(i, new ArrayList<>());
            }

            dijktra(q, start, visited, map, degree, route);
            removeEdges(end, route, map, N);

            Arrays.fill(degree, Integer.MAX_VALUE);
            degree[start] = 0;
            Arrays.fill(visited, false);
            q.clear();
            dijktra(q, start, visited, map, degree, route);
            if (degree[end] == Integer.MAX_VALUE) {
                System.out.println(-1);
            }else {
                System.out.println(degree[end]);
            }
            array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }

    public static void removeEdges(int target, Map<Integer, List<Integer>> route, Map<Integer, List<int[]>> map, int N) {
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (visited[curr])
                continue;
            visited[curr] = true;
            for (Integer prev : route.get(curr)) {
                List<int[]> edges = map.get(prev);
                if (edges != null) {
                    for (int[] edge : edges) {
                        if (edge[0] == curr) {
                            edge[1] = -1;
                        }
                    }
                }
                queue.offer(prev);
            }
        }
    }

    private static void dijktra(PriorityQueue<int[]> q, int start, boolean[] visited, Map<Integer, List<int[]>> map, int[] degree, Map<Integer, List<Integer>> route) {
        q.offer(new int[]{start, 0});
        while (!q.isEmpty()) {
            int[] pollNode = q.poll();
            int node = pollNode[0];
            if (visited[node]) {
                continue;
            }
            visited[node] = true;
            List<int[]> ints = map.get(node);
            for (int[] ints1 : ints) {
                if(ints1[1] == -1){
                    continue;
                }
                if (degree[ints1[0]] > degree[node] + ints1[1]) {
                    degree[ints1[0]] = degree[node] + ints1[1];
                    route.get(ints1[0]).clear();
                    route.get(ints1[0]).add(node);
                    q.offer(new int[]{ints1[0], degree[ints1[0]]});
                } else if (degree[ints1[0]] == degree[node] + ints1[1]) {
                    route.get(ints1[0]).add(node);
                }
            }
        }
    }
}