
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] count = new int[N];
        StringTokenizer st1 = new StringTokenizer(reader.readLine());
        for(int i = 0; i < N; i++){
            count[i] = Integer.parseInt(st1.nextToken());
        }
        int max = 0;
        for (int j = 0; j < X; j++) {
            max += count[j];
        }
        int sameCount = 1;
        int front = 0;
        int beforeValue = max;
        for (int i = X; i < N; i++) {
            int tmp = beforeValue - count[front] + count[i];
            if (max < tmp) {
                max = tmp;
                sameCount = 1;
            } else if (max == tmp) {
                sameCount++;
            }
            front++;
            beforeValue = tmp;
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(sameCount);
        }
    }
}
