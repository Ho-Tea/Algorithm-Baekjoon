import java.util.*;

import java.io.*;;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();
    static PriorityQueue<Integer> maxhip;
    static PriorityQueue<Integer> minhip;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 선언
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        maxhip = new PriorityQueue<>(Collections.reverseOrder());
        minhip = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st1.nextToken());
            if (maxhip.size() == minhip.size()) {
                maxhip.add(num);
            } else {
                minhip.add(num);
            }

            if (!maxhip.isEmpty() && !minhip.isEmpty()) {
                if (maxhip.peek() > minhip.peek()) {
                    int temp = maxhip.poll();
                    int temp2 = minhip.poll();
                    minhip.add(temp);
                    maxhip.add(temp2);
                }
            }
            sb.append(maxhip.peek() + "\n");

        }
        System.out.println(sb);

    }
}
