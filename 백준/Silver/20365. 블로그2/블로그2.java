
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(reader.readLine());

        int[] array = Arrays.stream(reader.readLine().split("")).mapToInt(a -> {
            if (a.equals("B")) {
                return 1;
            }
            return 0;
        }).toArray();
        int count = 1;
        int beforeNum = array[0];
        for(int i = 1; i < array.length; i++){
            if(beforeNum != array[i]){
                count++;
                int value = array[i];
                int j = i+1;
                for(; j < array.length-1; j++){
                    if(value != array[j]){
                        break;
                    }
                }
                i = j;
            }
        }
        System.out.println(count);

    }
}
