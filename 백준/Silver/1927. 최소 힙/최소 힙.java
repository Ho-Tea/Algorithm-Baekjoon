import java.util.*;

import java.io.*;;

public class Main {
    static int N;
    static int[] array;
    static PriorityQueue<Integer> priorityQ;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        array = new int[N];
        priorityQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st1.nextToken());
            array[i] = num;
        }

        for (int num : array) {
            if (num == 0) {
                if (priorityQ.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(priorityQ.poll());
                }
            } else {
                priorityQ.add(num);
            }

        }
    }
}
