
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(tokenizer.nextToken());
        List<PriorityQueue<Long>> result = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(reader.readLine());
            int[] strings = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            PriorityQueue<Long> results = new PriorityQueue<>();
            for(long value : strings){
                results.add(value);
            }
            result.add(results);
        }
        List<Long> realResult = new ArrayList<>();

        for(PriorityQueue<Long> pq : result){
            long sum = 0;
            while(pq.size() > 1){
                long left = pq.poll();
                long right = pq.poll();
                sum += left + right;
                pq.offer(left+right);
            }
            realResult.add(sum);
        }

        for(Long integer : realResult){
            System.out.println(integer);
        }
    }
}