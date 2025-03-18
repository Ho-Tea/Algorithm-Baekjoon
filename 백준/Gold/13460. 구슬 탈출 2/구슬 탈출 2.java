
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    static int[][] moved = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int M = array[1];
        int[][] matrix = new int[N][M];
        int redR = 0;
        int redC = 0;
        int blueR = 0;
        int blueC = 0;
        for (int i = 0; i < N; i++) {
            String[] values = reader.readLine().split("");
            for (int j = 0; j < values.length; j++) {
                if (values[j].equals("#")) {
                    matrix[i][j] = 0;
                } else if (values[j].equals(".")) {
                    matrix[i][j] = 1;
                } else if (values[j].equals("R")) {
                    matrix[i][j] = 1;
                    redR = i;
                    redC = j;
                } else if (values[j].equals("B")) {
                    matrix[i][j] = 1;
                    blueR = i;
                    blueC = j;
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[] result = new int[]{Integer.MAX_VALUE};
        int[][][][] visited = new int[N][M][N][M];


        backtracking(matrix, redR, redC, blueR, blueC, 0, result, visited);
        if (result[0] > 10) {
            System.out.println(-1);
            return;
        }
        System.out.println(result[0]);
    }


    public static void backtracking(int[][] matrix, int redRow, int redCol, int blueRow, int blueCol, int count, int[] result, int[][][][] visited) {
        if (redCol < 0 || blueCol < 0 || redRow < 0 || blueRow < 0 || blueCol >= matrix[0].length || blueRow >= matrix.length || redRow >= matrix.length || redCol >= matrix[0].length) {
            return;
        }
        // 파란색이 O에 가면 안됨
        if (matrix[blueRow][blueCol] == -1) {
            return;
        }
        if (result[0] < count) {
            return;
        }
        if (matrix[redRow][redCol] == -1) {
            result[0] = Math.min(count, result[0]);
            return;
        }
        if (count > 10) {
            return;
        }

        for (int[] move : moved) {
            int curRedRow = redRow;
            int curRedCol = redCol;
            int curBlueRow = blueRow;
            int curBlueCol = blueCol;
            int dr = move[0];
            int dc = move[1];
            if (curRedCol + dc < 0 || curBlueCol + dc < 0 || curRedRow + dr < 0 || curBlueRow + dr < 0 || curBlueCol + dc >= matrix[0].length || curBlueRow + dr >= matrix.length || curRedRow + dr >= matrix.length || curRedCol + dc >= matrix[0].length) {
                continue;
            }
            if (visited[redRow + dr][redCol + dc][blueRow + dr][blueCol + dc] != 0 && visited[redRow + dr][redCol + dc][blueRow + dr][blueCol + dc] < count + 1) {
                return;
            }
            int redMoveCount = 0;
            int blueMoveCount = 0;
            boolean redSuccess = false;
            boolean blueSuccess = false;
            // 빨간색 움직임
            while (matrix[curRedRow + move[0]][curRedCol + move[1]] != 0) {
                if (matrix[curRedRow + move[0]][curRedCol + move[1]] == -1) {
                    redSuccess = true;
                    break;
                }
                redMoveCount++;
                curRedRow += move[0];
                curRedCol += move[1];

            }
            // 파란색 움직임
            while (matrix[curBlueRow + move[0]][curBlueCol + move[1]] != 0) {
                if (matrix[curBlueRow + move[0]][curBlueCol + move[1]] == -1) {
                    blueSuccess = true;
                    break;
                }
                blueMoveCount++;
                curBlueRow += move[0];
                curBlueCol += move[1];
            }

            if (blueSuccess) {
                continue;
            }
            if (redSuccess) {
                result[0] = Math.min(count + 1, result[0]);
                visited[curRedRow][curRedCol][curBlueRow][curBlueCol] = count + 1;
                return;
            }
            if (curRedRow == curBlueRow && curRedCol == curBlueCol) {
                if (redMoveCount > blueMoveCount) {
                    curRedRow -= move[0];
                    curRedCol -= move[1];
                } else {
                    curBlueRow -= move[0];
                    curBlueCol -= move[1];
                }
            }
            backtracking(matrix, curRedRow, curRedCol, curBlueRow, curBlueCol, count + 1, result, visited);
        }
    }

}