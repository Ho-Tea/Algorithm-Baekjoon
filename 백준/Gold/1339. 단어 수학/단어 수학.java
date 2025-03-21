
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Character, Integer> letterWeight = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            int len = word.length();
            for (int j = 0; j < len; j++) {
                char c = word.charAt(j);
                int weight = (int) Math.pow(10, len - j - 1);
                letterWeight.put(c, letterWeight.getOrDefault(c, 0) + weight);
            }
        }

        List<Integer> weights = new ArrayList<>(letterWeight.values());
        Collections.sort(weights, Collections.reverseOrder());

        int digit = 9;
        long answer = 0;
        for (int weight : weights) {
            answer += (long) weight * digit;
            digit--;
        }

        System.out.println(answer);
    }

}