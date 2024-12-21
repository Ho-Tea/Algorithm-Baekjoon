

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        char[][] chars = new char[count][];
        for (int i = 0; i < count; i++) {
            char[] charArray2 = reader.readLine().toCharArray();
            chars[i] = charArray2;
        }

        for (int i = 0; i < count; i++) {
            int[] ascii = new int[200];
            char[] charArray = chars[i];
            for (char c : charArray) {
                if (c >= 97 && c <= 122) {
                    ascii[c]++;
                }
            }
            OptionalInt max = IntStream.of(ascii).max();
            int maxValue = max.getAsInt();
            int[] array = IntStream.range(0, ascii.length)
                    .filter(j -> ascii[j] == maxValue)
                    .toArray();
            if (array.length != 1) {
                System.out.println("?");
            } else {
                System.out.println((char) array[0]);
            }
        }

    }
}
