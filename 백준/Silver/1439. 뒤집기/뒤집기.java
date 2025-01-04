
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] S = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        List<Integer> N = new ArrayList<>();
        int beforeValue = S[0];
        N.add(beforeValue);

        for (int i = 1; i < S.length; i++) {
            if (beforeValue == S[i]) {
                continue;
            }
            beforeValue = S[i];
            N.add(S[i]);
        }
        long oneCount = N.stream().filter(o -> o == 1).count();
        long zeroCount = N.size() - oneCount;

        long result = Math.min(oneCount, zeroCount);

        System.out.println(result);
    }
}
