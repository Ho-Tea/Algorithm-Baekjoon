
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        for (int i = 0; i < num; i++) {
            String string = reader.readLine();
            int count = Integer.parseInt(reader.readLine());
            List<Integer> result = new ArrayList<>();
            Map<Character, List<Integer>> map = new HashMap<>();

            for (int j = 0; j < string.length(); j++) {
                char ch = string.charAt(j);
                map.computeIfAbsent(ch, key -> new ArrayList<>()).add(j);
            }

            for (char c : map.keySet()) {
                List<Integer> list = map.get(c);
                if (list.size() < count)
                    continue;
                for (int j = 0; j <= list.size() - count; j++) {
                    int start = list.get(j);
                    int end = list.get(j + count - 1);
                    int len = end - start + 1;
                    result.add(len);
                }
            }

            Collections.sort(result);

            if (result.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(result.get(0) + " " + result.get(result.size() - 1));
            }
        }
    }
}
