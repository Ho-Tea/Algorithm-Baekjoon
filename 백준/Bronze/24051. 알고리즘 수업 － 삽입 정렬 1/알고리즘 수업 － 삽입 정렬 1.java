
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
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = array[0];
        int K = array[1];
        long[] A = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int count = 0;
        for(int i = 1; i < N; i++){
            int point = i-1;
            long value = A[i];
            boolean moved = false;
            while(point >= 0 && A[point] > value){
                count++;
                A[point + 1] = A[point];
                if(count == K){
                    System.out.println(A[point+1]);
                    return;
                }
                point--;
                moved = true;
            }
            A[point+1] = value;
            if(moved){
                count++;
            }
            if(count == K){
                System.out.println(A[point+1]);
                return;
            }
        }
        System.out.println(-1);
    }
}