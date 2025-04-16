
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String in = reader.readLine();
        String[] inputs = (in).split("");
        int aCount = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].equals("a")) {
                aCount++;
            }
        }
        inputs = (in + in).split("");
        int bCount = 0;
        for(int i = 0; i < aCount; i++){
            if(inputs[i].equals("b")){
                bCount++;
            }
        }
        int first = 0;
        int min = bCount;
        int last = aCount-1;
        for(int j = last+1; j < inputs.length; j++){
            if(inputs[first].equals("b")){
                bCount--;
            }
            if(inputs[j].equals("b")){
                bCount++;
            }
            first++;
            min = Math.min(min, bCount);
        }

        System.out.println(min);
    }
}
