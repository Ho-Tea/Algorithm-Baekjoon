
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    static int K;
    static int count = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array1 = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = array1[0];
        K = array1[1];
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sortMerge(array, 0, N - 1);

        if (!check) {
            System.out.println(-1);
        }

    }

    public static void sortMerge(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sortMerge(arr, start, mid);
            sortMerge(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int leftArrayCount = mid - start + 1;
        int rightArrayCount = end - mid;

        int[] left = new int[leftArrayCount];
        int[] right = new int[rightArrayCount];

        for (int i = 0; i < leftArrayCount; i++)
            left[i] = array[start + i];
        for (int j = 0; j < rightArrayCount; j++)
            right[j] = array[mid + 1 + j];

        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;
        while (leftIndex < leftArrayCount && rightIndex < rightArrayCount) {
            if (left[leftIndex] < right[rightIndex]) {
                array[index] = left[leftIndex];
                count++;
                if (count == K) {
                    System.out.println(array[index]);
                    check = true;
                    return;
                }
                leftIndex++;
            } else {
                array[index] = right[rightIndex];
                count++;
                if (count == K) {
                    System.out.println(array[index]);
                    check = true;
                    return;
                }
                rightIndex++;
            }
            index++;
        }
        while (leftIndex < leftArrayCount) {
            array[index] = left[leftIndex];
            count++;
            if (count == K) {
                System.out.println(array[index]);
                check = true;
                return;
            }
            index++;
            leftIndex++;
        }
        while (rightIndex < rightArrayCount) {
            array[index] = right[rightIndex];
            count++;
            if (count == K) {
                System.out.println(array[index]);
                check = true;
                return;
            }
            index++;
            rightIndex++;
        }
    }
}