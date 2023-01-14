import java.io.*;
import java.util.*;



public class Main {
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());
    int count = 0;
    int nodeNumber;

    Main test = new Main();
    
    

    for(int i = 0; i < T; i++){ //map 초기화
      StringTokenizer sd = new StringTokenizer(br.readLine());
      nodeNumber = Integer.parseInt(sd.nextToken());
      StringTokenizer se = new StringTokenizer(br.readLine());
      boolean[] visited = new boolean[nodeNumber+1];
      visited = test.init(nodeNumber, visited);
      int[][] map = new int[nodeNumber+1][nodeNumber+1];
      count = 0;
      for(int j = 1; j <= nodeNumber;j++){
        map[j][Integer.parseInt(se.nextToken())] = 1;
      }
    
      for(int k = 1; k <= nodeNumber; k++){
        if(visited[k] == false){
          visited = test.dfs(visited, map, k);
          count++;
        }
      }
      System.out.println(count);
    }


  }
  boolean[] init(int N, boolean[] visited){
    for(int i = 1; i <= N; i++){ //visit 초기화
      visited[i] = false;
    }
    return visited;
  }

  boolean[] dfs(boolean[] visited, int[][] map, int i ){
      visited[i] = true;
      for(int j = 1; j < visited.length; j++){
        if((map[i][j] == 1) && visited[j] == false){
          dfs(visited, map, j);
        }
      }
      return visited;
  }
}
