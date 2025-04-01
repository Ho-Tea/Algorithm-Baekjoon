
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    static int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] function = reader.readLine().split("-");
        int sum = 0;
        String[] value = function[0].split("\\+");
        for (String ss : value) {
            sum += Integer.parseInt(ss);
        }
        for (int i = 0; i < function.length - 1; i++) {
            int subSum = 0;
            value = function[i + 1].split("\\+");
            for (String ss : value) {
                subSum += Integer.parseInt(ss);
            }
            sum -= subSum;

        }
        System.out.println(sum);
    }
}