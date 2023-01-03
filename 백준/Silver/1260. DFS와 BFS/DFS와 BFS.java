import java.io.*;
import java.util.*;



public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    Main test = new Main();
    int startNode = 0;
    int endNode = 0;
    boolean[] visited = new boolean[N+1];
    int[][] map = new int[N+1][N+1];

    

    for(int i = 0; i < M; i++){ //map 초기화
      StringTokenizer sd = new StringTokenizer(br.readLine());
      startNode = Integer.parseInt(sd.nextToken());
      endNode = Integer.parseInt(sd.nextToken());
      map[startNode][endNode] = 1;
    }
    
    visited = test.init(N, visited);
    test.dfs(visited, map, V);
    System.out.println();
    visited = test.init(N, visited);
    test.bfs(visited, map, V);

  }
  boolean[] init(int N, boolean[] visited){
    for(int i = 1; i <= N; i++){ //visit 초기화
      visited[i] = false;
    }
    return visited;
  }

  void dfs(boolean[] visited, int[][] map, int i ){
      visited[i] = true;
      System.out.print(i+ " ");
      for(int j = 1; j < visited.length; j++){
        if((map[i][j] == 1 || map[j][i] == 1) && visited[j] == false){
          dfs(visited, map, j);
        }
      }
  }

  void bfs(boolean[] visited, int[][] map, int i ){
    Queue<Integer> q = new LinkedList<>();
		q.offer(i);
		visited[i] = true;

		while(!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp + " ");
			for(int j=1; j < visited.length; j++) {
				if((map[temp][j] == 1|| map[j][temp] == 1) && visited[j] == false) {
					q.offer(j);
					visited[j] = true;
				}
			}
		}
  }
}
