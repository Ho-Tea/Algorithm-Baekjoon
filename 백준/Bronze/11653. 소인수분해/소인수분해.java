
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        if(N == 1){
            return;
        }
        List<Integer> array = new ArrayList<>();
        int index = 2;
        while(N != 1){
            if(N % index == 0){
                N = N / index;
                array.add(index);
                continue;
            }
            index++;
        }

        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
    }
}