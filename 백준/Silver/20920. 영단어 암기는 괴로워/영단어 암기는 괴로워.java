
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < N; i++) {
            String value = reader.readLine();
            if (value.length() < M) {
                continue;
            }
            map.put(value, map.getOrDefault(value, 0) + 1);
        }

        List<Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

        entryList.sort(Entry.comparingByKey());

        entryList.sort((e1, e2) -> {
            int count = e2.getValue() - e1.getValue();
            if (count == 0) {
                return Integer.compare(e2.getKey().length(), e1.getKey().length());
            }
            return count;
        });

        for (Entry<String, Integer> entry : entryList) {
            writer.write(entry.getKey());
            writer.newLine();
        }
        writer.flush();
    }
}