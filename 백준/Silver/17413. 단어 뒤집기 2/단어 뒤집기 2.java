
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
        String[] strings = reader.readLine().split("");
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new LinkedList<>();
        int index = 0;
        while (index < strings.length) {
            if (strings[index].equals("<")) {
                queue.add(strings[index]);
                for (int i = index + 1; i < strings.length; i++) {
                    if (strings[i].equals(">")) {
                        queue.add(strings[i]);
                        index = i + 1;
                        break;
                    }
                    queue.add(strings[i]);
                }
                continue;
            }
            if (strings[index].equals(" ")) {
                queue.add(strings[index]);
                index++;
            } else {
                while (!strings[index].equals(" ") && !strings[index].equals("<")) {
                    stack.push(strings[index]);
                    index++;
                    if(index == strings.length) {
                        break;
                    }
                }
                while (!stack.isEmpty()) {
                    queue.offer(stack.pop());
                }
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
        }
    }
}