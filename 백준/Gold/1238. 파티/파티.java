
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class Main {

    static int[][] moved = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int M = array[1];
        int X = array[2] - 1;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int[] node = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = node[0] - 1;
            int end = node[1] - 1;
            int cost = node[2];
            graph.get(start).add(new int[]{end, cost});
        }
        Map<Integer, Integer> result = new HashMap<>();
        for(int i = 0; i < N; i++) {
            result.put(i, 0);
        }
        for (int i = 0; i < N; i++) {
            int[] degree = new int[N];
            Arrays.fill(degree, Integer.MAX_VALUE);
            degree[i] = 0;
            PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            boolean[] visited = new boolean[N];
            queue.offer(new int[]{i, 0});
            int currentIndex = 0;
            while (!queue.isEmpty()) {
                int[] node = queue.poll();
                currentIndex = node[0];
                if (visited[node[0]]) {
                    continue;
                }
                List<int[]> ints = graph.get(node[0]);
                for (int[] ints1 : ints) {
                    int end = ints1[0];
                    int cost = ints1[1];
                    if (degree[end] > degree[currentIndex] + cost) {
                        degree[end] = degree[currentIndex] + cost;
                        queue.offer(new int[]{end, degree[end]});
                    }
                }
            }
            if(i == X){
                for(int j = 0; j < N; j++){
                    if(j == X){
                        continue;
                    }
                    result.put(j, result.get(j) + degree[j]);
                }
                continue;
            }
            result.put(i, result.get(i) + degree[X]);
        }
        int max = 0;
        for(int value : result.values()){
            if(value > max){
                max = value;
            }
        }

        System.out.println(max);
    }
}