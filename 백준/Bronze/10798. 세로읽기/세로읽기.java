

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] matrix = new boolean[20][20];
        String[][] candidate = new String[20][20];

        for (int i = 0; i < 5; i++) {
            String[] lineElement = reader.readLine().split("");
            int index = 0;
            for (String element : lineElement) {
                matrix[i][index] = true;
                candidate[i][index++] = element;
            }
        }
        String result = "";
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[j][i]) {
                    result += candidate[j][i];
                }
            }
        }
        System.out.println(result);
    }
}
