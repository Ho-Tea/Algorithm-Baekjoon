
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = reader.readLine().split("");
        int[] c = new int[26];
        for (String ss : s) {
            String upperCase = ss.toUpperCase();
            c[upperCase.charAt(0) - 65]++;
        }
        OptionalInt max = IntStream.of(c).max();
        int count = 0;
        int index = 0;
        for (int i = 0; i < 26; i++) {
            if (c[i] == max.getAsInt()) {
                count++;
                index = i;
            }
        }

        if (count != 1) {
            System.out.println("?");
            return;
        }
        System.out.println((char) (index + 65));
    }
}
