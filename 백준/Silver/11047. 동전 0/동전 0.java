
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // 힙 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // {1, 3, 5, 4, 2}
        //              p
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int K = array[1];
        int[] coins = new int[N];

        for (int i = 0; i < N; i++) {
            int coin = Integer.parseInt(reader.readLine());
            coins[i] = coin;
        }
        int totalQuantity = 0;
        for (int i = N - 1; i >= 0; i--) {
            int coin = coins[i];
            if (K >= coins[i]) {
                int quantity = K / coin;
                totalQuantity += quantity;
                K -= coin * quantity;
            }
            if(K == 0){
                break;
            }
        }

        System.out.println(totalQuantity);
    }
}
