
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
        Map<Integer, List<Integer>> map = new HashMap<>();
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int startTime = a[0] - b[0];
            if (startTime == 0) {
                return a[1] - b[1];
            }
            return startTime;
        });
        for (int i = 0; i < N; i++) {
            int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = numbers[0];
            int end = numbers[1];
            q.offer(new int[]{start, end});
        }


        int[] node = q.poll();
        int[] room = new int[N];
        Arrays.fill(room, Integer.MAX_VALUE);
        int index = 0;
        room[0] = node[1];
        int count = 1;
        while (!q.isEmpty()) {
            int[] newNode = q.poll();
            boolean found = false;
            for (int i = index; i >= 0; i--) {
                if (newNode[0] >= room[i]) {
                    room[i] = newNode[1];
                    found = true;
                    break;
                }
            }
            if (!found) {
                room[index + 1] = newNode[1];
                count++;
                index++;
            }
        }
        System.out.println(count);
    }
}