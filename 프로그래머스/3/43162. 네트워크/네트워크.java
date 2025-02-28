import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                bfs(i, n, computers, visited);
                count++;
            }
        }
        
        return count;
    }
    
    public void bfs(int i, int n, int[][] computers, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.offer(i);
        while(!q.isEmpty()){
            int node = q.poll();
            visited[node] = true;
            for(int j = 0; j < n; j++){
                if(computers[node][j] == 1 && !visited[j]){
                    q.offer(j);
                }
            }
        }
    }
}
