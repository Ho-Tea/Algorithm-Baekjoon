
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        int[][] inputMatrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inputMatrix[i] = array;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (inputMatrix[i][k] > 0 && inputMatrix[k][j] > 0) {
                        inputMatrix[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[i].length; j++) {
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}