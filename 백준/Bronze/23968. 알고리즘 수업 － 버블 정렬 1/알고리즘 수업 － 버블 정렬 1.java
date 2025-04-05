
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
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
        for(int i = N-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(A[j] > A[j+1]){
                    long temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    count++;
                    if(count == K){
                        System.out.print(A[j] + " " + A[j+1]);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);

    }

}