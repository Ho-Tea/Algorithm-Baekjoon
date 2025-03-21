
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


public class Main {
    static int[][] horseMoving = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
    static int[][] monkeyMoving = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int hoseMovingCount = Integer.parseInt(reader.readLine());
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int width = array[0];
        int height = array[1];
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            int[] array1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = array1;
        }
        int ans = Integer.MAX_VALUE;
        boolean[][][] visited = new boolean[height][width][hoseMovingCount+1];
        int[] startNode = new int[]{0, 0, 0, hoseMovingCount};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startNode);
        visited[0][0][hoseMovingCount] = true;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int wid = node[0];
            int hid = node[1];
            int count = node[2];
            int hoseMoving = node[3];
            if (wid == width - 1 && hid == height - 1) {
                ans = Math.min(ans, count);
                break;
            }
            int newWid = wid;
            int newHid = hid;
            for (int[] move : monkeyMoving) {
                newWid = wid + move[0];
                newHid = hid + move[1];
                if (newWid < 0 || newWid >= matrix[0].length || newHid < 0 || newHid >= matrix.length) {
                    continue;
                }
                if (visited[newHid][newWid][hoseMoving] || matrix[newHid][newWid] == 1) {
                    continue;
                }
                visited[newHid][newWid][hoseMoving] = true;
                queue.add(new int[]{newWid, newHid, count + 1, hoseMoving});
            }
            if (hoseMoving > 0) {
                for (int[] hose : horseMoving) {
                    int horseNewWid = wid + hose[0];
                    int horseNewHid = hid + hose[1];
                    if (horseNewWid < 0 || horseNewWid >= matrix[0].length || horseNewHid < 0 || horseNewHid >= matrix.length) {
                        continue;
                    }
                    if (visited[horseNewHid][horseNewWid][hoseMoving - 1] || matrix[horseNewHid][horseNewWid] == 1) {
                        continue;
                    }
                    visited[horseNewHid][horseNewWid][hoseMoving - 1] = true;
                    queue.add(new int[]{horseNewWid, horseNewHid, count + 1, hoseMoving - 1});
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
    }
}