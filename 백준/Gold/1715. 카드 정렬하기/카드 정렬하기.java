import java.util.*;

import java.io.*;;

public class Main {
    static int N;
    static PriorityQueue<Integer> priorityQ;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        priorityQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st1.nextToken());
            priorityQ.add(num);
        }

        while (priorityQ.size() != 1) {
            int first = priorityQ.poll();
            int second = priorityQ.poll();
            result.add(first + second);
            priorityQ.add(first + second);
        }
        int total = 0;
        for (int num : result) {
            total += num;
        }
        System.out.println(total);
    }
}

