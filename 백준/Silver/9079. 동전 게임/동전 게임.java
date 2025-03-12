
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(reader.readLine());

        boolean[] visited = new boolean[8];
        while (i > 0) {
            int[][] matrix = new int[3][3];
            for (int j = 0; j < 3; j++) {
                String[] array = reader.readLine().split(" ");
                for (int k = 0; k < 3; k++) {
                    if(array[k].equals("H")) {
                        matrix[j][k] = 1;
                        continue;
                    }
                    matrix[j][k] = 0;
                }
            }
            int[] results = new int[1];
            results[0] = 8;
            dfs(matrix, 0, visited, results);
            if(results[0] == 8){
                System.out.println(-1);
                i--;
                continue;
            }
            System.out.println(results[0]);
            i--;
        }


    }

    public static void dfs(int[][] matrix, int count, boolean[] visited, int[] result) {
        int sum = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                sum += matrix[i][j];
            }
        }
        if(sum == 0 || sum == 9){
            result[0] = Math.min(result[0], count);
            return;
        }

        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                // 맨 왼쪽 아래로
                if(i == 0){
                    int column = 0;
                    for(int row = 0; row < 3; row++){
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int row = 0; row < 3; row++){
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;

                }
                // 가운데 아래로
                else if (i == 1) {
                    int column = 1;
                    for(int row = 0; row < 3; row++){
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int row = 0; row < 3; row++){
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;
                }
                // 오른쪽 아래로
                else if (i == 2) {
                    int column = 2;
                    for(int row = 0; row < 3; row++){
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int row = 0; row < 3; row++){
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;
                }
                // 맨위 오른쪽
                else if (i == 3) {
                    int row = 0;
                    for(int column = 0; column < 3; column++){
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int column = 0; column < 3; column++){
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;
                }
                // 가운데 오른쪽
                else if (i == 4) {
                    int row = 1;
                    for(int column = 0; column < 3; column++){
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int column = 0; column < 3; column++){
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;
                }
                // 맨 아래 오른쪽
                else if (i == 5) {
                    int row = 2;
                    for(int column = 0; column < 3; column++){
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int column = 0; column < 3; column++){
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;
                }
                // 오른쪽 아래로 대각선
                else if (i == 6) {
                    for(int k = 0; k < 3; k++){
                        if(matrix[k][k] == 1){
                            matrix[k][k] = 0;
                        }else {
                            matrix[k][k] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int k = 0; k < 3; k++){
                        if(matrix[k][k] == 0){
                            matrix[k][k] = 1;
                        }else {
                            matrix[k][k] = 0;
                        }
                    }
                    visited[i] = false;
                }
                // 오른쪽 위로 대각선
                else{
                    for(int row = 0; row < 3; row++){
                        int column = 2 - row;
                        if(matrix[row][column] == 1){
                            matrix[row][column] = 0;
                        }else {
                            matrix[row][column] = 1;
                        }
                    }
                    dfs(matrix, count+1, visited, result);
                    for(int row = 0; row < 3; row++){
                        int column = 2 - row;
                        if(matrix[row][column] == 0){
                            matrix[row][column] = 1;
                        }else {
                            matrix[row][column] = 0;
                        }
                    }
                    visited[i] = false;
                }
            }
        }
    }
}