
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int[] arrayList = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            int length = array[j] - array[i];
            arrayList[i] = length;
            q.offer(length);
        }

        int result = Arrays.stream(arrayList).sum();
        for (int i = k - 1; i > 0; i--) {
            if (!q.isEmpty()) {
                result -= q.poll();
            }
        }
        System.out.println(result);
    }
}