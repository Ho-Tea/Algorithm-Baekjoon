import java.util.*;

import java.io.*;;

public class Main {
    static int N;
    static List<Integer>[] list;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        indegree = new int[N + 1];
        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st1.nextToken());
            int second = Integer.parseInt(st1.nextToken());
            indegree[second]++;
            list[first].add(second);
        }

        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                priorityQueue.offer(i);
            }
        }

        while (!priorityQueue.isEmpty()) {
            int ploblem = priorityQueue.poll();
            sb.append(ploblem);
            sb.append(" ");
            for (int i = 0; i < list[ploblem].size(); i++) {
                int node = list[ploblem].get(i);
                indegree[node]--;
                if (indegree[node] == 0) {
                    priorityQueue.offer(node);
                }
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
