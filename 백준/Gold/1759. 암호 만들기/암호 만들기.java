
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Main {

    static int[][] moved = new int[][]{{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] array = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int L = array[0];
        int C = array[1];

        String[] strings = reader.readLine().split(" ");
        boolean[] visited = new boolean[C];
        List<String> results = new ArrayList<>();
        backtracking(L, "", results, strings, visited);
        Collections.sort(results);
        for (String result : results) {
            System.out.println(result);
        }
    }

    public static void backtracking(int length, String result, List<String> results, String[] strings, boolean[] visited) {
        if (result.length() == length) {
            char[] charArray = result.toCharArray();
            if (!validate(charArray)) {
                return;
            }
            results.add(result);
            return;
        }

        for (int i = 0; i < strings.length; i++) {
            if (!visited[i]) {
                if(result.isEmpty()){
                    visited[i] = true;
                    backtracking(length, result + strings[i].charAt(0), results, strings, visited);
                    visited[i] = false;
                    continue;
                }
                if (result.charAt(result.length() - 1) > strings[i].charAt(0)) {
                    continue;
                }
                visited[i] = true;
                backtracking(length, result + strings[i].charAt(0), results, strings, visited);
                visited[i] = false;
            }
        }

    }

    public static boolean validate(char[] charArray) {
        List<Character> characters = new ArrayList<>();
        characters.add('a');
        characters.add('e');
        characters.add('i');
        characters.add('o');
        characters.add('u');
        int m = 0;
        int z = 0;
        for (char c : charArray) {
            if (characters.contains(c)) {
                m++;
                continue;
            }
            z++;
        }

        return m >= 1 && z >= 2;
    }

}