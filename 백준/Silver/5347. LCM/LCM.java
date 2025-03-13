
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
        int n = Integer.parseInt(reader.readLine());

        for(int i =0; i<n; i++) {
            int[] line = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int first = line[0];
            int second = line[1];
            int mod = 0;
            int value = 0;
            if(first < second){
                mod = second % first;
                while(mod != 0){
                    second = mod;
                    mod = first % second;
                    first = second;
                }
                value=second;
            }else {
                mod = first % second;
                while(mod != 0){
                    first = mod;
                    mod = second % first;
                    second = first;
                }
                value=first;
            }
            System.out.println(((long)line[0]*line[1])/value);
        }
    }
}