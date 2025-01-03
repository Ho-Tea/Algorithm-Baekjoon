
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] list = new int[array[0]];
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(reader.readLine());
        }

        int start = 0;
        int end = array[2] - 1;
        int initEnd = end;
        int nonDuplicates = array[3];
        int max = count(start, end, list, nonDuplicates);
        start = riseStartIndex(start, list);
        end = riseEndIndex(end, list);
        while (initEnd != end) {
            int count = count(start, end, list, nonDuplicates);
            if (count > max) {
                max = count;
            }
            start = riseStartIndex(start, list);
            end = riseEndIndex(end, list);
        }
        System.out.println(max);
    }

    private static int riseEndIndex(int end, int[] list) {
        end++;
        if (end >= list.length) {
            end = Math.abs(list.length - end);
        }
        return end;
    }

    private static int riseStartIndex(int start, int[] list) {
        start++;
        if (start >= list.length) {
            start = Math.abs(list.length - start);
        }
        return start;
    }

    public static int count(int start, int end, int[] list, int nonDuplicates) {
        Set<Integer> nonDuplicatesSet = new HashSet<>();
        if (end < start) {
            for (int i = start; i < list.length; i++) {
                nonDuplicatesSet.add(list[i]);
            }
            for (int i = 0; i <= end; i++) {
                nonDuplicatesSet.add(list[i]);
            }
        } else {
            for (int i = start; i <= end; i++) {
                nonDuplicatesSet.add(list[i]);
            }
        }
        nonDuplicatesSet.add(nonDuplicates);
        return nonDuplicatesSet.size();
    }
}
