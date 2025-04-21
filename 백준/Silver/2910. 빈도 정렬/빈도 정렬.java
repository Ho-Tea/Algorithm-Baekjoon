
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int N = array[0];
        int C = array[1];

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int cc = b[1] - a[1];
            if(cc == 0){
                return a[2] - b[2];
            }
            return cc;
        });
        Map<Integer, Integer> order = new HashMap<>();
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], map.getOrDefault(input[i], 0) + 1);
            if(order.containsKey(input[i])){
                continue;
            }
            order.put(input[i], i);
        }

        for (Entry<Integer, Integer> r : map.entrySet()) {
            q.offer(new int[]{r.getKey(), r.getValue(), order.get(r.getKey())});
        }

        while (!q.isEmpty()) {
            int[] node = q.poll();
            for (int j = 0; j < node[1]; j++) {
                System.out.print(node[0] + " ");

            }
        }

    }


}
