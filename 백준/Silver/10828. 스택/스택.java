
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s; i++) {
            String[] strings = reader.readLine().split(" ");
            if (strings.length == 2) {
                stack.push(Integer.parseInt(strings[1]));
                continue;
            }
            if (strings[0].equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
            } else if (strings[0].equals("size")) {
                System.out.println(stack.size());
            } else if (strings[0].equals("empty")) {
                if (!stack.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(1);
            } else if (strings[0].equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.pop());
            }
        }

    }
}