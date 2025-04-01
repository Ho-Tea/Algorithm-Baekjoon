
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        String startNumber = "666";
        int count = 2;
        if (N == 1) {
            System.out.println(666);
            return;
        }
        while (count <= N) {
            startNumber = String.valueOf(Integer.parseInt(startNumber) + 1);
            if (startNumber.contains("666")) {
                count++;
            }
        }

        System.out.println(startNumber);
    }
}