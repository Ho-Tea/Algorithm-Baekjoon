
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;


public class Main {

    static int[][] moved = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        long sum = 0;
        for (int i = 1; i < n + 1; i++) {
            int cost = Integer.parseInt(reader.readLine());
            q.add(cost);
            sum += cost;
        }
        int count = n/3;
        for(int i = 0; i < count; i++) {
            q.poll();
            q.poll();
            int discount = q.poll();
            sum -= discount;
        }
        System.out.println(sum);
    }
}