
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] list = new int[K][2];
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i < K; i++) {
                String[] strings = reader.readLine().split(" ");
                list[i] = new int[]{Integer.parseInt(strings[0]), Integer.parseInt(strings[1])};
                String key = list[i][0] + "," + list[i][1];
                map.put(key, i);
            }
            int[][] moves = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

            int max = 0;
            boolean[] visited = new boolean[K];

            for (int j = 0; j < K; j++) {
                if (!visited[j]) {
                    int count = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(list[j]);
                    visited[j] = true;
                    count++;

                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        for (int[] move : moves) {
                            int newX = cur[0] + move[0];
                            int newY = cur[1] + move[1];
                            String newKey = newX + "," + newY;
                            if (map.containsKey(newKey)) {
                                int idx = map.get(newKey);
                                if (!visited[idx]) {
                                    queue.offer(list[idx]);
                                    visited[idx] = true;
                                    count++;
                                }
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
            writer.write(String.valueOf(max));
            writer.flush();
            writer.close();
        }
}