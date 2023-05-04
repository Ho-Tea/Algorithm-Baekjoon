import java.io.*;
import java.util.*;

public class Main {
  static int [][] map;
  static int [][] map2;
  static boolean [] visit;
  static boolean [] visit2;
  static List<Integer> chain;
  static List<Integer> chain2;
  static Queue<Integer> q;
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    map = new int[N+1][N+1];
    visit = new boolean[N+1];
    map2 = new int[N+1][N+1];
    visit2 = new boolean[N+1];

    chain = new ArrayList<>();
    chain2 = new ArrayList<>();
    q = new LinkedList<>();

    for(int i = 0; i < M; i++){
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      int firstNode = Integer.parseInt(st1.nextToken());
      int secondNode = Integer.parseInt(st1.nextToken());

      map[firstNode][secondNode] = 1;
      map2[firstNode][secondNode] = 1;
    }
    dfs(V);
    for(int node : chain){
      System.out.print(node + " ");
    }
    System.out.println();

    bfs(V);
    for(int node : chain2){
      System.out.print(node+ " ");
    }
    
  }

  public static void dfs(int i){
    visit[i] = true;
    chain.add(i);
    for(int j = 1;j<N+1;j++){
      if((map[i][j] == 1 || map[j][i] == 1) && visit[j] == false){
        dfs(j);
      }
    }
  }

  public static void bfs(int i){
    q.offer(i);
    visit2[i] = true;
    while(!q.isEmpty()){
      int node = q.poll();
      chain2.add(node);
      for(int j = 1; j < N +1; j ++){
        if((map2[node][j] == 1 || map2[j][node] == 1) && visit2[j] == false){
          q.offer(j);
          visit2[j] = true;
      }
    }
  }
}
}
