
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Main {

    static int[][] moved = new int[][] {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(reader.readLine());
        while(i > 0){
            int l = Integer.parseInt(reader.readLine());
            int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startRow = array[0];
            int startColumn = array[1];
            int[] array2 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int endRow = array2[0];
            int endColumn = array2[1];

            boolean[][] visited = new boolean[l][l];

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{startRow, startColumn, 0});
            visited[startRow][startColumn] = true;
            int count = 0;
            while(!queue.isEmpty()){
                int[] poll = queue.poll();
                int currentRow = poll[0];
                int currentColumn = poll[1];
                int currentCount = poll[2];
                if(currentRow == endRow && currentColumn == endColumn){
                    count = currentCount;
                    break;
                }
                for(int[] move : moved){
                    if(currentRow + move[1] < l && currentColumn + move[0] <l && currentRow + move[1] >= 0 && currentColumn + move[0] >= 0 && !visited[currentRow+move[1]][currentColumn+move[0]]){
                        queue.offer(new int[]{currentRow + move[1], currentColumn + move[0], currentCount + 1});
                        visited[currentRow+move[1]][currentColumn+move[0]] = true;
                    }
                }
            }
            System.out.println(count);
            i--;
        }
    }
}