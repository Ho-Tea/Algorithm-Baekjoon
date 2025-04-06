
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

        heapSort(array);

        if(!check){
            System.out.println(-1);
        }
    }

    public static void heapSort(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, i, array.length);
        }

        for (int j = array.length - 1; j > 0; j--) {

            count++;
            if (count == K) {
                check = true;
                System.out.println(array[0] + " " + array[j]);
                return;
            }
            swap(array, 0, j);
            heapify(array, 0, j);
        }
    }

    public static void heapify(int[] array, int node, int length) {
        int leftNode = node * 2 + 1;
        int rightNode = node * 2 + 2;
        int minimumIndex = node;
        int minimum = array[node];
        if (leftNode < length && array[leftNode] < minimum) {
            minimum = array[leftNode];
            minimumIndex = leftNode;
        }
        if (rightNode < length && array[rightNode] < minimum) {
            minimum = array[rightNode];
            minimumIndex = rightNode;
        }

        if (minimum != array[node]) {
            count++;
            if (count == K) {
                check = true;
                System.out.println(array[minimumIndex] + " " + array[node]);
                return;
            }
            swap(array, node, minimumIndex);
            heapify(array, minimumIndex, length);
        }
    }


    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}