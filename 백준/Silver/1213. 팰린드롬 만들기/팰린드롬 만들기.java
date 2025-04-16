
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split("");
        Map<String, Integer> map = new HashMap<>();

        for (String input : inputs) {
            if (map.containsKey(input)) {
                map.put(input, map.get(input) + 1);
                continue;
            }
            map.put(input, 1);
        }
        List<String> list = Arrays.stream(inputs).distinct().collect(Collectors.toList());
        list.sort(Comparator.naturalOrder());

        long oddCount = map.values().stream()
                .filter(count -> count % 2 != 0)
                .count();

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }
        StringBuilder front = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        StringBuilder end = new StringBuilder();

        for (String value : list) {
            Integer count = map.get(value);
            if (count % 2 == 1) {
                for (int i = 0; i < count / 2; i++) {
                    front.append(value);
                    end.append(value);
                }
                mid.append(value);
            } else {
                for (int i = 0; i < count / 2; i++) {
                    front.append(value);
                    end.append(value);
                }
            }
        }
        end.reverse();

        System.out.println(front.append(mid).append(end));
    }
}
