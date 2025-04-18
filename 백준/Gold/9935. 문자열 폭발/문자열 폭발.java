
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        String tnt = reader.readLine();
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < string.length();i++){
            result.append(string.charAt(i));
            if(result.length() < tnt.length()){
                continue;
            }
            if(result.substring(result.length()- tnt.length(), result.length()).equals(tnt)){
                result.replace(result.length()- tnt.length(), result.length(), "");
            }
        }

        if(result.length() == 0){
            System.out.println("FRULA");
        }
        System.out.println(result.toString());
    }
}
