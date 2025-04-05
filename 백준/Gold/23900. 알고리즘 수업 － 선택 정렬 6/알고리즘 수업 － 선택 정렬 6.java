
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        long[] A = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] B = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(A[i], i);
        }
        List<Long> sortedA = new ArrayList<>(map.keySet());
        sortedA.sort(Comparator.comparingInt(Long::intValue));

        int[][] past = new int[N][2];
        int count = 0;
        for (int j = N - 1; j >= 0; j--) {
            long targetNumber = sortedA.get(j);
            int currentIndex = map.get(targetNumber);
            long temp = A[j];
            A[j] = A[currentIndex];
            A[currentIndex] = temp;
            map.put(temp, currentIndex);
            map.put(A[j], j);
            past[count][0] = j; // 끝 부터
            past[count][1] = currentIndex;
            count++;
        }

        int countNum = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (B[i] == A[i]) {
                countNum++;
            } else {
                break;
            }
        }

        for (int i = countNum; i < N; i++) {
            int right = past[i][0];
            int left = past[i][1];
            if (B[left] > B[right]) {
                long tmp = B[left];
                B[left] = B[right];
                B[right] = tmp;
            }
        }

        boolean isSame = Arrays.equals(B, A);
        System.out.println(isSame ? 1 : 0);
    }
}