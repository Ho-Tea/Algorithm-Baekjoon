
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] strings = reader.readLine().split("\\.");
            map.put(strings[1], map.getOrDefault(strings[1],0) + 1);
        }
        List<String> result = new ArrayList<>(map.keySet());
        Collections.sort(result);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i) + " " + map.get(result.get(i)));
        }
    }
}