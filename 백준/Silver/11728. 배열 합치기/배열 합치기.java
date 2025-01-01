
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = reader.readLine().split(" ");
        int[] array = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();

        int[] a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();

        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            if (a[aIndex] <= b[bIndex]) {
                sb.append(a[aIndex]).append(" ");
                aIndex++;
            } else {
                sb.append(b[bIndex]).append(" ");
                bIndex++;
            }
        }
        if (aIndex == a.length) {
            for (; bIndex < b.length; bIndex++) {
                sb.append(b[bIndex]).append(" ");
            }
        } else if (bIndex == b.length) {
            for (; aIndex < a.length; aIndex++) {
                sb.append(a[aIndex]).append(" ");
            }
        }
        System.out.println(sb);
    }
}
