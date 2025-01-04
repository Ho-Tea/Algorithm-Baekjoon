
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(reader.readLine());
        int[] arr = new int[s];
        for (int i = 0; i < s; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort2(arr, tmp, 0, arr.length - 1);
    }

    public static void mergeSort2(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort2(arr, tmp, start, mid);
            mergeSort2(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }
            else if (tmp[part2] <= tmp[part1]) {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = part1; i <= mid; i++) {
            arr[index++] = tmp[i];
        }
    }
}
