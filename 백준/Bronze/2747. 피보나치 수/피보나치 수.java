
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        int result = fib(dp, n);

        System.out.println(result);
    }

    public static int fib(int[] dp, int n) {
        if (n < 2) {
            return dp[n];
        } else if (dp[n] != 0) {
            return dp[n];
        }
        return dp[n] = fib(dp, n - 1) + fib(dp, n - 2);
    }
}
