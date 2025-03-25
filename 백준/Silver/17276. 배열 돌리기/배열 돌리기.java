
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
        int T = input[0];

        for (int i = 0; i < T; i++) {
            int[] inputValue = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int n = inputValue[0];
            int d = inputValue[1];
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++) {
                int[] row = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                matrix[j] = row;
            }

            int circleCount = d / 45;
            if (circleCount < 0) {
                circleCount += 8;
            }
            for (int k = 0; k < circleCount; k++) {
                for (int l = 0; l < n / 2; l++) {
                    int temp = matrix[l][l];
                    int move = n / 2 - l;
                    // 왼쪽 아래에서 왼쪽 위로
                    for (int c1 = l; c1 < n - l - 1; ) {
                        int col = c1 + move;
                        matrix[c1][l] = matrix[col][l];
                        c1 = col;
                    }


                    // 오른쪽 아래에서 왼쪽 아래로 보내고
                    for (int r1 = l; r1 < n - l - 1; ) {
                        int col = n - l - 1;
                        int row = r1 + move;
                        matrix[col][r1] = matrix[col][row];
                        r1 = row;
                    }

                    // 오른쪽 위에서 오른족 아래로 보내고
                    for (int c2 = n - l - 1; c2 > l; ) {
                        int col = n - l - 1;
                        int row = c2 - move;
                        matrix[c2][col] = matrix[row][col];
                        c2 = row;
                    }


                    // 왼쪽위에서 오른족 위로 보내고
                    for (int r2 = n - l - 1; r2 > l; ) {
                        int row = r2 - move;
                        matrix[l][r2] = matrix[l][row];
                        r2 = row;
                    }


                    matrix[l][l + move] = temp;

                }
            }



            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    System.out.print(matrix[a][b] + " ");
                }
                System.out.println();
            }
        }


    }


}