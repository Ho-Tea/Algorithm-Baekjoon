
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

        stringTokenizer.nextToken();
        int index = Integer.parseInt(stringTokenizer.nextToken());

        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        quickSort(array, 0, array.length - 1);

        System.out.println(array[index - 1]);

    }

    public static int[] quickSort(int[] array, int start, int end) {
        int rightPartition = partition(array, start, end);
        if (start + 1 < rightPartition) {
            quickSort(array, start, rightPartition - 1);
        }
        if (rightPartition < end) {
            quickSort(array, rightPartition, end);
        }
        return array;
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < pivot) {
                start++;
            }
            while (array[end] > pivot) {
                end--;
            }
            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
