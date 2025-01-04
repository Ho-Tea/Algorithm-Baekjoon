
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] P = reader.readLine().split("");
        List<String> result = new ArrayList<>();
        String x = "X";
        String dot = ".";
        String a = "AAAA";
        String b = "BB";
        int count = 0;
        for (int i = 0; i < P.length; i++) {
            if(P[i].equals(dot)) {
                result.add(String.valueOf(count));
                result.add(dot);
                count = 0;
            }
            else {
                count++;
                if(i == P.length - 1) {
                    result.add(String.valueOf(count));
                    break;
                }
            }
        }
        System.out.println(fill(result));
    }

    public static String fill(List<String> result){
        StringBuilder sb = new StringBuilder();
        for(String element : result){
            if(element.equals(".")){
                sb.append(element);
                continue;
            }
            int i = Integer.parseInt(element);
            int aCount = i / 4;
            if(i%4%2 != 0){
                return "-1";
            }
            int bCount = i % 4/2;
            sb.append("AAAA".repeat(aCount));
            sb.append("BB".repeat(bCount));
        }
        return sb.toString();
    }
}
