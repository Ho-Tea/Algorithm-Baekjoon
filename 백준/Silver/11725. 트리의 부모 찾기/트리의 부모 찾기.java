import java.util.*;

import javax.swing.text.html.HTMLDocument.BlockElement;

import java.io.*;;

public class Main {
    static int[] chain;
    static List<List<Integer>> map = new ArrayList<>();
    static boolean[] visit;
    static Queue<Integer> originQ = new LinkedList<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        chain = new int[N + 1];
        visit = new boolean[N + 1];
        for (int i = 0; i < N + 1; i++) {
            map.add(new ArrayList<>());
        }
        for (int i = 1; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(st1.nextToken());
            int column = Integer.parseInt(st1.nextToken());

            map.get(row).add(column);
            map.get(column).add(row);

        }
        originQ.offer(1);
        while (!originQ.isEmpty()) {
            int parentnode = originQ.poll();
            for (int child : map.get(parentnode)) {
                if (visit[child] == false) {
                    visit[child] = true;
                    originQ.offer(child);
                    chain[child] = parentnode;
                }
            }

        }
        for (int i = 2; i < N + 1; i++) {
            System.out.println(chain[i]);
        }

    }
}
