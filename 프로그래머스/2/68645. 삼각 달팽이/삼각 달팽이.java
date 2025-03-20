import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};
        
        int[][] matrix = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++){
            for (int j = i + 1; j < n; j++){
                visited[i][j] = true;
            }
        }
        
        // 총 채워야 할 셀 수: n*(n+1)/2
        int total = n * (n + 1) / 2;
        int num = 1;
        int r = 0, c = 0;
        int d = 0;
        
        while(num <= total) {
            matrix[r][c] = num;
            visited[r][c] = true;
            num++;
            int nr = r + dy[d];
            int nc = c + dx[d];
            
            // 범위를 벗어나거나 이미 방문한 셀이면 방향 전환
            if(nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) {
                d = (d + 1) % 3;  // 0→1→2→0 순서로 방향 변경
                nr = r + dy[d];
                nc = c + dx[d];
            }
            r = nr;
            c = nc;
        }
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                list.add(matrix[i][j]);
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}