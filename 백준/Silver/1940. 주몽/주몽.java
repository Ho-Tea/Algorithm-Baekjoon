
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
        int M = Integer.parseInt(reader.readLine());
        int[] material = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(material);
        int left = 0;
        int right = material.length-1;
        int count = 0;
        while(left < right){
            int newMaterial = material[left] + material[right];
            if(newMaterial > M){
                right--;
            }else if (newMaterial < M){
                left++;
            }else {
                count++;
                right--;
                left++;
            }
        }
        System.out.println(count);
    }
}