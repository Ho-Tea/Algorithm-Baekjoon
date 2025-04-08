
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();
        String answer = reader.readLine();

        dfs(result, answer);
        if (found) {
            System.out.println(1);
            return;
        }
        System.out.println(0);

    }

    public static void dfs(String result, String answer) {
        if (found) {
            return;
        }
        if (result.equals(answer)) {
            found = true;
            return;
        } else if (answer.length() <= result.length()) {
            return;
        }

        if(answer.charAt(answer.length()-1) == 'A'){
            dfs(result, answer.substring(0, answer.length()-1));
        }
        if(answer.charAt(0) == 'B'){
            String newString = answer.substring(1);
            String reversed = new StringBuilder(newString).reverse().toString();
            dfs(result, reversed);
        }
    }
}
