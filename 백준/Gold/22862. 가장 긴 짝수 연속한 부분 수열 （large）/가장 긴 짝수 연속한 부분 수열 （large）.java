
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int startIndex = 0;
        int endIndex = 0;
        int max = 0;
        int cnt = 0;
        while (endIndex < arr.length) {
            if (cnt < K) {
                if (arr[endIndex] % 2 == 1) {
                    cnt++;
                }
                endIndex++;
                max = Math.max(max, endIndex - startIndex - cnt);
            } else if (arr[endIndex] % 2 == 0) {
                endIndex++;
                max = Math.max(max, endIndex - startIndex - cnt);
            } else {
                if (arr[startIndex] % 2 == 1) {
                    cnt--;
                }
                startIndex++;
            }
        }
        System.out.println(max);
    }
}
