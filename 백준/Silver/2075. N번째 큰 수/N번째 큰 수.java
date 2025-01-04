
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < s; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < s; j++) {
                int a = Integer.parseInt(st.nextToken());
                pq.add(a);
            }
        }
        for (int i = 1; i < s; i++) {
            pq.poll();
        }
        System.out.println(pq.poll());

    }
}
