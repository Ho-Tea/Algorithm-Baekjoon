
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String input;
        while ((input = reader.readLine()) != null) {
            if (input.trim().isEmpty()) break;  // 빈 줄 입력 시 종료
            map.put(input, map.getOrDefault(input, 0) + 1);
            count++;
        }

        List<String> array = new ArrayList<>(map.keySet());
        array.sort(Comparator.naturalOrder());

        DecimalFormat df = new DecimalFormat("0.0000");

        for (String result : array) {
            double ratio = (double) map.get(result) / count * 100;
            System.out.println(result + " " + df.format(ratio));
        }
    }


}
