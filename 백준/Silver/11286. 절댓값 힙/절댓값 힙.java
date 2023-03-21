import java.util.*;

import java.io.*;;

public class Main {
    static int N;
    static int[] array;
    static PriorityQueue<Abs> priorityQ;
    static List<Integer> result = new ArrayList<>();

    static class Abs implements Comparable<Abs> {

        private int num;

        public Abs(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(Abs o) {
            if (Math.abs(this.num) > Math.abs(o.num)) {
                return 1;
            } else if (Math.abs(this.num) < Math.abs(o.num)) {
                return -1;
            } else {
                return Integer.compare(this.num, o.num);
            }
        }
        // TODO Auto-generated method stub

    }

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
                    System.out.println(priorityQ.poll().num);
                }
            } else {
                priorityQ.add(new Abs(num));
            }

        }
    }
}
